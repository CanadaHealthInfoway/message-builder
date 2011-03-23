package ca.infoway.messagebuilder.marshalling.hl7;


public interface RealFormat {

	public int getMaxDecimalPartLength();
	public int getMaxIntegerPartLength();
	public int getMaxValueLength();

}
