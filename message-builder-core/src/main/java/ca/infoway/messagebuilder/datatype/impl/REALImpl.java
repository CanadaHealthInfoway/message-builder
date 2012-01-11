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

import java.math.BigDecimal;

import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

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
public class REALImpl extends QTYImpl<BigDecimal> implements REAL {

	/**
	 * <p>Constructs an empty REAL.
	 */
	public REALImpl() {
		this((BigDecimal) null);
	}

	/**
	 * <p>Constructs a REAL using the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public REALImpl(BigDecimal defaultValue) {
		super(BigDecimal.class, defaultValue, null, StandardDataType.REAL);
	}

	/**
	 * <p>Constructs a REAL with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public REALImpl(NullFlavor nullFlavor) {
		super(BigDecimal.class, null, nullFlavor, StandardDataType.REAL);
	}
	
}
