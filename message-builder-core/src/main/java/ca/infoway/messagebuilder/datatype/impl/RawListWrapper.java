/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.datatype.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.iterators.UnmodifiableListIterator;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.platform.ClassUtil;

/**
 * <p>A list that wraps the underlying Java list of Java datatype values (the "raw" values).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * @sharpen.ignore
 */
@SuppressWarnings("unchecked")
public class RawListWrapper<T extends BareANY, V> implements List<V> {
	
	private final List<T> original;
	private final Class<? extends T> originalElementType;
	
	public RawListWrapper(Collection<T> original, Class<? extends T> originalElementType) {
		this.original = (List<T>) original;
		this.originalElementType = originalElementType;
	}
	
	private T wrap(Object element) {
		T bareAny = (T) ClassUtil.newInstance(originalElementType);
		((BareANYImpl) bareAny).setBareValue(element);
		return bareAny;	
	}
	
	private List<V> convertToList() {
		List<V> list = new ArrayList<V>();
		for (T originalElement : this.original) {
			BareANY any = (BareANY) originalElement;
			list.add((V) any.getBareValue());
		}
		return list;
	}

	
	public boolean add(V element) {
		T t = wrap(element);
		return original.add(t);
	}

	public void add(int index, V element) {
		T t = wrap(element);
		original.add(index, t);
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
	
	/**
	 * @sharpen.remove java api specific
	 */
	public boolean addAll(int index, Collection<? extends V> collection) {
		List<V> tempList = new ArrayList<V>(collection);
		Collections.reverse(tempList);
		for (V v : tempList) {
			T t = wrap(v);
			original.add(index, t);
		}
		return !collection.isEmpty();
	}
	
	public void clear() {
		original.clear();
	}
	
	public boolean contains(Object o) {
		List<V> list = convertToList();
		return list.contains(o);
	}
	
	public boolean containsAll(Collection<?> c) {
		List<V> list = convertToList();
		return list.containsAll(c);
	}
	
	public V get(int index) {
		T t = original.get(index);
		return (V) (t == null ?  null : ((BareANY) t).getBareValue());
	}
	
	public int indexOf(Object o) {
		List<V> list = convertToList();
		return list.indexOf(o);
	}
	
	public boolean isEmpty() {
		return original.isEmpty();
	}
	
	public Iterator<V> iterator() {
		Iterator<V> iterator = convertToList().iterator();
		return UnmodifiableIterator.decorate(iterator);
	}

	/**
	 * @sharpen.remove java api specific
	 */
	public int lastIndexOf(Object o) {
		List<V> list = convertToList();
		return list.lastIndexOf(o);
	}
	
	/**
	 * @sharpen.remove java api specific
	 */
	public ListIterator<V> listIterator() {
		ListIterator<V> listIterator = convertToList().listIterator();
		return UnmodifiableListIterator.decorate(listIterator);
	}
	
	/**
	 * @sharpen.remove java api specific
	 */
	public ListIterator<V> listIterator(int index) {
		ListIterator<V> listIterator = convertToList().listIterator(index);
		return UnmodifiableListIterator.decorate(listIterator);
	}
	
	/**
	 * @sharpen.remove java api specific
	 */
	public boolean remove(Object o) {
		int indexOf = indexOf(o);
		if (indexOf > 0) {
			remove(indexOf);
		}
		return indexOf >= 0;
	}
	
	public V remove(int index) {
		T removedValue = original.remove(index);
		return (V) (removedValue == null ? null : ((BareANY) removedValue).getBareValue());
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
	
	/**
	 * @sharpen.remove java api specific
	 */
	public boolean retainAll(Collection<?> c) {
		boolean result = false;
		List<T> values = original;
		for (Iterator<T> iterator = values.iterator(); iterator.hasNext(); ) {
			T t = iterator.next();
			if (!c.contains(((BareANY) t).getBareValue())) {
				iterator.remove();
				result = true;
			}
		}
		return result;
	}
	
	public V set(int index, V element) {
			T t = wrap(element);
			T result = original.set(index, t);
			return (V) (result == null ? null : ((BareANY) result).getBareValue());
	}
	
	public int size() {
		return original.size();
	}

	/**
	 * @sharpen.remove java api specific
	 */
	public List<V> subList(int fromIndex, int toIndex) {
		List<V> subList = convertToList().subList(fromIndex, toIndex);
		return Collections.unmodifiableList(subList);
	}

	/**
	 * @sharpen.remove java api specific
	 */
	public Object[] toArray() {
		return convertToList().toArray();
	}

	/**
	 * @sharpen.remove java api specific
	 */
	public <U> U[] toArray(U[] a) {
		return convertToList().toArray(a);
	}
	
}