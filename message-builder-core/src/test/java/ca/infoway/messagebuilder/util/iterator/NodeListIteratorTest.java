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

package ca.infoway.messagebuilder.util.iterator;

import static ca.infoway.messagebuilder.util.iterator.NodeListIterator.collatedElements;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.util.xml.DocumentFactory;

/**
 * @sharpen.ignore - util.iterator - translated manually
 */
public class NodeListIteratorTest {
	
	@Test
	public void shouldCollateElementsByName() throws Exception {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addAll(Arrays.asList(2, 1, 3));
		Document document = new DocumentFactory().createFromString("<top><fred/><fred/><barney/><wilma/><wilma /><wilma/></top>");
		
		for (List<Element> elements : collatedElements(document.getDocumentElement().getChildNodes())) {
			assertEquals("size", (Integer) elements.size(), (Integer) queue.poll());
		}
	}
}
