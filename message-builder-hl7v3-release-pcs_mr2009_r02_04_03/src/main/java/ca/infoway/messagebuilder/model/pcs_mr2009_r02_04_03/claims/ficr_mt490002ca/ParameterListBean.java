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
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt490002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT490002CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private TS coveredPartyDOBValue = new TSImpl();
    private CV coveredPartyGenderValue = new CVImpl();
    private PN coveredPartyNameValue = new PNImpl();
    private II policyIdentifierValue = new IIImpl();
    private II specialAuthorizationRequestIDValue = new IIImpl();


    /**
     * <p>Business Name: Covered Party Birthdate</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyDOB.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"coveredPartyDOB/value"})
    public Date getCoveredPartyDOBValue() {
        return this.coveredPartyDOBValue.getValue();
    }

    /**
     * <p>Business Name: Covered Party Birthdate</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyDOB.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCoveredPartyDOBValue(Date coveredPartyDOBValue) {
        this.coveredPartyDOBValue.setValue(coveredPartyDOBValue);
    }


    /**
     * <p>Business Name: Gender of covered party</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"coveredPartyGender/value"})
    public AdministrativeGender getCoveredPartyGenderValue() {
        return (AdministrativeGender) this.coveredPartyGenderValue.getValue();
    }

    /**
     * <p>Business Name: Gender of covered party</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCoveredPartyGenderValue(AdministrativeGender coveredPartyGenderValue) {
        this.coveredPartyGenderValue.setValue(coveredPartyGenderValue);
    }


    /**
     * <p>Business Name: Covered Party Name</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"coveredPartyName/value"})
    public PersonName getCoveredPartyNameValue() {
        return this.coveredPartyNameValue.getValue();
    }

    /**
     * <p>Business Name: Covered Party Name</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCoveredPartyNameValue(PersonName coveredPartyNameValue) {
        this.coveredPartyNameValue.setValue(coveredPartyNameValue);
    }


    /**
     * <p>Business Name: Policy Identifier</p>
     * 
     * <p>Relationship: FICR_MT490002CA.PolicyIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"policyIdentifier/value"})
    public Identifier getPolicyIdentifierValue() {
        return this.policyIdentifierValue.getValue();
    }

    /**
     * <p>Business Name: Policy Identifier</p>
     * 
     * <p>Relationship: FICR_MT490002CA.PolicyIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPolicyIdentifierValue(Identifier policyIdentifierValue) {
        this.policyIdentifierValue.setValue(policyIdentifierValue);
    }


    /**
     * <p>Business Name: Special Authorization Request ID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490002CA.SpecialAuthorizationRequestID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"specialAuthorizationRequestID/value"})
    public Identifier getSpecialAuthorizationRequestIDValue() {
        return this.specialAuthorizationRequestIDValue.getValue();
    }

    /**
     * <p>Business Name: Special Authorization Request ID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490002CA.SpecialAuthorizationRequestID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSpecialAuthorizationRequestIDValue(Identifier specialAuthorizationRequestIDValue) {
        this.specialAuthorizationRequestIDValue.setValue(specialAuthorizationRequestIDValue);
    }

}
