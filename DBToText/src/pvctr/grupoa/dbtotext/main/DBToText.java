package pvctr.grupoa.dbtotext.main;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.filecreator.FileCreator;
import pvctr.grupoa.dbtotext.tables.*;

public class DBToText {

	public static void main(String[] args) {

		//EPGTable epgTable = new EPGTable(new Connector());
		//DEPTable depTable = new DEPTable(new Connector());
		//DEPMAEPAITable depmaepaiTable = new DEPMAEPAITable(new Connector());
		//SEPTable sepTable = new SEPTable(new Connector());
		//CARTable carTable = new CARTable(new Connector());
		//FUNCCTPSTable funcctpsTable = new FUNCCTPSTable(new Connector());
		//FUNCCARGOTable funccargoTable = new FUNCCARGOTable(new Connector());
		//TOMTable tomTable = new TOMTable(new Connector());
		//OUTRAEMPEMPTable outraempempTable = new OUTRAEMPEMPTable(new Connector());
		//FUNCOUTRAEMPTable funcoutraempTable = new FUNCOUTRAEMPTable(new Connector());
		//LOTACAOTable lotacaoTable = new LOTACAOTable(new Connector());
		//HORARIOTable horarioTable = new HORARIOTable(new Connector());
		//SINDTable sindTable = new SINDTable(new Connector());
		//FUNCSINDICATOTable funcsindicatoTable = new FUNCSINDICATOTable(new Connector());
		//ORGANOGRAMATable organogramaTable = new ORGANOGRAMATable(new Connector());
		//FUNCLOCALTable funclocalTable = new FUNCLOCALTable(new Connector());
		//FUNCADICIONAL2Table funcadicional2Table = new FUNCADICIONAL2Table(new Connector());
		//FUNCSALARIOVALORTable funcsalariovalorTable = new FUNCSALARIOVALORTable(new Connector());
		//FUNCSALARIOINDICETable funcsalarioindiceTable = new FUNCSALARIOINDICETable(new Connector());
		//FUNCSALARIOINDICE2Table funcsalarioindice2Table = new FUNCSALARIOINDICE2Table(new Connector());
		//FUNCSALARIOINDICE3Table funcsalarioindice3Table = new FUNCSALARIOINDICE3Table(new Connector());
		//  deixar desativado ---FUNCSALARIOINDICETable funcsalarioindiceTable = new FUNCSALARIOINDICETable(new Connector());
		//FUNCSALARIOCARGOTable funcsalariocargoTable = new FUNCSALARIOCARGOTable(new Connector());
		//EVENTORELACTable eventorelacTable = new EVENTORELACTable(new Connector());
		//MOTIVORELACTable motivorelacTable = new MOTIVORELACTable(new Connector());
		CAUSADEMRELACTable causademrelacTable = new CAUSADEMRELACTable(new Connector());
		//EVENTOFIXOTable eventofixoTable = new EVENTOFIXOTable(new Connector());
		//AFASTAMENTOTable afastamentoTable = new AFASTAMENTOTable(new Connector());
		//PERIODOCALCULOTable periodocalculoTable = new PERIODOCALCULOTable(new Connector());
		//FUNCLOCALCTBTable funclocalctbTable = new FUNCLOCALCTBTable(new Connector());
		//FUNCESCALATable funcescalaTable = new FUNCESCALATable(new Connector());
		//FUNCADICIONALTable funcadicionalTable = new FUNCADICIONALTable(new Connector());
		//FUNCSEGUROTable funcseguroTable = new FUNCSEGUROTable(new Connector());
		//TABELASALARIALTable tabelasalarialTable = new TABELASALARIALTable(new Connector());
		//TABELASALPERTable tabelasalperTable = new TABELASALPERTable(new Connector());
		//PERIODOAQUISTable periodoaquisTable = new PERIODOAQUISTable(new Connector());
		FUNCAOTable funcaoTable = new FUNCAOTable(new Connector());
		RESCISAOTable rescisaoTable = new RESCISAOTable(new Connector());
		
		//FileCreator.CreateFile("FuncPessoa", epgTable.tableToText());
		//FileCreator.CreateFile("Dependente", depTable.tableToText());
		//FileCreator.CreateFile("Dependente_2MAEPAI", depmaepaiTable.tableToText());
		//FileCreator.CreateFile("FuncContrato", sepTable.tableToText());
		//FileCreator.CreateFile("Cargo", carTable.tableToText());
		//FileCreator.CreateFile("FUNCCTPS", funcctpsTable.tableToText());
		//FileCreator.CreateFile("FUNCCARGO", funccargoTable.tableToText());
		//FileCreator.CreateFile("OutraEmpresa", tomTable.tableToText());
		//FileCreator.CreateFile("OutraEmpEmp", outraempempTable.tableToText());
		//FileCreator.CreateFile("FuncOutraEmp", funcoutraempTable.tableToText());
		//FileCreator.CreateFile("Lotacao", lotacaoTable.tableToText());
		//FileCreator.CreateFile("Horario", horarioTable.tableToText());
		//FileCreator.CreateFile("Sindicato", sindTable.tableToText());
		//FileCreator.CreateFile("Funcsindicato", funcsindicatoTable.tableToText());
		//FileCreator.CreateFile("Organograma", organogramaTable.tableToText());
		//FileCreator.CreateFile("Funclocal", funclocalTable.tableToText());
		//FileCreator.CreateFile("FuncAdicional2", funcadicional2Table.tableToText());
		//FileCreator.CreateFile("Funcsalario", funcsalariovalorTable.tableToText());
		//FileCreator.CreateFile("Funcsalario1", funcsalarioindiceTable.tableToText());
		//FileCreator.CreateFile("Funcsalario_teste", funcsalarioindice2Table.tableToText());
		//FileCreator.CreateFile("Funcsalario_3", funcsalarioindice3Table.tableToText());
		//FileCreator.CreateFile("Funcsalario2", funcsalariocargoTable.tableToText());
		//FileCreator.CreateFile("EventoRelac", eventorelacTable.tableToText());
		//FileCreator.CreateFile("MotivoRelac", motivorelacTable.tableToText());
		FileCreator.CreateFile("CausaDemRelac", causademrelacTable.tableToText());
		//FileCreator.CreateFile("EventoFixo", eventofixoTable.tableToText());
		//FileCreator.CreateFile("Afastamento", afastamentoTable.tableToText());
		//FileCreator.CreateFile("Periodocalculo", periodocalculoTable.tableToText());
		//FileCreator.CreateFile("Funclocalctb", funclocalctbTable.tableToText());
		//FileCreator.CreateFile("Funcescala", funcescalaTable.tableToText());
		//FileCreator.CreateFile("Funcadicional", funcadicionalTable.tableToText());
		//FileCreator.CreateFile("Funcseguro", funcseguroTable.tableToText());
		//FileCreator.CreateFile("TabelaSalarial", tabelasalarialTable.tableToText());
		//FileCreator.CreateFile("TabelaSalPer", tabelasalperTable.tableToText());
		//FileCreator.CreateFile("PeriodoAquis", periodoaquisTable.tableToText());
		//FileCreator.CreateFile("Funcao", funcaoTable.tableToText());
		FileCreator.CreateFile("Rescisao", rescisaoTable.tableToText());
		
		//System.out.println(epgTable.tableToText());
		System.out.println("Done!");
	}

}
