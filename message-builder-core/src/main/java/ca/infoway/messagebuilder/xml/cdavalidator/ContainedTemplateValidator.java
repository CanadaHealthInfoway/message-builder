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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.xml.cdavalidator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.j5goodies.XPathHelper;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.ContainedTemplate;
import ca.infoway.messagebuilder.xml.PackageLocation;

public class ContainedTemplateValidator {
	
	private static final String PREFIX = "cda";
	private static final String NAMESPACE = "urn:hl7-org:v3";
	
	private Map<String,PackageLocation> packagesByOid;
	private XPathHelper xPathHelper = new XPathHelper();

	public ContainedTemplateValidator(Collection<PackageLocation> locations) {
		packagesByOid = new HashMap<String, PackageLocation>();
		for (PackageLocation packageLocation : locations) {
			if (packageLocation.getTemplateOid() != null) {
				packagesByOid.put(packageLocation.getTemplateOid(), packageLocation);
			}
		}
	}

	public void validate(String xml, Hl7Errors validationResult) {
		try {
			Document document = new DocumentFactory().createFromString(xml);
			validate(document, validationResult);
		} catch (SAXException e) {
			validationResult.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, "Unable to validate contained templates: " + e.getMessage(), "/"));
		}
	}
	
	public void validate(Document document, Hl7Errors validationResult) {
			validate(document, "/cda:ClinicalDocument", "cda:component/cda:structuredBody/cda:component/cda:section/cda:templateId/@root", validationResult);
			validate(document, "//cda:section", "cda:entry/*/cda:templateId/@root", validationResult);
			validate(document, "//cda:entry/*[cda:templateId]", "*//cda:templateId/@root", validationResult);
	}

	private void validate(Node xml, String baseNodeXPath,
			String containedNodeXPath, Hl7Errors validationResult) {
		try {
			NodeList baseNodes = xPathHelper.getNodes(xml, baseNodeXPath, "cda", NAMESPACE);
			for (int i = 0, ilength = baseNodes.getLength(); i < ilength; i++) {
				validateSingleNode(baseNodes.item(i), containedNodeXPath, validationResult);
			}
		} catch (XPathExpressionException e) {
			validationResult.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, "Unable to validate contained templates: " + e.getMessage(), baseNodeXPath));
		}
	}

	private void validateSingleNode(Node baseNode, String containedNodeXPath,
			Hl7Errors validationResult) throws XPathExpressionException {
		NodeList baseTemplateIds = xPathHelper.getNodes(baseNode, "cda:templateId/@root", PREFIX, NAMESPACE);
		for (int j = 0, jlength = baseTemplateIds.getLength(); j < jlength; j++) {
			String templateId = baseTemplateIds.item(j).getNodeValue();
			PackageLocation packageLocation = packagesByOid.get(templateId);
			if (packageLocation != null && packageLocation.getContainedTemplateConstraints() != null && !packageLocation.getContainedTemplateConstraints().isEmpty()) {
				NodeList containedTemplateIds = xPathHelper.getNodes(baseNode, containedNodeXPath, PREFIX, NAMESPACE);
				HashMap<String, Integer> containedTemplateMap = populateContainedTemplateMap(containedTemplateIds);
				
				for (ContainedTemplate containedTemplate : packageLocation.getContainedTemplateConstraints()) {
					Integer count = containedTemplateMap.get(containedTemplate.getTemplateOid());
					if (count == null) {
						count = 0;
					}
					if (!containedTemplate.getCardinality().contains((int)count)) { //Cast for .NET
						validationResult.addHl7Error(new Hl7Error(Hl7ErrorCode.CDA_CARDINALITY_CONSTRAINT, "Expected [" + containedTemplate.getRawCardinality() + "] instances of template "
								+ containedTemplate.getTemplateOid()
								+ ", but found " + count, baseNode));
					}
				}
				
			}
		}
	}

	private HashMap<String, Integer> populateContainedTemplateMap(
			NodeList containedTemplateIds) {
		HashMap<String,Integer> containedTemplateMap = new HashMap<String, Integer>();
		for (int k = 0, klength = containedTemplateIds.getLength(); k < klength; k++) {
			String containedTemplateId = containedTemplateIds.item(k).getNodeValue();
			PackageLocation containedPackageLocation = packagesByOid.get(containedTemplateId); 
			while (containedTemplateId != null && containedPackageLocation != null) {
				int count = 1;
				if (containedTemplateMap.containsKey(containedTemplateId)) {
					count += (int) containedTemplateMap.get(containedTemplateId); //Cast for .NET
				}
				containedTemplateMap.put(containedTemplateId, count);
				
				containedTemplateId = containedPackageLocation.getImpliedTemplateOid();
				containedPackageLocation = packagesByOid.get(containedTemplateId);
			}
		}
		return containedTemplateMap;
	}
}
