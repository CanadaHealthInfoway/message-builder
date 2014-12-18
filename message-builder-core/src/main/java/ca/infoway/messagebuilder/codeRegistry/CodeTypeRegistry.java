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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-11-06 15:40:43 -0500 (Thu, 06 Nov 2014) $
 * Revision:      $LastChangedRevision: 9058 $
 */

package ca.infoway.messagebuilder.codeRegistry;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.domainvalue.util.CodeTypeHandler;
import ca.infoway.messagebuilder.j5goodies.ClassFinder;
import ca.infoway.messagebuilder.j5goodies.ClassPredicate;
import ca.infoway.messagebuilder.j5goodies.Predicates;
import ca.infoway.messagebuilder.marshalling.hl7.MessageTypeKey;
import ca.infoway.messagebuilder.util.ManifestLocater;

/**
 * <p>A utility class that can be used to translate between domain types
 * and their corresponding Java class.
 * 
 * <p>This utility depends on the fact that every jar that contains generated model classes will include a Manifest
 * file that has an attribute, MBT-Model-Version-Numbers, which lists the version
 * numbers that the model classes are valid for.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore platform
 */
public class CodeTypeRegistry implements CodeTypeHandler {

	private static CodeTypeRegistry instance;
	
	private final Map<MessageTypeKey,Class<?>> codeTypeRegistry = Collections.synchronizedMap(new HashMap<MessageTypeKey, Class<?>>());

	private CodeTypeRegistry() {
	}
	
	public static CodeTypeRegistry getInstance() {
		if (instance == null) {
			initializeInstance();
		}
		return instance;
	}

	private synchronized static void initializeInstance() {
		if (instance == null) {
			CodeTypeRegistry registry = new CodeTypeRegistry();
			registry.initialize();
			instance = registry;
		}
	}

	private void initialize() {
		ClassPredicate codeTypePredicate = Predicates.isInstanceofPredicate(Code.class);
		Map<URL, List<String>> manifests = new ManifestLocater().getManifestsWithVersionAttribute();
		for (URL url : manifests.keySet()) {
			List<Class<?>> codes = new ClassFinder().findClasses(url, codeTypePredicate);
			registerCodeType(codes, manifests.get(url));
		}
	}

	private void registerCodeType(List<Class<?>> codes, List<String> versions) {
		for (Class<?> c : codes) {
			registerCodeType(c, versions);
		}
	}
	
	private void registerCodeType(Class<?> c, List<String> versions) {
		String domainType = ClassUtils.getShortClassName(c);
		for (String version : versions) {
			this.codeTypeRegistry.put(new MessageTypeKey(version, domainType), c);
		}
	}

	@SuppressWarnings("unchecked")
	public Class<? extends Code> getCodeType(String domainType, String version) {
		return (Class<? extends Code>) this.codeTypeRegistry.get(new MessageTypeKey(version, domainType));
	}
}
