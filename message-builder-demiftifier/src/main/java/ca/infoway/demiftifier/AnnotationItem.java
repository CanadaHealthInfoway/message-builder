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
package ca.infoway.demiftifier;

import ca.infoway.messagebuilder.xml.Annotation;

public class AnnotationItem {

	private Annotation annotation;
	private String relationshipName;
	
	public AnnotationItem(Annotation annotation, String relationshipName) {
		this.annotation = annotation;
		this.relationshipName = relationshipName;
	}
	public Annotation getAnnotation() {
		return annotation;
	}
	public String getRelationshipName() {
		return relationshipName;
	}
	public static AnnotationItem from(Annotation annotation, String relationshipName) {
		return new AnnotationItem(annotation, relationshipName);
	}
}
