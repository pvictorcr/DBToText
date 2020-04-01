package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class OUTRAEMPEMPTable extends GenericTable {

	private final String tableName = "TOM";
	
	public OUTRAEMPEMPTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO ***
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(6, rs.getInt("CODIGO")));
				dbl.getFields().add(new StringField(10, "01/05/2006"));
				dbl.getFields().add(new StringField(2, "2"));
				dbl.getFields().add(new StringField(2,""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(3, ""));
				dbl.getFields().add(new StringField(5, "0"));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new NumberField(7, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(9, ""));
				dbl.getFields().add(new StringField(18, ""));
				dbl.getFields().add(new StringField(5, "2"));
				dbl.getFields().add(new StringField(18,""));
				dbl.getFields().add(new StringField(5, "2"));
				dbl.getFields().add(new StringField(18, "0"));
				dbl.getFields().add(new StringField(2, "04"));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(5, "0"));
				dbl.getFields().add(new StringField(11, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(3, "0"));
					
				//ALTERACAO E DAQUI PRA CIMA ***
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
