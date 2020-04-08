package pvctr.grupoa.dbtotext.main;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.filecreator.FileCreator;
import pvctr.grupoa.dbtotext.tables.*;

public class DBToText {

	public static void main(String[] args) {

		EPGTable epgTable = new EPGTable(new Connector());
		DEPTable depTable = new DEPTable(new Connector());
		SEPTable sepTable = new SEPTable(new Connector());
		CARTable carTable = new CARTable(new Connector());
		FUNCCTPSTable funcctpsTable = new FUNCCTPSTable(new Connector());
		FUNCCARGOTable funccargoTable = new FUNCCARGOTable(new Connector());
		TOMTable tomTable = new TOMTable(new Connector());
		OUTRAEMPEMPTable outraempempTable = new OUTRAEMPEMPTable(new Connector());
		FUNCOUTRAEMPTable funcoutraempTable = new FUNCOUTRAEMPTable(new Connector());
		LOTACAOTable lotacaoTable = new LOTACAOTable(new Connector());
		HORARIOTable horarioTable = new HORARIOTable(new Connector());
		SINDTable sindTable = new SINDTable(new Connector());
		FUNCSINDICATOTable funcsindicatoTable = new FUNCSINDICATOTable(new Connector());
		ORGANOGRAMATable organogramaTable = new ORGANOGRAMATable(new Connector());
		FUNCLOCALTable funclocalTable = new FUNCLOCALTable(new Connector());
		FUNCSALARIOTable funcsalarioTable = new FUNCSALARIOTable(new Connector());
		FUNCLOCALCTBTable funclocalctbTable = new FUNCLOCALCTBTable(new Connector());
		
		FileCreator.CreateFile("FuncPessoa", epgTable.tableToText());
		FileCreator.CreateFile("Dependente", depTable.tableToText());
		FileCreator.CreateFile("FuncContrato", sepTable.tableToText());
		FileCreator.CreateFile("Cargo", carTable.tableToText());
		FileCreator.CreateFile("FUNCCTPS", funcctpsTable.tableToText());
		FileCreator.CreateFile("FUNCCARGO", funccargoTable.tableToText());
		FileCreator.CreateFile("OutraEmpresa", tomTable.tableToText());
		FileCreator.CreateFile("OutraEmpEmp", outraempempTable.tableToText());
		FileCreator.CreateFile("FuncOutraEmp", funcoutraempTable.tableToText());
		FileCreator.CreateFile("Lotacao", lotacaoTable.tableToText());
		FileCreator.CreateFile("Horario", horarioTable.tableToText());
		FileCreator.CreateFile("Sindicato", sindTable.tableToText());
		FileCreator.CreateFile("Funcsindicato", funcsindicatoTable.tableToText());
		FileCreator.CreateFile("Organograma", organogramaTable.tableToText());
		FileCreator.CreateFile("Funclocal", funclocalTable.tableToText());
		FileCreator.CreateFile("Funcsalario", funcsalarioTable.tableToText());
		FileCreator.CreateFile("Funclocalctb", funclocalctbTable.tableToText());
		
		
		//System.out.println(epgTable.tableToText());
		System.out.println("Done!");
	}

}
