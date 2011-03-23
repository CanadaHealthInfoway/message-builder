package ca.infoway.messagebuilder.marshalling.hl7;

public class RealCoordFormat implements RealFormat {
	
	public RealCoordFormat() {
	}
	
	public int getMaxDecimalPartLength() {
		return 4;
	}

	public int getMaxIntegerPartLength() {
		return 1;
	}

	public int getMaxValueLength() {
		return 6;
	}
}
