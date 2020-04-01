package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class EPGTable extends GenericTable {

	private final String tableName = "EPG WHERE EMP_CODIGO = '0008' AND DTRESCISAO IS NULL";
	
	public EPGTable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				
				dbl.getFields().add(new StringField(1, " "));
				dbl.getFields().add(new NumberField(9, Utilities.getCodFuncionario(rs.getString("EMP_CODIGO"), rs.getString("CODIGO"))));
				dbl.getFields().add(new StringField(70, rs.getString("NOME")));
				dbl.getFields().add(new StringField(70, rs.getString("NOMESOCIAL")));
				dbl.getFields().add(new StringField(14, Utilities.treatCPF(rs.getString("CPF"))));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("DTNASCIMENTO")));
				dbl.getFields().add(new StringField(14, rs.getString("PIS")));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(30, ""));
				dbl.getFields().add(new StringField(10, Utilities.treatCEP(rs.getString("CEP")))); //cep
				dbl.getFields().add(new NumberField(21, 33)); //codtipolograd
				dbl.getFields().add(new StringField(40, rs.getString("ENDLOGRADOURO")));
				dbl.getFields().add(new NumberField(7, Utilities.toNumbersOnly(rs.getString("ENDNUMERO"))));
				dbl.getFields().add(new StringField(20, "")); //rs.getString("ENDCOMPLEMENTO")));
				dbl.getFields().add(new StringField(30, rs.getString("BAIRRO")));
				dbl.getFields().add(new StringField(2, rs.getString("MUN_UFD_SIGLA")));
				dbl.getFields().add(new NumberField(8, Utilities.getCodmunicipio(rs.getString("MUN_UFD_SIGLA"), rs.getString("MUN_CODIGO")))); //codigomunic - verificar alteração deste campo
				dbl.getFields().add(new StringField(10, "")); //codigopostal
				dbl.getFields().add(new StringField(5, rs.getString("DDD")));
				dbl.getFields().add(new StringField(10, rs.getString("FONE")));
				dbl.getFields().add(new StringField(5, "")); //ramal
				dbl.getFields().add(new StringField(5, rs.getString("DDD")));
				dbl.getFields().add(new StringField(11, rs.getString("CELULAR")));
				dbl.getFields().add(new StringField(100, rs.getString("EMAIL")));
				dbl.getFields().add(new StringField(2, rs.getString("MUN_UFD_SIGLA_NATURALIDADE"))); //siglaestadonasc
				dbl.getFields().add(new NumberField(8, Utilities.getCodmunicipio(rs.getString("MUN_UFD_SIGLA_NATURALIDADE"), rs.getString("MUN_CODIGO_NATURALIDADE"))));
                dbl.getFields().add(new NumberField(2, Utilities.treatSex(rs.getString("SEXO"))));
                dbl.getFields().add(new NumberField(2, Utilities.treatRacaCor(rs.getInt("RACACOR"))));
				dbl.getFields().add(new StringField(1, "0")); //Deficiente físico
				dbl.getFields().add(new StringField(1, "0")); //Deficiente visual
				dbl.getFields().add(new StringField(1, "0")); //Deficiente auditiva
				dbl.getFields().add(new StringField(1, "0")); //Deficiente mental
				dbl.getFields().add(new StringField(1, "0")); //Deficiente intelectual
				dbl.getFields().add(new StringField(1, "0")); //Deficiente reabilitado
				dbl.getFields().add(new StringField(1, "0")); //Deficiente cotista PCD
				dbl.getFields().add(new StringField(255, "")); //Deficiente OBS
				dbl.getFields().add(new StringField(2, "3")); //BR - Beneficiário Reabilitado
				dbl.getFields().add(new NumberField(2, Utilities.treatEstadoCivil(rs.getInt("ESTADOCIVIL"))));
				dbl.getFields().add(new NumberField(3, rs.getInt("GRAUINSTRUCAO")));
				dbl.getFields().add(new NumberField(3, rs.getInt("NACIONALIDADE")));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(2, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(1, "")); //CASADOBR
				dbl.getFields().add(new StringField(1, "")); //FILHOSBR
				dbl.getFields().add(new StringField(20, "")); //CARTRNE
				dbl.getFields().add(new StringField(21, "")); //CODIGOORGAOEMISSORRNE
				dbl.getFields().add(new StringField(10, "")); //EXPEDICAORNE
				dbl.getFields().add(new StringField(10, "")); //VALIDRNE
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(20, rs.getString("IDENTIDADENUMERO")));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(21, "10"));
				dbl.getFields().add(new StringField(2, rs.getString("MUN_UFD_SIGLA_IDENTORGAOEXPED")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("IDENTIDADEDTEXPEDICAO")));
				dbl.getFields().add(new StringField(13, rs.getString("TITULO")));
				dbl.getFields().add(new NumberField(5, rs.getString("ZONA")));
				dbl.getFields().add(new NumberField(5, rs.getString("SECAO")));
				dbl.getFields().add(new StringField(15, rs.getString("HABILITACAONUMERO")));
				dbl.getFields().add(new StringField(3, rs.getString("HABILITACAOCATEGORIA")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("HABILITACAOEMISSAO")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("HABILITACAOVENCIMENTO")));
				dbl.getFields().add(new StringField(21, ""));
				dbl.getFields().add(new StringField(2, rs.getString("HABILITACAOUF")));
				dbl.getFields().add(new DateField(10, rs.getTimestamp("HABILITACAODATAPRIMEIRA")));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(3, ""));
				dbl.getFields().add(new StringField(4, ""));
				dbl.getFields().add(new StringField(15, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(18, ""));
				dbl.getFields().add(new StringField(1, "0")); //CERTCIVILTIPO
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(40, ""));
				dbl.getFields().add(new StringField(15, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(40, ""));
				dbl.getFields().add(new StringField(2, ""));
				dbl.getFields().add(new StringField(21, ""));
				dbl.getFields().add(new StringField(21, ""));
				dbl.getFields().add(new StringField(11, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(2, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(21, ""));
				dbl.getFields().add(new StringField(2, ""));
				dbl.getFields().add(new StringField(21, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(255, "IMPORTAÇÃO"));
				dbl.getFields().add(new StringField(3, "0"));
				
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
