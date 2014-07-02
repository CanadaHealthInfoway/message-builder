package ca.infoway.messagebuilder.guide.examples.devtools;

import static ca.infoway.messagebuilder.datatype.StandardDataType.BL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.util.messagegenerator.DefaultDataTypeValueStore;

public class MyDefaultDataTypeValueStore extends DefaultDataTypeValueStore {

	public MyDefaultDataTypeValueStore() {
		super();

		// my default values
		this.addValue(II, new Identifier("5.6.7", "MY CUSTOM II"));
		this.addValue(BL, Boolean.FALSE);
	}
}
