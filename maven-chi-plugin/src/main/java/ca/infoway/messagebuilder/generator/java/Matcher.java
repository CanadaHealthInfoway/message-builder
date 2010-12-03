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
		return matchesType(base, other, false);
	}
	
	MatchType matchesType(Relationship base, Relationship other, boolean debug) {
		if (base == null && other == null) {
			return MatchType.EXACT;
		} else if (base == null) {
			return MatchType.REMOVED;
		} else if (other == null) {
			return MatchType.ADDED;
		} else if (base.isAssociation() != other.isAssociation()) {
			if (debug) {
				System.out.println("major diff: only one is association");
			}
			return MatchType.MAJOR_DIFFERENCE;
		} else if (base.isAssociation()) {
			return matchesAssociationType(base, other, debug);
		} else {
			return matchesAttributeType(base, other, debug);
		}
	}

	private MatchType matchesAttributeType(Relationship base, Relationship other, boolean debug) {
		// should list major difference checks first, followed by minor, then exact
		Hl7TypeName baseType = Hl7TypeName.parse(base.getType());
		Hl7TypeName otherType = Hl7TypeName.parse(other.getType());
		
		if (!baseType.getUnspecializedName().equals(otherType.getUnspecializedName())) {
			if (debug) {
				System.out.println("major diff: unspecialized names different");
			}
			return MatchType.MAJOR_DIFFERENCE;
		} else if (base.getCardinality().isMultiple() != other.getCardinality().isMultiple()) {
			// bug 13308: cardinality not being checked when merging types (see comment in matchesAssociationType)
			if (debug) {
				System.out.println("major diff: cardinality different");
			}
			return MatchType.MAJOR_DIFFERENCE;
		} else if ((base.isCodedType() || other.isCodedType()) && !StringUtils.equals(base.getDomainType(), other.getDomainType())) {
			if (debug) {
				if (!DomainTypeHelper.isCompatibleDomainType(base, other)) {
					System.out.println("major diff: incompatible domains");
				}
			}
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

	MatchType matchesAssociationType(Relationship base, Relationship other, boolean debug) {
		if (base.isTemplateRelationship() != other.isTemplateRelationship()) {
			if (debug) {
				System.out.println("major diff: only one is template relationship");
			}
			return MatchType.MAJOR_DIFFERENCE;
		} else if (!matchesTypeName(base.getType(), other.getType())) {
			if (debug) {
				System.out.println("major diff: MatchesTypeName returns false: " + base.getType() + " " + other.getType() + "->" + substitute(base.getType()) + " " + substitute(other.getType()));
			}
			return MatchType.MAJOR_DIFFERENCE;
		} else if (base.getCardinality().isMultiple() != other.getCardinality().isMultiple()) {
//			System.out.println(">>>> Cardinality incompatibility: " + base.getType() + " ("+ base.getCardinality() + ") vs " + other.getType() + " (" + other.getCardinality() + ")");
			// bug 13308: cardinality not being checked when merging types
			// TODO TM - note that if bug 13050 is fixed the change here can be undone as long as in these cases
			//           the generator provides single and collection accessors (or just a collection, but that 
			//           could be confusing) for the property in question    
			if (debug) {
				System.out.println("major diff: cardinality different2");
			}
			return MatchType.MAJOR_DIFFERENCE;
		} else {
			return MatchType.EXACT;
		}
	}

	public MatchType matchesConformance(Relationship base, Relationship other) {
		return matchesConformance(base, other, false);
	}
	
	public MatchType matchesConformance(Relationship base, Relationship other, boolean debug) {
		if (base == null && other == null) {
			return MatchType.EXACT;
		} else if (base == null || other == null) {
			if (debug) {
				System.out.println("major diff: one or both conformance are null");
			}
			return MatchType.MAJOR_DIFFERENCE;
		} else if (base.getConformance() == other.getConformance()) {
			return MatchType.EXACT;
		} else if (base.getConformance() == ConformanceLevel.MANDATORY || other.getConformance() == ConformanceLevel.MANDATORY) {
			if (debug) {
				System.out.println("major diff: one or both conformances are mandatory");
			}
			return MatchType.MAJOR_DIFFERENCE;
		} else {
			return MatchType.MINOR_DIFFERENCE;
		}
	}

	public MatchType matchesCardinality(Relationship base, Relationship other) {
		if (base == null && other == null) {
			return MatchType.EXACT;
		} else if (base == null || other == null) {
//			if (debug) {
				System.out.println("major diff: incompatible domains");
//			}
			return MatchType.MAJOR_DIFFERENCE;
		} else if (StringUtils.equals(base.getCardinality().toString(), other.getCardinality().toString())) {
			return MatchType.EXACT;
		} else if (base.getCardinality().isSingle() == other.getCardinality().isSingle()) {
			return MatchType.MINOR_DIFFERENCE;
		} else {
//			if (debug) {
				System.out.println("major diff: weird cardinality case");
//			}
			return MatchType.MAJOR_DIFFERENCE;
		}
	}
}
