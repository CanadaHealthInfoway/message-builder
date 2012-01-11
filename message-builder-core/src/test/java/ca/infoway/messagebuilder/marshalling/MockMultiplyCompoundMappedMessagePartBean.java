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

package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

/**
 *	@sharpen.ignore 
 */
@Hl7PartTypeMapping("MOCK_MT898989CA")
public class MockMultiplyCompoundMappedMessagePartBean {

	private static final long serialVersionUID = -8148180862570811368L;
	
	private MockSubType type = new MockSubType();
	private MockSubType2 type2 = new MockSubType2();

	@Hl7XmlMapping("theType/theSubType/theSubSubType")
	@Hl7MapByPartTypes({@Hl7MapByPartType(name="theType",type="MOCK_MT123458CA.SubTypeA"),
						@Hl7MapByPartType(name="theType/theSubType",type="MOCK_MT123457CA.SubTypeB"),
						@Hl7MapByPartType(name="theType/theSubType/theSubSubType",type="MOCK_MT123456CA.SubType")})
	public MockSubType getType() {
		return type;
	}

	public void setType(MockSubType type) {
		this.type = type;
	}

	@Hl7XmlMapping("theType/theSubType/theSubSubType")
	@Hl7MapByPartTypes({@Hl7MapByPartType(name="theType",type="MOCK_MT123458CA.SubTypeA"),
						@Hl7MapByPartType(name="theType/theSubType",type="MOCK_MT123457CA.SubTypeB"),
						@Hl7MapByPartType(name="theType/theSubType/theSubSubType",type="MOCK_MT898989CA.SubType")})
	public MockSubType2 getType2() {
		return this.type2;
	}

	public void setType2(MockSubType2 type2) {
		this.type2 = type2;
	}
}
