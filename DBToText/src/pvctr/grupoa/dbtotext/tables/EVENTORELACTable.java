package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class EVENTORELACTable extends GenericTable {

	private final String tableName = "EVE where emp_codigo ='0008' order by codigo";
	
	public EVENTORELACTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				String Infprovdesc = rs.getString("INFPROVDESC");
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(11, rs.getInt("CODIGO")));
				dbl.getFields().add(new StringField(100, rs.getString("NOME")+" - " + Utilities.treatInfprovdesc(rs.getString("INFPROVDESC"))));
				dbl.getFields().add(new StringField(5, ""));
				
					
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
