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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.dependencyanalyzer.DependencyManager;
import ca.infoway.messagebuilder.dependencyanalyzer.Layer;
import ca.infoway.messagebuilder.dependencyanalyzer.Node;

public class DependencyManagerTest {

    @SuppressWarnings("deprecation")
    @Test
	public void testLevels() throws Exception {
        DependencyManager<String> manager = createDependencyManager();

        List<Layer<String>> layers = manager.getLayers();
        assertNotNull("layers", layers);
        assertEquals("number of layers", 3, layers.size());
        printLayers(layers);
    }

	private void printLayers(List<Layer<String>> layers) {
		for (Layer<String> layer : layers) {
            System.out.println(layer.getLevel() + " --> " + layer.getContents());
        }
	}

    @Test
    public void testNodeLevels() throws Exception {
    	DependencyManager<String> manager = createDependencyManager();

    	List<Layer<Node<String>>> layers = manager.getNodeLayers();
    	assertNotNull("layers", layers);
    	assertEquals("number of layers", 3, layers.size());

    	printNodeLayers(layers);
    }

	private void printNodeLayers(List<Layer<Node<String>>> layers) {
		for (Layer<Node<String>> layer : layers) {
    		System.out.println(layer.getLevel() + " --> " + layer.getContents());
    	}
	}

    @Test
    public void testThatAnItemWithNoDependenciesIsPreserved() throws Exception {
    	DependencyManager<String> manager = createDependencyManager();
    	manager.add("spring");

    	List<Layer<Node<String>>> layers = manager.getNodeLayers();
    	assertNotNull("layers", layers);
    	assertEquals("number of layers", 3, layers.size());

    	printNodeLayers(layers);

    	boolean found = false;
    	for (Node<String> node : layers.get(0).getContents()) {
    		found |= "spring".equals(node.getName());
		}
    	assertTrue("spring", found);
    }

    @Test
    public void testEfferentCouplings() throws Exception {
    	DependencyManager<String> manager = createDependencyManager();

    	List<Layer<Node<String>>> layers = manager.getNodeLayers();
    	assertNotNull("layers", layers);
    	assertEquals("number of layers", 3, layers.size());

    	Layer<Node<String>> layer = layers.get(1);
    	for (Node<String> node : layer.getContents()) {
    		System.out.println("Afferent couplings: " + node.getName() + " --> " + node.getAfferentCouplings());
    		assertFalse("afferent couplings", node.getAfferentCouplings().isEmpty());

    		System.out.println("Efferent couplings: " + node.getName() + " --> " + node.getEfferentCouplings());
    		assertFalse("efferent couplings", node.getEfferentCouplings().isEmpty());
		}
    }

    @Test
    public void testLevelsWithFiles() throws Exception {
        DependencyManager<File> manager = createDependencyManagerWithFiles();

        List<Layer<Node<File>>> layers = manager.getNodeLayers();
        assertNotNull("layers", layers);
        assertEquals("number of layers", 3, layers.size());
    }

    private DependencyManager<File> createDependencyManagerWithFiles() {
        DependencyManager<File> manager = new DependencyManager<File>();

        manager.add(new File("test.xml"), new File("something.xsd"));
        manager.add(new File("myprogram.dll"), new File("test.xml"));
        return manager;
    }

    @Test
    public void testLevelsWithCyclicDependency() throws Exception {
        DependencyManager<String> manager = createDependencyManager();
        manager.add("junit", "myproject");
        List<Layer<Node<String>>> layers = manager.getNodeLayers();
        assertEquals("number of layers", 4, layers.size());
    }

    @Test
    public void testDirectDependencies() throws Exception {
        DependencyManager<String> manager = createDependencyManager();

        Collection<String> directDependencies = manager.getDirectDependencies("jmock");
        assertEquals("size", 2, directDependencies.size());

    }

    private DependencyManager<String> createDependencyManager() {
        DependencyManager<String> manager = new DependencyManager<String>();

        manager.add("myproject", "hibernate");
        manager.add("myproject", "jmock");
        manager.add("hibernate", "cglib");
        manager.add("myproject", "jmock");
        manager.add("jmock", "junit");
        manager.add("jmock", "cglib");
        return manager;
    }
}
