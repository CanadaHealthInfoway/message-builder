package ca.infoway.messagebuilder.datatype;

/**
 * <p>TEL HL7 datatype.
 * 
 * <p>Represents CeRx's notion of a telecommunication address, such as a phone
 * number, fax, email or http address.
 *
 * <p>There are several parts to an tel address, but HL7 has dumped all the relevant 
 * information into a single text field. Urp.
 * 
 * <p>The first part is the URL scheme. This is something like tel: or http:. CeRx limits 
 * these based on the subclass of TEL (TEL.PHONEMAIL or TEL.URI).
 * 
 * <p>There are some number of uses for each address. CeRx limits this to three, which is
 * not enforced by this class. For the TEL.URI subclass, use is not permitted at all.
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TEL
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface TEL extends URL {

	// TODO - Datatype - TM/AG - useablePeriod not currently supported
	
}
