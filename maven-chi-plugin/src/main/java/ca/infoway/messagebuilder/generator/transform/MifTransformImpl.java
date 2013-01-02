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

package ca.infoway.messagebuilder.generator.transform;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.Mif2XPathHelper;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

/**
 * <p>Mif transformer for converting 2.1.6, 2.1.5, 2.1.4 version mifs into 2.1.3. 
 * 
 * <p>Currently, this transform depends on the Saxon parser (8.7). Transforms may fail or be incorrect if using the 
 * default Java transformer factory implementation.
 * 
 *  <p>The system property "javax.xml.transform.TransformerFactory" needs to be set to "net.sf.saxon.TransformerFactoryImpl".
 * 
 * <p>This class is not thread safe. This is due to the retained transformer object itself not being thread safe. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 */
public class MifTransformImpl implements MifTransform {

	private List<String> allowedVersions = Arrays.asList("2.1.4", "2.1.5", "2.1.6");
	
	private Transformer transformer;
	
	public MifTransformImpl(InputStream streamTransform) throws GeneratorException {
		this(streamTransform, new DocumentFactory());
	}
	
	public MifTransformImpl(InputStream streamTransform, DocumentFactory documentFactory) throws GeneratorException {
		this(createDocumentFromStream(streamTransform, documentFactory));
	}

	public MifTransformImpl(File fileTransform) throws GeneratorException {
		this(fileTransform, new DocumentFactory());
	}
	
	public MifTransformImpl(File fileTransform, DocumentFactory documentFactory) throws GeneratorException {
		this(createDocumentFromFile(fileTransform, documentFactory));
	}

	private static Document createDocumentFromStream(InputStream streamTransform, DocumentFactory documentFactory) throws GeneratorException {
		try {
			return documentFactory.createFromStream(streamTransform);
		} catch (Exception e) {
			throw new GeneratorException("Error creating Document from transform stream", e);
		}
	}
	
	private static Document createDocumentFromFile(File fileTransform, DocumentFactory documentFactory) throws GeneratorException {
		try {
			return documentFactory.createFromFile(fileTransform);
		} catch (Exception e) {
			throw new GeneratorException("Error creating Document from transform file", e);
		}
	}
	
	public MifTransformImpl(Document docTransform) throws GeneratorException {
		 TransformerFactory tFactory = TransformerFactory.newInstance();
		 try {
			this.transformer = tFactory.newTransformer(new DOMSource(docTransform));
		} catch (TransformerConfigurationException e) {
			throw new GeneratorException("Error trying to create transformer from xsl transform", e);
		}
	}
	
	public Document transform(Document documentToTransform) throws GeneratorException {
		if (!isValidVersion(documentToTransform)) {
			throw new GeneratorException("Mif transforms can only be applied to mifs of version: " + this.allowedVersions);
		}
		
		Source docSource = new DOMSource(documentToTransform);
		DOMResult docResult = new DOMResult();
		try {
			this.transformer.transform(docSource, docResult);
		} catch (TransformerException e) {
			throw new GeneratorException(e);
		}

		return (Document) docResult.getNode();
	}

	public boolean shouldBeTransformed(Document documentToTransform) throws GeneratorException {
		return isValidVersion(documentToTransform);
	}

	private boolean isValidVersion(Document documentToTransform) throws GeneratorException {
		try {
			String mifVersion = Mif2XPathHelper.getMifVersion(documentToTransform);
			return this.allowedVersions.contains(mifVersion);
		} catch (XPathExpressionException e) {
			throw new GeneratorException(e);
		}
	}

	
}
