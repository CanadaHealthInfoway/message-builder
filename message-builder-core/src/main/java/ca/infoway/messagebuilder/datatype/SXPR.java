package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.ParentheticSetExpr;

/**
 * <p>Parenthetic Set Expression (SXPR) specializes SXCM. Backed by the java datatype ParentheticSetExpr.
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
 * @sharpen.ignore - datatype - translated manually 
 */
public interface SXPR<T> extends ANY<ParentheticSetExpr<T>> {
}
