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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.NamespaceContext;

import org.w3c.dom.Document;

public class XmlFilterList implements XmlFilter {
	private List<XmlFilter> filters = new ArrayList<XmlFilter>();
	
	public XmlFilterList() {
	}
	
	/**
	 * Create an {@link XmlFilterList} containg filters as described by the individual members of {@code definitions}.
	 * Each <i>definition</i> is in the form of the value of a {@code filter} entry in the {@link GlobalConfiguration} file.
	 */
	public XmlFilterList(NamespaceContext nsContext, Iterable<String> definitions) {
		for (String def : definitions)
			this.add(XmlFilterImpl.newInstance(nsContext, def));
	}
	
	public void add(XmlFilter filter) {
		this.filters.add(filter);
	}

	public void apply(File file, Document dom, MessageList msgs) {
		for (XmlFilter f : filters)
			f.apply(file, dom, msgs);
	}

	/**
	 * For testing
	 */
	List<XmlFilter> getFilters() {
		return filters;
	}
}
