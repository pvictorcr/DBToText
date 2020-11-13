package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class FUNCAOTable extends GenericTable {

	private final String tableName = "emp inner join (SELECT EMP_CODIGO AS EMPCOD_FUN, codigo AS FUN_CODIGO, NOME AS NOME_FUN FROM FUN) on emp.codigo = EMPCOD_FUN\n" + 
			"inner join car C on emp.codigo = C.emp_codigo WHERE EMPCOD_FUN = '0008' AND C.nome = NOME_FUN";
	
	public FUNCAOTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO ***
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(7, rs.getInt("FUN_CODIGO")));
				dbl.getFields().add(new StringField(10, "01/01/1900"));
				dbl.getFields().add(new StringField(100, rs.getString("NOME_FUN")));
				dbl.getFields().add(new StringField(6, rs.getString("CBO_CODIGO")));
				dbl.getFields().add(new NumberField(3, "0"));
				
						
				//ALTERACAO E DAQUI PRA CIMA ***
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
