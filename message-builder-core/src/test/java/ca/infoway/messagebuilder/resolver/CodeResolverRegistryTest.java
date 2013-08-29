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
 * Last modified: $LastChangedDate: 2013-08-27 12:20:47 -0300 (Tue, 27 Aug 2013) $
 * Revision:      $LastChangedRevision: 7837 $
 */

package ca.infoway.messagebuilder.resolver;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;

public class CodeResolverRegistryTest {

	private final GenericCodeResolverRegistry registry1 = new GenericCodeResolverRegistryImpl(); 
	private final GenericCodeResolverRegistry registry2 = new GenericCodeResolverRegistryImpl(); 
	private final GenericCodeResolverRegistry registry3 = new GenericCodeResolverRegistryImpl(); 
	private final GenericCodeResolverRegistry registry4 = new GenericCodeResolverRegistryImpl(); 
	private final GenericCodeResolverRegistry registry5 = new GenericCodeResolverRegistryImpl(); 
	private final GenericCodeResolverRegistry registry6 = new GenericCodeResolverRegistryImpl(); 
	
	@Before
	public void startup() {
		CodeResolverRegistry.clearThreadLocalVersion();
		CodeResolverRegistry.removeAllRegistries();
		CodeResolverRegistry.unregisterAll();
	}
	
	@After
	public void teardown() {
		CodeResolverRegistry.clearThreadLocalVersion();
		CodeResolverRegistry.removeAllRegistries();
		CodeResolverRegistry.unregisterAll();
	}
	
	@Test
	public void testRegistryRegistration() {
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_02, registry1);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03, registry2);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03_AB, registry3);
		
		assertEquals(registry1, CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.R02_04_02));
		assertEquals(registry2, CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03));
		assertEquals(registry3, CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03_AB));
		
		assertNull(CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.V01R04_3));
	}
	
	@Test
	public void testRegistryRetrieval() {
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_02, registry1);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03, registry2);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03_AB, registry3);
		
		CodeResolverRegistry.setThreadLocalVersion(SpecificationVersion.R02_04_02);
		assertEquals(registry1, CodeResolverRegistry.getRegistry());
		CodeResolverRegistry.setThreadLocalVersion(SpecificationVersion.R02_04_03);
		assertEquals(registry2, CodeResolverRegistry.getRegistry());
		CodeResolverRegistry.setThreadLocalVersion(SpecificationVersion.R02_04_03_AB);
		assertEquals(registry3, CodeResolverRegistry.getRegistry());
		CodeResolverRegistry.clearThreadLocalVersion();
		assertEquals("should return default registry when no thread-local version is stored", CodeResolverRegistry.getDefaultRegistry(), CodeResolverRegistry.getRegistry());
	}
	
	@Test
	public void testRegistryRemoval() {
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_02, registry1);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03, registry2);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03_AB, registry3);
		
		assertEquals(registry1, CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.R02_04_02));
		assertEquals(registry2, CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03));
		assertEquals(registry3, CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03_AB));

		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_02, null);
		assertNull(CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.R02_04_02));
		
		CodeResolverRegistry.removeAllRegistries();
		assertNull(CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.R02_04_02));
		assertNull(CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03));
		assertNull(CodeResolverRegistry.getCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03_AB));
	}
	
	@Test
	public void testThreadSafety() throws Exception {
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_02, registry1);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03, registry2);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.R02_04_03_AB, registry3);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.V01R04_2_SK, registry4);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.V01R04_3, registry5);
		CodeResolverRegistry.registerCodeResolverRegistryForVersion(SpecificationVersion.V01R04_3_ON, registry6);

		List<ThreadTest> testList = new ArrayList<ThreadTest>();
		
		for (int i = 0; i < 100; i++) {
			testList.add(new ThreadTest(i*6, SpecificationVersion.R02_04_02, registry1));
			testList.add(new ThreadTest(i*6+1, SpecificationVersion.R02_04_03, registry2));
			testList.add(new ThreadTest(i*6+2, SpecificationVersion.R02_04_03_AB, registry3));
			testList.add(new ThreadTest(i*6+3, SpecificationVersion.V01R04_2_SK, registry4));
			testList.add(new ThreadTest(i*6+4, SpecificationVersion.V01R04_3, registry5));
			testList.add(new ThreadTest(i*6+5, SpecificationVersion.V01R04_3_ON, registry6));
		}
		
		for (ThreadTest threadTest : testList) {
			threadTest.start();
		}
		
		for (ThreadTest threadTest : testList) {
			threadTest.join();
		}
		
		for (ThreadTest threadTest : testList) {
			assertTrue("thread " + threadTest.getThreadId(), threadTest.hasPassedTest());
		}
		
	}

	
	private class ThreadTest extends Thread {

		private final VersionNumber version;
		private final GenericCodeResolverRegistry registry;
		private boolean passedTest = false;
		private final int threadId;

		public int getThreadId() {
			return threadId;
		}

		public ThreadTest(int threadId, VersionNumber version, GenericCodeResolverRegistry registry) {
			this.threadId = threadId;
			this.version = version;
			this.registry = registry;
		}
		
		public void run() {
			CodeResolverRegistry.setThreadLocalVersion(this.version);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			this.passedTest = (CodeResolverRegistry.getRegistry() == registry);
		}
		
		public boolean hasPassedTest() {
			return this.passedTest;
		}
	}
	
}
