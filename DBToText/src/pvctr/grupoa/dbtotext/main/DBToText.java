package pvctr.grupoa.dbtotext.main;

import pvctr.grupoa.dbtotext.connection.Connector;
import pvctr.grupoa.dbtotext.filecreator.FileCreator;
import pvctr.grupoa.dbtotext.tables.*;

public class DBToText {

	public static void main(String[] args) {

		EPGTable epgTable = new EPGTable(new Connector());
		DEPTable depTable = new DEPTable(new Connector());
		SEPTable sepTable = new SEPTable(new Connector());
		
		FileCreator.CreateFile("FuncPessoa", epgTable.tableToText());
		FileCreator.CreateFile("Dependentes", depTable.tableToText());
		FileCreator.CreateFile("FuncContrato", sepTable.tableToText());
		//System.out.println(epgTable.tableToText());
		System.out.println("Done!");
	}

}
