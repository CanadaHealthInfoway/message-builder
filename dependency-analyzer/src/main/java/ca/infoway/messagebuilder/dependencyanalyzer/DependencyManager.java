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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.dependencyanalyzer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DependencyManager<T> {

	private Set<T> all = Collections.synchronizedSet(new HashSet<T>());
    private Map<T,Set<T>> efferents = Collections.synchronizedMap(new HashMap<T,Set<T>>());
    private Map<T,Set<T>> afferents = Collections.synchronizedMap(new HashMap<T,Set<T>>());

    private LayeredGraph<T> layeredGraph;

    public void add(T t) {
    	this.layeredGraph = null;
    	if (t != null) {
    		this.all.add(t);
    	}
    }
    public void add(T dependant, T dependsOn) {
    	add(dependant);
    	add(dependsOn);
    	add(this.afferents, dependsOn, dependant);
    	add(this.efferents, dependant, dependsOn);
    }

    private void add(Map<T, Set<T>> map, T key, T value) {
    	this.layeredGraph = null;
    	if (key != null) {
			if (!map.containsKey(key)) {
				map.put(key, new HashSet<T>());
			}

			if (value != null) {
				map.get(key).add(value);
			}
    	}
	}
	public int getNodeCount() {
    	return getAll().size();
    }

    public Set<T> getDirectDependencies(T dependent) {
    	HashSet<T> result = new HashSet<T>();
    	Set<T> set = this.efferents.get(dependent);
    	if (set != null) {
    		result.addAll(set);
    	}
		return result;
    }

    @Deprecated
    public List<Layer<T>> getLayers() {
        List<Layer<T>> list = new ArrayList<Layer<T>>();
        Set<T> all = getAll();
        Set<T> sorted = new HashSet<T>();

        int level = 0;
        while (!all.isEmpty()) {
            Set<T> layer = new HashSet<T>();
            for (T t : all) {
                Collection<T> dependencies = getDirectDependencies(t);
                dependencies.removeAll(sorted);
                if (dependencies.isEmpty()) {
                    layer.add(t);
                }
            }

            if (!layer.isEmpty()) {
                list.add(new Layer<T>(level, layer));
                level++;
                all.removeAll(layer);
                sorted.addAll(layer);
            } else {
                throw new IllegalStateException("Looks like a cyclic dependency!");
            }
        }

        return list;
    }

	private synchronized LayeredGraph<T> initializeLayers() {
    	return new LayeredGraph<T>(this.all, this.efferents, this.afferents);
	}

    public List<Layer<Node<T>>> getNodeLayers() {
        return getLayeredGraph().getLayers();
    }

    private Set<T> getAll() {
        return new HashSet<T>(this.all);
    }
	public LayeredGraph<T> getLayeredGraph() {
		if (this.layeredGraph == null) {
			this.layeredGraph = initializeLayers();
		}
		return this.layeredGraph;
	}
}
