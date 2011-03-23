package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.Ratio;

/**
 * <p>HL7 datatype for ratios. Backed by a Ratio object.
 * 
 * <p>For RTO&lt;PQ.DRUG, PQ.TIME&gt;: Used to express a quantity of drug over a particular time-period.
 * 
 * <p>For RTO&lt;MO.CAD, PQ.BASIC&gt;: Used to express a monetary value over quantity.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <N> The underlying java datatype for the numerator.
 * @param <D> The underlying java datatype for the denominator.
 * @sharpen.ignore - datatype - translated manually 
 */
public interface RTO<N, D> extends QTY<Ratio<N, D>> {
}
