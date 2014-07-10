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

import java.util.HashMap;
import java.util.Map;

public class TemplateSet {

	private Map<String,Template> templates = new HashMap<String,Template>();

	public void addTemplate(Template template) {
		templates.put(template.getOid(), template);
	}
	
	public Template getByOid(String oid) {
		return templates.get(oid);
	}
}
