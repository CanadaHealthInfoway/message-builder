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

package ca.infoway.messagebuilder.mifcomparer;

import java.io.File;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;


public abstract class XmlTextChildTransformerBase extends XmlIndependentFilterBase {

	public XmlTextChildTransformerBase() {
		super();
	}

	/**
	 * Transform an individual Text node.
	 * 
	 * <p>This can make any of the changes documented for {@link org.w3c.dom.Text.replaceWholeText}; it can:<ol>
	 * 		<li>modify {@code t} in place, and make no other changes
	 * 		<li>replace {@code t} -- and multiple nearby objects, at multiple depths in the tree -- with a single new {@link org.w3c.dom.Text}
 	 *		<li>remove {@code t} from the tree entirely
	 * </ol>
 	 * 
 	 * There is an important restriction: for any Text node {@code t}, if this method has already been called on {@code t}'s
 	 * predecessor siblings, then when it is called on {@code t} itself, those predecessors must not be affected.
 	 * (Affecting <i>successors</i> is fine.)
 	 * 
	 * <p>Caveat: it is assumed -- but not known for sure -- that transformations based on
	 * {@link org.w3c.dom.Text.getWholeText} and {@link org.w3c.dom.Text.replaceWholeText} abide by this restriction
	 * (which is why the restriction seems reasonable in the first place).
	 * 
	 * @param	f		the file we're working on, for message reporting
	 * @param	t		the Text node whose text content is to be transformed
	 * @param	msgs	destination for message reporting
	 * 
	 * @return	<ul><li>If {@code t} was modified in place, {@code t}
	 * <li>If {@code t} was replaced by another node (or a subtree of them), the new node (or the root of the new tree)
	 * <li>If {@code t} was removed, {@code null}
	 * </ul>
	 */
	protected abstract Text transformTextNode(File f, Text t, MessageList msgs);
	
	/**
	 * Perform a transformation on all Text nodes that are direct children of e, by calling {@link #transformTextNode}
	 * on each one, in firstChild/nextSibling order.
	 * 
	 * @param	f		- the file we're working on, for message reporting
	 * @param	e		- the element whose text content is to be squashed
	 * @param	msgs	- destination for message reporting
	 */
	protected void transformTextChildren(File f, Element e,	MessageList msgs) {	
		/*
		 * Because {@link #transformTextNode) can have such dramatic effects on the tree,
		 * a naive linked-list traversal is doomed to failure.  So would be slurping
		 * of the nodes into a List or array first and then naively traversing that.
		 * Instead, we have to be careful to keep track of our current position in a way that will
		 * remain stable, regardless of what happens to the current node.
		 * 
		 * The restriction described for {@code transformTextNode}, however, allows us to assume that,
		 * by the time we get to a given Text node, its predecessor is stable (either it was already stable
		 * when we started, or was made so when we processed it in this loop). 
		 */
		Node curr = e.getFirstChild();
		while (curr != null) {
			if (curr.getNodeType() != Node.TEXT_NODE) {
				curr = curr.getNextSibling();
				continue;
			}
			
			Node prev = curr.getPreviousSibling();

			Node newCurr = transformTextNode(f, (Text)curr, msgs);
			
			if (newCurr != null) {
				// newCurr has taken curr's place in the tree
				curr = newCurr.getNextSibling();
			} else {
				// what was the current node has been removed from the tree
				if (prev != null)
					curr = prev.getNextSibling();		// advance to what is now the successor of what was the old curr's predecessor
				else
					curr = e.getFirstChild();			// if the node that has vanished had no predecessor, it was e's first child
			}
		}
	}
}
