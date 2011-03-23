package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;

/**
 * <p>A class to represent CeRx's notion of a physical quantity. Backed by the java datatype PhysicalQuantity.
 *
 * <p>There are two attributes of note: value (amount) and unit.
 * 
 * <p>The HL7 version of this class relies on the HL7 REAL, which is a
 * re-implemented BigDecimal for all intents and purposes.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @see <a href="http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PQ">The HL7 Definition</a>
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface PQ extends QTY<PhysicalQuantity> {

	// TODO - Datatypes - TM/AG - consider implementing the following unsupported methods
	
//    PQ canonical();
//    PQ expressedIn(PQ that);
//    INT precision();
//    PQ withLimitedPrecision(INT precisionLimit);
	
}
