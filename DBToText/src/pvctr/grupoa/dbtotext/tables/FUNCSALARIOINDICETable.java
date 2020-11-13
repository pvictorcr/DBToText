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

public class FUNCSALARIOINDICETable extends GenericTable {

	private final String tableName = "EPG\n" + 
			"INNER JOIN SEP ON EPG.EMP_CODIGO = SEP.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO\n" + 
			"inner join (select emp_codigo as cod2, epg_codigo as epgcod2, max(data) as maxdata from sep group by emp_codigo, epg_codigo)\n" + 
			"on sep.emp_codigo = cod2 and sep.epg_codigo = epgcod2 and sep.data = maxdata\n" + 
			"INNER JOIN (SELECT VALOR AS VALOR_VID, DATA AS DATA_VID, IND_CODIGO FROM VID) ON IND_CODIGO = SEP.IND_CODIGO_SALARIO\n" + 
			"WHERE SEP.SALTIPO = 'I' AND EPG.EMP_CODIGO = '0008'"; 
			//"EPG INNER JOIN SEP ON EPG.EMP_CODIGO = SEP.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO INNER JOIN (SELECT VALOR AS VALOR_VID, DATA AS DATA_VID, IND_CODIGO FROM VID) ON IND_CODIGO = SEP.IND_CODIGO_SALARIO WHERE SEP.SALTIPO = 'I' AND EPG.DTRESCISAO IS NULL AND EPG.EMP_CODIGO = '0008'";
	
	public FUNCSALARIOINDICETable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				String saltipo = rs.getString("SALTIPO");
				Timestamp admissaodata = rs.getTimestamp("ADMISSAODATA");
				Timestamp data_vid = rs.getTimestamp("DATA_VID");
				int valorvid = 0;
				//Timestamp teste == data_vid < admissaodata;
				
				
				/*while(teste == true) {
					valorvid = rs.getInt("VALOR_VID");
					rs.next();
					System.out.println("ainda no laço");
					System.out.println(valorvid);
				}
					System.out.println("saiu do laço");
				rs.next();**/
				
				
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
					
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(7, rs.getInt("EPG_CODIGO")));
				
				
				
				/**if (data_vid.compareTo(admissaodata) < 0) {    //FILTRO DA DATA POR DATA DE ADMISSÃO
					dbl.getFields().add(new DateField(10, rs.getTimestamp("ADMISSAODATA")));
				}
				else {
					dbl.getFields().add(new DateField(10, rs.getTimestamp("DATA_VID")));
				}**/
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DATA_VID")));
				dbl.getFields().add(new StringField(4, "1"));
				dbl.getFields().add(new StringField(10, rs.getString("IND_CODIGO")));
				
				if(data_vid.compareTo(admissaodata)==0) {
					dbl.getFields().add(new NumberField(4, "1"));
				}else {
					dbl.getFields().add(new NumberField(4, "2"));
				}
				dbl.getFields().add(new NumberField(5, "1"));
				if (saltipo == "V") {
					dbl.getFields().add(new StringField(16, rs.getString("VALOR")));
				}
				else {
					dbl.getFields().add(new NumberField(16, valorvid));
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
