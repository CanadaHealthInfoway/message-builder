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
package ca.infoway.messagebuilder.guide.examples.devtools;

import static ca.infoway.messagebuilder.datatype.StandardDataType.BL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.util.messagegenerator.DefaultDataTypeValueStore;

public class MyDefaultDataTypeValueStore extends DefaultDataTypeValueStore {

	public MyDefaultDataTypeValueStore() {
		super();

		// my default values
		this.addValue(II, new Identifier("5.6.7", "MY CUSTOM II"));
		this.addValue(BL, Boolean.FALSE);
	}
}
