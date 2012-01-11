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

package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;

public class TsToIvlAdapter implements DataTypeAdapter {
	
	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		if (TS.class.isAssignableFrom(fromDataType) 
		 && (StandardDataType.IVL_FULL_DATE.getType().equals(toDataTypeName)
		 || StandardDataType.IVL_FULL_DATE_WITH_TIME.getType().equals(toDataTypeName))) {
			return true;
		}
		return false;
	}

	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDateType) {
		return false;
	}
	
	public BareANY adapt(BareANY any) {
		return new DataTypeAdapterHelper().copyAndReturnAdapted(
				any, 
				(BareANY) new IVLImpl<TS,Interval<Date>>(), 
				any.getBareValue() !=null ? IntervalFactory.<Date>createLow((Date) any.getBareValue()) : null);
	}

}
