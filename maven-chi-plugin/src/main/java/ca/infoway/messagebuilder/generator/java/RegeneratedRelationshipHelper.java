package ca.infoway.messagebuilder.generator.java;

import java.util.LinkedHashSet;
import java.util.Set;

public class RegeneratedRelationshipHelper {

	private final RegeneratedRelationship regeneratedRelationship;

	public RegeneratedRelationshipHelper(RegeneratedRelationship regeneratedRelationship) {
		this.regeneratedRelationship = regeneratedRelationship;
	}

	public Set<Object> getImportTypes() {
		Set<Object> importedTypes = new LinkedHashSet<Object>();
		// FIXME - TM - REGEN - some of the import types may have to be checked against removed types
		//                    - leaving this work until we know where the regen work/re-design is headed
		importedTypes.addAll(this.regeneratedRelationship.getNewRelationship().getImportTypes());
		return importedTypes;
	}

}
