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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.prpm_mt306050ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.AssignedRoleType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.domainvalue.JurisdictionTypeCode;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.domainvalue.x_RoleClassAssignedQualifiedProvider;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PRPM_MT306050CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private List<AD> addressValue = new ArrayList<AD>();
    private CV administrativeGenderValue = new CVImpl();
    private List<CV> assignedRoleTypeValue = new ArrayList<CV>();
    private REAL confidenceValue = new REALImpl();
    private TS dOBValue = new TSImpl();
    private List<CV> jurisdictionValue = new ArrayList<CV>();
    private PN nameValue = new PNImpl();
    private II providerIDValue = new IIImpl();
    private List<CV> roleClassValue = new ArrayList<CV>();
    private List<CV> roleTypeValue = new ArrayList<CV>();


    /**
     * <p>Business Name: Healthcare Provider Role Address</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.Address.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The address for the provider when playing the role of 
     * healthcare provider.</p>
     */
    @Hl7XmlMapping({"address/value"})
    public List<PostalAddress> getAddressValue() {
        return new RawListWrapper<AD, PostalAddress>(addressValue, ADImpl.class);
    }


    /**
     * <p>Business Name: Principal Person Gender</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.AdministrativeGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The principal person's gender.</p>
     */
    @Hl7XmlMapping({"administrativeGender/value"})
    public AdministrativeGender getAdministrativeGenderValue() {
        return (AdministrativeGender) this.administrativeGenderValue.getValue();
    }

    /**
     * <p>Business Name: Principal Person Gender</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.AdministrativeGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The principal person's gender.</p>
     */
    public void setAdministrativeGenderValue(AdministrativeGender administrativeGenderValue) {
        this.administrativeGenderValue.setValue(administrativeGenderValue);
    }


    /**
     * <p>Business Name: Assigned Role Type Value</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.AssignedRoleType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The code identifying the specific functional role.</p>
     */
    @Hl7XmlMapping({"assignedRoleType/value"})
    public List<AssignedRoleType> getAssignedRoleTypeValue() {
        return new RawListWrapper<CV, AssignedRoleType>(assignedRoleTypeValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Confidence Value</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.Confidence.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute to provide information about success 
     * of query</p>
     * 
     * <p>A real number value indicating the confidence of the 
     * query with regard to finding the intended target provider 
     * i.e. the value would be the computed confidence value.</p>
     */
    @Hl7XmlMapping({"confidence/value"})
    public BigDecimal getConfidenceValue() {
        return this.confidenceValue.getValue();
    }

    /**
     * <p>Business Name: Confidence Value</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.Confidence.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute to provide information about success 
     * of query</p>
     * 
     * <p>A real number value indicating the confidence of the 
     * query with regard to finding the intended target provider 
     * i.e. the value would be the computed confidence value.</p>
     */
    public void setConfidenceValue(BigDecimal confidenceValue) {
        this.confidenceValue.setValue(confidenceValue);
    }


    /**
     * <p>Business Name: Principal Person Date of Birth</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.DOB.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The principal person's date of birth.</p>
     */
    @Hl7XmlMapping({"dOB/value"})
    public Date getDOBValue() {
        return this.dOBValue.getValue();
    }

    /**
     * <p>Business Name: Principal Person Date of Birth</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.DOB.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The principal person's date of birth.</p>
     */
    public void setDOBValue(Date dOBValue) {
        this.dOBValue.setValue(dOBValue);
    }


    /**
     * <p>Business Name: Jurisdiction Type</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.Jurisdiction.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p>
     * 
     * <p>A character value that represents the Canadian provincial 
     * or territorial geographical area within which the Provider 
     * is operating.</p>
     */
    @Hl7XmlMapping({"jurisdiction/value"})
    public List<JurisdictionTypeCode> getJurisdictionValue() {
        return new RawListWrapper<CV, JurisdictionTypeCode>(jurisdictionValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Name</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.Name.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The provider's name pertaining to the specific healthcare 
     * provider role.</p>
     */
    @Hl7XmlMapping({"name/value"})
    public PersonName getNameValue() {
        return this.nameValue.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Name</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.Name.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The provider's name pertaining to the specific healthcare 
     * provider role.</p>
     */
    public void setNameValue(PersonName nameValue) {
        this.nameValue.setValue(nameValue);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Identification</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.ProviderID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>A unique identifier for a provider in a specific 
     * healthcare role.</p>
     */
    @Hl7XmlMapping({"providerID/value"})
    public Identifier getProviderIDValue() {
        return this.providerIDValue.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Identification</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.ProviderID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>A unique identifier for a provider in a specific 
     * healthcare role.</p>
     */
    public void setProviderIDValue(Identifier providerIDValue) {
        this.providerIDValue.setValue(providerIDValue);
    }


    /**
     * <p>Business Name: Role Class Value</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.RoleClass.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute where queried upon</p>
     * 
     * <p>Indicates Role Class being queried upon</p>
     */
    @Hl7XmlMapping({"roleClass/value"})
    public List<x_RoleClassAssignedQualifiedProvider> getRoleClassValue() {
        return new RawListWrapper<CV, x_RoleClassAssignedQualifiedProvider>(roleClassValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Type</p>
     * 
     * <p>Relationship: PRPM_MT306050CA.RoleType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The code identifying the specific healthcare provider 
     * role.</p>
     */
    @Hl7XmlMapping({"roleType/value"})
    public List<HealthcareProviderRoleType> getRoleTypeValue() {
        return new RawListWrapper<CV, HealthcareProviderRoleType>(roleTypeValue, CVImpl.class);
    }

}
