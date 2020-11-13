package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class FUNCCARGOTable extends GenericTable {

	private final String tableName = "SEP INNER JOIN EPG ON EPG.EMP_CODIGO = SEP.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO LEFT JOIN SEP B ON SEP.EPG_CODIGO = B.EPG_CODIGO AND SEP.EMP_CODIGO = B.EMP_CODIGO AND SEP.DATA < B.DATA WHERE B.DATA IS NULL AND EPG.EMP_CODIGO = '0008'";//"SEP INNER JOIN EPG ON SEP.EMP_CODIGO = EPG.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO WHERE EPG.EMP_CODIGO = '0008' AND DTRESCISAO IS NULL";
	
	public FUNCCARGOTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(7, rs.getInt("EPG_CODIGO")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("ADMISSAODATA")));
				dbl.getFields().add(new NumberField(7, rs.getInt("CAR_CODIGO")));
				dbl.getFields().add(new StringField(4, "0001"));
				dbl.getFields().add(new StringField(3, "000"));
				dbl.getFields().add(new StringField(7, rs.getString("FUN_CODIGO")));
				dbl.getFields().add(new StringField(3, "000"));
					
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
