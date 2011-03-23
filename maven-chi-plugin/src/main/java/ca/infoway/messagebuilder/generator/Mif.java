package ca.infoway.messagebuilder.generator;

import org.w3c.dom.Document;

/**
 * <p>Model Interchange Format file contents.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
interface Mif {
	/**
	 * <p>Return the MIF file as a parsed DOM document. </p>
	 * @return
	 */
	public Document asDocument();
	/**
	 * <p>Return the MIF name in the form AAAA_MTBBBBBBCA.</p>
	 * 
	 * <p>Example names might include PRPA_MT101101CA or MCAI_MT700212CA.
	 * @return - the package location
	 */
	public String getPackageLocation();
	/**
	 * <p>Return the MIF name in the Camel-case form.</p>
	 * 
	 * <p>Example names might include "OrderID" or "ActingPersonIdentified-confirmable".</p>
	 * @return - the MIF name
	 */
	public String getName();
	/**
	 * <p>The category that has been assigned to the MIF during the MIF to XML process.</p>
	 * 
	 * <p>Typical categories might be 'cr' or 'iehr'.
	 * 
	 * @return - the category
	 */
	public String getCategory();
}
