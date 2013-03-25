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

import java.util.ArrayList;
import java.util.List;

import org.custommonkey.xmlunit.NamespaceContext;
import org.custommonkey.xmlunit.XMLUnit;

/**
 * Save and restore XMLUnit's global state.
 *
 * Much of XMLUnit's configuration is done via static methods on
 * the {@link XMLUnit} class itself, i.e. via (effectively) global
 * state.  This class allows one to save and restore that state --
 * or more specifically, the few bits of it that we care about:<ul>
 *		<li>ignoreWhitespace
 *		<li>compareUnmatched
 *		<li>xpathNamespaceContext
 * </ul>
 *
 * The intended usage is:<pre>
 *		XmlunitState.save();
 *		try {
 *			XMLUnit.setIgnoreWhitespace(newValue);
 *			XMLUnit.setXpathNamespaceContext(newContext);
 *			// other settings as appropriate
 *
 *			do stuff
 *		} finally {
 *			XmlunitState.restore();
 *		}
 * </pre>
 */
public class XmlunitState {
	static class State {
		private NamespaceContext nsCtx;
		private boolean ignoreComments;
		private boolean ignoreWhitespace;
		private boolean compareUnmatched;
		
		private State() {
			nsCtx = XMLUnit.getXpathNamespaceContext();
			ignoreComments = XMLUnit.getIgnoreComments();
			ignoreWhitespace = XMLUnit.getIgnoreWhitespace();
			compareUnmatched = XMLUnit.getCompareUnmatched();
		}
		
		private void restore() {
			XMLUnit.setXpathNamespaceContext(nsCtx);
			XMLUnit.setIgnoreComments(ignoreComments);
			XMLUnit.setIgnoreWhitespace(ignoreWhitespace);
			XMLUnit.setCompareUnmatched(compareUnmatched);
		}
	}
	
	static XmlunitState instance;
	
	static {
		//System.err.println("XmlunitState static init: instance was    " + instance);
		instance = new XmlunitState();
		//System.err.println("XmlunitState static init: instance is now " + instance);
	}
	
	private List<State> stack;
	private State originalState;
	
	XmlunitState() {
		stack = new ArrayList<State>();
		originalState = new State();
	}

	private void _save() {
		State s = new State();
		stack.add(s);
	}
	
	private void _restore() {
		int i = stack.size() - 1;
		
		State state = (i >= 0) ? stack.remove(i) : originalState;
		
		state.restore();
	}
	
	public static void save() {
		//System.err.println("save: instance = " + instance);

		instance._save();
	}
	
	public static void restore() {
		//System.err.println("restore: instance = " + instance);

		instance._restore();
	}
}
