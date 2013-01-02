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

package ca.infoway.messagebuilder.j5goodies;

import java.util.Enumeration;
import java.util.Iterator;

import org.apache.commons.lang.NotImplementedException;

/**
 * <p>A utility that helps represent old Enumeration objects as an Iterable type,
 * for use in new 'for' contructs.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class EnumeratedIterable {

	static class IteratorImpl<T> implements Iterator<T> {

		private final Enumeration<T> e;

		public IteratorImpl(Enumeration<T> e) {
			this.e = e;
		}

		public boolean hasNext() {
			return e.hasMoreElements();
		}

		public T next() {
			return e.nextElement();
		}

		public void remove() {
			throw new NotImplementedException("remove()");
		}

	}

	static class IterableImpl<T> implements Iterable<T> {
		private final Enumeration<T> e;
		public IterableImpl(Enumeration<T> e) {
			this.e = e;
		}
		public Iterator<T> iterator() {
			return new IteratorImpl<T>(e);
		}
	}

	/**
	 * <p>Convert the enumeration into an iterable.
	 * @param <T> the element type
	 * @param e - the enumeration
	 * @return - an iterable type
	 */
	public static <T> Iterable<T> iterable(Enumeration<T> e) {
		return new IterableImpl<T>(e);
	}
	
}