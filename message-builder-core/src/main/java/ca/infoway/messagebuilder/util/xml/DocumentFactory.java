package ca.infoway.messagebuilder.util.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * <p>A class that simplifies the process of parsing XML documents.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - util.xml - translated manually
 */
public class DocumentFactory {

    private final EntityResolver entityResolver;
   
    /**
     * <p>Standard constructor.
     */
    public DocumentFactory() {
        this.entityResolver = null;
    }
    
    /**
     * <p>Standard constructor.
     * @param entityResolver - a class that can help resolve entity references.
     */
    public DocumentFactory(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    /**
     * <p>Read in a file and parse it as XML.
     * @param xmlFile - the file that contains the XML
     * @return - the DOM document.
     * @throws SAXException - if the XML file cannot be parsed.
     * @throws IOException - if the file cannot be read.
     */
    public Document createFromFile(File xmlFile)
            throws SAXException, IOException {
        return createDocumentBuilder().parse(xmlFile);
    }
    
    /**
     * <p>Read in a stream and parse it as XML.
     * @param stream - the stream that contains the XML
     * @return - the DOM document.
     * @throws SAXException - if the stream cannot be parsed as XML.
     * @throws IOException - if the stream cannot be read.
     */
    public Document createFromStream(InputStream stream)
            throws SAXException, IOException {
        return createDocumentBuilder().parse(
                new InputSource(stream));
    }
    
    /**
     * <p>Parse the string as XML.
     * @param xml - the string that contains the XML
     * @return - the DOM document.
     * @throws SAXException - if the stream cannot be parsed as XML.
     */
    public Document createFromString(String xml)
            throws SAXException {
        Document document = null;
        try {
            document = createDocumentBuilder().parse(
                    new InputSource(new StringReader(xml)));
        } catch (IOException e) {
            // should never happen
        }
        return document;
    }
    
    /**
     * <p>Read in a resource and parse it as XML.
     * @param resource - the resource that contains the XML
     * @return - the DOM document.
     * @throws SAXException - if the resource cannot be parsed as XML.
     * @throws IOException - if the resource cannot be read.
     */
    public Document createFromResource(InputStreamResource resource) 
    		throws IOException, SAXException {
    	Document document = null;
    	InputStream input = resource.getInputStream();
    	try {
    		document = input == null ? null : createDocumentBuilder().parse(
    				new InputSource(input));
    	} finally {
    		IOUtils.closeQuietly(input);
    	}
    	return document;
    }
    
    /**
     * <p>Parse the byte array as XML.
     * @param xml - the byte array that contains the XML
     * @return - the DOM document.
     * @throws SAXException - if the byte array cannot be parsed as XML.
     */
    public Document createFromByteArray(byte[] xml)
            throws SAXException {
        Document document = null;
        try {
            document = createDocumentBuilder().parse(
                    new InputSource(new ByteArrayInputStream(xml)));
        } catch (IOException e) {
        	throw new SAXException(e);
        }
        return document;
    }
    
    protected DocumentBuilder createDocumentBuilder() {
        DocumentBuilder builder = null;
        try {
            DocumentBuilderFactory factory = createDocumentBuilderFactory();
            builder = factory.newDocumentBuilder();
            if (this.entityResolver != null) {
                builder.setEntityResolver(this.entityResolver);
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e.toString());
        }
        return builder;
    }

    DocumentBuilderFactory createDocumentBuilderFactory() {
        DocumentBuilderFactory factory =
            DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory;
    }

    /**
     * <p>Create a new (blank) document.
     * @return - a new document
     */
    public Document newDocument() {
        return createDocumentBuilder().newDocument();
    }
}
