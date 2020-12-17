package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;

public class DEPMAEPAITable extends GenericTable {

	private final String tableName = "EPG WHERE EPG.EMP_CODIGO = '0008'";
	
	public DEPMAEPAITable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		int	i = 2;
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO É DAQUI PRA BAIXO
				int empCodigo = rs.getInt("EMP_CODIGO");
				int epgCodigo = rs.getInt("CODIGO");
				String maenome = rs.getString("MAENOME");
				String painome = rs.getString("PAINOME");
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, empCodigo));
				dbl.getFields().add(new NumberField(7, epgCodigo));
				dbl.getFields().add(new StringField(5, "20"));
				if(maenome == null || maenome == "") {
					dbl.getFields().add(new StringField(70, "NÃO DECLARADO"));
				}else {	
					dbl.getFields().add(new StringField(70, rs.getString("MAENOME")));
				}
				dbl.getFields().add(new StringField(10, "01/01/1900"));
				dbl.getFields().add(new StringField(2, "03"));   //dbl.getFields().add(new StringField(2, Utilities.treatParente(rs.getString("TB_TIP_DEP_CODIGO"))));
				dbl.getFields().add(new StringField(14, "000.000.000-00"));
				dbl.getFields().add(new StringField(2, "2")); //SEXO
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new StringField(3, "7"));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(3, "014"));
				dbl.getFields().add(new StringField(4, "021"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(5, "1"));
				dbl.getFields().add(new StringField(2, "1")); //CONTROLE DE VACINA
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(2, "RN"));
				dbl.getFields().add(new StringField(8, "89"));
				dbl.getFields().add(new StringField(3, "10"));
				dbl.getFields().add(new StringField(30, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(50, ""));
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
				
				
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new NumberField(5, empCodigo));
				dbl.getFields().add(new NumberField(7, epgCodigo));
				dbl.getFields().add(new StringField(5, "10"));
				if(painome == null || painome == "") {
					dbl.getFields().add(new StringField(70, "NÃO DECLARADO"));
				}else {	
					dbl.getFields().add(new StringField(70, rs.getString("PAINOME")));
				}
				dbl.getFields().add(new StringField(10, "01/01/1900"));
				dbl.getFields().add(new StringField(2, "03"));   //dbl.getFields().add(new StringField(2, Utilities.treatParente(rs.getString("TB_TIP_DEP_CODIGO"))));
				dbl.getFields().add(new StringField(14, "000.000.000-00"));
				dbl.getFields().add(new StringField(2, "1")); //SEXO
				dbl.getFields().add(new StringField(2, "1"));
				dbl.getFields().add(new StringField(3, "7"));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(5, ""));
				dbl.getFields().add(new StringField(3, "014"));
				dbl.getFields().add(new StringField(4, "021"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(5, "1"));
				dbl.getFields().add(new StringField(2, "1")); //CONTROLE DE VACINA
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(2, "RN"));
				dbl.getFields().add(new StringField(8, "89"));
				dbl.getFields().add(new StringField(3, "10"));
				dbl.getFields().add(new StringField(30, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(6, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(50, ""));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(20, ""));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(1, "0"));
				dbl.getFields().add(new StringField(10, ""));
				dbl.getFields().add(new StringField(3, "0"));
				dbl.getFields().add(new StringField(1, "1"));
				
				this.lines.add(dbl);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		
		}
		}

	}