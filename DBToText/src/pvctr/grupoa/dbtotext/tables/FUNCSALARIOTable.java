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

	private final String tableName = "SEP INNER JOIN EPG ON EPG.EMP_CODIGO = SEP.EMP_CODIGO AND SEP.EPG_CODIGO = EPG.CODIGO LEFT JOIN SEP B ON SEP.EPG_CODIGO = B.EPG_CODIGO AND SEP.EMP_CODIGO = B.EMP_CODIGO AND SEP.DATA < B.DATA WHERE B.DATA IS NULL AND EPG.DTRESCISAO IS NULL AND EPG.EMP_CODIGO = '0008'";
	
	public FUNCSALARIOTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(7, rs.getInt("EPG_CODIGO")));	
				dbl.getFields().add(new DateField(10, rs.getTimestamp("ADMISSAODATA")));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new NumberField(4, "1"));
				dbl.getFields().add(new NumberField(5, "1"));
				dbl.getFields().add(new StringField(1, Utilities.treatFgts(rs.getString("FGTS"))));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("ADMISSAODATA")));
				dbl.getFields().add(new StringField(12, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(2, rs.getString("ADMISSAOVINCULO")));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(2, rs.getString("MUN_UFD_SIGLA")));
				dbl.getFields().add(new StringField(3, ""));
				dbl.getFields().add(new StringField(2, rs.getString("CATEGORIA")));
				dbl.getFields().add(new StringField(4, rs.getString("CATEGORIAESOCIAL")));
				dbl.getFields().add(new NumberField(5, rs.getInt("QTDDIASPRAZO")));
				dbl.getFields().add(new NumberField(4, rs.getInt("QTDDIASPRAZOPRORROGACAO")));
				dbl.getFields().add(new StringField(4, "1"));
				dbl.getFields().add(new StringField(999, "CADASTRO IMPORTADO POR CONVERSÃO"));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(3, "0"));
				dbl.getFields().add(new StringField(18, Utilities.treatCNPJ(rs.getString("CNPJEMPREGADORANTERIOR"))));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(30, ""));
				dbl.getFields().add(new StringField(3, "0"));
				dbl.getFields().add(new StringField(18, ""));
				dbl.getFields().add(new StringField(30, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(5, "1"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(50, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(9, ""));
				dbl.getFields().add(new StringField(1, "1")); //RECEBE 13 SALARIO
				dbl.getFields().add(new StringField(2, "3"));
				dbl.getFields().add(new StringField(8, ""));
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new StringField(2, "4"));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(19, ""));
				dbl.getFields().add(new StringField(2, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(1, "1"));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(11, ""));
				dbl.getFields().add(new StringField(1, "1"));  //Documentos Completos
				dbl.getFields().add(new StringField(1, "1"));
				dbl.getFields().add(new StringField(20, "1"));
				dbl.getFields().add(new StringField(14, ""));
				dbl.getFields().add(new StringField(1, "1"));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(1, ""));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DTRESCISAO")));
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(5, "2"));
				dbl.getFields().add(new StringField(999, "IMPORTACAO"));
				dbl.getFields().add(new StringField(5, "3"));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(7, ""));
				dbl.getFields().add(new StringField(5, "1"));
				dbl.getFields().add(new StringField(5, "1"));
				dbl.getFields().add(new StringField(19, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(3, "0"));
				dbl.getFields().add(new StringField(5, "0"));
				
				
				
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
