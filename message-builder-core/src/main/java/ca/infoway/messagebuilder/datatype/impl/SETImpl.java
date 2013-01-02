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

package ca.infoway.messagebuilder.datatype.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype SET. Backed by a java Set.
 * 
 * <p>Used when multiple repetitions are allowed, order is irrelevant and duplicates are prohibited.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the HL7 datatype held by the SET 
 * @param <V> the underlying Java datatype held by the underlying Java Set
 * @sharpen.ignore - datatype - translated manually 
 */
public class SETImpl<T extends ANY<V>, V> extends ANYImpl<Collection<T>> implements SET<T, V>, BareCollection, CollectionHelper {
	
	private static final long serialVersionUID = -6170605246120245157L;
	
	private final Class<? extends T> hl7Class;

	/**
	 * <p>Builds an HL7 SET from an existing java Set.
	 * 
	 * @param <T> the HL7 datatype held by the SET 
	 * @param <V> the underlying Java datatype held by the underlying Java Set
	 * @param rawElementType the class of the underlying Java datatype held by the set
	 * @param rawElements a set of Java datatype values
	 * @return the constructed SET
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ANY<V>, V> SET<T, V> create(Class rawElementType, Set<V> rawElements) {
		SETImpl<T, V> list = new SETImpl<T, V>(rawElementType);
		list.rawSet().addAll(rawElements);
		return list;
	}

	/**
	 * <p>Constructs an empty SET of the given HL7 datatype.
	 * 
	 * @param hl7Class the HL7 datatype class
	 */
	@SuppressWarnings("unchecked")
	public SETImpl(Class<? extends ANYImpl> hl7Class) {
		this(hl7Class, new LinkedHashSet<T>());
	}
	
	/**
	 * <p>Constructs a SET of the given HL7 datatype with a null flavor.
	 * 
	 * @param hl7Class the HL7 datatype class
	 * @param nullFlavor a null flavor
	 */
	@SuppressWarnings("unchecked")
	public SETImpl(Class hl7Class, NullFlavor nullFlavor) {
		this(hl7Class, new LinkedHashSet<T>());
		setNullFlavor(nullFlavor);
	}

	/**
	 * <p>Constructs a SET of the given HL7 datatype with the supplied initial value.
	 * 
	 * @param hl7Class the HL7 datatype class
	 * @param defaultValue the initial value
	 */
	@SuppressWarnings("unchecked")
	public SETImpl(Class hl7Class, Set<T> defaultValue) {
		super(Set.class, defaultValue, null, StandardDataType.SET);
		this.hl7Class = hl7Class;
	}
	
	/**
	 * <p>Returns an empty Set.
	 *  
	 * @return an empty Set 
	 */
	@Override
	protected Set<T> getNullValue() {
		return new HashSet<T>();
	}

	/**
	 * <p>Returns the underlying Java Set containing values in the underlying Java datatype.
	 * 
	 * @return the underlying Java Set containing values in the underlying Java datatype
	 */
	public Set<V> rawSet() {
		return new RawSetWrapper<T, V>(getValue(), getHl7Class());
	}

	public <U extends V> Set<U> rawSet(Class<U> elementType) {
		return new RawSetWrapper<T, U>(getValue(), getHl7Class());
	}
	
	private Class<? extends T> getHl7Class() {
		return this.hl7Class;
	}

	/**
	 * <p>Returns the underlying Java Collection containing values in the underlying Java datatype.
	 * 
	 * @return the underlying Java Collection containing values in the underlying Java datatype
	 */
	public Collection<?> rawCollection() {
		return rawSet();
	}

	/**
	 * <p>Returns the HL7 datatype class.
	 * 
	 * @return the HL7 datatype class.
	 */
	public Class<?> getElementType() {
		return this.hl7Class;
	}

	public Collection<BareANY> getBareCollectionValue() {
		Collection<BareANY> result = new ArrayList<BareANY>();
		for (T t : getValue()) {
			result.add(t);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public void add(BareANY any) {
		getValue().add((T) any);
	}
}
