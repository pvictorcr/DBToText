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
import java.sql.Timestamp;

public class FUNCSALARIOINDICE3Table extends GenericTable {

	private final String tableName = "EPG\n" + 
			"INNER JOIN SEP ON EPG.EMP_CODIGO = SEP.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO\n" + 
			"inner join (select emp_codigo as cod2, epg_codigo as epgcod2, max(data) as maxdata from sep group by emp_codigo, epg_codigo)\n" + 
			"on sep.emp_codigo = cod2 and sep.epg_codigo = epgcod2 and sep.data = maxdata\n" + 
			"INNER JOIN (SELECT VALOR AS VALOR_VID, DATA AS DATA_VID, IND_CODIGO FROM VID) ON IND_CODIGO = SEP.IND_CODIGO_SALARIO\n" + 
			"WHERE SEP.SALTIPO = 'I' AND EPG.EMP_CODIGO = '0008'"; 
			//"EPG INNER JOIN SEP ON EPG.EMP_CODIGO = SEP.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO INNER JOIN (SELECT VALOR AS VALOR_VID, DATA AS DATA_VID, IND_CODIGO FROM VID) ON IND_CODIGO = SEP.IND_CODIGO_SALARIO WHERE SEP.SALTIPO = 'I' AND EPG.DTRESCISAO IS NULL AND EPG.EMP_CODIGO = '0008'";
	
	public FUNCSALARIOINDICE3Table(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		
		int empCodigo = 0;
		int epgCodigo = 0;
		boolean hasNext = true;
		
		try {
			while(rs.next()) {

				while(hasNext &&
					  empCodigo == rs.getInt("EMP_CODIGO") &&
					  epgCodigo == rs.getInt("EPG_CODIGO")) {
					hasNext = rs.next();
				}				

				hasNext = true;
				empCodigo = rs.getInt("EMP_CODIGO");
				epgCodigo = rs.getInt("EPG_CODIGO");
				Timestamp admissaoData = rs.getTimestamp("ADMISSAODATA");
				Timestamp data_vid = rs.getTimestamp("DATA_VID");
				String valorVid = rs.getString("VALOR_VID");
				
				while(hasNext &&
					  empCodigo == rs.getInt("EMP_CODIGO") &&
					  epgCodigo == rs.getInt("EPG_CODIGO") &&
					  (data_vid.before(admissaoData) || data_vid.compareTo(admissaoData) == 0)) {
					valorVid = rs.getString("VALOR_VID");
					hasNext = rs.next();
				}
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
					
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				
				dbl.getFields().add(new NumberField(5, empCodigo));
				
				dbl.getFields().add(new NumberField(7, epgCodigo));
				
				dbl.getFields().add(new DateField(10, data_vid));
				dbl.getFields().add(new StringField(4, "1"));
				dbl.getFields().add(new StringField(10, rs.getString("IND_CODIGO")));
				
				if(data_vid.compareTo(admissaoData)==0) {
					dbl.getFields().add(new NumberField(4, "1"));
				}else {
					dbl.getFields().add(new NumberField(4, "2"));
				}
				dbl.getFields().add(new NumberField(5, "1"));
				
				String saltipo = rs.getString("SALTIPO");
				if (saltipo == "V") {
					dbl.getFields().add(new StringField(16, rs.getString("VALOR")));
				}
				else {
					dbl.getFields().add(new StringField(16, valorVid));
				}
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(18, "000000000000000,00"));
				dbl.getFields().add(new StringField(18, "000000000000000,00"));
				dbl.getFields().add(new StringField(16, "0000000000000,00"));
				dbl.getFields().add(new StringField(255, ""));
				dbl.getFields().add(new NumberField(3, "0"));
				
				
				
				
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}