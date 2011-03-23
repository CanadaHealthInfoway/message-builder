package ca.infoway.messagebuilder.j5goodies;

import java.beans.PropertyDescriptor;

import org.apache.commons.lang.ClassUtils;

/**
 * <p>An exception that indicates that a problem was encountered while
 * performing reflection on a bean.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class BeanReflectionException extends RuntimeException {

	private static final long serialVersionUID = -7767648387814671605L;

	/**
	 * <p>Standard constructor.
	 * @param beanProperty - the bean property that caused the exception.
	 * @param cause - the problem that was encountered.
	 */
	public BeanReflectionException(BeanProperty beanProperty, Throwable cause) {
		this(beanProperty.getBeanType(), beanProperty.getDescriptor(), cause);
	}
	/**
	 * <p>Standard constructor.
	 * @param beanClass - the bean type that caused the exception.
	 * @param descriptor - the descriptor of the property that caused the exception.
	 * @param cause - the problem that was encountered.
	 */
	public BeanReflectionException(Class<?> beanClass, PropertyDescriptor descriptor, Throwable cause) {
		super("Exception thrown while trying to work with property " 
				+ descriptor.getName() 
				+ " on " + ClassUtils.getShortClassName(beanClass), cause);
	}
	/**
	 * <p>Standard constructor.
	 * @param e - the problem that was encountered.
	 */
	public BeanReflectionException(Throwable e) {
		super(e.toString(), e);
	}
}
