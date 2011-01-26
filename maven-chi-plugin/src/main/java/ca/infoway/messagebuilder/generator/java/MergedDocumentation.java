package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Documentation;

public class MergedDocumentation extends Documentation {

	private List<Annotation> annotations = new ArrayList<Annotation>();
	private String businessName = null;
	
	public MergedDocumentation(Collection<BaseRelationship> mergedRelationships) {
		Set<String> businessNames = new HashSet<String>();
		Set<Documentation> documentations = new HashSet<Documentation>();
		for (BaseRelationship relationship : mergedRelationships) {
			Documentation documentation = relationship.getDocumentation();
			if (documentation != null && 
					(StringUtils.isNotBlank(documentation.getBusinessName()) || !documentation.getAnnotations().isEmpty())) {
				// would be REALLY nice to show parent type of each relationship, but don't have it at this point
				documentations.add(documentation);
			}
			if (documentation != null && documentation.getBusinessName() != null) {
				businessNames.add(BusinessNameUtil.cleanUpBusinessName(documentation.getBusinessName()));
			}
		}
		for (Documentation documentation: documentations) {
			String businessName = StringUtils.defaultIfEmpty(documentation.getBusinessName(), "(no business name)");
			this.annotations.add(new Annotation(businessName));
			if (!documentation.getAnnotations().isEmpty()) {
				this.annotations.addAll(documentation.getAnnotations());
			}
		}

		// only use business names if the business names are identical (skipping those w/o business names)
		if (businessNames.size() == 1) {
			this.businessName = businessNames.iterator().next();
		}
	}

	public MergedDocumentation(List<Type> types) {
		// allow doc duplication for types since we have the exact type name to match up with each set of documentation
		Set<String> businessNames = new HashSet<String>();
		for (Type type : types) {
			Documentation documentation = type.getTypeDocumentation().getOriginalDocumentation();
			if (documentation != null && 
					(StringUtils.isNotBlank(documentation.getBusinessName()) || !documentation.getAnnotations().isEmpty())) {
				String businessName = StringUtils.defaultIfEmpty(documentation.getBusinessName(), "(no business name)");
				this.annotations.add(new Annotation(type.getTypeName().getName() + ": " + businessName));
				if (!documentation.getAnnotations().isEmpty()) {
					this.annotations.addAll(documentation.getAnnotations());
				}
			}
			if (documentation != null && documentation.getBusinessName() != null) {
				businessNames.add(BusinessNameUtil.cleanUpBusinessName(documentation.getBusinessName()));
			}
		}

		// only use business names if the business names are identical (skipping those w/o business names)
		if (businessNames.size() == 1) {
			this.businessName = businessNames.iterator().next();
		}
	}

	@Override
	public List<Annotation> getAnnotations() {
		return this.annotations;
	}
	
	@Override
	public String getBusinessName() {
		return this.businessName;
	}
	
	@Override
	public String getTitle() {
		throw new UnsupportedOperationException("title not currently used by generator");
	}
	
}
