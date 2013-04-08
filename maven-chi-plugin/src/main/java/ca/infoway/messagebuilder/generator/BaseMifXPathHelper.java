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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.Namespaces.isMif1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.util.xml.DOMWriter;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.UpdateModeType;

abstract class BaseMifXPathHelper {

	public static Element getSingleElement(Element start, String xpath) {
		try {
			return (Element) new XPathHelper().getSingleNode(start, xpath, 
					Namespaces.MIF_NAMESPACE,
					Namespaces.MIF2_NAMESPACE);
		} catch (XPathExpressionException e) {
			throw new MifProcessingException(e);
		}
	}

	protected static List<Element> toElementList(NodeList nodes) {
		List<Element> result = new ArrayList<Element>();
		for (int i = 0, length = nodes == null ? 0 : nodes.getLength(); i < length; i++) {
			result.add((Element) nodes.item(i));
		}
		return result;
	}

	protected static NodeList getNodes(Element start, String xpath) {
		try {
			return new XPathHelper().getNodes(start, xpath, 
					Namespaces.MIF_NAMESPACE, Namespaces.MIF2_NAMESPACE, Namespaces.HTML_NAMESPACE);
		} catch (XPathExpressionException e) {
			throw new MifProcessingException(e);
		}
	}

	protected static String getAttribute(Element start, String xpath) {
		try {
			return new XPathHelper().getAttributeValue(start, xpath, Namespaces.MIF_NAMESPACE, Namespaces.MIF2_NAMESPACE);
		} catch (XPathExpressionException e) {
			throw new MifProcessingException(e);
		}
	}

	public static String getMifVersion(Document document) throws XPathExpressionException {
		String mifVersion = null;
		String namespace = getMifNamespace(document);
		String version = new XPathHelper().getAttributeValue(document, "/mif2:staticModel/@schemaVersion", Namespaces.MIF2_NAMESPACE);
		if (isMif1(namespace)) {
			mifVersion = "1.x";
		} else {
			mifVersion = version;
		}
		return mifVersion;
	}
	
	public static String getMifNamespace(Document document) {
		return document.getDocumentElement().getNamespaceURI();
	}
	
	List<Annotation> getDocumentation(Element classElement, String preMifAnnotationPath, String... postMifAnnotationPaths) {
		List<Annotation> result = new ArrayList<Annotation>();
		// for every annotation type
		for (AnnotationType annotationType : (List<AnnotationType>) EnumPattern.values(AnnotationType.class)) {
			String[] elementNames = annotationType.getMifElementNames();
			// for every different way for MIFs to describe the given annotation type
			for (String elementName : elementNames) {
				List<Element> annotationElements = toElementList(getNodes(classElement, preMifAnnotationPath+elementName));
				// for every high-level annotation element (<mif:description>, for example)
				for (Element annotationElement : annotationElements) {
					List<Element> paragraphElements = extractParagraphElements(annotationElement, postMifAnnotationPaths);
					if (!paragraphElements.isEmpty()) {
						Annotation annotation = new Annotation();
						
						annotation.setAnnotationTypeAsEnum(annotationType);
						String sourceName = annotationElement.getAttribute("sourceName");
						if (StringUtils.isNotBlank(sourceName)) {
							annotation.setSourceName(sourceName);
						}
						// TM - I have not seen this case in any MIF, so I'm not certain that this is the correct way to pull out "type"
						String otherType = annotationElement.getAttribute("type");
						if (StringUtils.isNotBlank(otherType)) {
							annotation.setOtherAnnotationType(otherType);
						}
						// for every paragraph of text within the annotation
						for (Element paragraphElement : paragraphElements) {
							String text = convertElementToText(paragraphElement);
							if (StringUtils.isNotBlank(text)) {
								annotation.setText( (annotation.getText() == null) ? text : annotation.getText() + text);
							}
						}
						if (StringUtils.isNotBlank(annotation.getText())) {
							result.add(annotation);
						}
					}
				}
			}
		}
		
		for (Iterator<Annotation> iterator = result.iterator(); iterator.hasNext();) {
			Annotation annotation = iterator.next();
			String newText = cleanInteractionAnnotationText(annotation.getText(), annotation.getAnnotationType());
			if (newText == null) {
				iterator.remove();
			} else {
				annotation.setText(newText);
			}
		}

		return result;
	}

	private List<Element> extractParagraphElements(Element annotationElement, String... postMifAnnotationPaths) {
		List<Element> paragraphElements = Collections.emptyList();
		int index = 0;
		while (paragraphElements.isEmpty() && index < postMifAnnotationPaths.length) {
			paragraphElements = toElementList(getNodes(annotationElement, postMifAnnotationPaths[index++]));
		}
		
		return paragraphElements;
	}

	public String convertElementToText(Element element) {
		String text = null;
		recurisvelyClearMifPrefix(element);
		try {
			text = StringUtils.trim(sanitizeText(DOMWriter.renderAsString(element)));
		} catch (IOException e) {
			throw new MifProcessingException(e);
		}
		return text;
	}

	private void recurisvelyClearMifPrefix(Element element) {
		element.setPrefix(null);
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof Element) {
				recurisvelyClearMifPrefix((Element)child);
			}
		}
	}

	protected String sanitizeText(String string) {
		String result = string;
//		if (result != null && !StringUtils.isAsciiPrintable(result)) {
//			result = result.replaceAll("[^\\p{ASCII}]", "");
//		}
		if (result != null) {
			result = StringUtils.trim(result).replaceAll("\\s+", " ");
		}
		return result;
	}
	
	String cleanInteractionAnnotationText(String annotationText, String annotationTypeAsString) {
		AnnotationType annotationType = AnnotationType.valueOf(AnnotationType.class, annotationTypeAsString);
		Object[] tagsToRemove = ArrayUtils.add(annotationType.getMifElementNames(), "text");
		for (Object tagToRemove : tagsToRemove) {
			annotationText = StringUtils.remove(annotationText, "<" + tagToRemove + ">");
			annotationText = StringUtils.remove(annotationText, "</" + tagToRemove + ">");
		}
		annotationText = StringUtils.trim(annotationText);
		
		if (StringUtils.isBlank(annotationText)) {
			annotationText = null;
		} else if (!annotationText.startsWith("<p>")) {
			annotationText = "<p>" + annotationText + "</p>";
		}
		
		return annotationText; 
	}
	
	abstract String getOwnedEntryPoint(Document document);
	abstract String getRootType(Element ownedEntryPoint);
	abstract List<Annotation> getDocumentation(Element classElement);
	abstract String getBusinessName(Element element);
	abstract Element getOwnedEntryPointElement(Document document);
	abstract List<UpdateModeType> getAllowedUpdateModes(Element element);
	abstract Element getTemplateParameter(Element targetConnection);
	abstract String determineRimClassForChoiceElement(Element classElement);
	
}
