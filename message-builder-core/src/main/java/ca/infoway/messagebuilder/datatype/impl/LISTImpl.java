/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
import java.util.List;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

/**
 * <p>HL7 datatype LIST. Backed by a java List.
 * 
 * <p>Used when multiple repetitions are allowed and order matters.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the HL7 datatype held by the LIST 
 * @param <V> the underlying Java datatype held by the underlying Java List
 * @sharpen.ignore - datatype - translated manually 
 */
public class LISTImpl<T extends ANY<V>, V> extends ANYImpl<Collection<T>> implements LIST<T, V>, CollectionHelper, BareCollection {
	private static final long serialVersionUID = -1016261753587524757L;
	
	private final Class<T> hl7Class;

	/**
	 * <p>Builds an HL7 LIST from an existing java List.
	 * 
	 * @param <T> the HL7 datatype held by the LIST 
	 * @param <V> the underlying Java datatype held by the underlying Java List
	 * @param rawElementType the class of the underlying Java datatype held by the list
	 * @param rawElements a list of Java datatype values
	 * @return the constructed LIST
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ANY<V>, V> LIST<T, V> create(Class rawElementType, List<V> rawElements) {
		LISTImpl<T, V> list = new LISTImpl<T, V>(rawElementType);
		list.rawList().addAll(rawElements);
		return list;
	}
	
	/**
	 * <p>Constructs an empty LIST of the given HL7 datatype.
	 * 
	 * @param hl7Class the HL7 datatype class
	 */
	@SuppressWarnings("unchecked")
	public LISTImpl(Class<? extends ANYImpl> hl7Class) {
		this(hl7Class, new ArrayList<T>());
	}
	
	/**
	 * <p>Constructs a LIST of the given HL7 datatype with a null flavor.
	 * 
	 * @param hl7Class the HL7 datatype class
	 * @param nullFlavor a null flavor
	 */
	@SuppressWarnings("unchecked")
	public LISTImpl(Class hl7Class, NullFlavor nullFlavor) {
		this(hl7Class, new ArrayList<T>());
		setNullFlavor(nullFlavor);
	}

	/**
	 * <p>Constructs a LIST of the given HL7 datatype with the supplied initial value.
	 * 
	 * @param hl7Class the HL7 datatype class
	 * @param defaultValue the initial value
	 */
	@SuppressWarnings("unchecked")
	public LISTImpl(Class hl7Class, List<T> defaultValue) {
		super(List.class, defaultValue, null, StandardDataType.LIST);
		this.hl7Class = hl7Class;
	}
	
	/**
	 * <p>Returns an empty List.
	 *  
	 * @return an empty List 
	 */
	@Override
	protected List<T> getNullValue() {
		return new ArrayList<T>();
	}
	
	/**
	 * <p>Returns the underlying Java List containing values in the underlying Java datatype.
	 * 
	 * @return the underlying Java List containing values in the underlying Java datatype
	 */
	public List<V> rawList() {
		return new RawListWrapper<T, V>(getValue(), getHl7Class());
	}

	public <U extends V> List<U> rawList(Class<U> elementType) {
		return new RawListWrapper<T, U>(getValue(), getHl7Class());
	}
	
	private Class<T> getHl7Class() {
		return this.hl7Class;
	}

	/**
	 * <p>Returns the underlying Java Collection containing values in the underlying Java datatype.
	 * 
	 * @return the underlying Java Collection containing values in the underlying Java datatype
	 */
	public Collection<?> rawCollection() {
		return rawList();
	}

	/**
	 * <p>Returns the HL7 datatype class.
	 * 
	 * @return the HL7 datatype class.
	 */
	public Class<?> getElementType() {
		return this.hl7Class;
	}

	@SuppressWarnings("unchecked")
	public void add(BareANY any) {
		getValue().add((T) any);
	}

	public Collection<BareANY> getBareCollectionValue() {
		Collection<BareANY> result = new ArrayList<BareANY>();
		for (T t : getValue()) {
			result.add(t);
		}
		return result;
	}

}
