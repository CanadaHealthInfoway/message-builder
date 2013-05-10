/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.datatype.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.datatype.mif.MifAnnotations;
import ca.infoway.messagebuilder.datatype.mif.MifAppInfo;
import ca.infoway.messagebuilder.datatype.mif.MifBasicAnnotation;
import ca.infoway.messagebuilder.datatype.mif.MifDatatype;
import ca.infoway.messagebuilder.datatype.mif.MifDerivedFrom;
import ca.infoway.messagebuilder.datatype.mif.MifDocumentation;
import ca.infoway.messagebuilder.datatype.mif.MifFormalConstraint;
import ca.infoway.messagebuilder.datatype.mif.MifHttpParagraph;
import ca.infoway.messagebuilder.datatype.mif.MifStaticExample;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Documentation;

@Root(strict=false)
public class Datatype {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	@Attribute(required=false)
	private Boolean isAbstract;
	@Attribute(required=false)
	private String name;
	@Attribute(required=false)
	private String businessName;
	@Attribute(required=false)
	private String visibility;
	@Attribute(required=false)
	private String superType;
	@Attribute(required=false)
	private Boolean isMerged = false;
	
	@Element(required=false)
	private Documentation documentation;
	
	@ElementList(name="staticExample",required=false,inline=true,entry="staticExampleEntry") 
	private List<StaticExampleAnnotation> staticExamples = new ArrayList<StaticExampleAnnotation>();
	
	@Element(required=false)
	private Datatype parentDatatype;
	
	public Datatype(){}
	
	public Datatype(MifDatatype mifDatatype) {
		this.name = mifDatatype.getName();
		this.businessName = mifDatatype.getTitle();
		this.visibility = mifDatatype.getVisibility();
		this.isAbstract = (mifDatatype.getIsAbstract()==null)?false:mifDatatype.getIsAbstract();
		this.superType = determineSuperType(mifDatatype.getDerivedFrom());
		this.documentation = createDocumentation(mifDatatype.getAnnotations());
		this.staticExamples = createStaticExamples(mifDatatype.getAnnotations());
		this.isMerged = false;
	}
	
	public Datatype(MifDatatype mifDatatype, DatatypeSet parentDatatypeSet) {
		this(mifDatatype);
		if (getSuperType() != null && parentDatatypeSet != null) {
			this.parentDatatype = parentDatatypeSet.getDatatype(getSuperType());
			if (this.parentDatatype != null) { 
				if (this.getName().equals(getParentDatatype().getName())) {
					getDocumentation().getAnnotations().addAll(getParentDatatype().getDocumentation().getAnnotations());
					this.superType = getParentDatatype().getSuperType();
					this.isMerged = true;
				}
			}
		}
	}
	

	private List<StaticExampleAnnotation> createStaticExamples(MifAnnotations annotations) {
		List<StaticExampleAnnotation> result = new ArrayList<StaticExampleAnnotation>();
		if (annotations != null && annotations.getAppInfo() != null) {
			MifAppInfo appInfo = annotations.getAppInfo();
			List<MifStaticExample> staticExamples = appInfo.getStaticExamples();
			for (MifStaticExample mifStaticExample : staticExamples) {
				Annotation annotation = createAnnotation(AnnotationType.STATIC_EXAMPLE, mifStaticExample);
				StaticExampleAnnotation staticExampleAnnotation = new StaticExampleAnnotation(
						annotation, mifStaticExample.getBusinessName()==null?"":mifStaticExample.getBusinessName().getName());
				result.add(staticExampleAnnotation);			
			}
		}
		return result;
	}

	private Documentation createDocumentation(MifAnnotations annotations) {
		Documentation result = new Documentation();
		
		result.setBusinessName(getBusinessName());
		
		addAnnotations(annotations, result);	

		return result;
	}

	private void addAnnotations(MifAnnotations annotations, Documentation documentation) {
		if (annotations != null) {		
			MifDocumentation mifDocumentation = annotations.getDocumentation();
			
			if (mifDocumentation != null) {
				//ADD BASIC ANNOTATIONS
				Annotation definition = createAnnotation(AnnotationType.DEFINITION, mifDocumentation.getDefinition());
				if (definition != null) {
					documentation.getAnnotations().add(definition);
				}
				Annotation description = createAnnotation(AnnotationType.DESCRIPTION, mifDocumentation.getDescription());
				if (description != null) {
					documentation.getAnnotations().add(description);
				}
				Annotation rationale = createAnnotation(AnnotationType.RATIONALE, mifDocumentation.getRationale());
				if (rationale != null) {
					documentation.getAnnotations().add(rationale);
				}
				Annotation requirements = createAnnotation(AnnotationType.REQUIREMENTS, mifDocumentation.getRequirements());
				if (requirements != null) {
					documentation.getAnnotations().add(requirements);
				}
				Annotation walkthrough = createAnnotation(AnnotationType.WALKTHROUGH, mifDocumentation.getWalkthrough());
				if (walkthrough != null) {
					documentation.getAnnotations().add(walkthrough);
				}
				
				List<MifBasicAnnotation> usageNotes = mifDocumentation.getUsageNotes();
				for (MifBasicAnnotation usageNote : usageNotes) {
					Annotation usageNoteAnnotation = createAnnotation(AnnotationType.USAGE_NOTES, usageNote);
					if (usageNoteAnnotation != null) {
						documentation.getAnnotations().add(usageNoteAnnotation);
					}
				}
				
				List<MifBasicAnnotation> designComments = mifDocumentation.getDesignComments();
				for (MifBasicAnnotation designComment : designComments) {
					Annotation designCommentAnnotation = createAnnotation(AnnotationType.DESIGN_COMMENTS, designComment);
					if (designCommentAnnotation != null) { 
						documentation.getAnnotations().add(designCommentAnnotation);
					}
				}
				
				List<MifBasicAnnotation> usageConstraints = mifDocumentation.getUsageConstraints();
				for (MifBasicAnnotation usageConstraint : usageConstraints) {
					Annotation usageConstraintAnnotation = createAnnotation(AnnotationType.USAGE_CONSTRAINT, usageConstraint);
					if (usageConstraintAnnotation != null) {
						documentation.getAnnotations().add(usageConstraintAnnotation);
					}
				}
			}
			
			MifAppInfo mifAppInfo = annotations.getAppInfo();
			if (mifAppInfo != null) {		
				List<MifFormalConstraint> formalConstraints = mifAppInfo.getFormalConstraints();
				for (MifFormalConstraint mifFormalConstraint : formalConstraints) {
					Annotation formalConstraint = createAnnotation(AnnotationType.CONSTRAINT, mifFormalConstraint);
					if (formalConstraint != null) {
						documentation.getAnnotations().add(formalConstraint);
					}
				}
			}
		}
	}

	private Annotation createAnnotation(AnnotationType type, MifStaticExample example) {
		Annotation result = new Annotation();
		result.setAnnotationTypeAsEnum(type);
		result.setText(example.getData().getValue());
		return result;
	}

	private Annotation createAnnotation(AnnotationType type, MifBasicAnnotation mifBasicDefinition) {
		if (mifBasicDefinition != null) {
			Annotation result = new Annotation();
			result.setAnnotationTypeAsEnum(type);
			String textValue = mifBasicDefinition.getText().getValue();
			if (StringUtils.isNotBlank(textValue)) {
				result.setText(textValue);
			} else {
				String paragraphValue = "" + LINE_SEPARATOR;
				for (MifHttpParagraph mifHttpParagraph : mifBasicDefinition.getText().getParagraphs()) {
					paragraphValue += "<p>" + mifHttpParagraph.getValue() + "</p>" + LINE_SEPARATOR;
				}
				result.setText(paragraphValue);
			}
			return result;
		}
		return null;
	}

	private String determineSuperType(List<MifDerivedFrom> derivedFrom) {
		if(derivedFrom.size() > 1
				&& derivedFrom.get(0).getTargetDatatype() != null
				&& derivedFrom.get(1).getTargetDatatype() != null) {
			//Special handling for OID datatype (which has UID and LIST<INT> as parent types)
			return derivedFrom.get(0).getTargetDatatype().getName() + ", " + derivedFrom.get(1).getTargetDatatype().getName();
		} else if (derivedFrom.size() > 0 && derivedFrom.get(0).getTargetDatatype() != null){
			return derivedFrom.get(0).getTargetDatatype().getName();
		} 
		return null;
	}

	public Boolean getIsAbstract() {
		return isAbstract;
	}
	public void setIsAbstract(Boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Documentation getDocumentation() {
		return documentation;
	}
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}

	public String getSuperType() {
		return superType;
	}
	public void setSuperType(String superType) {
		this.superType = superType;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public List<StaticExampleAnnotation> getStaticExamples() {
		return staticExamples;
	}

	public void setStaticExamples(List<StaticExampleAnnotation> staticExamples) {
		this.staticExamples = staticExamples;
	}

	public Datatype getParentDatatype() {
		return parentDatatype;
	}

	public void setParentDatatype(Datatype parentDatatype) {
		this.parentDatatype = parentDatatype;
	}

	public Boolean getIsMerged() {
		return isMerged;
	}

	public void setIsMerged(Boolean isMerged) {
		this.isMerged = isMerged;
	}
}
