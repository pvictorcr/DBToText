package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;
import pvctr.grupoa.dbtotext.fields.DateMYField;
import java.sql.Timestamp;

public class EVENTOFIXOTable extends GenericTable {

	private final String tableName = "ERF WHERE EVE_CODIGO <> '011' AND EMP_CODIGO = '0008'ORDER BY SEP_EPG_CODIGO"; // inner join (SELECT count(SEP_DATA) AS DATA2 FROM ERF) on SEP_DATA = DATA2 where EMP_CODIGO = '0008'"; 
			//"EME inner join (SELECT count(SEP_DATA) AS DATA2 FROM EME group by SEP_DATA) on SEP_DATA = DATA2 where EVE_CODIGO = '054' AND EMP_CODIGO = '0008'";
	
	public EVENTOFIXOTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		int ID = 1;
		int empregadoAnterior = 0;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
		int empregadoAtual = rs.getInt("SEP_EPG_CODIGO");
		
		if(empregadoAnterior == empregadoAtual) {
			++ID;
		}else {
			ID = 1;
		} empregadoAnterior = empregadoAtual;
			
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new StringField(5, rs.getString("EMP_CODIGO")));
				
				
				
				dbl.getFields().add(new NumberField(10, ID)); //SEQUENCIAL
				dbl.getFields().add(new NumberField(7, rs.getInt("SEP_EPG_CODIGO")));
				dbl.getFields().add(new NumberField(5, rs.getInt("EVE_CODIGO")));
				dbl.getFields().add(new StringField(18, rs.getString("PARAMETRO")));
				dbl.getFields().add(new StringField(16, rs.getString("VALOR")));
				dbl.getFields().add(new StringField(3, "000"));
				dbl.getFields().add(new StringField(11, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(11, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(10, ""));
				/*dbl.getFields().add(new DateMYField(10, rs.getTimestamp("SEP_DATA")));
				
				Timestamp sepdataread = rs.getTimestamp("SEP_DATA");
				Timestamp sepdataread2 = rs.getTimestamp("DATA2");
				if(sepdataread.compareTo(sepdataread2) == 0) {
					dbl.getFields().add(new DateMYField(10, rs.getTimestamp("SEP_DATA")));
				}
				else {
					dbl.getFields().add(new StringField(10, ""));
			} **/
				
				
				
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

