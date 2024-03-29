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

package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.StandardDataType;

/**
 * 
 * ANY, ANY.LAB, ANY.CA.IZ, ANY.PATH; added for BC: ANY.X1, ANY.X2
 * 
 * Each value sent over the wire must correspond to one of the
 * following non-abstract data type flavor specifications defined below:
 * 
 * ANY:       all types allowed
 * ANY.LAB:   CD.LAB, ST, PQ.LAB, IVL&lt;PQ.x&gt;, INT.NONNEG, INT.POS, TS.FULLDATETIME, URG&lt;PQ,x&gt;
 * ANY.CA.IZ: ST, PN.BASIC, INT.POS, BL
 * ANY.PATH:  ST, PQ, ED.DOCORREF or CD.LAB
 * ANY.X1:    ST, CV, PQ.LAB, IVL&lt;PQ.x&gt;, URG&lt;PQ.LAB&gt;
 * ANY.X2:    ST, CV, ED.DOCORREF
 * 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 */
public class AnyHelper {
	
	private static List<String> ANY_LAB_LIST = Arrays.asList(new String[] {
			StandardDataType.CD_LAB.getType(), 
			StandardDataType.ST.getType(),
			StandardDataType.PQ_LAB.getType(),
			StandardDataType.IVL_PQ_BASIC.getType(),
			StandardDataType.IVL_PQ_DISTANCE.getType(),
			StandardDataType.IVL_PQ_DRUG.getType(),
			StandardDataType.IVL_PQ_HEIGHTWEIGHT.getType(),
			StandardDataType.IVL_PQ_LAB.getType(),
			StandardDataType.IVL_PQ_TIME.getType(),
			StandardDataType.INT_NONNEG.getType(),
			StandardDataType.INT_POS.getType(),
			StandardDataType.TS_FULLDATETIME.getType(),
			StandardDataType.URG_PQ_BASIC.getType(),
			StandardDataType.URG_PQ_DISTANCE.getType(),
			StandardDataType.URG_PQ_DRUG.getType(),
			StandardDataType.URG_PQ_HEIGHTWEIGHT.getType(),
			StandardDataType.URG_PQ_LAB.getType(),
			StandardDataType.URG_PQ_TIME.getType()
	});
	
	private static List<String> ANY_PATH_LIST = Arrays.asList(new String[] {
			StandardDataType.ST.getType(),
			StandardDataType.PQ_BASIC.getType(),
			StandardDataType.PQ_DISTANCE.getType(),
			StandardDataType.PQ_DRUG.getType(),
			StandardDataType.PQ_HEIGHTWEIGHT.getType(),
			StandardDataType.PQ_LAB.getType(),
			StandardDataType.PQ_TIME.getType(),
			StandardDataType.ED_DOC_OR_REF.getType(),
			StandardDataType.CD_LAB.getType() 
	});
	
	private static List<String> ANY_CA_IZ_LIST = Arrays.asList(new String[] {
			StandardDataType.ST.getType(),
			StandardDataType.PN_BASIC.getType(),
			StandardDataType.INT_POS.getType(),
			StandardDataType.BL.getType()
	});

	private static List<String> ANY_X1_LIST = Arrays.asList(new String[] {
			StandardDataType.CV.getType(), 
			StandardDataType.ST.getType(),
			StandardDataType.PQ_LAB.getType(),
			StandardDataType.IVL_PQ_BASIC.getType(),
			StandardDataType.IVL_PQ_DISTANCE.getType(),
			StandardDataType.IVL_PQ_DRUG.getType(),
			StandardDataType.IVL_PQ_HEIGHTWEIGHT.getType(),
			StandardDataType.IVL_PQ_LAB.getType(),
			StandardDataType.IVL_PQ_TIME.getType(),
			StandardDataType.URG_PQ_LAB.getType(),
	});

	private static List<String> ANY_X2_LIST = Arrays.asList(new String[] {
			StandardDataType.CV.getType(), 
			StandardDataType.ST.getType(),
			StandardDataType.ED_DOC_OR_REF.getType()
	});

	private static Map<String, List<String>> validTypesForAnyType = new HashMap<String, List<String>>();
	static {
		validTypesForAnyType.put("ANY.LAB", ANY_LAB_LIST); 
		validTypesForAnyType.put("ANY.CA.IZ", ANY_CA_IZ_LIST); 
		validTypesForAnyType.put("ANY.PATH", ANY_PATH_LIST); 
		validTypesForAnyType.put("ANY.x1", ANY_X1_LIST); 
		validTypesForAnyType.put("ANY.x2", ANY_X2_LIST); 
	}
	
	public static boolean isValidTypeForAny(String type, String specializationType) {
		// this method expects collection type info (LIST, SET, COLLECTION) to be already removed from speciaizationType
		if ("ANY".equals(type)) {
			// any valid type other than ANY (and its variants) are allowed
			StandardDataType specializationTypeAsEnum = StandardDataType.getByTypeName(specializationType);
			return specializationType != null && !specializationType.startsWith("ANY") && specializationTypeAsEnum != null;
		} else if (AnyHelper.validTypesForAnyType.containsKey(type)) {
			return AnyHelper.validTypesForAnyType.get(type).contains(specializationType);
		}
		return false;
	}
	
}
