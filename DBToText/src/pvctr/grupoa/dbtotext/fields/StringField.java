package pvctr.grupoa.dbtotext.fields;

public class StringField extends DatabaseField {

	private String field = "";
	
	public StringField(int size, String field) {
		this.size = size;
		this.field = field;
	}

	@Override
	public String toText() {

		if(this.field == null)
			this.field = "";
		
		return String.format("%-" + this.size + "s", this.field.substring(0, Math.min(size, this.field.length())));
	}
}
