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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT300000CA.Substitution"})
public class DispenseSubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CV code = new CVImpl();
    private CV reasonCode = new CVImpl();
    private II performerSubstitutionRoleId = new IIImpl();


    /**
     * <p>Business Name: Substitution Type</p>
     * 
     * <p>Relationship: COCT_MT300000CA.Substitution.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>type of substitution</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdminSubstitutionCode getCode() {
        return (ActSubstanceAdminSubstitutionCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Substitution Type</p>
     * 
     * <p>Relationship: COCT_MT300000CA.Substitution.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>type of substitution</p>
     */
    public void setCode(ActSubstanceAdminSubstitutionCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Substitution Reason</p>
     * 
     * <p>Relationship: COCT_MT300000CA.Substitution.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Reason for substituting or not substituting, e.g. because 
     * prescriber requested</p>
     * 
     * <p>Reason why the substitution occurred.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionReason getReasonCode() {
        return (SubstanceAdminSubstitutionReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: Substitution Reason</p>
     * 
     * <p>Relationship: COCT_MT300000CA.Substitution.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Reason for substituting or not substituting, e.g. because 
     * prescriber requested</p>
     * 
     * <p>Reason why the substitution occurred.</p>
     */
    public void setReasonCode(SubstanceAdminSubstitutionReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Business Name: Person who did the substitution</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SubstitutionRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ID must be that of the patient, ordering provider or 
     * dispensing provider</p>
     * 
     * <p>Id must be that of the patient, ordering provider or 
     * dispensing provider.</p>
     */
    @Hl7XmlMapping({"performer/substitutionRole/id"})
    public Identifier getPerformerSubstitutionRoleId() {
        return this.performerSubstitutionRoleId.getValue();
    }

    /**
     * <p>Business Name: Person who did the substitution</p>
     * 
     * <p>Relationship: COCT_MT300000CA.SubstitutionRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ID must be that of the patient, ordering provider or 
     * dispensing provider</p>
     * 
     * <p>Id must be that of the patient, ordering provider or 
     * dispensing provider.</p>
     */
    public void setPerformerSubstitutionRoleId(Identifier performerSubstitutionRoleId) {
        this.performerSubstitutionRoleId.setValue(performerSubstitutionRoleId);
    }

}
