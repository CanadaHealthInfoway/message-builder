package ca.infoway.messagebuilder.xml;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 * <p>A utility to read and write the Java representation of a message set.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class MessageSetMarshaller {

	private Serializer serializer = new Persister();
	
	/**
	 * <p>Unmarshall a message set to a file.
	 * 
	 * @param file - the file to read
	 * @return the message set.
	 * @throws Exception - if any underlying exception occurs
	 */
	public MessageSet unmarshall(File file) throws Exception {
		return (MessageSet) this.serializer.read(MessageSet.class, file);
	}

	/**
	 * <p>Marshall a message set to an output stream.
	 * 
	 * @param domain - the message set to marshall
	 * @param output - the output stream
	 * @throws Exception - if any underlying exception occurs
	 */
	public void marshall(MessageSet domain, OutputStream output) throws Exception {
		this.serializer.write(domain, output);
	}
	/**
	 * <p>Marshall a message set to an output stream.
	 * 
	 * @param domain - the message set to marshall
	 * @param file - the file to write to
	 * @throws Exception - if any underlying exception occurs
	 */
	public void marshall(MessageSet domain, File file) throws Exception {
		this.serializer.write(domain, file);
	}

	/**
	 * <p>Unmarshall a message set to a file.
	 * 
	 * @param input - the input stream
	 * @return the message set.
	 * @throws Exception - if any underlying exception occurs
	 */
	public MessageSet unmarshall(InputStream input) throws Exception {
		return (MessageSet) this.serializer.read(MessageSet.class, input);
	}
}
