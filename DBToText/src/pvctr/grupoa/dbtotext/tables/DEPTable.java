package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class DEPTable extends GenericTable {

	private final String tableName = "DEP INNER JOIN EPG ON EPG.EMP_CODIGO = DEP.EMP_CODIGO AND DEP.EPG_CODIGO = EPG.CODIGO WHERE EPG.EMP_CODIGO = '0008'";
	
	public DEPTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		int i =0;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(7, rs.getInt("EPG_CODIGO")));
				dbl.getFields().add(new NumberField(5, rs.getInt("SEQ")));
				dbl.getFields().add(new StringField(70, rs.getString("NOME")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("NASCDATA")));
				dbl.getFields().add(new StringField(2, "01"));   //dbl.getFields().add(new StringField(2, Utilities.treatParente(rs.getString("TB_TIP_DEP_CODIGO"))));
				dbl.getFields().add(new StringField(14, Utilities.treatCPF(rs.getString("CPF"))));
				dbl.getFields().add(new NumberField(2, Utilities.treatSex(rs.getString("SEXO"))));
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new StringField(3, "1"));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(3, "014"));
				dbl.getFields().add(new StringField(4, "021"));
				dbl.getFields().add(new StringField(1, Utilities.treatSimounao(rs.getString("INCAPAZTRABALHO"))));
				dbl.getFields().add(new StringField(5, "1"));
				dbl.getFields().add(new StringField(2, "1")); //CONTROLE DE VACINA
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(2, Utilities.treatUfsigla(rs.getString("MUN_UFD_SIGLA_NASC"))));
				dbl.getFields().add(new NumberField(8, Utilities.getCodmunicipio(rs.getString("MUN_UFD_SIGLA_NASC"), rs.getString("MUN_CODIGO_NASC")))); //codigomunic - verificar alteração deste campo
				dbl.getFields().add(new StringField(3, "10"));
				dbl.getFields().add(new StringField(30, rs.getString("CERTIDAOCARTORIO")));
				dbl.getFields().add(new StringField(6, rs.getString("CERTIDAOLIVRO")));
				dbl.getFields().add(new StringField(6, rs.getString("CERTIDAOFOLHA")));
				dbl.getFields().add(new StringField(10, rs.getString("CERTIDAONUMERO")));
				dbl.getFields().add(new StringField(50, rs.getString("CERTIDAOMATRICULA")));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(3, "0"));
				dbl.getFields().add(new StringField(1, "1"));
				
				
			
				
				
				
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
