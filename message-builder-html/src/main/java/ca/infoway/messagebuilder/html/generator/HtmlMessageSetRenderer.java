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

import java.io.InputStream;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.model.Datatype;
import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.ValueSet;

public interface HtmlMessageSetRenderer {
	public String writeInteraction(Interaction interaction, MessageSet messageSet);

	public String writePackageLocation(PackageLocation packageLocation, MessageSet messageSet);
	public String writePackageLocation(PackageLocation packageLocation, MessageSet messageSet, Boolean excludeStructuralAttributes);

	public String writeMessagePart(MessagePart messagePart, MessageSet messageSet);

	public String writeValueSet(ValueSet valueSet, MessageSet messageSet);
	
	public String writeConceptDomain(ConceptDomain conceptDomain, MessageSet messageSet);
	
	public String writeDatatype(Datatype datatype, DatatypeSet datatypeSet, MessageSet messageSet);
	
	public String writeSideNavBarScript(MessageSet messageSet,
			Map<String, String> categoryNames);
	
	public String writeOuterStartFile(String pathToIndexPage, String indexFileName);
	public String writeInnerStartFile(MessageSet messageSet);

	public Map<String, InputStream> getStaticResourceFiles();
	
	public void setJavascriptPath(String javascriptPath);
	public String getJavascriptPath();

	public void setPackagesPath(String messagePartsPath);
	public String getPackagesPath();

	public void setInteractionsPath(String interactionsPath);
	public String getInteractionsPath();

	public void setResourcesPath(String resourcesPath);
	public String getResourcesPath();
	
	public Boolean getExcludeStructuralAttributes();
	public void setExcludeStructuralAttributes(Boolean includeStructuralAttributes);

}
