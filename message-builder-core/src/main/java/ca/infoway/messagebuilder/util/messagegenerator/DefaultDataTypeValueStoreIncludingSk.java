/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.util.messagegenerator;

import java.math.BigDecimal;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeSk;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;

/**
 * @sharpen.ignore sample message generator is for MB Java only
 */
public class DefaultDataTypeValueStoreIncludingSk extends DefaultDataTypeValueStore {

	private PeriodicIntervalTimeSk pivlSk;
	
	public DefaultDataTypeValueStoreIncludingSk() {
		super();
		this.pivlSk = createPivlForSk();
	}
	
	@Override
	public Object getValueForDatatype(String dataType, Class<?> propertyType, VersionNumber version) {
		Object valueForDatatype = super.getValueForDatatype(dataType, propertyType, version);
		if (SpecificationVersion.isExactVersion(version, SpecificationVersion.V01R04_2_SK)) {
			if (valueForDatatype instanceof PeriodicIntervalTime) {
				valueForDatatype = this.pivlSk;
			}
		}
		return valueForDatatype;
	}

	/**
	 * Hack for SK as that jurisdiction has a specialized form of PIVL. This should be refactored into a more generic approach, but can wait until other exceptions are added.
	 * 
	 * @return
	 */
	private PeriodicIntervalTimeSk createPivlForSk() {
		PhysicalQuantity lowQuantity = new PhysicalQuantity(new BigDecimal(1), DefaultTimeUnit.DAY);
		PhysicalQuantity highQuantity = new PhysicalQuantity(new BigDecimal(4), DefaultTimeUnit.DAY);
		PeriodicIntervalTimeSk pivlSk = PeriodicIntervalTimeSk.createFrequencySk(3, lowQuantity, highQuantity);
		return pivlSk;
	}
	
}
