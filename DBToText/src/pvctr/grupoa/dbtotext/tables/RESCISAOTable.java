package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class RESCISAOTable extends GenericTable {

	private final String tableName = "epg inner JOIN efo ON EPG_CODIGO = CODIGO\n" + 
			"INNER JOIN FOL ON FOL.SEQ = EFO.fol_seq\n" + 
			"INNER JOIN (SELECT EMP_CODIGO AS EMPCOD_REC, FOL_SEQ as FOLSEQ_REC,\n" +
			"TRC_CODIGO, DATAAVISO, DISPINDAVISO, JORNADACUMPRIDA, COMPENSASABADO, DIASAVISO, DATAPAGAMENTO,\n" +
			"MAIORREMUNERACAO, SALDOCEF, TIPOAVISO from REC) ON FOLSEQ_REC = FOL.SEQ\n" + 
			"WHERE EPG.EMP_CODIGO = '0008' and folha = 10 ORDER BY EPG.CODIGO";
	
	public RESCISAOTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO ***
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMPCOD_REC")));
				dbl.getFields().add(new NumberField(7, rs.getInt("CODIGO")));
				dbl.getFields().add(new NumberField(3, "1"));
				dbl.getFields().add(new StringField(5, "1"));
				dbl.getFields().add(new NumberField(11, ""));
				dbl.getFields().add(new StringField(2, Utilities.treatTipoaviso2("TIPOAVISO")));
				dbl.getFields().add(new NumberField(4, rs.getInt("TRC_CODIGO")));
				dbl.getFields().add(new StringField(3, ""));
				dbl.getFields().add(new StringField(2, ""));
				dbl.getFields().add(new StringField(2, ""));
				dbl.getFields().add(new StringField(2, ""));
				dbl.getFields().add(new StringField(5, "1"));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DATAAVISO")));
				dbl.getFields().add(new StringField(1, "1"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(1, Utilities.treatSimounao("DISPINDAVISO")));
				dbl.getFields().add(new StringField(1, Utilities.treatSimounao("JORNADACUMPRIDA")));
				dbl.getFields().add(new StringField(1, Utilities.treatSimounao("COMPENSASABADO")));
				dbl.getFields().add(new NumberField(4, rs.getInt("DIASAVISO")));
				dbl.getFields().add(new NumberField(4, rs.getInt("DIASAVISO")));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DTRESCISAO")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DATAPAGAMENTO")));
				dbl.getFields().add(new StringField(1, "1"));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(50, ""));
				dbl.getFields().add(new NumberField(4, rs.getInt("DIASTRABALHADOS")));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(1, Utilities.treatTipoaviso("TIPOAVISO")));
				dbl.getFields().add(new StringField(1, Utilities.treatTipoaviso("TIPOAVISO")));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(16, rs.getString("MAIORREMUNERACAO")));
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new StringField(16, rs.getString("SALDOCEF")));
				dbl.getFields().add(new StringField(255, ""));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(3, "0"));
				dbl.getFields().add(new StringField(3, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(1, "1"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new NumberField(16, "0,00"));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(7, ""));
				dbl.getFields().add(new StringField(32, ""));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(3, "0"));
				
				
				
				
						
				//ALTERACAO E DAQUI PRA CIMA ***
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
