package ca.infoway.messagebuilder.marshalling.hl7;

public class RealConfFormat implements RealFormat {
	
	public RealConfFormat() {
	}
	
	public int getMaxDecimalPartLength() {
		return 4;
	}

	public int getMaxIntegerPartLength() {
		return 4;
	}

	public int getMaxValueLength() {
		return 9;
	}
}
