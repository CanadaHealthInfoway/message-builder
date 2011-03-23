package ca.infoway.messagebuilder.transport.mohawk;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.transport.TransportLayerException;

/**
 * @sharpen.ignore - transport - TBD!
 */
class Hl7MessageExtractor {

	/**
	 * <p>Extracts an HL7 message as a string from an input stream. 
	 * 
	 * @param input the input stream from which a message can be extracted 
	 * @return the message in string format
	 * @throws IOException if there is a problem in reading data from the input stream
	 * @throws SOAPException may be thrown if the message is invalid
	 */
	public String getHl7Message(InputStream input) throws IOException, SOAPException {
		
		SOAPMessage message = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage(new MimeHeaders(), input);
		SOAPBody body = message.getSOAPBody();
		
		Document document = body.extractContentAsDocument();
		return toString(document);
	}
	
	private String toString(Document document) {
		try {
	    	StringWriter writer = new StringWriter();
	        Transformer transformer = TransformerFactory.newInstance().newTransformer();
	        transformer.transform(new DOMSource(document.getDocumentElement()), new StreamResult(writer));
	        return writer.toString();
		} catch (TransformerException e) {
			throw new TransportLayerException(e);
		}
	}	
}
