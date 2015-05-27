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
 * Last modified: $LastChangedDate: 2014-01-09 11:56:23 -0500 (Thu, 09 Jan 2014) $
 * Revision:      $LastChangedRevision: 8280 $
 */
package ca.infoway.messagebuilder.marshalling;

import java.lang.reflect.Type;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD_R2;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.impl.BXITImpl;
import ca.infoway.messagebuilder.datatype.impl.CD_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.COImpl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CV_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.CollectionHelper;
import ca.infoway.messagebuilder.datatype.impl.HXITImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQRImpl;
import ca.infoway.messagebuilder.datatype.impl.SC_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.SXCM_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;

/**
 * @sharpen.ignore - used to handle generics issues with CodedTypeR2 in .NET
 */
public class CodedTypeR2Helper {
	
	public static boolean isCodedTypeR2(Object value) {
		return value instanceof CodedTypeR2;
	}
	
	@SuppressWarnings("unchecked")
	public static String getCodeValue(Object codedTypeR2) {
		if (!isCodedTypeR2(codedTypeR2)) {
			throw new IllegalArgumentException("Object is not a CodedTypeR2 " + codedTypeR2);
		}
		return ((CodedTypeR2<Code>)codedTypeR2).getCodeValue(); 
	}
	
	@SuppressWarnings("unchecked")
	public static Code getCode(Object codedTypeR2) {
		if (!isCodedTypeR2(codedTypeR2)) {
			throw new IllegalArgumentException("Object is not a CodedTypeR2 " + codedTypeR2);
		}
		return ((CodedTypeR2<Code>) codedTypeR2).getCode();
	}

	public static Object convertCodedTypeR2(CodedTypeR2<Code> source, Type parameterType) {
		return source; //No-op due to type erasure
	}
	
	@SuppressWarnings("unchecked")
	public static CodedTypeR2<Code> convertCodedTypeR2(Object source) {
		return (CodedTypeR2<Code>) source; //No-op due to type erasure
	}
	
	public static CollectionHelper createCDList(Type codeType) {
		return new LISTImpl<CD_R2<Code>, CodedTypeR2<Code>>(CD_R2Impl.class);
	}
	
	public static CollectionHelper createCSList(Type codeType) {
		return new LISTImpl<CS_R2<Code>, CodedTypeR2<Code>>(CS_R2Impl.class);
	}
	
	public static CollectionHelper createCEList(Type codeType) {
		return new LISTImpl<CE_R2<Code>, CodedTypeR2<Code>>(CE_R2Impl.class);
	}
	
	public static BareANY createCEInstance(Type codeType) {
		return new CE_R2Impl<Code>();
	}
	
	public static BareANY createCDInstance(Type codeType) {
		return new CD_R2Impl<Code>();
	}
	
	public static BareANY createCOInstance(Type codeType) {
		return new COImpl<Code>();
	}
	
	public static BareANY createCSInstance(Type codeType) {
		return new CS_R2Impl<Code>();
	}
	
	public static BareANY createCVInstance(Type codeType) {
		return new CV_R2Impl<Code>();
	}
	
	public static BareANY createHXITInstance(Type codeType) {
		return new HXITImpl<Code>();
	}
	
	public static BareANY createPQRInstance(Type codeType) {
		return new PQRImpl<Code>();
	}
	
	public static BareANY createSCInstance(Type codeType) {
		return new SC_R2Impl<Code>();
	}
	
	public static BareANY createBXITInstance(Type codeType) {
		return new BXITImpl<CodedTypeR2<Code>>();
	}
	
	public static BareANY createSXCMInstance(Type codeType) {
		return new SXCM_R2Impl<CodedTypeR2<Code>>();
	}
}