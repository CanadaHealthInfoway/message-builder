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

package ca.infoway.messagebuilder.j5goodies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.util.iterator.EmptyIterable;

/**
 * <p>A class that counts references to a particular type, T.
 * 
 * @param <T> - a comparable type of thing to be counted.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class Counter<T extends Comparable<T>> {

	private Map<T,Integer> map = Collections.synchronizedMap(new HashMap<T,Integer>());
    
    /**
     * <p>Increment the number of instances of 't' by one.
     * @param t - the instance being counted.
     */
    public void increment(T t) {
        if (this.map.containsKey(t)) {
            this.map.put(t, this.map.get(t)+1);
        } else {
            this.map.put(t, 1);
        }
    }
    
    /**
     * <p>Get a list of tallies or counts of each item tracked.
     * @param order - either ascending or descending (null is equivalent to ascending).
     * @return - the list of all final tallies, ordered as requested.
     */
    public List<Tally<T>> getAll(CounterOrder order) {
        
        List<Tally<T>> list = new ArrayList<Tally<T>>();
        for (T t : this.map.keySet()) {
            list.add(new Tally<T>(t, this.map.get(t)));
        }
        
        Collections.sort(list);
        if (order == CounterOrder.Descending) {
            Collections.reverse(list);
        }
        return list;
    }
    
    /**
     * <p>Get the number of times the instance, t, was counted.
     * @param t - the instance.
     * @return - the count
     */
    public int get(T t) {
    	return this.map.containsKey(t) ? this.map.get(t) : 0;
    }

    /**
     * <p>Get the total number of instances counted.
     * 
     * @return - the count
     */
    public int getTotal() {
    	int total = 0;
    	for (T t : EmptyIterable.nullSafeKeySetIterable(this.map)) {
			total += this.map.get(t);
		}
    	return total;
    }
}
