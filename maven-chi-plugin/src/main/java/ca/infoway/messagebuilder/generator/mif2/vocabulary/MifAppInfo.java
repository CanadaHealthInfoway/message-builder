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
package ca.infoway.messagebuilder.generator.mif2.vocabulary;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;

@Root(strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifAppInfo {

	@ElementList(entry="mapping",required=false,inline=true)
	private List<MifMapping> mappings = new ArrayList<MifMapping>();
	@ElementList(entry="openIssue",required=false,inline=true)
	private List<MifBasicAnnotation> openIssues = new ArrayList<MifBasicAnnotation>();
	@ElementList(entry="formalConstraint", required=false, inline=true)
	private List<MifFormalConstraint> formalConstraints = new ArrayList<MifFormalConstraint>();
	
	@ElementList(entry="ballotComment",required=false,inline=true)
	private List<MifBasicAnnotation> ballotComments = new ArrayList<MifBasicAnnotation>();
	@ElementList(entry="changeRequest",required=false,inline=true)
	private List<MifBasicAnnotation> changeRequests = new ArrayList<MifBasicAnnotation>();
	@ElementList(entry="staticExample",required=false,inline=true)
	private List<MifStaticExample> staticExamples = new ArrayList<MifStaticExample>();
	@ElementList(entry="deprecationInfo",required=false,inline=true)
	private List<MifBasicAnnotation> deprecationInfos = new ArrayList<MifBasicAnnotation>();
	
	private int unusedAnnotations = 0;
	
	public MifAppInfo(){}
	
	public MifAppInfo(List<Annotation> annotations) {
		for (Annotation annotation : annotations) {
			if (AnnotationType.CONSTRAINT.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.formalConstraints.add(new MifFormalConstraint(annotation.getText()));
			} else if (AnnotationType.MAPPING.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.mappings.add(new MifMapping(annotation.getText(), annotation.getSourceName()));
			} else if (AnnotationType.OPEN_ISSUE.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.openIssues.add(new MifBasicAnnotation(annotation.getText()));
			} else if (AnnotationType.BALLOT_COMMENT.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.ballotComments.add(new MifBasicAnnotation(annotation.getText()));
			} else if (AnnotationType.CHANGE_REQUEST.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.changeRequests.add(new MifBasicAnnotation(annotation.getText()));
			} else if (AnnotationType.STATIC_EXAMPLE.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.getStaticExamples().add(new MifStaticExample(annotation.getText()));
			} else if (AnnotationType.DEPRECATION_INFO.equals(annotation
					.getAnnotationTypeAsEnum())) {
				this.deprecationInfos.add(new MifBasicAnnotation(annotation.getText()));
			} else {
				this.unusedAnnotations ++;
			}
		}
	}
	
	public List<MifMapping> getMappings() {
		return mappings;
	}
	
	public List<MifBasicAnnotation> getOpenIssues() {
		return openIssues;
	}
	
	public List<MifFormalConstraint> getFormalConstraints() {
		return formalConstraints;
	}

	public int getUnusedAnnotations() {
		return unusedAnnotations;
	}

	public List<MifBasicAnnotation> getDeprecationInfos() {
		return deprecationInfos;
	}

	public List<MifStaticExample> getStaticExamples() {
		return staticExamples;
	}

	public void setStaticExamples(List<MifStaticExample> staticExamples) {
		this.staticExamples = staticExamples;
	}
}
