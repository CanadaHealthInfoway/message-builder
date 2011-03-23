package ca.infoway.messagebuilder.platform;

import java.util.Map;

/**
 * @sharpen.ignore platform
 */ 
public class MapEntry<K,V> implements Map.Entry<K, V> {

	private V v;
	private final K k;

	public MapEntry(K k, V v) {
		this.k = k;
		this.v = v;
	}
	
	public K getKey() {
		return this.k;
	}

	public V getValue() {
		return this.v;
	}

	public V setValue(V value) {
		V v = this.v;
		this.v = value;
		return v;
	}

}
