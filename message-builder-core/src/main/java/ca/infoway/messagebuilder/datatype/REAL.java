package ca.infoway.messagebuilder.datatype;

import java.math.BigDecimal;

/**
 * <p>HL7 datatype used for real numbers. Backed by a java BigDecimal.
 *
 * <p>Covers the following Hl7 datatypes:
 * 
 * <p>REAL.COORD: A real number intended for use in conveying geographic coordinate values
 * 
 * <p>REAL.CONF: A real number intended for use in conveying confidence level values in registries 
 *            NOTE: As of R02.04.02, this datatype flavor is also used for expressing percentages. 
 *            It is expected that the flavor name may change in a future release. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public interface REAL extends QTY<BigDecimal> {

}
