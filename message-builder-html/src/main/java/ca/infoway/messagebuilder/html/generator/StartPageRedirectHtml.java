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
package ca.infoway.messagebuilder.html.generator;

import java.util.HashSet;
import java.util.Set;

import ca.infoway.messagebuilder.xml.AnnotationType;

import com.hp.gagawa.java.Document;
import com.hp.gagawa.java.DocumentType;
import com.hp.gagawa.java.elements.Link;
import com.hp.gagawa.java.elements.Script;
import com.hp.gagawa.java.elements.Title;

public class StartPageRedirectHtml extends BaseHtmlGenerator {
	private String indexFileName;
	private String pathToIndexPage;
	
	public StartPageRedirectHtml(String indexFileName, String pathToIndexPage) {
		this.indexFileName = indexFileName;
		this.pathToIndexPage = pathToIndexPage;
	}
	
	@Override
	public String write() {
		return this.writeOuterStartFile().write();
	}

	@Override
	public Set<AnnotationType> getExcludeAnnotationFilter() {
		Set<AnnotationType> filterTypes = new HashSet<AnnotationType>();
		filterTypes.add(AnnotationType.MAPPING);
		return filterTypes;
	}
	
	public Document writeOuterStartFile() {
		Document doc = new Document(DocumentType.HTMLStrict);
		
		Title title = new Title();
		title.appendText("Start Page");
		Script redirectScript = new Script("text/javascript");
		redirectScript.appendText("window.location.href=\"" + getPathToIndexPage() + "/" + getIndexFileName() + "\"");
		Link cssLink = new Link();
		cssLink.setRel("stylesheet");
		cssLink.setType("text/css");
		cssLink.setHref(getResourcesPath() + "/mystyle.css");
		
		doc.head.appendChild(title);
		doc.head.appendChild(cssLink);
		doc.head.appendChild(redirectScript);
		
		return doc;
	}

	public String getPathToIndexPage() {
		return pathToIndexPage;
	}

	public void setPathToIndexPage(String pathToIndexPage) {
		this.pathToIndexPage = pathToIndexPage;
	}

	public String getIndexFileName() {
		return indexFileName;
	}

	public void setIndexFileName(String indexFileName) {
		this.indexFileName = indexFileName;
	}
}
