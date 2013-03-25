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

import static org.junit.Assert.*;

import java.util.Iterator;

import org.custommonkey.xmlunit.NamespaceContext;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class XmlunitStateTest {
	
	// We use the XpathNamspaceContext as our test state item, so make sure we
	// don't change it, no matter how badly we screw up.
	static NamespaceContext originalNsCtx;
	
	@BeforeClass
	public static void stashNamespaceContext() {
		originalNsCtx = XMLUnit.getXpathNamespaceContext();
		System.out.println("stashing; instance = " + XmlunitState.instance);
		Class clazz = XmlunitState.class;			// Force it to load, and so do its static initialization, before we start
														// messing around
		System.out.println("stashed; instance = " + XmlunitState.instance);
	}
	
	@AfterClass
	public static void restoreNamespaceContext() {
		XMLUnit.setXpathNamespaceContext(originalNsCtx);
	}

	@Test
	public void that_single_save_restore_cycle_restores_old_value() {
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("orig"));
		XmlunitState.save();
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("new"));
		XmlunitState.restore();
		assertEquals("orig", ((StubNamespaceContext)XMLUnit.getXpathNamespaceContext()).name);
	}

	@Test
	public void that_three_save_restore_cycles_restore_old_value() {
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("orig"));
		XmlunitState.save();
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("one"));
		XmlunitState.restore();
		assertEquals("orig", ((StubNamespaceContext)XMLUnit.getXpathNamespaceContext()).name);
		
		XmlunitState.save();
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("two"));
		XmlunitState.restore();
		assertEquals("orig", ((StubNamespaceContext)XMLUnit.getXpathNamespaceContext()).name);
		
		XmlunitState.save();
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("three"));
		XmlunitState.restore();
		assertEquals("orig", ((StubNamespaceContext)XMLUnit.getXpathNamespaceContext()).name);
	}
	
	@Test
	public void that_three_nested_save_restores_pop_the_stack_properly() {
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("orig"));
		
		XmlunitState.save();
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("one"));
		XmlunitState.save();
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("two"));
		XmlunitState.save();
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("three"));
		
		assertEquals("three", ((StubNamespaceContext)XMLUnit.getXpathNamespaceContext()).name);
		
		XmlunitState.restore();
		assertEquals("two", ((StubNamespaceContext)XMLUnit.getXpathNamespaceContext()).name);
		
		XmlunitState.restore();
		assertEquals("one", ((StubNamespaceContext)XMLUnit.getXpathNamespaceContext()).name);
		
		XmlunitState.restore();
		assertEquals("orig", ((StubNamespaceContext)XMLUnit.getXpathNamespaceContext()).name);
		
		XmlunitState.restore();
		assertEquals(originalNsCtx, XMLUnit.getXpathNamespaceContext());

	}
	
	@Test
	public void that_restore_with_no_save_restores_to_originalNsCtx() {
		XMLUnit.setXpathNamespaceContext(new StubNamespaceContext("new"));
		XmlunitState.restore();
		assertEquals(originalNsCtx, XMLUnit.getXpathNamespaceContext());
	}
	
	private static class StubNamespaceContext implements NamespaceContext {
		final String name;
		
		public StubNamespaceContext(String name) {
			this.name = name;
		}

		/**
		 *  Stub implementation; should never be called
		 */
		public String getNamespaceURI(String prefix) {
			return null;
		}

		/**
		 *  Stub implementation; should never be called
		 */
		public Iterator getPrefixes() {
			return null;
		}
	}
		
	
}
