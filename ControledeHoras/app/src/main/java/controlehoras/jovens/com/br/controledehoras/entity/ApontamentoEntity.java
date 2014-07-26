package controlehoras.jovens.com.br.controledehoras.entity;

import java.io.Serializable;

import br.com.controledehoras.core.beans.RegistroArquivo;

/**
 * Created by Alex  on 25/07/2014.
 */
public class ApontamentoEntity extends RegistroArquivo implements Serializable {

    private static final long serialVersionUID = -5275763475704105815L;

    public ApontamentoEntity() {

    }

    public ApontamentoEntity(RegistroArquivo registro) {
        //temporario ate especificar os beans finais e construtores
        super.setData(registro.getData());
        super.setHoraFinal(registro.getHoraFinal());
        super.setHoraInicial(registro.getHoraInicial());
        super.setTempo(registro.getTempo());
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Apontamento ID: ")
                .append(super.getId()).append(", Dia: ")
                .append(super.getData()).append(", Total Horas: ")
                .append(super.getTempo().getHoras());
        return sb.toString();
    }
}
