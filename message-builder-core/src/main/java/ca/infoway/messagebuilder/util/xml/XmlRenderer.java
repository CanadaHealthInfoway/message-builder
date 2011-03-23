package ca.infoway.messagebuilder.util.xml;

import java.io.StringWriter;
import java.io.Writer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * <p>A utility that renders a DOM tree into a String representation.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - util.xml - translated manually
 */
public class XmlRenderer {

	/**
	 * <p>Render the document to properly-formatted XML.
	 * @param document - the document to render.
	 * @return - the XML.
	 * @throws TransformerException - if the XML cannot be rendered
	 */
    public static String render(Document document) throws TransformerException {
    	StringWriter writer = new StringWriter();
    	render(document, writer);
    	return writer.toString();
    }
	/**
	 * <p>Render the document to properly-formatted XML.
	 * @param document - the document to render.
	 * @param writer - the writer to which the XML should be rendered.
	 * @throws TransformerException - if the XML cannot be rendered
	 */
    public static void render(Document document, Writer writer) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
    }
}