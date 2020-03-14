package pvctr.grupoa.dbtotext.tables;

import java.util.ArrayList;

import pvctr.grupoa.dbtotext.fields.DatabaseField;
import pvctr.grupoa.dbtotext.lines.DBLine;

public abstract class GenericTable {

	protected ArrayList<DBLine> lines = new ArrayList<DBLine>();
	
	public StringBuilder tableToText() {
		
		StringBuilder sb = new StringBuilder();
		
		for(DBLine dbl : lines) {
			for(DatabaseField dbf : dbl.getFields()) {
				sb.append(dbf.toText());
			}
			sb.append("\r\n");
		}
		
		return sb;
	}
}
