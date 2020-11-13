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

public class FUNCSALARIOINDICE2Table extends GenericTable {

	private final String tableName = "EPG\n" + 
			"INNER JOIN SEP ON EPG.EMP_CODIGO = SEP.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO\n" + 
			"inner join (select emp_codigo as cod2, epg_codigo as epgcod2, max(data) as maxdata from sep group by emp_codigo, epg_codigo)\n" + 
			"on sep.emp_codigo = cod2 and sep.epg_codigo = epgcod2 and sep.data = maxdata\n" + 
			"INNER JOIN (SELECT VALOR AS VALOR_VID, DATA AS DATA_VID, IND_CODIGO FROM VID) ON IND_CODIGO = SEP.IND_CODIGO_SALARIO\n" + 
			"WHERE SEP.SALTIPO = 'I' AND EPG.EMP_CODIGO = '0008'"; 
			//"EPG INNER JOIN SEP ON EPG.EMP_CODIGO = SEP.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO INNER JOIN (SELECT VALOR AS VALOR_VID, DATA AS DATA_VID, IND_CODIGO FROM VID) ON IND_CODIGO = SEP.IND_CODIGO_SALARIO WHERE SEP.SALTIPO = 'I' AND EPG.DTRESCISAO IS NULL AND EPG.EMP_CODIGO = '0008'";
	
	public FUNCSALARIOINDICE2Table(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		
		int empCodigo = 0;
		int epgCodigo = 0;

		
		try {
			boolean hasNext = rs.next();
			while(hasNext) {

				/*while(hasNext &&
					  empCodigo == rs.getInt("EMP_CODIGO") &&
					  epgCodigo == rs.getInt("EPG_CODIGO")) {
					hasNext = rs.next();
				}**/				

				empCodigo = rs.getInt("EMP_CODIGO");
				epgCodigo = rs.getInt("EPG_CODIGO");
				Timestamp admissaoData = rs.getTimestamp("ADMISSAODATA");
				Timestamp data_vid = rs.getTimestamp("DATA_VID");
				String valorVid = rs.getString("VALOR_VID");
				String indCodigo = rs.getString("IND_CODIGO");
				String primeiroValor = null;
				
				boolean dataVidIgualDataAdmissao = false;
				Timestamp data_vid_anterior = null;
				String valorVid_anterior = null;
				
				while(hasNext &&
					  empCodigo == rs.getInt("EMP_CODIGO") &&
			          epgCodigo == rs.getInt("EPG_CODIGO") /*&&
					  (data_vid.before(admissaoData) || data_vid.compareTo(admissaoData) == 0)*/){
					System.out.println("empCodigo: " + empCodigo + ", epgCodigo: " + epgCodigo);
					System.out.println("data_vid: " + data_vid + "admissaoData: " + admissaoData + "\n");
					data_vid = rs.getTimestamp("DATA_VID");

					valorVid = rs.getString("VALOR_VID");
					if(primeiroValor == null)
						primeiroValor = valorVid;
					indCodigo = rs.getString("IND_CODIGO");
					if(data_vid.before(admissaoData)) {
						data_vid_anterior = data_vid;
						valorVid_anterior = valorVid;
					}
					else if(data_vid.compareTo(admissaoData)==0) {
						dataVidIgualDataAdmissao = true;
					}
					admissaoData = rs.getTimestamp("ADMISSAODATA");
					
					hasNext = rs.next();
					dbLine(empCodigo, epgCodigo, admissaoData, data_vid, indCodigo, valorVid);
					
				
				}
				if(data_vid_anterior != null && dataVidIgualDataAdmissao==false) {
					dbLine(empCodigo, epgCodigo, admissaoData, admissaoData, indCodigo, valorVid_anterior);
				}
				else if(data_vid_anterior == null) {
					dbLine(empCodigo, epgCodigo, admissaoData, admissaoData, indCodigo, primeiroValor);
				}
				/*admissaoData = rs.getTimestamp("ADMISSAODATA");
				
				valorVid = rs.getString("VALOR_VID");
				indCodigo = rs.getString("IND_CODIGO");*/
	
				//dbLine(empCodigo, epgCodigo, admissaoData, data_vid, indCodigo, valorVid);

				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		private void dbLine(int empCodigo, int epgCodigo, Timestamp admissaoData, Timestamp data_vid, String indCodigo, String valorVid) {
			DBLine dbl = new DBLine();
			//aLTERACAO É DAQUI PRA BAIXO
				
			dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
			
			dbl.getFields().add(new NumberField(5, empCodigo));
			
			dbl.getFields().add(new NumberField(7, epgCodigo));
			
			
					/*if(data_vid.before(admissaoData)){
				dbl.getFields().add(new DateField(10, admissaoData));
			}else { 
				dbl.getFields().add(new DateField(10, data_vid));
			}**/
			dbl.getFields().add(new DateField(10, data_vid));
			dbl.getFields().add(new StringField(4, "1"));
			dbl.getFields().add(new StringField(10, indCodigo));
			
			if(data_vid.compareTo(admissaoData)==0) {
				dbl.getFields().add(new NumberField(4, "1"));
			}else {
				dbl.getFields().add(new NumberField(4, "2"));
			}
			dbl.getFields().add(new NumberField(5, "1"));
			dbl.getFields().add(new StringField(16, valorVid));

			dbl.getFields().add(new StringField(20, ""));
			dbl.getFields().add(new StringField(18, "000000000000000,00"));
			dbl.getFields().add(new StringField(18, "000000000000000,00"));
			dbl.getFields().add(new StringField(16, "0000000000000,00"));
			dbl.getFields().add(new StringField(255, ""));
			dbl.getFields().add(new NumberField(3, "0"));
			
			
			
			
			//ALTERACAO E DAQUI PRA CIMA
			this.lines.add(dbl);
		}
}	