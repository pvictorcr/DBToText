package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class CARTable extends GenericTable {

	private final String tableName = "CAR where EMP_CODIGO = '0008'";
	
	public CARTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(7, rs.getInt("CODIGO")));
				dbl.getFields().add(new StringField(10, "01/01/1900"));
				dbl.getFields().add(new StringField(100, rs.getString("NOME")));
				dbl.getFields().add(new StringField(30, rs.getString("NOME")));
				dbl.getFields().add(new StringField(6, rs.getString("CBO_CODIGO")));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(1, ""));
				dbl.getFields().add(new StringField(5, "00001"));
				dbl.getFields().add(new StringField(5, "00001"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(3, "000"));
					
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
