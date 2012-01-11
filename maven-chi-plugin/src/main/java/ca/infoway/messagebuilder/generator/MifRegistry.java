/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.xpath.XPathException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.generator.transform.MifTransform;
import ca.infoway.messagebuilder.generator.transform.MifTransformImpl;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

/**
 * <p>A class that caches XML-parsed MIF files.</p>
 * 
 * @author administrator
 */
class MifRegistry {
	
	class MifImpl implements Mif {
		private final String key;
		private final Document document;
		private final String name;
		private final String category;
		
		public MifImpl(String key, String name, Document document, String category) {
			this.key = key;
			this.name = name;
			this.document = document;
			this.category = category;
		}
		public Document asDocument() {
			return this.document;
		}
		public String getPackageLocation() {
			return this.key;
		}
		public String getName() {
			return this.name;
		}
		public String getCategory() {
			return this.category;
		}
	}
	
	protected Map<String,Mif> packageLocationToMif = Collections.synchronizedMap(new HashMap<String,Mif>());
	private Map<String,Mif> nameToMif = Collections.synchronizedMap(new HashMap<String,Mif>());
	private Map<String,String> aliasToMifId = Collections.synchronizedMap(new HashMap<String,String>());
	private DocumentFactory factory;
	private String mifVersion;
	private final LogUI log;
	protected String namespace;
	private final MifTransform mifTransformer;
	
	public MifRegistry(File mifTransform, LogUI log) throws GeneratorException {
		this.factory = new DocumentFactory();
		this.mifTransformer = (mifTransform == null ? null : new MifTransformImpl(mifTransform, this.factory));
		this.log = log;
	}

	// tests only
	MifRegistry(DocumentFactory documentFactory, MifTransform mifTransformer, LogUI log) throws GeneratorException {
		this.log = log;
		this.factory = documentFactory;
		this.mifTransformer = mifTransformer;
	}

	public String getMifVersion() {
		return this.mifVersion;
	}
	public boolean isMifRegistered(String packageLocation) {
		return this.packageLocationToMif.containsKey(toKey(packageLocation));
	}
	private String toKey(String packageLocation) {
		return PackageLocationDeriver.derive(packageLocation).getName();
	}
	public Mif getMifByName(String name) {
		if (this.aliasToMifId.containsKey(name)) {
			return getMif(this.aliasToMifId.get(name));
		} else {
			if (StringUtils.length(name) >= 2 
					&& name.charAt(1) == '_') {
				name = name.substring(2);
			}
			return this.nameToMif.get(name);
		}
	}
	public Mif getMif(String packageLoction) {
		String key = toKey(packageLoction);
		return this.packageLocationToMif.get(key);
	}
	
	public Collection<Mif> getAllMifs() {
		return this.packageLocationToMif.values();
	}
	
	void register(String packageLocation, Document document, String category) throws GeneratorException {
		String key = toKey(packageLocation);
		this.log.log(LogLevel.DEBUG, "Now registering MIF for package location " + key);
		MifImpl mif = new MifImpl(key, extractName(document), document, category);
		this.packageLocationToMif.put(key, mif);
		this.nameToMif.put(mif.getName(), mif);
	}
	
	String extractName(Document mif) throws GeneratorException {
		BaseMifXPathHelper helper = getHelper();
		return MifRegistry.convert(helper.getOwnedEntryPointElement(mif).getAttribute("name"));
	}

	private BaseMifXPathHelper getHelper() throws GeneratorException {
		if (isMif1()) {
			return new MifXPathHelper();
		} else if (isMif2()) {
			return new Mif2XPathHelper();
		} else {
			throw new GeneratorException("Can't determine MIF version");
		}
	}

	public Mif getMif(MifReference mifReference) throws IOException, GeneratorException {
		File file = mifReference.asFile();
		if (isMifRegistered(file.getName())) {
			return getMif(file.getName());
		} else {
			try {
				this.log.log(LogLevel.INFO, "Now parsing file \"" + file.getName() + "\"");
				Document document = createDocument(file);
				checkVersion(document, file);
				register(file.getName(), document, mifReference.getCategory());
				return getMif(file.getName());
			} catch (SAXException e) {
				throw new GeneratorException("Error parsing XML", e);
			}
		}
	}

	private Document createDocument(File file) throws SAXException, IOException, GeneratorException {
		Document result = this.factory.createFromFile(file);
		
		// if document is mif2 but not version 2.1.3 then transform to 2.1.3
		if (this.mifTransformer != null && this.mifTransformer.shouldBeTransformed(result)) {
			this.log.log(LogLevel.DEBUG, "Mif2 file being transformed to version 2.1.3");
			result = this.mifTransformer.transform(result);
		}
		
		return result;
	}
	
	void checkVersion(Document document, File file) throws GeneratorException {
		try {
			String namespace = BaseMifXPathHelper.getMifNamespace(document); 
			String version = BaseMifXPathHelper.getMifVersion(document);
			if (this.mifVersion == null) {
				this.namespace = namespace;
				this.mifVersion = version;
			} else if (!StringUtils.equals(this.namespace, namespace)) {
				throw new MifVersionException(file, namespace, this.namespace);
			} else if (isMif2() && !StringUtils.equals(this.mifVersion, version)) {
				throw new MifVersionException(file, version, this.mifVersion);
			}
		} catch (XPathException e) {
			throw new GeneratorException("Problem reading MIF XML: " + file.getName(), e);
		}
	}

	static String convert(String name) {
		return StringUtils.remove(WordUtils.capitalizeFully(name), " ");
	}

	public void addAlias(String alias, String mifId) {
		this.aliasToMifId.put(alias, mifId);
	}

	public String getMifIdFromAlias(String alias) {
		return this.aliasToMifId.get(alias);
	}
	
	public boolean isMif1() {
		return Namespaces.isMif1(this.namespace);
	}

	public boolean isMif2() {
		return Namespaces.isMif2(this.namespace);
	}
}
