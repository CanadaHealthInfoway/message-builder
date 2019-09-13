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

package ca.infoway.messagebuilder.generator.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.util.MatchType;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;


public class MatcherTest {

	
	@Test
	public void shouldMatchSimilarAttributes() throws Exception {
		MatchType type = new Matcher().matchesType(new Relationship("id", "II", Cardinality.create("1")), 
				new Relationship("id", "II.BUS", Cardinality.create("1")));
		assertEquals("type", MatchType.MINOR_DIFFERENCE, type);
	}
	
	@Test
	public void shouldMatchSimilarParameterizedAttributes() throws Exception {
		MatchType type = new Matcher().matchesType(new Relationship("creationTime", "IVL.LOW<TS.FULLDATETIME>", Cardinality.create("1")), 
				new Relationship("creationTime", "IVL<TS.DATE>", Cardinality.create("1")));
		assertEquals("type", MatchType.MINOR_DIFFERENCE, type);
	}
	
	@Test
	public void shouldNotMatchDifferentParameterizedAttributes() throws Exception {
		MatchType type = new Matcher().matchesType(new Relationship("creationTime", "IVL.LOW<PQ>", Cardinality.create("1")), 
				new Relationship("creationTime", "IVL.LOW<TS.DATE>", Cardinality.create("1")));
		assertEquals("type", MatchType.MAJOR_DIFFERENCE, type);
	}
	
	@Test
	public void shouldNotMatchDifferentAttributeTypes() throws Exception {
		MatchType type = new Matcher().matchesType(new Relationship("id", "II", Cardinality.create("1")), 
				new Relationship("id", "TS.FULLDATETIME", Cardinality.create("1")));
		assertEquals("type", MatchType.MAJOR_DIFFERENCE, type);
	}
	
	@Test
	public void shouldMatchExactAttributes() throws Exception {
		MatchType type = new Matcher().matchesType(new Relationship("id", "II.BUS", Cardinality.create("1")), 
				new Relationship("id", "II.BUS", Cardinality.create("1")));
		assertEquals("type", MatchType.EXACT, type);
	}
	
}
