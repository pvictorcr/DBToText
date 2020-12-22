package pvctr.grupoa.dbtotext.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.fields.DateField;
import pvctr.grupoa.dbtotext.fields.NumberField;
import pvctr.grupoa.dbtotext.fields.StringField;
import pvctr.grupoa.dbtotext.lines.DBLine;
import pvctr.grupoa.dbtotext.utils.Utilities;
import pvctr.grupoa.dbtotext.fields.DateMYField;
import java.sql.Timestamp;

public class EVENTOVARIAVELPIPETable extends GenericTable {
//  ***ARQUIVO GERADO COM PIPES PARA SER IMPORTADO PELO IMPORTADOR VIA LAYOUT GERADO, ONDE DEVE SER IMPORTADO PELA ROTINA
//     UTILITÁRIOS > BANCO DE DADOS > IMPORTAÇÃO ***
	private final String tableName = "fol\r\n"
			+ "inner join efo\r\n"
			+ "on fol_seq = seq\r\n"
			+ "left join efp on efo_fol_seq = fol_seq\r\n"
			+ "and epg_codigo = efo_epg_codigo\r\n"
			+ "where fol.emp_codigo = '0008' and dtcalculo = '30.09.2020 00:00'\r\n"
			+ "and eve_codigo not in(011, 310, 091, 600, 601, 602, 603, 604, 605) order by dtcalculo";
	
	public EVENTOVARIAVELPIPETable(Connector con) {
		
		ResultSet rs = con.getTable(tableName);
		int codFuncPessoa = 1;
		int ID = 1;
		int empregadoAnterior = 0;
		
		
		try {
			while(rs.next()) {
				
				DBLine dbl = new DBLine();
				//aLTERACAO Ã‰ DAQUI PRA BAIXO
		int empregadoAtual = rs.getInt("EFO_EPG_CODIGO");
		int codigodoevento = rs.getInt("EVE_CODIGO");
		int valordoevento = rs.getInt("VALOR");
		int parametrodoevento = rs.getInt("PARAMETRO");
		//if(codigodoevento == 31 && parametrodoevento != 0 || valordoevento != 0) {
		if(empregadoAnterior == empregadoAtual) {
			++ID;
		}else {
			ID = 1;
		} empregadoAnterior = empregadoAtual;
				System.out.println("ParÃ¢metrodo evento: " + parametrodoevento);
				System.out.println("valor do evento: " + valordoevento);
			
				
				dbl.getFields().add(new StringField(1, " ")); //NAO MEXER
				dbl.getFields().add(new StringField(5, rs.getString("EMP_CODIGO")));
				dbl.getFields().add(new StringField(1, "|"));
				dbl.getFields().add(new StringField(11, "00000001008"));
				dbl.getFields().add(new StringField(1, "|"));
				dbl.getFields().add(new NumberField(11, ID)); //SEQUENCIAL
				dbl.getFields().add(new StringField(1, "|"));
				dbl.getFields().add(new NumberField(8, rs.getInt("EFO_EPG_CODIGO")));
				dbl.getFields().add(new StringField(1, "|"));
				dbl.getFields().add(new StringField(11, rs.getString("EVE_CODIGO")));
				dbl.getFields().add(new StringField(1, "|"));
				dbl.getFields().add(new StringField(18, rs.getString("PARAMETRO"))); //Referência do Evento
				dbl.getFields().add(new StringField(1, "|"));
						System.out.println(codigodoevento);
				dbl.getFields().add(new StringField(16, rs.getString("VALOR"))); //Valor do Evento
				dbl.getFields().add(new StringField(1, "|"));
				dbl.getFields().add(new StringField(3, "~"));
				dbl.getFields().add(new StringField(11, "~"));
				dbl.getFields().add(new StringField(6, "~"));
				dbl.getFields().add(new StringField(11, "~"));
				dbl.getFields().add(new StringField(1, "0"));
				/*dbl.getFields().add(new DateMYField(10, rs.getTimestamp("SEP_DATA")));
				
				Timestamp sepdataread = rs.getTimestamp("SEP_DATA");
				Timestamp sepdataread2 = rs.getTimestamp("DATA2");
				if(sepdataread.compareTo(sepdataread2) == 0) {
					dbl.getFields().add(new DateMYField(10, rs.getTimestamp("SEP_DATA")));
				}
				else {
					dbl.getFields().add(new StringField(10, ""));
			} **/
				
				
				
				//ALTERACAO E DAQUI PRA CIMA
				this.lines.add(dbl);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}

