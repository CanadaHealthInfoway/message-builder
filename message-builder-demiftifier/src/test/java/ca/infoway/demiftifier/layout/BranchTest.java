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
package ca.infoway.demiftifier.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.demiftifier.MessagePartLayoutItem;

@RunWith(MockitoJUnitRunner.class)
public class BranchTest {

	@Mock
	MessagePartLayoutItem root;
	@Mock
	MessagePartLayoutItem item1;
	@Mock
	MessagePartLayoutItem item2;
	@Mock
	MessagePartLayoutItem item3;

	@Before
	public void setUp() {
		Mockito.when(this.root.getName()).thenReturn("ABCD_MT123456CA.Root");
		Mockito.when(this.item1.getName()).thenReturn("ABCD_MT123456CA.Item1");
		Mockito.when(this.item2.getName()).thenReturn("ABCD_MT123456CA.Item2");
		Mockito.when(this.item3.getName()).thenReturn("ABCD_MT123456CA.Item3");
	}
	
	@Test
	public void shouldCreateNewEndpointBranch() {
		Branch root = Branch.createWithRoot(this.root);
		Branch branch = root.withNewEndpoint(item1);
		
		assertEquals(item1, branch.getCurrentEndpoint());
	}

	@Test
	public void shouldCreateNewChoiceBranch() {
		Branch root = Branch.createWithRoot(this.root);
		Branch branch = root.createChoiceBranch(item1);
		
		assertEquals(1, branch.nodes.size());
		assertTrue("choice", branch.getCurrentEndpointNode().isChoice());
		assertEquals("ancestor", "ABCD_MT123456CA.Root", branch.getCurrentEndpointNode().getAncestor().getName());
		assertEquals("item", "ABCD_MT123456CA.Item1", branch.getCurrentEndpointNode().getItem().getName());
	}
	
	@Test
	public void shouldDetectCyclesInSimpleCase() {
		Branch branch = Branch.createWithRoot(this.root).withNewEndpoint(item1).withNewEndpoint(item2).withNewEndpoint(item3).withNewEndpoint(item2);
		Branch branch2 = Branch.createWithRoot(this.root).withNewEndpoint(item1).withNewEndpoint(item2).withNewEndpoint(item3);
		
		assertFalse("root is not cyclic", Branch.createWithRoot(this.root).isEndingInCycle());
		assertTrue("cyclic", branch.isEndingInCycle());
		assertFalse("not cyclic", branch2.isEndingInCycle());
	}
	
	@Test
	public void shouldDetectCyclesInChoiceCase() {
		Branch branch1 = Branch.createWithRoot(this.root).createChoiceBranch(item1).withNewEndpoint(item2).withNewEndpoint(item1);
		Branch branch2 = Branch.createWithRoot(this.root).createChoiceBranch(item1).withNewEndpoint(item2).withNewEndpoint(root);
		
		assertTrue("specialization cyclic", branch1.isEndingInCycle());
		assertTrue("root cyclic", branch2.isEndingInCycle());
	}
	
}
