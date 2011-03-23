package ca.infoway.messagebuilder.simple.xml.parser;

public class GivenNameDisambiguator {

	private int timesGivenNameHasBeenMapped;

	public int timesGivenNameHasBeenMapped() {
		return this.timesGivenNameHasBeenMapped;
	}

	public void incrementTimesGivenNameHasBeenMapped() {
		this.timesGivenNameHasBeenMapped++;
	}

}
