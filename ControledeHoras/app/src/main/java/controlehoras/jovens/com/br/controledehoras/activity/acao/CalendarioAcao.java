package controlehoras.jovens.com.br.controledehoras.activity.acao;

import android.net.Uri;
import android.util.Log;

import java.net.URISyntaxException;
import java.util.List;

import br.com.controledehoras.core.beans.RegistroArquivo;
import br.com.controledehoras.core.csv.CSVHelper;
import controlehoras.jovens.com.br.controledehoras.activity.CalendarioActivity;
import controlehoras.jovens.com.br.controledehoras.dao.ApontamentoDAO;
import controlehoras.jovens.com.br.controledehoras.entity.ApontamentoEntity;
import controlehoras.jovens.com.br.controledehoras.helper.SelecionadorArquivoHelper;
import controlehoras.jovens.com.br.controledehoras.util.MensagemUtil;

/**
 * Created by Fabio on 25/07/2014.
 */
public class CalendarioAcao {

    private CalendarioActivity calendario;

    public CalendarioAcao(CalendarioActivity calendario){
        this.calendario = calendario;
    }

    public void executarArquivoSelecionado(Uri uri) {
        SelecionadorArquivoHelper selecionadorArquivo = calendario.getSelecionadorArquivo();
        selecionadorArquivo.setUri(uri);

        Log.d("CSV", "Uri Arquivo: " + selecionadorArquivo.getUri().toString());
        try {
            String path = selecionadorArquivo.getPath();
            MensagemUtil.exibirMensagemLonga(calendario, path);

            // Inserir chamada a biblioteca controle-horas-core
            List<RegistroArquivo> registros = CSVHelper.getInstance().obterRegistrosDoArquivo(path);
            //TODO: salvar registros no banco, verificar se já existe
			/*
			 * Será necessário incluir um botao no calendario para excluir registros de um determinado dia.
			 * Caso haja atualizações no dia, nao poderão somar e sim substituir
			 *
			 * Coloquei os comandos abaixo apenas como exemplo, tem que arrumar os parametros e classes
			 * Por exemplo, a diferença entra Apontamento e RegistroArquivo
			 */

            for (RegistroArquivo registro : registros) {
                List<RegistroArquivo> regEncontrados= new ApontamentoDAO(null).selectApontamentoByApontamento(registro);
                if(regEncontrados==null || regEncontrados.isEmpty()){
                    new ApontamentoDAO(null).save(new ApontamentoEntity(registro));//passar apontamento
                }
            }
            MensagemUtil.exibirMensagemLonga(calendario, "Quantidade de registros: " + registros.size());//remover

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception x){
            x.printStackTrace();
        }
    }

    public void executarSelecionadorArquivo(){
        SelecionadorArquivoHelper selecionadorArquivo = calendario.getSelecionadorArquivo();
        selecionadorArquivo.showFileChooser();
    }

}
