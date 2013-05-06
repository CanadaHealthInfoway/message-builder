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
package ca.infoway.messagebuilder.datatype.mif;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;

@Root(strict = false)
@Namespace(prefix = "mif", reference = "urn:hl7-org:v3/mif2")
public class MifDocumentation {

	@Element(required = false)
	private MifBasicAnnotation definition;
	@Element(required = false)
	private MifBasicAnnotation description;
	@ElementList(entry = "usageConstraint", required = false, inline = true)
	private List<MifBasicAnnotation> usageConstraints = new ArrayList<MifBasicAnnotation>();
	@ElementList(entry = "usageNotes", required = false, inline = true)
	private List<MifBasicAnnotation> usageNotes = new ArrayList<MifBasicAnnotation>();
	@Element(required = false)
	private MifBasicAnnotation rationale;
	@ElementList(entry = "designComments", required = false, inline = true)
	private List<MifBasicAnnotation> designComments = new ArrayList<MifBasicAnnotation>();
	@ElementList(entry = "otherAnnotation", required = false, inline = true)
	private List<MifOtherAnnotation> otherAnnotations = new ArrayList<MifOtherAnnotation>();
	
	@Element(required=false)
	private MifBasicAnnotation requirements;
	@ElementList(entry = "stabilityRemarks", required = false, inline = true)
	private List<MifBasicAnnotation> stabilityRemarks = new ArrayList<MifBasicAnnotation>();
	@Element(required=false)
	private MifBasicAnnotation walkthrough;
	@ElementList(entry="appendix",required=false,inline=true)
	private List<MifBasicAnnotation> appendices = new ArrayList<MifBasicAnnotation>();
	
	private int unusedAnnotations = 0;
	
	public MifDocumentation() {
	}

	public MifDocumentation(List<Annotation> annotations) {
		for (Annotation annotation : annotations) {
			if (AnnotationType.DEFINITION.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.definition = new MifBasicAnnotation(annotation.getText());
			} else if (AnnotationType.DESCRIPTION.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.description = new MifBasicAnnotation(annotation.getText());
			} else if (AnnotationType.USAGE_CONSTRAINT.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.usageConstraints.add(new MifBasicAnnotation(annotation.getText()));
			} else if (AnnotationType.USAGE_NOTES.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.usageNotes.add(new MifBasicAnnotation(annotation.getText()));
			} else if (AnnotationType.RATIONALE.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.rationale = new MifBasicAnnotation(annotation.getText());
			} else if (AnnotationType.REQUIREMENTS.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.requirements = new MifBasicAnnotation(annotation.getText());
			} else if (AnnotationType.DESIGN_COMMENTS.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.designComments.add(new MifBasicAnnotation(annotation.getText()));
			} else if (AnnotationType.STABILITY_REMARKS.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.stabilityRemarks.add(new MifBasicAnnotation(annotation.getText()));
			} else if (AnnotationType.WALKTHROUGH.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.walkthrough = new MifBasicAnnotation(annotation.getText());
			} else if (AnnotationType.APPENDIX.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.appendices.add(new MifBasicAnnotation(annotation.getText()));
			} else if (AnnotationType.OTHER_NOTES.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.otherAnnotations.add(new MifOtherAnnotation(annotation.getText(), annotation.getOtherAnnotationType()));
			} else {
				this.unusedAnnotations++ ;
			}
		}
	}

	public MifBasicAnnotation getDefinition() {
		return definition;
	}

	public MifBasicAnnotation getDescription() {
		return description;
	}

	public List<MifBasicAnnotation> getUsageConstraints() {
		return usageConstraints;
	}

	public List<MifBasicAnnotation> getUsageNotes() {
		return usageNotes;
	}

	public MifBasicAnnotation getRationale() {
		return rationale;
	}

	public List<MifBasicAnnotation> getDesignComments() {
		return designComments;
	}

	public List<MifOtherAnnotation> getOtherAnnotations() {
		return otherAnnotations;
	}

	public int getUnusedAnnotations() {
		return new Integer(unusedAnnotations);
	}

	public MifBasicAnnotation getRequirements() {
		return requirements;
	}

	public MifBasicAnnotation getWalkthrough() {
		return walkthrough;
	}
}
