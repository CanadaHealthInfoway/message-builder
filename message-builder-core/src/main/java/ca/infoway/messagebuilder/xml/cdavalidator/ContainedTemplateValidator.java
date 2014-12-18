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
import ca.infoway.messagebuilder.j5goodies.XPathHelper;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.ContainedTemplate;
import ca.infoway.messagebuilder.xml.PackageLocation;

public class ContainedTemplateValidator {
	
	private static final String NAMESPACE = "urn:hl7-org:v3";
	
	private Map<String,PackageLocation> packagesByOid;
	private XPathHelper xPathHelper = new XPathHelper();

	public ContainedTemplateValidator(Collection<PackageLocation> locations) {
		packagesByOid = new HashMap<String, PackageLocation>();
		for (PackageLocation packageLocation : locations) {
			packagesByOid.put(packageLocation.getTemplateOid(), packageLocation);
		}
	}

	public void validate(String xml, ModelToXmlResult result) {
		try {
			Document document = new DocumentFactory().createFromString(xml);

			validate(document, "/cda:ClinicalDocument", "cda:component/cda:structuredBody/cda:component/cda:section/cda:templateId/@root", result);
			validate(document, "//cda:section", "cda:entry/*/cda:templateId/@root", result);
			validate(document, "//cda:entry/*[cda:templateId]", "cda:entryRelationship/*/cda:templateId/@root", result);
		} catch (SAXException e) {
			result.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, "Unable to validate contained templates: " + e.getMessage(), "/"));
		}
	}

	private void validate(Node xml, String baseNodeXPath,
			String containedNodeXPath, ModelToXmlResult result) {
		try {
			NodeList baseNodes = xPathHelper.getNodes(xml, baseNodeXPath, NAMESPACE);
			for (int i = 0, ilength = baseNodes.getLength(); i < ilength; i++) {
				validateSingleNode(baseNodes.item(i), containedNodeXPath, result);
			}
		} catch (XPathExpressionException e) {
			result.addHl7Error(new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, "Unable to validate contained templates: " + e.getMessage(), baseNodeXPath));
		}
	}

	private void validateSingleNode(Node baseNode, String containedNodeXPath,
			ModelToXmlResult result) throws XPathExpressionException {
		NodeList baseTemplateIds = xPathHelper.getNodes(baseNode, "cda:templateId/@root", NAMESPACE);
		for (int j = 0, jlength = baseTemplateIds.getLength(); j < jlength; j++) {
			String templateId = baseTemplateIds.item(j).getNodeValue();
			PackageLocation packageLocation = packagesByOid.get(templateId);
			if (packageLocation != null && packageLocation.getContainedTemplateConstraints() != null && !packageLocation.getContainedTemplateConstraints().isEmpty()) {
				NodeList containedTemplateIds = xPathHelper.getNodes(baseNode, containedNodeXPath, NAMESPACE);
				HashMap<String, Integer> containedTemplateMap = populateContainedTemplateMap(containedTemplateIds);
				
				for (ContainedTemplate containedTemplate : packageLocation.getContainedTemplateConstraints()) {
					Integer count = containedTemplateMap.get(containedTemplate.getTemplateOid());
					if (count == null) {
						count = 0;
					}
					if (!containedTemplate.getCardinality().contains(count)) {
						result.addHl7Error(new Hl7Error(Hl7ErrorCode.CDA_CARDINALITY_CONSTRAINT, "Expected [" + containedTemplate.getRawCardinality() + "] instances of template "
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
					count += containedTemplateMap.get(containedTemplateId);
				}
				containedTemplateMap.put(containedTemplateId, count);
				
				containedTemplateId = containedPackageLocation.getImpliedTemplateOid();
				containedPackageLocation = packagesByOid.get(containedTemplateId);
			}
		}
		return containedTemplateMap;
	}
}
