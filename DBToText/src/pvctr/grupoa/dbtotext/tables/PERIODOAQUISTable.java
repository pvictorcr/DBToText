package pvctr.grupoa.dbtotext.tables;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;
import java.util.Calendar;

public class PERIODOAQUISTable extends GenericTable {

	private final String tableName = "PAE WHERE EMP_CODIGO ='0008'"; 
			
			//"PAE INNER JOIN EPG ON EPG.EMP_CODIGO = PAE.EMP_CODIGO AND PAE.EPG_CODIGO = EPG.CODIGO LEFT JOIN SEP B ON SEP.EPG_CODIGO = B.EPG_CODIGO AND SEP.EMP_CODIGO = B.EMP_CODIGO AND SEP.DATA < B.DATA WHERE B.DATA IS NULL AND EPG.EMP_CODIGO = '0008'";
	
	public PERIODOAQUISTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO ***
				
				Timestamp dtfinal = rs.getTimestamp("DTFINAL");
				Integer diasgozados = rs.getInt("DIASGOZADOS");
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(7, rs.getInt("EPG_CODIGO")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DTINICIAL")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DTFINAL")));
				if(dtfinal != null && diasgozados == 30) {
				dbl.getFields().add(new StringField(2, "2"));
				}
			    else{
				dbl.getFields().add(new StringField(2, "1"));
				}
				dbl.getFields().add(new StringField(7, rs.getString("DIASGOZADOS")));
				dbl.getFields().add(new NumberField(7, ""));
				dbl.getFields().add(new NumberField(5, ""));
				dbl.getFields().add(new NumberField(5, ""));
				dbl.getFields().add(new NumberField(5, ""));
				dbl.getFields().add(new NumberField(5, ""));
				dbl.getFields().add(new NumberField(5, "")); //desconta contribuicao sindical
				
				
				dbl.getFields().add(new DateField(10, rs.getTimestamp("dtfinal")));
				/**dbl.getFields().add(new NumberField(5, "00003"));
				dbl.getFields().add(new NumberField(3, "000"));**/
						
				//ALTERACAO E DAQUI PRA CIMA ***
				this.lines.add(dbl);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}