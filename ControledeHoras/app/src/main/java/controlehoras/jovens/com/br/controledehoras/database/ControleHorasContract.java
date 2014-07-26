package controlehoras.jovens.com.br.controledehoras.database;

import android.provider.BaseColumns;

/**
 * Created by Fabio on 25/07/2014.
 */
public final class ControleHorasContract {

    public ControleHorasContract() {

    }

    public abstract class TabelaApontamento implements BaseColumns {
        public static final String TABLE_NAME = "apontamento";
        public static final String COLUMN_NAME_APONTAMENTO_ID = "apontamentoid";
        public static final String COLUMN_NAME_MINUTOS = "minutos";
        public static final String COLUMN_NAME_DATA = "data";
        public static final String COLUMN_NAME_HORAINICIAL = "horainicial";
        public static final String COLUMN_NAME_HORAFINAL = "horafinal";


    }

}
