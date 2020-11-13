package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class FUNCSALARIOTable extends GenericTable {

	private final String tableName = "EPG INNER JOIN SEP ON EPG.EMP_CODIGO = SEP.EMP_CODIGO INNER JOIN (select emp_codigo as cod2, epg_codigo as epgcod2, max(data) as maxdata from sep group by emp_codigo, epg_codigo)on sep.emp_codigo = cod2 and sep.epg_codigo = epgcod2 and sep.data = maxdata WHERE SALTIPO = 'V' AND EPG.EMP_CODIGO = '0008'";
			//Ultimo select dia 17/07/2020--"EPG INNER JOIN SEP ON SEP.EPG_CODIGO = EPG.CODIGO WHERE SEP.SALTIPO = 'V' AND EPG.DTRESCISAO IS NULL AND EPG.EMP_CODIGO = '0069'"; 
			/*"SEP FULL OUTER JOIN VID V ON V.IND_CODIGO = SEP.IND_CODIGO_SALARIO WHERE V.IND_CODIGO IS NULL OR SEP.IND_CODIGO_SALARIO IS NULL"; /**"SEP LEFT JOIN EPG ON EPG.EMP_CODIGO = SEP.EMP_CODIGO " + 
			"FULL OUTER JOIN (SELECT VALOR AS VALOR_VID, DATA AS DATA_VID, IND_CODIGO FROM VID) ON IND_CODIGO = SEP.IND_CODIGO_SALARIO " + 
			"WHERE EPG.DTRESCISAO IS NULL AND EPG.EMP_CODIGO = '0008'";
	*/
	public FUNCSALARIOTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("cod2")));
			    dbl.getFields().add(new NumberField(7, rs.getInt("epgcod2")));
				String saltipo = rs.getString("SALTIPO");
				if (saltipo == "V") {
					dbl.getFields().add(new DateField(10, rs.getTimestamp("maxdata")));
				}else {
					dbl.getFields().add(new DateField(10, rs.getTimestamp("DATA")));
				}
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(4, "1"));
				dbl.getFields().add(new StringField(5, "1"));
				dbl.getFields().add(new StringField(16, rs.getString("VALOR")));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(18, "000000000000000,00"));
				dbl.getFields().add(new StringField(18, "000000000000000,00"));
				dbl.getFields().add(new StringField(16, "0000000000000,00"));
				dbl.getFields().add(new StringField(255, ""));
				dbl.getFields().add(new StringField(3, "0"));
				
				
				
				
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
