package ca.infoway.messagebuilder.datatype.lang;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Parenthetic Set Expression (SXPR) specializes SXCM
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-SXPR
 * 
 * <p>Definition: A set-component that is itself made up of set-components that are
 * evaluated as one value.
 * 
 * <p>There must be at least 2 component elements.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the underlying java datatype
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class ParentheticSetExpr<T> extends SetComponent<T> {

	public static final String COMPONENT = "comp";
	
	private List<SetComponent<T>> components = new ArrayList<SetComponent<T>>();

	/**
	 * <p>Constructs an empty ParentheticSetExpr.
	 */
	public ParentheticSetExpr() {
	}

	/**
	 * <p>Constructs a ParentheticSetExpr given ths supplied parameters.
	 * 
	 * @param components a list of SetComponents
	 */
	public ParentheticSetExpr(List<SetComponent<T>> components) {
		this.components = components;
	}

	/**
	 * <p>Constructs a ParentheticSetExpr given ths supplied parameters.
	 * 
	 * @param component1 a list of SetComponents
	 * @param component2 a list of SetComponents
	 */
	public ParentheticSetExpr(SetComponent<T> component1, SetComponent<T> component2) {
		this.components.add(component1);
		this.components.add(component2);
	}

	/**
	 * <p>Obtains the list of SetComponents.
	 * 
	 * @return the list of SetComponents
	 */
	public List<SetComponent<T>> getComponents() {
		return components;
	}
}
