package ca.infoway.messagebuilder.generator.regen;

import static java.lang.String.format;

import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class TypeDeltaApplicatorProvider {
	
	private static final Log log = LogFactory.getLog(TypeDeltaApplicatorProvider.class);
	
	private final Set<TypeDeltaApplicator> applicators;

	public TypeDeltaApplicatorProvider() {
		this(TypeDeltaApplicators.allApplicators());
	}
	
	TypeDeltaApplicatorProvider(Set<TypeDeltaApplicator> applicators) {
		this.applicators = applicators;
	}

	public TypeDeltaApplicator getApplicator(final BaseRelationship originalRelationship, final BaseRelationship newRelationship) {
		TypeDeltaApplicator applicator;
		
		try {
			applicator = Iterables.find(applicators, new Predicate<TypeDeltaApplicator>() {
				public boolean apply(TypeDeltaApplicator applicator) {
					return applicator.canApply(originalRelationship, newRelationship);
				}
			});
		} catch (NoSuchElementException e) {
			applicator = NullApplicator.INSTANCE;
		}
		
		return applicator;
	}

	static class NullApplicator implements TypeDeltaApplicator {
		static NullApplicator INSTANCE = new NullApplicator();
		public void apply(RelationshipsMergerContext context, BaseRelationship originalRelationship, BaseRelationship newRelationship) {
			log.error(format("Unable to support type change for %s.%s. Type changed from %s/%s%s to %s/%s%s.", 
					context.getMergedType().getName(), originalRelationship.getName(),
					toSimpleName(originalRelationship.getWrappedType()), toSimpleName(originalRelationship.getType()), originalRelationship.getTypeParameters(), 
					toSimpleName(newRelationship.getWrappedType()), toSimpleName(newRelationship.getType()), newRelationship.getTypeParameters()));
		}

		public boolean canApply(BaseRelationship originalRelationship, BaseRelationship newRelationship) {
			return true;
		}
	}

	static String toSimpleName(String typeName) {
		return ClassUtils.getShortClassName(typeName);
	}
	
}
