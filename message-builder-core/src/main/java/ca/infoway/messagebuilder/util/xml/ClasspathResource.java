package ca.infoway.messagebuilder.util.xml;

import java.io.InputStream;

/**
 * <p>A class that makes it easy to read a resource on the classpath as an XML document.
 * 
 * @author Intelliware Development
 * 
 * @sharpen.ignore - util.xml - translated manually
 */
public class ClasspathResource implements InputStreamResource {

	private final Class<?> c;
	private final String resourceName;

	/**
	 * <p>Standard constructor.
	 * 
	 * <p>Using this constructor is equivalent to 
	 * <code>ClasspathResource.class.getClassLoader().getResourceAsStream(resourceName)</code>
	 * 
	 * @param resourceName - the resource name.
	 */
	public ClasspathResource(String resourceName) {
		this.resourceName = resourceName;
		this.c = null;
	}
	/**
	 * <p>Standard constructor.
	 * 
	 * <p>Using this constructor is equivalent to 
	 * <code>c.getResourceAsStream(resourceName)</code>
	 * 
	 * @param c - a class whose package helps identify the location of the resource name.
	 * @param resourceName - the resource name that can be found relative to the class, c
	 */
	public ClasspathResource(Class<?> c, String resourceName) {
		this.c = c;
		this.resourceName = resourceName;
		
	}
	
	/**
	 * <p>Obtain the classpath resource as a stream.
	 * @return - the stream
	 */
	public InputStream getInputStream() {
		if (c == null) {
			return getClass().getClassLoader().getResourceAsStream(this.resourceName);
		} else {
			return c.getResourceAsStream(this.resourceName);
		}
	}

}