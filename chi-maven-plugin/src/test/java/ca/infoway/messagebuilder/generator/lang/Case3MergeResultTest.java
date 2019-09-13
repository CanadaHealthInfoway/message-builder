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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class Case3MergeResultTest {
	
	@Test
	public void shouldIndicateWhetherOrNotMatchIsNewlyRecorded() throws Exception {
		
		Type type1 = TypeAndRelationshipBuilder.createType(null, "Person");
		Type type2 = TypeAndRelationshipBuilder.createType(null, "APerson");
		Type type3 = TypeAndRelationshipBuilder.createType(null, "SomePerson");
		Type type4 = TypeAndRelationshipBuilder.createType(null, "ThatPerson");
		
		Case3MergeResult result = new Case3MergeResult();
		
		assertTrue("first match", result.recordMatch(type1, type2));
		assertFalse("repeat first match", result.recordMatch(type1, type2));
		
		assertTrue("second match", result.recordMatch(type3, type4));
		assertTrue("third match", result.recordMatch(type2, type4));
		
		assertFalse("fourth match", result.recordMatch(type1, type4));
	}

	@Test
	public void shouldInitialize() throws Exception {
		SimplifiableDefinitions definitions = new SimplifiableDefinitions();
		SimplifiableType type1 = TypeAndRelationshipBuilder.createSimplifiableType(definitions, "Person", false);
		type1.getInterfaceTypes().add("ABCD_MT123456CA.Choice1");
		SimplifiableType type2 = TypeAndRelationshipBuilder.createSimplifiableType(definitions, "APerson", false);
		type2.getInterfaceTypes().add("ABCD_MT123456CA.Choice1");
		
		Case3MergeResult mergeResult = new Case3MergeResult();
		mergeResult.initialize(definitions);
		
		assertTrue("unmergeable", mergeResult.isUnmergeable(type1, type2));
	}

	@Test
	public void shouldRecognizeTransitivelyUnmergeableResults() throws Exception {
		SimplifiableDefinitions definitions = new SimplifiableDefinitions();
		SimplifiableType type1 = TypeAndRelationshipBuilder.createSimplifiableType(definitions, "Person", false);
		type1.getInterfaceTypes().add("ABCD_MT123456CA.Choice1");
		SimplifiableType type2 = TypeAndRelationshipBuilder.createSimplifiableType(definitions, "APerson", false);
		type2.getInterfaceTypes().add("ABCD_MT123456CA.Choice1");
		
		Case3MergeResult mergeResult = new Case3MergeResult();
		mergeResult.initialize(definitions);
		
		SimplifiableType type3 = TypeAndRelationshipBuilder.createSimplifiableType(definitions, "Person1", false);
		
		mergeResult.recordMatch(type3, type1);
		
		assertTrue("unmergable normal", mergeResult.isUnmergeable(type1, type2));
		assertTrue("unmergable transitive", mergeResult.isUnmergeable(type2, type3));
	}
}
