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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt080100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.SpecimenIdentifierRoleType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ResponsibleOrganizationBean;



/**
 * <p>Business Name: Other Specimen Identifications</p>
 * 
 * <p>For referral and redirected orders, this information 
 * helps keep track of the different id's assigned during each 
 * phase of processing.</p>
 * 
 * <p>Associated specimen identifiers.</p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.IdentifiedEntity"})
public class OtherSpecimenIdentificationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ResponsibleOrganizationBean assigningOrganization;


    /**
     * <p>Business Name: Other Specimen Identifiers</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For referral and redirected orders, this information 
     * helps keep track of the different id's assigned during each 
     * phase of processing.</p>
     * 
     * <p>Associated specimen identifiers.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Other Specimen Identifiers</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>For referral and redirected orders, this information 
     * helps keep track of the different id's assigned during each 
     * phase of processing.</p>
     * 
     * <p>Associated specimen identifiers.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Other Specimen Identifier Type</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Categorized the type of role identifier.</p>
     * 
     * <p>Describes the type of other specimen identifier 
     * (referral, primary, etc.)</p>
     */
    @Hl7XmlMapping({"code"})
    public SpecimenIdentifierRoleType getCode() {
        return (SpecimenIdentifierRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: Other Specimen Identifier Type</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Categorized the type of role identifier.</p>
     * 
     * <p>Describes the type of other specimen identifier 
     * (referral, primary, etc.)</p>
     */
    public void setCode(SpecimenIdentifierRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * COCT_MT080100CA.IdentifiedEntity.assigningOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"assigningOrganization"})
    public ResponsibleOrganizationBean getAssigningOrganization() {
        return this.assigningOrganization;
    }

    /**
     * <p>Relationship: 
     * COCT_MT080100CA.IdentifiedEntity.assigningOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAssigningOrganization(ResponsibleOrganizationBean assigningOrganization) {
        this.assigningOrganization = assigningOrganization;
    }

}
