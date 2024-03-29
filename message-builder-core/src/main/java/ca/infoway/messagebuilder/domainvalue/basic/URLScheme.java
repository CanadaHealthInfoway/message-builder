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

package ca.infoway.messagebuilder.domainvalue.basic;

import java.util.Arrays;
import java.util.List;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum representing all the valid and applicable URL types used within MessageBuilder.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class URLScheme extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.URLScheme, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
    private static final long serialVersionUID = -2569871003868077442L;
    
	public static final URLScheme FTP = new URLScheme("ftp"); 
    public static final URLScheme FAX = new URLScheme("fax"); 
    public static final URLScheme FILE = new URLScheme("file"); 
    public static final URLScheme HTTP = new URLScheme("http"); 
    public static final URLScheme HTTPS = new URLScheme("https"); 
    public static final URLScheme MLLP = new URLScheme("mllp"); 
    public static final URLScheme MAILTO = new URLScheme("mailto"); 
    public static final URLScheme MODEM = new URLScheme("modem"); 
    public static final URLScheme NFS = new URLScheme("nfs"); 
    public static final URLScheme TEL = new URLScheme("tel", "Phone"); 
    public static final URLScheme TELNET = new URLScheme("telnet");

	private final String description;

    private URLScheme(String codeValue) {
    	super(codeValue);
        this.description = DescribableUtil.getDefaultDescription(name());
    }
    
    private URLScheme(String codeValue, String description) {
    	super(codeValue);
		this.description = description;
    }
    
    /**
     * <p>Returns the code system for the URL.
     * 
     * @return the code system for the URL
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_URL_SCHEME.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeSystemName() {
    	return null;
    }
    
    /**
     * <p>Returns the value (protocol) for the URL.
     * 
     * @return the value (protocol) for the URL.
     */
    public String getCodeValue() {
        return name();
    }

    /**
     * <p>A description of the URL.
     * 
     * @return the URL description
     */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * <p>Returns a list of enums applicable for "phone". 
	 *  
	 * @return URLs applicable for phone
	 */
	public static List<URLScheme> getPhoneSchemes() {
		return Arrays.asList(FAX, TEL); 
	}
}
