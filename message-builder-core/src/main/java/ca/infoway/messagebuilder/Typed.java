package ca.infoway.messagebuilder;


/**
 * <p>An interface that defines HL7 concepts that have types.</p>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface Typed {

	/**
	 * <p>Return the HL7 type -- either an HL7 data type or a complex message type.
	 * @return - the HL7 type
	 */
	public String getType();

}
