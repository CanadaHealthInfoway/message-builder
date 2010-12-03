package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.Hl7TypeName;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

public class Matcher {
	
	private final TypeNameSubstituter substituter;
	private final TypeConverter converter = new TypeConverter();

	public Matcher() {
		this(null);
	}

	public Matcher(TypeNameSubstituter substituter) {
		this.substituter = substituter;
	}
	
	public boolean matchesBusinessName(Interaction base, Interaction other) {
		return StringUtils.equalsIgnoreCase(base.getBusinessName(), other.getBusinessName());
	}
	
	public boolean matchesArgumentRoot(Argument base, Argument other) {
		return matchesTypeName(base == null ? null : base.getName(), other == null ? null : other.getName());
	}
	
	public boolean matchesArgumentTraversalName(Argument base, Argument other) {
		return StringUtils.equals(base == null ? null : base.getTraversalName(), other == null ? null : other.getTraversalName());
	}
	
	public boolean matchesTypeName(String base, String other) {
		return StringUtils.equals(substitute(base), substitute(other));
	}
	
	private String substitute(String name) {
		return this.substituter == null ? name : this.substituter.substitute(new TypeName(name)).getName();
	}

	MatchType matchesType(Relationship base, Relationship other) {
		if (base == null && other == null) {
			return MatchType.EXACT;
		} else if (base == null) {
			return MatchType.REMOVED;
		} else if (other == null) {
			return MatchType.ADDED;
		} else if (base.isAssociation() != other.isAssociation()) {
			return MatchType.MAJOR_DIFFERENCE;
		} else if (base.isAssociation()) {
			return matchesAssociationType(base, other);
		} else {
			return matchesAttributeType(base, other);
		}
	}

	private MatchType matchesAttributeType(Relationship base, Relationship other) {
		// should list major difference checks first, followed by minor, then exact
		Hl7TypeName baseType = Hl7TypeName.parse(base.getType());
		Hl7TypeName otherType = Hl7TypeName.parse(other.getType());
		
		if (!baseType.getUnspecializedName().equals(otherType.getUnspecializedName())) {
			return MatchType.MAJOR_DIFFERENCE;
		} else if (base.getCardinality().isMultiple() != other.getCardinality().isMultiple()) {
			// bug 13308: cardinality not being checked when merging types (see comment in matchesAssociationType)
			return MatchType.MAJOR_DIFFERENCE;
		} else if ((base.isCodedType() || other.isCodedType()) && !StringUtils.equals(base.getDomainType(), other.getDomainType())) {
			return DomainTypeHelper.isCompatibleDomainType(base, other) ?
						MatchType.MINOR_DIFFERENCE
						: MatchType.MAJOR_DIFFERENCE;
		} else if (base.isFixed() != base.isFixed()) {
			return MatchType.MINOR_DIFFERENCE;
		} else if (base.isFixed() && !StringUtils.equals(base.getFixedValue(), other.getFixedValue())) {
			return MatchType.MINOR_DIFFERENCE;
		} else if (baseType.toString().equals(otherType.toString())) {
			return MatchType.EXACT;
		} else {
			return MatchType.MINOR_DIFFERENCE;
		}
	}

	MatchType matchesAssociationType(Relationship base, Relationship other) {
		if (base.isTemplateRelationship() != other.isTemplateRelationship()) {
			return MatchType.MAJOR_DIFFERENCE;
		} else if (!matchesTypeName(base.getType(), other.getType())) {
			return MatchType.MAJOR_DIFFERENCE;
		} else if (base.getCardinality().isMultiple() != other.getCardinality().isMultiple()) {
//			System.out.println(">>>> Cardinality incompatibility: " + base.getType() + " ("+ base.getCardinality() + ") vs " + other.getType() + " (" + other.getCardinality() + ")");
			// bug 13308: cardinality not being checked when merging types
			// TODO TM - note that if bug 13050 is fixed the change here can be undone as long as in these cases
			//           the generator provides single and collection accessors (or just a collection, but that 
			//           could be confusing) for the property in question    
			return MatchType.MAJOR_DIFFERENCE;
		} else {
			return MatchType.EXACT;
		}
	}

	public MatchType matchesConformance(Relationship base, Relationship other) {
		if (base == null && other == null) {
			return MatchType.EXACT;
		} else if (base == null || other == null) {
			return MatchType.MAJOR_DIFFERENCE;
		} else if (base.getConformance() == other.getConformance()) {
			return MatchType.EXACT;
		} else if (base.getConformance() == ConformanceLevel.MANDATORY || other.getConformance() == ConformanceLevel.MANDATORY) {
			return MatchType.MAJOR_DIFFERENCE;
		} else {
			return MatchType.MINOR_DIFFERENCE;
		}
	}

	public MatchType matchesCardinality(Relationship base, Relationship other) {
		if (base == null && other == null) {
			return MatchType.EXACT;
		} else if (base == null || other == null) {
			return MatchType.MAJOR_DIFFERENCE;
		} else if (StringUtils.equals(base.getCardinality().toString(), other.getCardinality().toString())) {
			return MatchType.EXACT;
		} else if (base.getCardinality().isSingle() == other.getCardinality().isSingle()) {
			return MatchType.MINOR_DIFFERENCE;
		} else {
			return MatchType.MAJOR_DIFFERENCE;
		}
	}
}
