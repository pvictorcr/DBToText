package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class LOTACAOTable extends GenericTable {

	private final String tableName = "TOM";
	
	public LOTACAOTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO ***
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(31, rs.getInt("CODIGO")));
				dbl.getFields().add(new StringField(10, "01/05/2006"));
				dbl.getFields().add(new StringField(100, rs.getString("NOME")));
				dbl.getFields().add(new NumberField(2, "04"));
				dbl.getFields().add(new NumberField(3, "1"));
				dbl.getFields().add(new NumberField(6, rs.getInt("CODIGO")));
				dbl.getFields().add(new NumberField(3, "0"));
						
				//ALTERACAO E DAQUI PRA CIMA ***
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
