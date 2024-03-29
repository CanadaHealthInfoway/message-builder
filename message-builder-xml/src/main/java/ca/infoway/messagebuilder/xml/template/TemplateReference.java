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
 * Last modified: $LastChangedDate: 2013-10-11 11:41:37 -0400 (Fri, 11 Oct 2013) $
 * Revision:      $LastChangedRevision: 7977 $
 */

package ca.infoway.messagebuilder.xml.template;

import ca.infoway.messagebuilder.xml.Cardinality;

/**
 * @sharpen.ignore - only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
public class TemplateReference {
	
	private String context;
	private String oid;
	private Cardinality cardinality;
	
	public TemplateReference() {
		
	}
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Cardinality getCardinality() {
		return cardinality;
	}

	public void setCardinality(Cardinality cardinality) {
		this.cardinality = cardinality;
	}

}
