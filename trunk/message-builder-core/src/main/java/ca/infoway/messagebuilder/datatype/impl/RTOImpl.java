/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

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
public class RTOImpl<N, D> extends QTYImpl<Ratio<N, D>> implements RTO<N, D> {

	private static final long serialVersionUID = 425471575439329037L;

	/**
	 * <p>Constructs an empty RTO.
	 */
	@SuppressWarnings("unchecked")
	public RTOImpl() {
		this((Ratio) null);
	}

	/**
	 * <p>Constructs an RTO with the given intial value.
	 * 
	 * @param defaultValue initial RTO value
	 */
	public RTOImpl(Ratio<N, D> defaultValue) {
		super(Ratio.class, defaultValue, null, StandardDataType.RTO);
	}

	/**
	 * <p>Constructs an RTO with a null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public RTOImpl(NullFlavor nullFlavor) {
		super(Ratio.class, null, nullFlavor, StandardDataType.RTO);
	}
	
}
