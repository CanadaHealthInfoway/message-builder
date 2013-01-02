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

package ca.infoway.messagebuilder.datatype.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype ST (and ST.LANG). Backed by a java String.
 * 
 * <p>The character string data type stands for text data, primarily intended for machine processing 
 * (e.g., sorting, querying, indexing, etc.) Used for names, symbols, and formal expressions.
 *  
 * <p>ST is a restricted ED, whose ED.mediaType property is fixed to text/plain, and whose data must be 
 * inlined and not compressed. Thus, the properties compression, reference, integrity check, algorithm, 
 * and thumbnail are not applicable. The character string data type is used when the appearance of text 
 * does not bear meaning, which is true for formalized text and all kinds of names.
 *  
 * <p>ST data type interprets the encapsulated data as character data (as opposed to bits), depending on the 
 * charset property of the encapsulated data type. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class STImpl extends EDImpl<String> implements ST {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 9117867441166259585L;

	public static List<String> ALLOWED_LANGUAGES = Arrays.asList("en-CA", "fr-CA");

	private String language;
	
	/**
	 * <p>Constructs an empty ST.
	 */
	public STImpl() {
		this((String) null);
	}

	/**
	 * <p>Constructs an ST using the supplied value.
	 * 
	 * @param defaultVaString the initial value
	 */
	public STImpl(String defaultVaString) {
		super(String.class, defaultVaString, null, StandardDataType.ST);
	}
	
	/**
	 * <p>Constructs a language-based ST.
	 * 
	 * @param defaultVaString the initial value
	 * @param language the language of the initial value
	 */
	public STImpl(String defaultVaString, String language) {
		super(String.class, defaultVaString, null, StringUtils.isBlank(language) ? StandardDataType.ST : StandardDataType.ST_LANG);
		setLanguage(StringUtils.trimToNull(language));
	}
	
	/**
	 * <p>Constructs an ST with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public STImpl(NullFlavor nullFlavor) {
		super(String.class, null, nullFlavor, StandardDataType.ST);
	}

	/**
	 * <p>Returns the ST's language.
	 * 
	 * @return the language of the ST
	 */
	public String getLanguage() {
		return this.language;
	}
	
	/**
	 * <p>Sets the language of the ST.
	 * 
	 * @param language a language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
}
