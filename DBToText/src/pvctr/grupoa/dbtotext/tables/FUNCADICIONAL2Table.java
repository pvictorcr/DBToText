package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class FUNCADICIONAL2Table extends GenericTable {

	private final String tableName = "ERF inner join (select distinct sep_epg_codigo as codigodoempregado, min(sep_data) as mindata from erf group by emp_codigo, sep_epg_codigo) on codigodoempregado = sep_epg_codigo and  mindata = sep_data where emp_codigo = '0008' order by emp_codigo, codigodoempregado, mindata";
			//"ERF WHERE EMP_CODIGO = '0008' order by SEP_EPG_CODIGO, SEP_DATA"; 
			//"SEP INNER JOIN EPG ON EPG.EMP_CODIGO = SEP.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO LEFT JOIN SEP B ON SEP.EPG_CODIGO = B.EPG_CODIGO AND SEP.EMP_CODIGO = B.EMP_CODIGO AND SEP.DATA < B.DATA WHERE B.DATA IS NULL AND EPG.DTRESCISAO IS NULL AND EPG.EMP_CODIGO = '0008'";
	
	public FUNCADICIONAL2Table(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		//Essa tabela
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO ***
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(7, rs.getInt("CODIGODOEMPREGADO")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("MINDATA")));
				dbl.getFields().add(new StringField(2, "00"));
				dbl.getFields().add(new NumberField(1, "0"));
				
				Integer evecodigoread = rs.getInt("EVE_CODIGO");
				
				if (evecodigoread == 16) {
					dbl.getFields().add(new StringField(8, rs.getString("PARAMETRO")));
				
					if (evecodigoread == 100) {
					dbl.getFields().add(new StringField(8, rs.getString("PARAMETRO")));	
				
					if (evecodigoread == 905) {
					dbl.getFields().add(new StringField(8, rs.getString("PARAMETRO")));
				} } }
				else {
					dbl.getFields().add(new StringField(8, "000000000"));
				} 
				if (evecodigoread == 13) {
					dbl.getFields().add(new StringField(8, rs.getString("PARAMETRO")));
				}
				else {
					dbl.getFields().add(new StringField(8, "00000000"));
				}
				dbl.getFields().add(new NumberField(8, ""));
				dbl.getFields().add(new NumberField(8, ""));
				dbl.getFields().add(new NumberField(8, ""));
						
				//ALTERACAO E DAQUI PRA CIMA ***
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
