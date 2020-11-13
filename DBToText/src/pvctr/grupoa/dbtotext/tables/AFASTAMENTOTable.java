package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class AFASTAMENTOTable extends GenericTable {

	private final String tableName = "LIC inner join EPG on epg_codigo = epg.codigo where lic.emp_codigo = '0008' and dtrescisao is null";
	
	public AFASTAMENTOTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(7, rs.getInt("EPG_CODIGO")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DTINICIAL")));
				dbl.getFields().add(new NumberField(5, "1"));
				dbl.getFields().add(new StringField(16, ""));
				dbl.getFields().add(new StringField(4, Utilities.treatTiposdeAfastamento(rs.getString("TLI_CODIGO"))));
				dbl.getFields().add(new StringField(13, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(16, ""));
				dbl.getFields().add(new StringField(3, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DTFINAL")));
				dbl.getFields().add(new StringField(16, ""));
				dbl.getFields().add(new StringField(10, "")); //rs.getTimestamp("DTPREVISAORETORNO")));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(1, "1"));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(1, "1"));
				dbl.getFields().add(new StringField(1, "1"));
				dbl.getFields().add(new StringField(1, "1"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(3, ""));
				dbl.getFields().add(new StringField(1, Utilities.treatTlicodigo("TLI_CODIGO")));
				dbl.getFields().add(new StringField(5, "0"));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(18, ""));
				dbl.getFields().add(new StringField(50, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(5, "0"));
				dbl.getFields().add(new StringField(11, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(3, "0"));
				dbl.getFields().add(new StringField(255, "IMPORTACAO"));
				dbl.getFields().add(new StringField(19, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(3, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(5, ""));
				
					
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
