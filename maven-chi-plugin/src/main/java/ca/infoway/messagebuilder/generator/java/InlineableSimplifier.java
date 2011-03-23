package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.Cardinality;

public abstract class InlineableSimplifier {

	protected static final Cardinality EXACTLY_ONE = new Cardinality(1, 1);
	
	protected final TypeAnalysisResult result;
	protected final LogUI log;

	protected InlineableSimplifier(LogUI log, TypeAnalysisResult result) {
		this.log = log;
		this.result = result;
	}

	public void execute() {
		for (ComplexTypePackage complexTypePackage : this.result.getAllPackages()) {
			for (Type type : new ArrayList<Type>(complexTypePackage.getTypes().values())) {
				this.log.log(DEBUG, "Now analyzing " + type.getName());
				if (isInlineable(complexTypePackage, type)) {
					inline(complexTypePackage, type);
				}
			}
		}
	}
	
	protected abstract boolean isInlineable(ComplexTypePackage complexTypePackage, Type inlineableType);
	protected abstract void inline(ComplexTypePackage complexTypePackage, Type inlineableType);
	
	protected BaseRelationship createInlinedRelationship(
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
						inlineableType.getName());
	}

	protected boolean containedInChoice(Type inlineableType) {
		return !inlineableType.getInterfaceTypes().isEmpty();
	}

	protected boolean isTemporary(Type inlineableType) {
		return inlineableType.getName() instanceof TemporaryTypeName;
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
}
