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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Has</p>
 * 
 * <p>REPC_MT500004CA.Participant: *has</p>
 * 
 * <p><p>Identifies the participants associated with the 
 * particular location.</p></p>
 * 
 * <p><p>Cardinality is constrained to 200 rather than 1000 
 * because it is exactly equal to the sum of the number of 
 * potential patients and providers</p></p>
 * 
 * <p><p>Important for providing context for the encounter. The 
 * element is mandatory because there whole purpose of having a 
 * participant grouping is to have participants.</p></p>
 * 
 * <p>REPC_MT500002CA.Participant: *has</p>
 * 
 * <p><p>Identifies the participants associated with the 
 * particular location.</p></p>
 * 
 * <p><p>Cardinality is constrained to 200 rather than 1000 
 * because it is exactly equal to the sum of the number of 
 * potential patients and providers</p></p>
 * 
 * <p><p>Important for providing context for the encounter. The 
 * element is mandatory because there whole purpose of having a 
 * participant grouping is to have participants.</p></p>
 * 
 * <p>REPC_MT500001CA.Participant: *has</p>
 * 
 * <p><p>Identifies the participants associated with the 
 * particular location.</p></p>
 * 
 * <p><p>Cardinality is constrained to 200 rather than 1000 
 * because it is exactly equal to the sum of the number of 
 * potential patients and providers</p></p>
 * 
 * <p><p>Important for providing context for the encounter. The 
 * element is mandatory because there whole purpose of having a 
 * participant grouping is to have participants.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT500001CA.Participant","REPC_MT500002CA.Participant","REPC_MT500004CA.Participant"})
public class HasBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CV modeCode = new CVImpl();
    private II roleId = new IIImpl();
    private SET<CV, Code> roleConfidentialityCode = new SETImpl<CV, Code>(CVImpl.class);


    /**
     * <p>ParticipationMechanism</p>
     * 
     * <p>B:Participation Mechanism</p>
     * 
     * <p><p>Identifies how the patient and/or provider(s) 
     * participated in the encounter (in person, by phone, by 
     * videoconference, etc.)</p></p>
     * 
     * <p><p>Understanding how each participant was involved in the 
     * encounter gives context to the encounter, particularly for 
     * telehealth.</p></p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getModeCode() {
        return (ParticipationMode) this.modeCode.getValue();
    }
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>ParticipantIdReference</p>
     * 
     * <p>A: Participant Id Reference</p>
     * 
     * <p><p>The unique identifier of a patient or provider who was 
     * involved in the encounter at the identified location. This 
     * will reference one of the patient or provider ids already 
     * associated with the Care Composition.</p></p>
     * 
     * <p><p>Links the participant to the location where they were 
     * involved in the encounter. The element is mandatory because 
     * there's no point listing participants unless they can be 
     * explicitly identified.</p></p>
     */
    @Hl7XmlMapping({"role/id"})
    public Identifier getRoleId() {
        return this.roleId.getValue();
    }
    public void setRoleId(Identifier roleId) {
        this.roleId.setValue(roleId);
    }


    /**
     * <p>ParticipantConfidentialities</p>
     * 
     * <p>C: Participant Confidentialities</p>
     * 
     * <p><p>Identifies the confidentiality level associated with 
     * the encounter for this specific participant.</p></p>
     * 
     * <p><p>Provides individual participants in a group encounter 
     * with complete control over the confidentiality of their 
     * participation in that encounter.</p><p>The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p>Provides individual participants in a group encounter 
     * with complete control over the confidentiality of their 
     * participation in that encounter.</p><p>The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p>This element should only be specified if the id is 
     * referencing a patient, not a provider.</p><p>Stricter 
     * confidentiality asserted at the overall encounter level 
     * overrides looser confidentiality asserted at the participant 
     * level.</p></p>
     * 
     * <p><p>This element should only be specified if the id is 
     * referencing a patient, not a provider.</p><p>Stricter 
     * confidentiality asserted at the overall encounter level 
     * overrides looser confidentiality asserted at the participant 
     * level.</p></p>
     */
    @Hl7XmlMapping({"role/confidentialityCode"})
    public Set<x_VeryBasicConfidentialityKind> getRoleConfidentialityCode() {
        return this.roleConfidentialityCode.rawSet(x_VeryBasicConfidentialityKind.class);
    }

}
