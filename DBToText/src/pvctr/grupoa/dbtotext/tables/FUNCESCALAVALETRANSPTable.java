package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.DatetimeField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class FUNCESCALAVALETRANSPTable extends GenericTable {

	private final String tableName = "vse\n" + 
			"    INNER JOIN (SELECT EMP_CODIGO AS COD2, EPG_CODIGO, DATA from SEP ORDER BY COD2, EPG_CODIGO, DATA)\n" + 
			"    ON COD2 = emp_codigo and sep_epg_codigo = EPG_CODIGO and DATA = SEP_DATA\n" + 
			"     WHERE COD2 = '0008' ORDER BY EMP_CODIGO, EPG_CODIGO, SEP_DATA";
	
	public FUNCESCALAVALETRANSPTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		
		int empCodigo = 0;
		int epgCodigo = 0;
		Timestamp primeiraData = null;
		boolean hasNext = true;
		
		try {
			while(rs.next()) {
				while(hasNext &&
						  empCodigo == rs.getInt("EMP_CODIGO") &&
						  epgCodigo == rs.getInt("EPG_CODIGO")) {
						hasNext = rs.next();
				}
				hasNext = true;
				Timestamp sepData = rs.getTimestamp("SEP_DATA");
							
				//if(primeiraData == null)
				primeiraData = rs.getTimestamp("SEP_DATA");
					sepData = rs.getTimestamp("SEP_DATA");
					empCodigo = rs.getInt("EMP_CODIGO");
					epgCodigo = rs.getInt("EPG_CODIGO");
				if(primeiraData.before(sepData))
					rs.next();
					/*hasNext = true;
					empCodigo = rs.getInt("COD2");
					epgCodigo = rs.getInt("SEP_EPG_CODIGO");
			}**/
					
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO ***

				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, empCodigo));
				dbl.getFields().add(new NumberField(7, epgCodigo));
				dbl.getFields().add(new DateField(10, primeiraData));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(4, "1"));
						
				//ALTERACAO E DAQUI PRA CIMA ***
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		 }
		
	}
}







		
		
		
		

	


	



		

