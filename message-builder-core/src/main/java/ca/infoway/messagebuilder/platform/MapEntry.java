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
