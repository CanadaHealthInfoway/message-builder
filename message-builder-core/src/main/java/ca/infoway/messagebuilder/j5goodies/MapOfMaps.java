package ca.infoway.messagebuilder.j5goodies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class provides simple semantics for the common situation where you want to have
 * a map that contains other maps.
 * @param <K1> - the type of the outer map key.
 * @param <K2> - the type of the inner map key.
 * @param <V> - the type of the map value.
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class MapOfMaps<K1, K2, V> implements Map<K1, Map<K2,V>> {
	
	private Map<K1, Map<K2, V>> map = Collections.synchronizedMap(new HashMap<K1, Map<K2, V>>());

	/**
	 * {@inheritDoc}
	 */
	public void clear() {
		this.map.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean containsKey(Object key) {
		return this.map.containsKey(key);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean containsValue(Object value) {
		return this.map.containsValue(value);
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<Map.Entry<K1, Map<K2, V>>> entrySet() {
		return this.map.entrySet();
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<K2, V> get(Object key) {
		return this.map.get(key);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<K1> keySet() {
		return this.map.keySet();
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<K2, V> put(K1 key, Map<K2, V> value) {
		return this.map.put(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	public void putAll(Map<? extends K1, ? extends Map<K2, V>> t) {
		this.map.putAll(t);
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<K2, V> remove(Object key) {
		return this.map.remove(key);
	}

	/**
	 * {@inheritDoc}
	 */
	public int size() {
		return this.map.size();
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<Map<K2, V>> values() {
		return this.map.values();
	}

	/**
	 * <p>Put the value.
	 * @param key1 - the key of the outer map.
	 * @param key2 - the key of the innter map.
	 * @param value - the new value
	 */
	public void put(K1 key1, K2 key2, V value) {
		if (!containsKey(key1)) {
			put(key1, new HashMap<K2,V>());
		}
		get(key1).put(key2, value);
	}

	/**
	 * <p>Determine if the map contains a compound key.
	 * @param key1 - the key of the outer map.
	 * @param key2 - the key of the innter map.
	 * @return true if the map contains the compound key; false otherwise.
	 */
	public boolean containsKey(K1 key1, K2 key2) {
		return containsKey(key1) && get(key1).containsKey(key2);
	}

	/**
	 * <p>Get the value.
	 * @param key1 - the key of the outer map.
	 * @param key2 - the key of the innter map.
	 * @return the value
	 */
	public V get(K1 key1, K2 key2) {
		if (containsKey(key1)) {
			return get(key1).get(key2);
		} else {
			return null;
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.map.toString();
	}
}
