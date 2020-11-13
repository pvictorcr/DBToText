package pvctr.grupoa.dbtotext.fields;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateMYField extends DatabaseField {

	Timestamp field;
	
	public DateMYField(int size, Timestamp field) {
		this.size = size;
		this.field = field;
	}
	
	@Override
	public String toText() {

		if(field == null)
			return "01/1901";
		
		return new SimpleDateFormat("MM/yyyy").format(field);
	}

}