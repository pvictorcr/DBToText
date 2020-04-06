package pvctr.grupoa.dbtotext.fields;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DatetimeField extends DatabaseField {

	Timestamp field;
	
	public DatetimeField(int size, Timestamp field) {
		this.size = size;
		this.field = field;
	}
	
	@Override
	public String toText() {

		if(field == null)
			return "01/01/1901 00:00:00";
		
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(field);
		
	}

}