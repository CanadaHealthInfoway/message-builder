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
