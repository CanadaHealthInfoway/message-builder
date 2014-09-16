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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.xml;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CodedTypeEvaluatorTest {

	@Test
	public void testCodedTypes() {
		assertFalse(CodedTypeEvaluator.isCodedType("ANY"));
		assertFalse(CodedTypeEvaluator.isCodedType("ANY.LAB"));
		assertFalse(CodedTypeEvaluator.isCodedType("ANY.CA.IZ"));
		assertFalse(CodedTypeEvaluator.isCodedType("ANY.PATH"));
		assertFalse(CodedTypeEvaluator.isCodedType("ANY.X1"));
		assertFalse(CodedTypeEvaluator.isCodedType("ANY.X2"));
		assertFalse(CodedTypeEvaluator.isCodedType("AD"));
		assertFalse(CodedTypeEvaluator.isCodedType("AD.BASIC"));
		assertFalse(CodedTypeEvaluator.isCodedType("AD.FULL"));
		assertFalse(CodedTypeEvaluator.isCodedType("AD.SEARCH"));
		assertFalse(CodedTypeEvaluator.isCodedType("BL"));
		assertFalse(CodedTypeEvaluator.isCodedType("BN"));
		assertFalse(CodedTypeEvaluator.isCodedType("ON"));
		assertTrue(CodedTypeEvaluator.isCodedType("SC"));
		assertFalse(CodedTypeEvaluator.isCodedType("EN"));
		assertFalse(CodedTypeEvaluator.isCodedType("TN"));
		assertFalse(CodedTypeEvaluator.isCodedType("QTY"));
		assertFalse(CodedTypeEvaluator.isCodedType("GTS"));
		assertFalse(CodedTypeEvaluator.isCodedType("GTS.BOUNDEDPIVL"));
		assertFalse(CodedTypeEvaluator.isCodedType("II"));
		assertFalse(CodedTypeEvaluator.isCodedType("II.TOKEN"));
		assertFalse(CodedTypeEvaluator.isCodedType("II.BUS"));
		assertFalse(CodedTypeEvaluator.isCodedType("II.PUBLIC"));
		assertFalse(CodedTypeEvaluator.isCodedType("II.OID"));
		assertFalse(CodedTypeEvaluator.isCodedType("II.VER"));
		assertFalse(CodedTypeEvaluator.isCodedType("II.PUBLICVER"));
		assertFalse(CodedTypeEvaluator.isCodedType("II.BUS_AND_VER"));
		assertFalse(CodedTypeEvaluator.isCodedType("II.BUSVER"));
		assertTrue(CodedTypeEvaluator.isCodedType("CV"));
		assertTrue(CodedTypeEvaluator.isCodedType("CO"));
		assertTrue(CodedTypeEvaluator.isCodedType("CD"));
		assertTrue(CodedTypeEvaluator.isCodedType("CD.LAB"));
		assertTrue(CodedTypeEvaluator.isCodedType("CE"));
		assertTrue(CodedTypeEvaluator.isCodedType("CS"));
		assertTrue(CodedTypeEvaluator.isCodedType("PQR"));
		assertFalse(CodedTypeEvaluator.isCodedType("CR"));
		assertFalse(CodedTypeEvaluator.isCodedType("HXIT"));
		assertTrue(CodedTypeEvaluator.isCodedType("HXIT<CE>"));
		assertFalse(CodedTypeEvaluator.isCodedType("ST"));
		assertFalse(CodedTypeEvaluator.isCodedType("ST.LANG"));
		assertFalse(CodedTypeEvaluator.isCodedType("ED"));
		assertFalse(CodedTypeEvaluator.isCodedType("ED.DOC"));
		assertFalse(CodedTypeEvaluator.isCodedType("ED.DOC_OR_REF"));
		assertFalse(CodedTypeEvaluator.isCodedType("ED.REF"));
		assertFalse(CodedTypeEvaluator.isCodedType("ED.DOC_REF"));
		assertFalse(CodedTypeEvaluator.isCodedType("ED.SIGNATURE"));
		assertFalse(CodedTypeEvaluator.isCodedType("PN"));
		assertFalse(CodedTypeEvaluator.isCodedType("PN.BASIC"));
		assertFalse(CodedTypeEvaluator.isCodedType("PN.SIMPLE"));
		assertFalse(CodedTypeEvaluator.isCodedType("PN.FULL"));
		assertFalse(CodedTypeEvaluator.isCodedType("PN.SEARCH"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<DATE>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<DATETIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<FULL_DATE>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<FULL_DATE_WITH_TIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<FULL_DATE_TIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<FULL_DATE_PART_TIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<TS>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<HIGH_TS_FULLDATE>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<WIDTH_TS_FULLDATE>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<LOW_TS_DATE>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<LOW_TS_FULLDATE>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<LOW_TS_FULLDATETIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<PQ>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<PQ_BASIC>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<PQ_DRUG>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<PQ_TIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<PQ_LAB>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<PQ_HEIGHTWEIGHT>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<PQ_DISTANCE>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<INT>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<REAL>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL<MO>"));
		assertFalse(CodedTypeEvaluator.isCodedType("EIVL"));
		assertFalse(CodedTypeEvaluator.isCodedType("EIVL<TS>"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL.WIDTH"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL.LOW"));
		assertFalse(CodedTypeEvaluator.isCodedType("IVL.HIGH"));
		assertFalse(CodedTypeEvaluator.isCodedType("MO"));
		assertFalse(CodedTypeEvaluator.isCodedType("MO.CAD"));
		assertFalse(CodedTypeEvaluator.isCodedType("PIVL"));
		assertFalse(CodedTypeEvaluator.isCodedType("PIVL<TS>"));
		assertFalse(CodedTypeEvaluator.isCodedType("PIVL<TS.DATETIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("PIVL<TS.FULLDATETIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("INT"));
		assertFalse(CodedTypeEvaluator.isCodedType("INT.NONNEG"));
		assertFalse(CodedTypeEvaluator.isCodedType("INT.POS"));
		assertFalse(CodedTypeEvaluator.isCodedType("PQ"));
		assertFalse(CodedTypeEvaluator.isCodedType("PQ.BASIC"));
		assertFalse(CodedTypeEvaluator.isCodedType("PQ.DRUG"));
		assertFalse(CodedTypeEvaluator.isCodedType("PQ.TIME"));
		assertFalse(CodedTypeEvaluator.isCodedType("PQ.LAB"));
		assertFalse(CodedTypeEvaluator.isCodedType("PQ.HEIGHTWEIGHT"));
		assertFalse(CodedTypeEvaluator.isCodedType("PQ.DISTANCE"));
		assertFalse(CodedTypeEvaluator.isCodedType("REAL"));
		assertFalse(CodedTypeEvaluator.isCodedType("REAL.COORD"));
		assertFalse(CodedTypeEvaluator.isCodedType("REAL.CONF"));
		assertFalse(CodedTypeEvaluator.isCodedType("RTO"));
		assertFalse(CodedTypeEvaluator.isCodedType("RTO<PQ,PQ>"));
		assertFalse(CodedTypeEvaluator.isCodedType("RTO<MO,PQ>"));
		assertFalse(CodedTypeEvaluator.isCodedType("RTO<PQ.DRUG,PQ.TIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("RTO<PQ.DRUG,PQ.DRUG>"));
		assertFalse(CodedTypeEvaluator.isCodedType("RTO<MO.CAD,PQ.BASIC>"));
		assertFalse(CodedTypeEvaluator.isCodedType("TS"));
		assertFalse(CodedTypeEvaluator.isCodedType("TS.DATE"));
		assertFalse(CodedTypeEvaluator.isCodedType("TS.DATETIME"));
		assertFalse(CodedTypeEvaluator.isCodedType("TS.FULLDATEWITHTIME"));
		assertFalse(CodedTypeEvaluator.isCodedType("TS.FULLDATE"));
		assertFalse(CodedTypeEvaluator.isCodedType("TS.FULLDATETIME"));
		assertFalse(CodedTypeEvaluator.isCodedType("TS.FULLDATEPARTTIME"));
		assertFalse(CodedTypeEvaluator.isCodedType("TEL"));
		assertFalse(CodedTypeEvaluator.isCodedType("TEL.ALL"));
		assertFalse(CodedTypeEvaluator.isCodedType("TEL.PHONEMAIL"));
		assertFalse(CodedTypeEvaluator.isCodedType("TEL.PHONE"));
		assertFalse(CodedTypeEvaluator.isCodedType("TEL.EMAIL"));
		assertFalse(CodedTypeEvaluator.isCodedType("TEL.URI"));
		assertFalse(CodedTypeEvaluator.isCodedType("URG"));
		assertFalse(CodedTypeEvaluator.isCodedType("URG<TS.DATE>"));
		assertFalse(CodedTypeEvaluator.isCodedType("URG<PQ>"));
		assertFalse(CodedTypeEvaluator.isCodedType("URG<PQ.BASIC>"));
		assertFalse(CodedTypeEvaluator.isCodedType("URG<PQ.DRUG>"));
		assertFalse(CodedTypeEvaluator.isCodedType("URG<PQ.TIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("URG<PQ.LAB>"));
		assertFalse(CodedTypeEvaluator.isCodedType("URG<PQ.HEIGHTWEIGHT>"));
		assertFalse(CodedTypeEvaluator.isCodedType("URG<PQ.DISTANCE>"));
		assertFalse(CodedTypeEvaluator.isCodedType("URL"));
		assertFalse(CodedTypeEvaluator.isCodedType("SXPR"));
		assertFalse(CodedTypeEvaluator.isCodedType("SXCM"));
		assertTrue(CodedTypeEvaluator.isCodedType("SXCM<CD>"));
		assertFalse(CodedTypeEvaluator.isCodedType("SXCM<INT>"));
		assertFalse(CodedTypeEvaluator.isCodedType("SXCM<MO>"));
		assertFalse(CodedTypeEvaluator.isCodedType("SXCM<PQ>"));
		assertFalse(CodedTypeEvaluator.isCodedType("SXCM<REAL>"));
		assertFalse(CodedTypeEvaluator.isCodedType("SXCM<TS>"));
		assertFalse(CodedTypeEvaluator.isCodedType("BXIT"));
		assertTrue(CodedTypeEvaluator.isCodedType("BXIT<CD>"));
		assertFalse(CodedTypeEvaluator.isCodedType("SET"));
		assertFalse(CodedTypeEvaluator.isCodedType("LIST"));
		assertFalse(CodedTypeEvaluator.isCodedType("COLLECTION"));
		assertFalse(CodedTypeEvaluator.isCodedType("BAG"));
		assertTrue(CodedTypeEvaluator.isCodedType("SET<CD>"));
		assertTrue(CodedTypeEvaluator.isCodedType("LIST<CO>"));
		assertTrue(CodedTypeEvaluator.isCodedType("COLLECTION<HXIT<CE>>"));
		assertTrue(CodedTypeEvaluator.isCodedType("BAG<BXIT<CD>"));
		assertFalse(CodedTypeEvaluator.isCodedType("SET<TS.FULLDATETIME>"));
		assertFalse(CodedTypeEvaluator.isCodedType("LIST<URG<PQ>>>"));
		assertFalse(CodedTypeEvaluator.isCodedType("COLLECTION<SXCM<TS>>"));
		assertFalse(CodedTypeEvaluator.isCodedType("BAG<CR>"));
	}
	
}
