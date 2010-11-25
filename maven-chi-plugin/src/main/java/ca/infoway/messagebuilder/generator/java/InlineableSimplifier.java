package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.TypeName;

public abstract class InlineableSimplifier {

	protected static final Cardinality EXACTLY_ONE = new Cardinality(1, 1);
	
	protected final TypeAnalysisResult result;
	protected final LogUI log;

	private final SimplifiableDefinitions definitions;

	protected InlineableSimplifier(LogUI log, TypeAnalysisResult result, SimplifiableDefinitions definitions) {
		this.log = log;
		this.result = result;
		this.definitions = definitions;
	}

	public void execute() {
		for (ComplexTypePackage complexTypePackage : this.result.getAllPackages()) {
			for (Type type : new ArrayList<Type>(complexTypePackage.getTypes().values())) {
				this.log.log(DEBUG, "Now analyzing " + type.getTypeName());
				if (isInlineable(complexTypePackage, type)) {
					inline(complexTypePackage, type);
				}
			}
		}
		for (SimplifiablePackage simplifiablePackage : this.definitions.getAllPackages()) {
			for (SimplifiableType type : new ArrayList<SimplifiableType>(simplifiablePackage.getTypes())) {
				this.log.log(DEBUG, "Now analyzing " + type.getMessagePart().getName());
				if (isInlineable(simplifiablePackage, type)) {
					inline(type);
				}
			}
		}
	}
	
	protected void inline(SimplifiableType type) {
		type.setInlined(true);
	}

	protected abstract boolean isInlineable(SimplifiablePackage simplifiablePackage, SimplifiableType type);
	@Deprecated
	protected boolean isInlineable(ComplexTypePackage complexTypePackage, Type inlineableType) { return false; }
	@Deprecated
	protected abstract void inline(ComplexTypePackage complexTypePackage, Type inlineableType);
	
	protected BaseRelationship createInlinedRelationship(TypeName name, 
			BaseRelationship inlinedRelationship, BaseRelationship elidedRelationship) {
		if (inlinedRelationship.getRelationshipType() == RelationshipType.ATTRIBUTE) {
			return new InlinedAttribute((Attribute) inlinedRelationship, elidedRelationship);
		} else {
			return new InlinedAssociation((Association) inlinedRelationship, elidedRelationship);
		}
	}
	
	protected boolean matches(Type inlineableType, BaseRelationship relationship) {
		return relationship.getRelationshipType() == RelationshipType.ASSOCIATION
				&& ObjectUtils.equals(((Association) relationship).getPropertyTypeName(),
						inlineableType.getTypeName());
	}

	protected boolean matches(SimplifiableType inlineableType, SimplifiableRelationship relationship) {
		return relationship.getRelationship().isAssociation()
			&& ObjectUtils.equals(relationship.getRelationship().getType(),
					inlineableType.getMessagePart().getName());
	}
	
	protected boolean containedInChoice(Type inlineableType) {
		return !inlineableType.getInterfaceTypes().isEmpty();
	}

	protected boolean isTemporary(Type inlineableType) {
		return inlineableType.getTypeName() instanceof TemporaryTypeName;
	}

	protected List<BaseRelationship> getNonFixedRelationships(Type inlineableType) {
		List<BaseRelationship> nonFixedRelationships = new ArrayList<BaseRelationship>();
		List<BaseRelationship> allRelationships = inlineableType.getRelationships();
		for (BaseRelationship baseRelationship : allRelationships) {
			if (!baseRelationship.isFixed()) {
				nonFixedRelationships.add(baseRelationship);
			}
		}
		return nonFixedRelationships;
	}
	
	protected boolean hasAtLeastOneNonFixedRelationship(Type inlineableType) {
		return !getNonFixedRelationships(inlineableType).isEmpty();
	}
	
	protected List<SimplifiableRelationship> getNonFixedRelationships(SimplifiableType inlineableType) {
		List<SimplifiableRelationship> nonFixedRelationships = new ArrayList<SimplifiableRelationship>();
		List<SimplifiableRelationship> allRelationships = inlineableType.getRelationships();
		for (SimplifiableRelationship simplifiableRelationship : allRelationships) {
			if (!simplifiableRelationship.getRelationship().isFixed()) {
				nonFixedRelationships.add(simplifiableRelationship);
			}
		}
		return nonFixedRelationships;
	}
	
	protected boolean hasAtLeastOneNonFixedRelationship(SimplifiableType inlineableType) {
		return !getNonFixedRelationships(inlineableType).isEmpty();
	}
}
