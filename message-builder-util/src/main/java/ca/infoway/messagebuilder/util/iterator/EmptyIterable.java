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

package ca.infoway.messagebuilder.util.iterator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * <p>A utility that performs nullness checking on an iterable.  If an 
 * iterable is null, then an empty iterable is returned, preventing a 
 * NullPointerException.
 * 
 * <p>A typical use of this class is as follows:
 * 
 * <code>
 * import static ca.infoway.messagebuilder.util.iterator.EmptyIterable.nullSafeIterable;
 * 
 *   ...
 *   public void doMethod() {
 *     for (String text : nullSafeIterable(getTextCollection)) {
 *       ...
 *     }
 *   }
 *   ...
 * </code>
 * 
 * @param <T> - the element type of the iterable.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - util.iterator - translated manually
 */
public class EmptyIterable<T> {

    /**
     * <p>Check the incoming iterable type to see if it's null.
     * @param <T> - the type of object to iterate over
     * @param i - the iterable type that might be null
     * @return - the iterable types iterator if it's not null; an empty iterator otherwise
     */
    public static <T> Iterable<T> nullSafeIterable(Iterable<T> i) {
    	return i == null ? Collections.<T>emptyList() : i;
    }
    
    /**
     * <p>Check the incoming array to see if it's null.
     * @param <T> - the element type of the array
     * @param i - the array that might be null
     * @return - an array iterator or an empty iterator
     */
    public static <T> Iterable<T> nullSafeIterable(T[] i) {
    	return i == null ? Collections.<T>emptyList() : Arrays.asList(i);
    }

    /**
     * <p>Check the incoming map to see if it's null.  If not, return the 
     * keySet iterator, otherwise return an empty iterator.
     * 
     * @param <K> - the key type of the map
     * @param <V> - the value type of the map
     * @param map - the map that might be null
     * @return - the keyset iterator
     */
    public static <K,V> Iterable<K> nullSafeKeySetIterable(Map<K,V> map) {
    	return map == null ? Collections.<K>emptyList() : nullSafeIterable(map.keySet());
    }
    
    /**
     * <p>Check the incoming map to see if it's null.  If not, return the 
     * values iterator, otherwise return an empty iterator.
     * 
     * @param <K> - the key type of the map
     * @param <V> - the value type of the map
     * @param map - the map that might be null
     * @return - the values iterator
     */
    public static <K,V> Iterable<V> nullSafeValuesIterable(Map<K,V> map) {
    	return map == null ? Collections.<V>emptyList() : nullSafeIterable(map.values());
    }
}
