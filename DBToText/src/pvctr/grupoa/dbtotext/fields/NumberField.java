package pvctr.grupoa.dbtotext.fields;

public class NumberField extends DatabaseField{

	private long field = 0;

	public NumberField(int size, long field) {
		this.size = size;
		this.field = field;

	}

	public NumberField(int size, String s_field) {
		this.size = size;
		if(s_field != null && s_field.trim().matches("\\d+"))
			this.field = Long.parseLong(s_field.trim());
		else
			this.field = 0;

	}

	@Override
	public String toText() {


		return String.format("%0" + this.size + "d", field);

	}

}

