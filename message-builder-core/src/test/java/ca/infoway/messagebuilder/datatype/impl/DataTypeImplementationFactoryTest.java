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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.datatype.impl;

import static org.junit.Assert.assertNotNull;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class DataTypeImplementationFactoryTest {
	
	private static final Set<StandardDataType> CDA_R2_TYPES = new HashSet<StandardDataType>();
	private static final StandardDataType[] DATA_TYPES = EnumPattern.values(StandardDataType.class).toArray(new StandardDataType[0]);
	
	static {
		CDA_R2_TYPES.add(StandardDataType.CD);
		CDA_R2_TYPES.add(StandardDataType.CV);
		CDA_R2_TYPES.add(StandardDataType.CE);
		CDA_R2_TYPES.add(StandardDataType.CO);
		CDA_R2_TYPES.add(StandardDataType.SC);
		CDA_R2_TYPES.add(StandardDataType.CS);
		CDA_R2_TYPES.add(StandardDataType.PQR);
	}
	
	@Test
	public void makeSureDataTypeHasAnImplemenation() throws Exception {
		for (StandardDataType type : DATA_TYPES) {
			if (type != StandardDataType.COLLECTION && type != StandardDataType.BAG) {
				if (type.isCoded() && CDA_R2_TYPES.contains(type)) {
					assertNotNull(MessageFormat.format("no implementation for: {0}", 
							type.getType()), 
							DataTypeImplementationFactory.getImplementation(type.getType(), true));
				}
				assertNotNull(MessageFormat.format("no implementation for: {0}", 
						type.getType()), 
						DataTypeImplementationFactory.getImplementation(type.getType(), false));
			}
		}
	}

}
