package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

public class InlinedAttribute extends Attribute {

	private static final long serialVersionUID = -4309595874411105506L;
	
	private final BaseRelationship elidedRelationship;
	private final Attribute inlinedRelationship;

	protected InlinedAttribute(Attribute inlinedRelationship, BaseRelationship elidedRelationship) {
		this(inlinedRelationship, elidedRelationship, false);
	}
	
	protected InlinedAttribute(Attribute inlinedRelationship, BaseRelationship elidedRelationship, boolean indicator) {
		super(inlinedRelationship.getRelationship(), inlinedRelationship.getDataType(), indicator);
		this.inlinedRelationship = inlinedRelationship;
		this.elidedRelationship = elidedRelationship;
	}
	
	@Override
	public String getName() {
		return this.elidedRelationship.getName() + WordUtils.capitalize(this.inlinedRelationship.getName());
	}
	
	@Override
	XmlMappingHelper getXmlMappingHelper() {
		return this.elidedRelationship.getXmlMappingHelper().concat(inlinedRelationship.getXmlMappingHelper());
	}
	
	@Override
	public Documentation getDocumentation() {
		if (this.inlinedRelationship.getDocumentation() != null) {
			return this.inlinedRelationship.getDocumentation();
		} else if (this.elidedRelationship.getDocumentation() != null) {
			return this.elidedRelationship.getDocumentation();
		} else {
			return null;
		}
	}
	
	@Override
	public Cardinality getCardinality() {
		Cardinality cardinality = super.getCardinality();
		if (new Cardinality(1,1).equals(cardinality)) {
			return this.elidedRelationship.getCardinality();
		} else {
			return cardinality;
		}
	}
	
	@Override
	public Set<Object> getImportTypes() {
		Set<Object> result = super.getImportTypes();
		if (this.elidedRelationship.isCardinalityMultiple()) {
			result.add(List.class.getName());
			result.add(ArrayList.class.getName());
		}
		return result;
	}

	BaseRelationship getElidedRelationship() {
		return this.elidedRelationship;
	}

	Attribute getInlinedRelationship() {
		return this.inlinedRelationship;
	}
	@Override
	Relationship getOriginalRelationship() {
		return this.elidedRelationship.getOriginalRelationship();
	}
	
	@Override
	public Fingerprint getFingerprint() {
		return getElidedRelationship().getFingerprint().concat(getInlinedRelationship().getFingerprint());
	}
}
