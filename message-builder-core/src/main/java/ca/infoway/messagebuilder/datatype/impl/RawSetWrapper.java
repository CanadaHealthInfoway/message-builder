package ca.infoway.messagebuilder.datatype.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.collections.iterators.UnmodifiableIterator;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.platform.ClassUtil;

/**
 * <p>A list that wraps the underlying Java list of Java datatype values (the "raw" values).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * @sharpen.ignore
 */
@SuppressWarnings("unchecked")
class RawSetWrapper<T extends BareANY, V> implements Set<V> {
	
	private final Set<T> original;
	private final Class<? extends T> originalElementType;
	
	RawSetWrapper(Collection<T> original, Class<? extends T> originalElementType) {
		this.original = (Set<T>) original;
		this.originalElementType = originalElementType;
	}
	
	private T wrap(Object element) {
		T bareAny = (T) ClassUtil.newInstance(originalElementType);
		((BareANYImpl) bareAny).setBareValue(element);
		return bareAny;	
	}
	
	private Set<V> convertToSet() {
		Set<V> set = new LinkedHashSet<V>();
		for (T originalElement : this.original) {
			BareANY any = (BareANY) originalElement;
			set.add((V) any.getBareValue());
		}
		return set;
	}

	
	public boolean add(V element) {
		T t = wrap(element);
		return original.add(t);
	}

	/**
	 * @sharpen.remove java api specific
	 */
	public boolean addAll(Collection<? extends V> collection) {
		for (V v : collection) {
			T t = wrap(v);
			original.add(t);
		}
		return !collection.isEmpty();
	}
	
	public void clear() {
		original.clear();
	}
	
	public boolean contains(Object o) {
		Set<V> list = convertToSet();
		return list.contains(o);
	}
	
	public boolean containsAll(Collection<?> c) {
		Set<V> list = convertToSet();
		return list.containsAll(c);
	}
	
	public boolean isEmpty() {
		return original.isEmpty();
	}
	
	public Iterator<V> iterator() {
		Iterator<V> iterator = convertToSet().iterator();
		return UnmodifiableIterator.decorate(iterator);
	}

	/**
	 * @sharpen.remove java api specific
	 */
	public boolean removeAll(Collection<?> c) {
		boolean result = false;
		for (Object object : c) {
			result |= remove(object);
		}
		return result;
	}
	
	public boolean remove(Object o) {
		boolean result = false;
		for (Iterator<T> iterator = original.iterator(); iterator.hasNext(); ) {
			T t = iterator.next();
			if (o!=null && o.equals(t.getBareValue())) {
				iterator.remove();
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * @sharpen.remove java api specific
	 */
	public boolean retainAll(Collection<?> c) {
		boolean result = false;
		for (Iterator<T> iterator = original.iterator(); iterator.hasNext(); ) {
			T t = iterator.next();
			if (!c.contains(((BareANY) t).getBareValue())) {
				iterator.remove();
				result = true;
			}
		}
		return result;
	}
	
	public int size() {
		return original.size();
	}

	/**
	 * @sharpen.remove java api specific
	 */
	public Object[] toArray() {
		return convertToSet().toArray();
	}

	/**
	 * @sharpen.remove java api specific
	 */
	public <U> U[] toArray(U[] a) {
		return convertToSet().toArray(a);
	}

}