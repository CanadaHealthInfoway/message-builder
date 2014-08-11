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

package ca.infoway.messagebuilder.domainvalue.basic;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>EntityNamePartQualifier
 * 
 * <p>From http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#domain-EntityNameUse
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class EntityNamePartQualifier extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.EntityNamePartQualifier, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
    
	private static final long serialVersionUID = -8087184682557715309L;
	
	public static final EntityNamePartQualifier ACADEMIC = new EntityNamePartQualifier("ACADEMIC", "AC");
	public static final EntityNamePartQualifier ADOPTED = new EntityNamePartQualifier("ADOPTED", "AD");
	public static final EntityNamePartQualifier BIRTH = new EntityNamePartQualifier("BIRTH", "BR");
	public static final EntityNamePartQualifier CALLME = new EntityNamePartQualifier("CALLME", "CL");
	public static final EntityNamePartQualifier INITIAL = new EntityNamePartQualifier("INITIAL", "IN");
	public static final EntityNamePartQualifier NOBILITY = new EntityNamePartQualifier("NOBILITY", "NB");
	public static final EntityNamePartQualifier PROFESSIONAL = new EntityNamePartQualifier("PROFESSIONAL", "PR");
	public static final EntityNamePartQualifier SPOUSE = new EntityNamePartQualifier("SPOUSE", "SP");
	public static final EntityNamePartQualifier TITLE = new EntityNamePartQualifier("TITLE", "TITLE");
	public static final EntityNamePartQualifier VOORVOEGSEL = new EntityNamePartQualifier("VOORVOEGSEL", "VV");
	public static final EntityNamePartQualifier LEGALSTATUS = new EntityNamePartQualifier("LEGALSTATUS", "LS");
    
    private final String codeValue;

    private EntityNamePartQualifier(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

    /**
     * <p>Returns the entity name code system.
     * 
     * @return the entity name code system
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_ENTITY_NAME_QUALIFIER.getRoot();
    }

    /**
     * <p>Returns the code value.
     * 
     * @return the code value
     */
    public String getCodeValue() {
        return this.codeValue;
    }

    /**
     * <p>Returns the description.
     * 
     * @return the description
     */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
