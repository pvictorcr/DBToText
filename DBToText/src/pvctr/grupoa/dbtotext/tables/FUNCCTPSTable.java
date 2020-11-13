package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class FUNCCTPSTable extends GenericTable {

	private final String tableName = "EPG WHERE EMP_CODIGO = '0008'";
	
	public FUNCCTPSTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(7, rs.getInt("CODIGO")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("ADMISSAODATA")));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(11, rs.getString("CTPSNUMERO")+Utilities.treatCtpsdv(rs.getString("CTPSDV"))));
				dbl.getFields().add(new StringField(5, rs.getString("CTPSSERIE")));
				dbl.getFields().add(new StringField(2, rs.getString("UFD_SIGLA_CTPS")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("CTPSDTEXPEDICAO")));				
				dbl.getFields().add(new StringField(3, "000"));
					
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
