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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.guide.hello_world;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TimeZone;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.TransformError;
import ca.infoway.messagebuilder.error.TransformErrors;
import ca.infoway.messagebuilder.marshalling.CdaModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.ClinicalDocumentTransformer;
import ca.infoway.messagebuilder.marshalling.XmlToCdaModelResult;
import ca.infoway.messagebuilder.model.ClinicalDocumentBean;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public abstract class HelloWorldAppBase {
	
	public static final VersionNumber MBSpecificationVersion = SpecificationVersion.CCDA_R1_1;
	
	protected String processDocumentObject(ClinicalDocumentBean clinicalDocumentBean) {
		
		// the transformer would ideally be cached
		CdaModelToXmlResult result = this.createTransformer().transformToDocument(MBSpecificationVersion, clinicalDocumentBean);
		
		System.out.println("\nDocument (converted to XML):\n");
		
		// IMPORTANT NOTE: it is the application's responsibility to add a valid xml header to the xml output
		//                 (this feature is under consideration for a future version of MB)
		
		String documentXml = result.getXmlDocument();
		System.out.println(documentXml);
		
		reportErrorsAndWarnings(result, true, true);
		
		return documentXml;
	}
	
	protected ClinicalDocumentBean processDocumentXml(String documentXml) {
		
		ClinicalDocumentBean documentBean = null;
		
		// the transformer would ideally be cached
		ClinicalDocumentTransformer transformer = this.createTransformer();
		
		// this is a W3C DOM Document (not to be confused with a CDA Document)
		Document xmlAsDoc = createW3CDocument(documentXml);
		
		XmlToCdaModelResult result = transformer.transformFromDocument(MBSpecificationVersion, xmlAsDoc);
		
		documentBean = (ClinicalDocumentBean) result.getClinicalDocumentObject();
		
		reportErrorsAndWarnings(result, false, false);
			
		return documentBean;
	}
	
	private void reportErrorsAndWarnings(TransformErrors errors, boolean toXml, boolean includeInfo) {
		String message = (toXml ? "Document object to XML" : "Document XML to object");
		if (errors.isValid()) {
			System.out.println("\n\nNo errors or warnings to report from converting " + message + ".\n");
		} else {
			System.out.println("\n\nErrors/warnings from converting " + message + ":\n");
		}
		// printing everything (to include INFO messages as well)
		for (TransformError transformError : errors.getErrors()) {
			if (includeInfo || transformError.getErrorLevel() != ErrorLevel.INFO) {
				System.out.println(transformError);
			}
		}
	}
	
	protected ClinicalDocumentTransformer createTransformer() {
		
		// PERMISSIVE is the default setting for the transformer; this allows processing to continue even if errors are detected

		// this creates a transformer using the local timezone and PERMISSIVE
		// return new MessageBeanTransformerImpl();

		// this creates a transformer using the local timezone and explicitly sets PERMISSIVE
		// return new MessageBeanTransformerImpl(RenderMode.PERMISSIVE);
		
		// specify a time zone when using the transformer 
		// (not absolutely necessary, if not set, local timezone is used)
		// Note: a time zone can also be specified for each individual transform, overriding any provided in the constructor
		TimeZone timeZone = TimeZone.getTimeZone("GMT-5");
		return new ClinicalDocumentTransformer(timeZone, timeZone);
	}
	
	private Document createW3CDocument(String xml) {
		
		// there are many ways to end up with a W3C XML Document; this one shows creating one from a String
		
		Document result = null;
		try {
			result = new DocumentFactory().createFromString(xml);
		} catch (SAXException e) {
			System.err.print("SAXException in HelloWorldApp.createXmlDocument() method");
			e.printStackTrace();
		}
		return result;
	}

	protected String readResourceFile(String resourceName) {
		InputStream is = getClass().getResourceAsStream(resourceName);
		String contents = null;
		try {
			contents = convertStreamToString(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contents;

	}
	
	public String convertStreamToString(InputStream is) throws  IOException {
		/*
		 * To convert the InputStream to String we use the BufferedReader.readLine()
		 * method. We iterate until the BufferedReader return null which means
		 * there's no more data to read. Each line will appended to a StringBuilder
		 * and returned as String.
		 */
		if (is != null) {
			StringBuilder sb = new StringBuilder();
			String line;

			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\n");
				}
			} finally {
				is.close();
			}
			return sb.toString();
		} else {       
			return null;
		}
	}

}
