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

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Documentation;

@Root(strict=false)
@Namespace(prefix="mif",reference="urn:hl7-org:v3/mif2")
public class MifAnnotations {

	@Element(required=false)
	private MifDocumentation documentation;
	@Element(required=false)
	private MifAppInfo appInfo;

	public MifAnnotations() {}
	
	public MifAnnotations(Documentation msgPartDoc) {
		List<Annotation> annotations = msgPartDoc.getAnnotations();
		if (annotations.size() > 0) {
			this.documentation = new MifDocumentation(annotations);
			if (this.documentation.getUnusedAnnotations() == annotations.size()) {
				this.documentation = null;
			}
			this.appInfo = new MifAppInfo(annotations);
			if(this.appInfo.getUnusedAnnotations() == annotations.size()) {
				this.appInfo = null;
			}
		}			
	}
	
	public MifDocumentation getDocumentation() {
		return documentation;
	}
	public MifAppInfo getAppInfo() {
		return appInfo;
	}
}
