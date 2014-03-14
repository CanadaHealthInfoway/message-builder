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

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

/**
 */
public class RelationshipTest {

	@Test
	public void shouldSortRelationships() throws Exception {
		Relationship relationship1 = createRelationship(true, "attribute", 5, null);
		Relationship relationship2 = createRelationship(true, "another attribute", 11, null);
		Relationship relationship3 = createRelationship(false, "early association", 3, "A");
		Relationship relationship4 = createRelationship(false, "late association a", 9, "ZZ");
		Relationship relationship5 = createRelationship(false, "late association b", 6, "ZZ");
		
		ArrayList<Relationship> list = new ArrayList<Relationship>();
		list.add(relationship5);
		list.add(relationship3);
		list.add(relationship4);
		list.add(relationship1);
		list.add(relationship2);
//		Collections.shuffle(list);	// just to make it interesting  // TM - removed for translation purposes
		
		Collections.sort(list);
		assertTrue(relationship1 == list.get(0));
		assertTrue(relationship2 == list.get(1));
		assertTrue(relationship3 == list.get(2));
		assertTrue(relationship4 == list.get(3));
		assertTrue(relationship5 == list.get(4));
	}
	
	private Relationship createRelationship(boolean isAttribute, String name, int sortKey, String associationSortKey) {
		Relationship result = new Relationship();
		result.setName(name);
		result.setSortOrder(sortKey);
		
		if (isAttribute) {
			result.setType("CS");
			result.setFixedValue("FIXED"); // faking out the dumb isAttribute() algorithm
		} else {
			result.setType("PORX_MT010101CA.EntryPoint");
			result.setAssociationSortKey(associationSortKey);
		}
		
		return result;
	}
	
}
