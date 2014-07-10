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

package ca.infoway.messagebuilder.generator.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.NamedType;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.xml.TypeName;

@RunWith(Theories.class)
public class SimpleNameCoordinatorTest {
	
	class HelperImpl implements TypeNameHelper {

		private final Map<TypeName, Type> map;

		public HelperImpl(Map<TypeName,Type> map) {
			this.map = map;
		}
		public NamedType getNamedType(TypeName name) {
			return this.map.get(name);
		}
		public Map<TypeName, Type> getTypes() {
			return this.map;
		}
		public boolean isAbstract(TypeName name) {
			return this.map.get(name).isAbstract();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldReturnUnqualifiedNameWhenNoMap() throws Exception {
		SimpleNameCoordinator translator = new SimpleNameCoordinator(new HelperImpl(Collections.EMPTY_MAP));
		TypeName name = new TypeName("REPC_IN002120.Purple");
		assertEquals("Purple", translator.getName(name));
	}

	@Test
	public void shouldReturnUnqualifiedNameWhenTypeNotFound() throws Exception {
		HashMap<TypeName, Type> types = new HashMap<TypeName, Type>();
		TypeName name = new TypeName("REPC_IN002120.Orange");
		Type type = new Type(name);
		types.put(name, type);
		SimpleNameCoordinator translator = new SimpleNameCoordinator(new HelperImpl(types));
		assertEquals("Purple", translator.getName(new TypeName("REPC_IN002120.Purple")));
	}

	@Test
	public void shouldReturnUnqualifiedNameWhenTypeHasNoBusinessName() throws Exception {
		HashMap<TypeName, Type> types = new HashMap<TypeName, Type>();
		TypeName name = new TypeName("REPC_IN002120.Purple");
		Type type = new Type(name);
		types.put(name, type);
		SimpleNameCoordinator translator = new SimpleNameCoordinator(new HelperImpl(types));
		assertEquals("Purple", translator.getName(name));
	}

	@Test
	public void shouldReturnBusinessNameWhenTypeHasBusinessName() throws Exception {
		HashMap<TypeName, Type> types = new HashMap<TypeName, Type>();
		TypeName name = new TypeName("REPC_IN002120.Purple");
		Type type = new Type(name);
		type.setBusinessName("Business name for purple type.");
		types.put(name, type);
		SimpleNameCoordinator translator = new SimpleNameCoordinator(new HelperImpl(types));
		assertEquals("BusinessNameForPurpleType", translator.getName(name));
	}

	@Test
	public void shouldNotReturnBusinessNameWhenTypeHasBusinessNameButPolicyPrecludesItsUse() throws Exception {
		HashMap<TypeName, Type> types = new HashMap<TypeName, Type>();
		TypeName name = new TypeName("REPC_IN002120.Purple");
		Type type = new Type(name);
		type.setBusinessName("Business name for purple type.");
		types.put(name, type);

		SimpleNameCoordinator translator = new SimpleNameCoordinator(new HelperImpl(types), NamingPolicy.STANDARD_NAMES);
		assertEquals("Purple", translator.getName(name));
		
		translator = new SimpleNameCoordinator(new HelperImpl(types), NamingPolicy.MIXED_NAMES);
		assertEquals("BusinessNameForPurpleType", translator.getName(name));
		
		translator = new SimpleNameCoordinator(new HelperImpl(types), NamingPolicy.BUSINESS_NAMES);
		assertEquals("BusinessNameForPurpleType", translator.getName(name));
	}
	
	@Test
	public void shouldReturnFriendlyNameWhenTypeHasBusinessName() throws Exception {
		HashMap<TypeName, Type> types = new HashMap<TypeName, Type>();
		TypeName name1 = new TypeName("REPC_IN002120.Purple");
		Type type1 = new Type(name1);
		type1.setBusinessName("A: Barney and Friends");
		types.put(name1, type1);
		
		TypeName name2 = new TypeName("REPC_IN002120.Orange");
		Type type2 = new Type(name2);
		type2.setBusinessName("A: Barney and Friends");
		types.put(name2, type2);
		
		SimpleNameCoordinator translator = new SimpleNameCoordinator(new HelperImpl(types));
		assertEquals("BarneyAndFriends_2", translator.getName(name1));
		assertEquals("BarneyAndFriends_1", translator.getName(name2));
//		assertEquals("Purple", translator.getName(name1));
//		assertEquals("Orange", translator.getName(name2));
	}	

	@Test
	public void shouldReturnReplaceOldWithNormalNameAndAddNewWithFriendlyNameWhenNameClash() throws Exception {
		HashMap<TypeName, Type> types = new HashMap<TypeName, Type>();
		TypeName name1 = new TypeName("REPC_IN002120.Purple");
		Type type1 = new Type(name1);
		type1.setBusinessName("*orange");
		types.put(name1, type1);
		
		TypeName name2 = new TypeName("REPC_IN002120.Orange");
		Type type2 = new Type(name2);
		type2.setBusinessName("A: Orange");
		types.put(name2, type2);
		
		SimpleNameCoordinator translator = new SimpleNameCoordinator(new HelperImpl(types));
		assertEquals("Orange_2", translator.getName(name1));
		assertEquals("Orange_1", translator.getName(name2));
	}	
	
	@Test
	public void shouldProcessMergedTypesAndEnsureUniqueAndDeterministicNames() throws Exception {
		HashMap<TypeName, Type> types = new HashMap<TypeName, Type>();
		Type type1 = new Type(TemporaryTypeName.create("merged"));
		Type mergedType1a = new Type(new TypeName("ABCD_MT123456CA.Purple"));
		Type mergedType1b = new Type(new TypeName("ABCD_MT135799CA.Purple"));
		type1.getMergedTypes().add(mergedType1a);
		type1.getMergedTypes().add(mergedType1b);
		types.put(type1.getTypeName(), type1);
		types.put(mergedType1a.getTypeName(), mergedType1a);
		types.put(mergedType1b.getTypeName(), mergedType1b);
		
		Type type2 = new Type(TemporaryTypeName.create("merged"));
		Type mergedType2a = new Type(new TypeName("ABCD_MT222222CA.Purple"));
		Type mergedType2b = new Type(new TypeName("ABCD_MT333333CA.Purple"));
		type2.getMergedTypes().add(mergedType2a);
		type2.getMergedTypes().add(mergedType2b);
		types.put(type2.getTypeName(), type2);
		types.put(mergedType2a.getTypeName(), mergedType2a);
		types.put(mergedType2b.getTypeName(), mergedType2b);
		
		Type type3 = new Type(TemporaryTypeName.create("merged"));
		Type mergedType3a = new Type(new TypeName("ABCD_MT001122CA.Purple"));
		Type mergedType3b = new Type(new TypeName("ABCD_MT998877CA.Purple"));
		type3.getMergedTypes().add(mergedType3a);
		type3.getMergedTypes().add(mergedType3b);
		types.put(type3.getTypeName(), type3);
		types.put(mergedType3a.getTypeName(), mergedType3a);
		types.put(mergedType3b.getTypeName(), mergedType3b);
		
		SimpleNameCoordinator translator = new SimpleNameCoordinator(new HelperImpl(types));
		assertEquals("Purple_2", translator.getName(type1.getTypeName()));
		assertEquals("Purple_3", translator.getName(type2.getTypeName()));
		assertEquals("Purple_1", translator.getName(type3.getTypeName()));
	}	
	
	@Test
	public void shouldProcessMergedTypesAndMakeUseOfBusinessNames() throws Exception {
		HashMap<TypeName, Type> types = new HashMap<TypeName, Type>();
		Type type1 = new Type(TemporaryTypeName.create("merged"));
		Type mergedType1a = new Type(new TypeName("ABCD_MT123456CA.Purple"));
		mergedType1a.setBusinessName("purple business name");
		Type mergedType1b = new Type(new TypeName("ABCD_MT135799CA.Purple"));
		mergedType1b.setBusinessName("purple business name");
		type1.getMergedTypes().add(mergedType1a);
		type1.getMergedTypes().add(mergedType1b);
		types.put(type1.getTypeName(), type1);
		types.put(mergedType1a.getTypeName(), mergedType1a);
		types.put(mergedType1b.getTypeName(), mergedType1b);
		
		SimpleNameCoordinator translator = new SimpleNameCoordinator(new HelperImpl(types));
		assertEquals("PurpleBusinessName", translator.getName(type1.getTypeName()));
	}
	
	@Test
	public void shouldProcessMultipleSimilarlyNameMergedTypesAndMakeUseOfBusinessNames() throws Exception {
		HashMap<TypeName, Type> types = new HashMap<TypeName, Type>();
		
		Type type1 = new Type(TemporaryTypeName.create("merged"));
		Type mergedType1a = new Type(new TypeName("ABCD_MT123456CA.Purple"));
		mergedType1a.setBusinessName("purple business name");
		Type mergedType1b = new Type(new TypeName("ABCD_MT135799CA.Purple"));
		mergedType1b.setBusinessName("purple business name");
		type1.getMergedTypes().add(mergedType1a);
		type1.getMergedTypes().add(mergedType1b);
		
		Type type2 = new Type(TemporaryTypeName.create("merged"));
		Type mergedType2a = new Type(new TypeName("ABCD_MT111111CA.Purple"));
		mergedType2a.setBusinessName("purple business name");
		Type mergedType2b = new Type(new TypeName("ABCD_MT222222CA.Purple"));
		mergedType2b.setBusinessName("purple business name");
		type2.getMergedTypes().add(mergedType2a);
		type2.getMergedTypes().add(mergedType2b);
		
		types.put(type1.getTypeName(), type1);
		types.put(mergedType1a.getTypeName(), mergedType1a);
		types.put(mergedType1b.getTypeName(), mergedType1b);
		types.put(type2.getTypeName(), type2);
		types.put(mergedType2a.getTypeName(), mergedType2a);
		types.put(mergedType2b.getTypeName(), mergedType2b);
		
		List<String> translatedTypeNames = Arrays.asList("PurpleBusinessName_1", "PurpleBusinessName_2"); 
		SimpleNameCoordinator translator = new SimpleNameCoordinator(new HelperImpl(types));
		String name1 = translator.getName(type1.getTypeName());
		String name2 = translator.getName(type2.getTypeName());
		System.out.println(name1 + " " + name2);
		assertFalse("unique names", name1.equals(name2));
		assertTrue("translated name1", translatedTypeNames.contains(name1));
		assertTrue("translated name2", translatedTypeNames.contains(name2));
	}	
}
