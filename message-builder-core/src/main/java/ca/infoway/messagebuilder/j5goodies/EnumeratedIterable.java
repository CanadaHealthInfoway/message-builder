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