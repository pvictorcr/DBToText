package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class SINDTable extends GenericTable {

	private final String tableName = "SIN";
	
	public SINDTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("CODIGO")));
				String nome = rs.getString("NOME");
				String abv = "";
				for(String s : nome.split(" +"))
					abv += s.toUpperCase().charAt(0);
				dbl.getFields().add(new StringField(50, nome));
				dbl.getFields().add(new StringField(10, "01/01/1900"));
				dbl.getFields().add(new StringField(20, abv));
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new StringField(19, Utilities.treatCNPJ(rs.getString("CNPJ"))));
				dbl.getFields().add(new StringField(18, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(21, "000000000000000000033"));
				dbl.getFields().add(new StringField(40, rs.getString("ENDLOGRADOURO")));
				dbl.getFields().add(new NumberField(7,Utilities.toNumbersOnly(rs.getString("ENDNUMERO"))));
				dbl.getFields().add(new StringField(20, rs.getString("ENDCOMPLEMENTO")));
				dbl.getFields().add(new StringField(30, rs.getString("BAIRRO")));
				dbl.getFields().add(new StringField(2, rs.getString("MUN_UFD_SIGLA")));
				dbl.getFields().add(new NumberField(8, Utilities.getCodmunicipio(rs.getString("MUN_UFD_SIGLA"), rs.getString("MUN_CODIGO")))); //codigomunic - verificar alteração deste campo
				dbl.getFields().add(new StringField(10, Utilities.treatCEP(rs.getString("CEP")))); //cep
				dbl.getFields().add(new StringField(7, ""));
				dbl.getFields().add(new StringField(5, rs.getString("DDD")));
				dbl.getFields().add(new StringField(10, rs.getString("FONE")));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(100, rs.getString("EMAIL")));
				dbl.getFields().add(new StringField(100, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(3, "000"));
					
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
