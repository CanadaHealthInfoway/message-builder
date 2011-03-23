package ca.infoway.messagebuilder.datatype;


/**
 * <p>Hl7 datatype CS. backed by a Code.
 * 
 * <p>Coded data in its simplest form, where only the code is not predetermined. The code system and code system version 
 * are fixed by the context in which the CS value occurs. CS is used for coded attributes that have a 
 * single HL7-defined value set.
 *
 * <p>CS can only be used in either of the following cases:
 * 
 * <p>for a coded attribute which has a single HL7-defined code system, and where code additions to that value set 
 *   require formal HL7 action (such as harmonization.) Such coded attributes must have type CS.
 *   
 * <p>for a property in this specification that is assigned to a single code system defined either in this 
 *   specification or defined outside HL7 by a body that has authority over the concept and the maintenance 
 *   of that code system.
 * 
 * <p>For example, since ED subscribes to the MIME design, it trusts IETF to manage the media type. This includes 
 * that this specification subscribes to the extension mechanism built into the 
 * MIME media type code (e.g., "application/x-myapp").
 * 
 * <p>For CS values, the designation of the domain qualifier will always be CNE (coded, non-extensible) 
 * and the context will determine which HL7 values to use.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying code.
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface CS extends CV {
	
}
