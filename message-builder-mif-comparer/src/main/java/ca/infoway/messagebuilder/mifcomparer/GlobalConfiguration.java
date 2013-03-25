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

package ca.infoway.messagebuilder.mifcomparer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.NamespaceContext;

import org.ini4j.Ini;
import org.ini4j.Profile;

public class GlobalConfiguration {
	
	public XmlFilterList xmlFilters;
	public MapBasedNamespaceContext namespaceContext;

	/**
	 * Create a no-op {@link GlobalConfiguration}.  That is to say, where possible,
	 * each config item is initialized to an object that does nothing -- an XmlFilter
	 * that makes no changes, a namespaceContext with no mappings, etc. 
	 */
	public GlobalConfiguration() {
		xmlFilters = new XmlFilterList();
		namespaceContext = new MapBasedNamespaceContext(new HashMap<String,String>());
	}

	/**
	 * Create a {@link GlobalConfiguration} object, initialized by a config file.
	 * 
	 * <p>The config file is in modified Windows "ini" format.  The modification is that
	 * keys can be multivalued -- there can be multiple entries for one key.  This only
	 * makes sense for some keys, but where it doesn't make sense, single-valued-ness is
	 * <i>not</i> enforced.
	 * 
	 * <p>The sections are:
	 * 
	 * <p><b>[Filters]</b>
	 * <p><pre>
	 * 		[Filters]
	 * 		filter = filter-type arguments
	 * </pre>
	 * 
	 * <p>The only allowed key is {@code filter}, which may occur multiple times.  For each entry,
	 * the value consists of a {@code filter-type} followed by arguments as defined for that filter type,
	 * all whitespace-separated.  The filter types are:<dl>
	 * <dt>delete xpathExpr
	 * <dd>Creates a filter to delete all nodes matching {@literal xpathExpr}
	 * 
	 * <dt>resequence sortKeyAttr xpathExpr
	 * <dd>Creates a filter to resequence all XML elements matching {@literal xpathExpr} based on their values for the
	 *     attributes named by {@literal sortKeyAttr}.  See {@link XmlResequenceFilter} for details.
	 * </dl>
	 * 
	 * <p><b>[Namespaces]</b>
	 * <p><pre>
	 * 		[Namespaces]
	 *		prefix = namespace-uri
	 * </pre>
	 * 
	 * <p>The filters specify their targets via XPath expressions.  The {@code [Namespaces]} section defines
	 * the XML-namespace prefixes that will be in effect during filtering.  The prefixes themselves do not need
	 * to bear any relation to the prefixes used in the XML documents; only the URIs matter.  That is, if the config
	 * file contains:<pre>
	 * xhtml = http://www.w3.org/1999/xhtml
	 * </pre>
	 * 
	 * then a filter definition which uses {@code xhtml:} prefixes in its XPath expression will work even on XML files
	 * that bind that URI to a different prefix ({@code html}, say).  
	 * @throws IOException 
	 */
	public GlobalConfiguration(File configFile) throws IOException {
		this();				// Start with a no-op configuration; we'll replace individual items as they occur
		
		initialize(configFile);
	}
	
	public GlobalConfiguration(Reader reader) throws IOException {
		this();				// Start with a no-op configuration; we'll replace individual items as they occur
		
		initialize(reader);
	}
		
	public void initialize(File configFile) throws IOException {
		Reader r = new FileReader(configFile);
		initialize(r);
	}
	
	public void initialize(Reader r) throws IOException {
		Ini ini = new Ini(r);
		initialize(ini);
	}
	
	public void initialize(Ini ini) {
		Profile.Section section;
		
		if ((section = ini.get("Namespaces")) != null) {
			Map<String,String> map = new HashMap<String,String>(section);		// For paranoia's sake, copy it to a Map that's independent of ini4j
			namespaceContext = new MapBasedNamespaceContext(map);
		}
		
		if ((section = ini.get("Filters")) != null) {
			List<String> filterConfigs = section.getAll("filter");
			if (filterConfigs == null)				// happens if the section exists, but has no "filter=" entries
				filterConfigs = new LinkedList();
			
			this.xmlFilters = new XmlFilterList(this.namespaceContext, filterConfigs);
		}
	}	
}
