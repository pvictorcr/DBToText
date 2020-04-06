package pvctr.grupoa.dbtotext.tables;


import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class ORGANOGRAMATable extends GenericTable {

	private final String tableName = "LOT WHERE EMP_CODIGO = '0008'";
	
	public ORGANOGRAMATable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO ***
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(5, "00001"));
				dbl.getFields().add(new StringField(20, rs.getString("CODIGO")));
				dbl.getFields().add(new StringField(30, rs.getString("NOME")));
				dbl.getFields().add(new StringField(2, "02"));
				dbl.getFields().add(new StringField(2, "01"));
				dbl.getFields().add(new StringField(3, "001"));  //código na tabela gps
				dbl.getFields().add(new StringField(5, "     "));
				dbl.getFields().add(new StringField(5, "00001"));
				dbl.getFields().add(new StringField(20, "                    "));
				dbl.getFields().add(new StringField(20, "                    "));
				dbl.getFields().add(new StringField(3, "   "));
				dbl.getFields().add(new StringField(3, "   "));
				dbl.getFields().add(new StringField(3, "   "));
				dbl.getFields().add(new StringField(2, "00"));
				dbl.getFields().add(new StringField(5, "     "));
				dbl.getFields().add(new StringField(3, "   "));
				
						
				//ALTERACAO E DAQUI PRA CIMA ***
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
