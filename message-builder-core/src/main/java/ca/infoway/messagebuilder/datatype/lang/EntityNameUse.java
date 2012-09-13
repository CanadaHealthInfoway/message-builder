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

package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>EntityNameUse.
 * 
 * <p>From http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#domain-EntityNameUse
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class EntityNameUse extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.EntityNameUse, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
    
	private static final long serialVersionUID = -8087184682557715309L;
	
	public static final EntityNameUse LICENSE = new EntityNameUse("LICENSE", "C"); 
	public static final EntityNameUse INDIGENOUS_TRIBAL = new EntityNameUse("INDIGENOUS_TRIBAL", "I"); 
	public static final EntityNameUse LEGAL = new EntityNameUse("LEGAL", "L"); 
	public static final EntityNameUse PSEUDONYM = new EntityNameUse("PSEUDONYM", "P"); 
	public static final EntityNameUse ARTIST_STAGE = new EntityNameUse("ARTIST_STAGE", "A"); 
	public static final EntityNameUse RELIGIOUS = new EntityNameUse("RELIGIOUS", "R");
	public static final EntityNameUse SEARCH = new EntityNameUse("SEARCH", "SRCH"); 
	public static final EntityNameUse PHONETIC = new EntityNameUse("PHONETIC", "PHON"); 
	public static final EntityNameUse SOUNDEX = new EntityNameUse("SOUNDEX", "SNDX"); 
	public static final EntityNameUse ALPHABETIC = new EntityNameUse("ALPHABETIC", "ABC"); 
	public static final EntityNameUse SYLLABIC = new EntityNameUse("SYLLABIC", "SYL");
	public static final EntityNameUse IDEOGRAPHIC = new EntityNameUse("IDEOGRAPHIC", "IDE");
    
	public static final EntityNameUse ASSIGNED = new EntityNameUse("ASSIGNED", "ASGN");

    @Deprecated
    public static final EntityNameUse HEALTH_CARD = new EntityNameUse("HEALTH_CARD", "HC");
    
    // This use replaces "Health Card", and has been adopted internationally
    public static final EntityNameUse OFFICIAL_REGISTRY = new EntityNameUse("OFFICIAL_REGISTRY", "OR");
    
    private final String codeValue;

    private EntityNameUse(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
    }

    /**
     * <p>Returns the entity name code system.
     * 
     * @return the entity name code system
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_ENTITY_NAME_USE.getRoot();
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
