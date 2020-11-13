package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class TABELASALPERTable extends GenericTable {

	private final String tableName = "VID INNER JOIN IND ON IND.CODIGO = VID.IND_CODIGO";
	
	public TABELASALPERTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new StringField(4, "0001"));
				dbl.getFields().add(new StringField(10, rs.getString("IND_CODIGO")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DATA")));
				dbl.getFields().add(new StringField(16, rs.getString("VALOR")));
				dbl.getFields().add(new StringField(18, "0"));
				dbl.getFields().add(new StringField(18, "0"));
				dbl.getFields().add(new StringField(4, "2"));
				
				
					
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
