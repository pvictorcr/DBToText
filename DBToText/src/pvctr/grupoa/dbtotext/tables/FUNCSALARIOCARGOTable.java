package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;
import java.sql.Timestamp;

public class FUNCSALARIOCARGOTable extends GenericTable {

	private final String tableName = "EPG INNER JOIN (select emp_codigo as cod2, epg_codigo as epgcod2, max(data) as maxdata, valor, ind_codigo_salario, saltipo from sep group by emp_codigo, epg_codigo, data, valor, ind_codigo_salario, saltipo)\n" + 
			"on emp_codigo = cod2 and codigo = epgcod2\n" + 
			"left join (select ind_codigo, data as data_vid, valor valor_vid from vid group by ind_codigo, data_vid, valor_vid) on ind_codigo = ind_codigo_salario\n" + 
			"WHERE EPG.DTRESCISAO IS NULL AND EMP_CODIGO = '0008'";
			/** BACKUP---"EPG\n" +
            "INNER JOIN SEP ON EPG.EMP_CODIGO = SEP.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO\n" +
            "inner join (select emp_codigo as cod2, epg_codigo as epgcod2, data as dataSEP from sep group by emp_codigo, epg_codigo, data)\n" +
            "on sep.emp_codigo = cod2 and sep.epg_codigo = epgcod2 and sep.data = datasep\n" +
            "INNER JOIN (SELECT EMP_CODIGO AS CODIGO_SCA, MAX(VALOR) AS VALOR_SCA, MAX(DATA) AS DATA_SCA FROM SCA GROUP BY CODIGO_SCA, VALOR, DATA) ON CAR_CODIGO = SEP.CAR_CODIGO\n" +
            "INNER JOIN car on CAR.CODIGO = SEP.car_codigo AND CAR.EMP_CODIGO = CODIGO_SCA\n" +
            "WHERE SEP.SALTIPO = 'C' AND EPG.DTRESCISAO IS NULL AND CODIGO_SCA = '0069' 
	*/
	public FUNCSALARIOCARGOTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(7, rs.getInt("epgcod2")));
				String saltipo = rs.getString("SALTIPO");
				Timestamp data_vid = rs.getTimestamp("DATA_VID");
				Timestamp data_sep = rs.getTimestamp("MAXDATA");
				
				if (saltipo == "V") {
					dbl.getFields().add(new DateField(10, rs.getTimestamp("DATA")));
				} else {
			
					dbl.getFields().add(new DateField(10, rs.getTimestamp("DATA_VID")));
				
				}
				dbl.getFields().add(new StringField(4, "1"));
				dbl.getFields().add(new StringField(10, "")); //estrutura salarial
				dbl.getFields().add(new NumberField(4, "1"));
				dbl.getFields().add(new NumberField(5, "1"));
				if (saltipo == "V") {
					dbl.getFields().add(new StringField(16, rs.getString("VALOR")));
				
				} else {
					dbl.getFields().add(new StringField(16, rs.getString("VALOR_VID")));
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