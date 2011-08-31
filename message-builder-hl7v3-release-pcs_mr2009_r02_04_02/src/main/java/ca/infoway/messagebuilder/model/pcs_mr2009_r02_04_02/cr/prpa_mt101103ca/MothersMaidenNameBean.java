/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.cr.prpa_mt101103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT101103CA.MothersMaidenName"})
public class MothersMaidenNameBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private PN motherSMaidenName = new PNImpl();
    private ST semanticsText = new STImpl();


    /**
     * <p>Mother's Maiden Name</p>
     * 
     * <p><p>This query parameter is the maiden name of the focal 
     * person's mother.</p></p>
     * 
     * <p><p>It is included as a parameter because it is a common 
     * attribute for confirming the identity of persons in some 
     * person registries.</p></p>
     * 
     * <p><p>This parameter does not map to a single RIM attribute, 
     * instead, in RIM terms Mother's maiden name is the person 
     * name part of &quot;family&quot; with an 
     * EntityNamePartQualifier of &quot;birth&quot; for the person 
     * who is the player in a PersonalRelationship of type of 
     * &quot;mother&quot; to the focal person.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public PersonName getMotherSMaidenName() {
        return this.motherSMaidenName.getValue();
    }
    public void setMotherSMaidenName(PersonName motherSMaidenName) {
        this.motherSMaidenName.setValue(motherSMaidenName);
    }


    @Hl7XmlMapping({"semanticsText"})
    public String getSemanticsText() {
        return this.semanticsText.getValue();
    }
    public void setSemanticsText(String semanticsText) {
        this.semanticsText.setValue(semanticsText);
    }

}
