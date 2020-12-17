package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class ESTABTable extends GenericTable {

	private final String tableName = "EST INNER JOIN (SELECT EMP.CODIGO CODIGOEMP, NOME EMPNOME, RAZAOSOCIAL EMPRAZAOSOCIAL, NMFANTASIA EMPNMFANTASIA, CNPJBASE, CPF FROM EMP) ON CODIGOEMP = EMP_CODIGO";
	
	public ESTABTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				String cnpjSemVerificador = rs.getString("CNPJBASE") + rs.getString("SEQCNPJ");
				int soma = 0;
				System.out.println(cnpjSemVerificador);
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, rs.getInt("EMP_CODIGO")));
				dbl.getFields().add(new NumberField(5, rs.getInt("CODIGO")));
				dbl.getFields().add(new StringField(10, "01/01/1900")); //DATA INICIAL OU DTINIATV
				dbl.getFields().add(new StringField(100, rs.getString("NOME")));
				dbl.getFields().add(new StringField(300, ""));
				dbl.getFields().add(new StringField(55, rs.getString("EMPNMFANTASIA")));
				int seqCnpj = rs.getInt("SEQCNPJ");
				String apelidoEstab;
				
				if(seqCnpj == 0001) {
					apelidoEstab = "Matriz";
				}else {
					apelidoEstab = "Filial "+seqCnpj;
				}
				dbl.getFields().add(new StringField(10, (apelidoEstab)));
				dbl.getFields().add(new StringField(10, Utilities.treatCEP(rs.getString("CEP"))));
				dbl.getFields().add(new NumberField(21, "33"));//tipologradouro
				dbl.getFields().add(new StringField(40, rs.getString("ENDLOGRADOURO")));
				dbl.getFields().add(new NumberField(7, rs.getInt("ENDNUMERO")));
				dbl.getFields().add(new StringField(50, rs.getString("ENDCOMPLEMENTO")));
				dbl.getFields().add(new StringField(30, rs.getString("BAIRRO")));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(2, rs.getString("MUN_UFD_SIGLA")));
				dbl.getFields().add(new NumberField(8, Utilities.getCodmunicipio(rs.getString("MUN_UFD_SIGLA"), rs.getString("MUN_CODIGO"))));
				dbl.getFields().add(new NumberField(5, rs.getInt("DDD")));
				dbl.getFields().add(new NumberField(10, rs.getInt("FONE")));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(7, ""));
				dbl.getFields().add(new StringField(2, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(100, rs.getString("EMAIL")));
				dbl.getFields().add(new StringField(100, ""));
				dbl.getFields().add(new StringField(10, "01/01/1900"));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(14, ""));
				dbl.getFields().add(new StringField(2, "2"));
				dbl.getFields().add(new StringField(18, Utilities.getCnpjComVerificador(cnpjSemVerificador)));
				dbl.getFields().add(new StringField(18, rs.getString("CPF")));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(14, ""));
				dbl.getFields().add(new StringField(9, ""));
				dbl.getFields().add(new StringField(5, "2062"));
				dbl.getFields().add(new StringField(9, "5243-4/99"));
				dbl.getFields().add(new StringField(200, "Comércio Varejista"));
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new StringField(50, rs.getString("NIRC")));
				dbl.getFields().add(new StringField(10, "01/01/1900"));
				dbl.getFields().add(new StringField(150, ""));
				dbl.getFields().add(new StringField(25, rs.getString("IE")));
				dbl.getFields().add(new StringField(25, ""));
				dbl.getFields().add(new StringField(100, ""));
				dbl.getFields().add(new StringField(25, rs.getString("IM")));
				dbl.getFields().add(new StringField(25, ""));
				dbl.getFields().add(new StringField(19, ""));
				dbl.getFields().add(new StringField(30, ""));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(100, ""));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(4, "1"));
				dbl.getFields().add(new StringField(16, "1,00"));
				dbl.getFields().add(new StringField(16, ""));
				dbl.getFields().add(new StringField(5, "0"));
				dbl.getFields().add(new StringField(100, ""));
				dbl.getFields().add(new StringField(50, ""));
				dbl.getFields().add(new StringField(18, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(3, ""));
				dbl.getFields().add(new StringField(4000, ""));
				
				System.out.println(cnpjSemVerificador);
					
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
