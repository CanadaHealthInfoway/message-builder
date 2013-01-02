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

package ca.infoway.messagebuilder.model.newfoundland;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.DirectoryWalker;
import org.junit.Test;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.j5goodies.ClassFileUtil;
import ca.infoway.messagebuilder.junit.ModelClassFinder;

public class ModelTest {
	
	interface Assertion {
		void perform(Class<?> c);
	}
	
	class PackageFinder extends DirectoryWalker {
		
		@SuppressWarnings("unchecked")
		@Override
		protected boolean handleDirectory(File directory, int depth,
				@SuppressWarnings("rawtypes") Collection results) throws IOException {
			if (".svn".equals(directory.getName())) {
				return false;
			} else {
				String name = ClassFileUtil.convertFileNameToClassName(ModelClassFinder.srcDirectory, directory);
				results.add(name);
				return true;
			}
		}

		public List<String> getPackageNames(String packageRoot) throws IOException {
			List<String> result = new ArrayList<String>();
			walk(new File(ModelClassFinder.srcDirectory, packageRoot.replace('.', File.separatorChar)), result);
			return result;
		}
	}
	
	@Test
	public void testShouldBeTrueThatAllModelClassesImplementSerializable() throws Exception {
		processAllModelObjects(new Assertion() {
			public void perform(Class<?> c) {
				if (!c.isInterface()) {
					assertTrue(c.getName() + " should implement Serializable", Serializable.class.isAssignableFrom(c));
					assertHasSerialId(c);
				}
			}
		});
	}

	private void processAllModelObjects(Assertion assertion) throws IOException,
			ClassNotFoundException {
		List<String> packageNames = new PackageFinder().getPackageNames("ca.infoway.messagebuilder.model");
		List<File> allModelFiles = ModelClassFinder.getAllModelFiles(packageNames.toArray(new String[packageNames.size()]));
		for (File file : allModelFiles) {
			String javaClassName = ClassFileUtil.convertFileNameToClassName(ModelClassFinder.srcDirectory, file);
			Class<?> c = Class.forName(javaClassName);
			assertion.perform(c);
		}
	}
	
	@Test
	public void testShouldBeAnnotatedWithHl7PartTypeMappingIfItsAMessageBean() throws Exception {
		processAllModelObjects(new Assertion() {
			public void perform(Class<?> c) {
				if (MessageBean.class.isAssignableFrom(c) && !Modifier.isAbstract(c.getModifiers())) {
					assertTrue(c.getName() + " should be annotated with Hl7PartTypeMapping", 
							c.isAnnotationPresent(Hl7PartTypeMapping.class)
							|| c.isAnnotationPresent(Hl7PartTypeMapping.class));
				}
			}
		});
	}

	private void assertHasSerialId(Class<?> c) {
		try {
			c.getDeclaredField("serialVersionUID");
		} catch (NoSuchFieldException e) {
			fail(c.getName() + " should define a serialVersionUID");
		}
	}
}
