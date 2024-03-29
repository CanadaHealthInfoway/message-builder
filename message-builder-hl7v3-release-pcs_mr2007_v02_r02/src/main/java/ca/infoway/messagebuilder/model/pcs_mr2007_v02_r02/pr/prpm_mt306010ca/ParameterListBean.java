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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.prpm_mt306010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.AssignedRoleType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.QualifiedRoleType;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.JurisdictionTypeCode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PRPM_MT306010CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private List<AD> addressValue = new ArrayList<AD>();
    private CV administrativeGenderValue = new CVImpl();
    private List<CV> assignedRoleTypeValue = new ArrayList<CV>();
    private REAL confidenceValue = new REALImpl();
    private TS dOBValue = new TSImpl();
    private BL includeHistoryIndicatorValue = new BLImpl();
    private List<CV> jurisdictionValue = new ArrayList<CV>();
    private PN nameValue = new PNImpl();
    private List<II> providerIDValue = new ArrayList<II>();
    private List<CV> qualificationValue = new ArrayList<CV>();
    private List<ResponseObjectBean> responseObject = new ArrayList<ResponseObjectBean>();
    private List<CV> roleClassValue = new ArrayList<CV>();
    private IVL<TS, Interval<Date>> roleEffectiveDateValue = new IVLImpl<TS, Interval<Date>>();
    private List<CV> roleTypeValue = new ArrayList<CV>();
    private CV routedDocTypeValue = new CVImpl();
    private List<AD> serviceDeliveryLocationAddressValue = new ArrayList<AD>();
    private List<II> serviceDeliveryLocationIDValue = new ArrayList<II>();
    private List<CV> serviceDeliveryLocationTypeValue = new ArrayList<CV>();
    private List<CV> statusValue = new ArrayList<CV>();
    private List<TEL> telecomValue = new ArrayList<TEL>();


    /**
     * <p>Business Name: Healthcare Provider Role Address</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.Address.value</p>
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
     * <p>Relationship: PRPM_MT306010CA.AdministrativeGender.value</p>
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
     * <p>Relationship: PRPM_MT306010CA.AdministrativeGender.value</p>
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
     * <p>Relationship: PRPM_MT306010CA.AssignedRoleType.value</p>
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
     * <p>Relationship: PRPM_MT306010CA.Confidence.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Required attribute to provide information about success 
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
     * <p>Relationship: PRPM_MT306010CA.Confidence.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Required attribute to provide information about success 
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
     * <p>Relationship: PRPM_MT306010CA.DOB.value</p>
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
     * <p>Relationship: PRPM_MT306010CA.DOB.value</p>
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
     * <p>Business Name: History Indicator Value</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306010CA.IncludeHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute when queried upon</p>
     * 
     * <p>Indicates whether or not historical records should be 
     * included in this query response</p>
     */
    @Hl7XmlMapping({"includeHistoryIndicator/value"})
    public Boolean getIncludeHistoryIndicatorValue() {
        return this.includeHistoryIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: History Indicator Value</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306010CA.IncludeHistoryIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute when queried upon</p>
     * 
     * <p>Indicates whether or not historical records should be 
     * included in this query response</p>
     */
    public void setIncludeHistoryIndicatorValue(Boolean includeHistoryIndicatorValue) {
        this.includeHistoryIndicatorValue.setValue(includeHistoryIndicatorValue);
    }


    /**
     * <p>Business Name: Jurisdiction Type</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.Jurisdiction.value</p>
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
     * <p>Relationship: PRPM_MT306010CA.Name.value</p>
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
     * <p>Relationship: PRPM_MT306010CA.Name.value</p>
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
     * <p>Relationship: PRPM_MT306010CA.ProviderID.value</p>
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
    public List<Identifier> getProviderIDValue() {
        return new RawListWrapper<II, Identifier>(providerIDValue, IIImpl.class);
    }


    /**
     * <p>Business Name: Expertise or Credentials Role Identifier</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.Qualification.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider credentials</p>
     * 
     * <p>Unique identifier for the Expertise or Credential.</p>
     */
    @Hl7XmlMapping({"qualification/value"})
    public List<QualifiedRoleType> getQualificationValue() {
        return new RawListWrapper<CV, QualifiedRoleType>(qualificationValue, CVImpl.class);
    }


    /**
     * <p>Relationship: 
     * PRPM_MT306010CA.ParameterList.responseObject</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     */
    @Hl7XmlMapping({"responseObject"})
    public List<ResponseObjectBean> getResponseObject() {
        return this.responseObject;
    }


    /**
     * <p>Business Name: Role Class Value</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.RoleClass.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ASSIGNED or PROV</p>
     * 
     * <p>Mandatory attribute where queried upon</p>
     * 
     * <p>Indicates Role Class being queried upon</p>
     */
    @Hl7XmlMapping({"roleClass/value"})
    public List<RoleClass> getRoleClassValue() {
        return new RawListWrapper<CV, RoleClass>(roleClassValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Effective Date</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.RoleEffectiveDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The effective date of the provider in the healthcare 
     * provider role.</p>
     */
    @Hl7XmlMapping({"roleEffectiveDate/value"})
    public Interval<Date> getRoleEffectiveDateValue() {
        return this.roleEffectiveDateValue.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Effective Date</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.RoleEffectiveDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The effective date of the provider in the healthcare 
     * provider role.</p>
     */
    public void setRoleEffectiveDateValue(Interval<Date> roleEffectiveDateValue) {
        this.roleEffectiveDateValue.setValue(roleEffectiveDateValue);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Type</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.RoleType.value</p>
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


    /**
     * <p>Business Name: Routed Document Type</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.RoutedDocType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Supports the business requirement to identify the 
     * specified roleClass being queried upon</p>
     * 
     * <p>Supports the business requirement to identify the 
     * specified roleClass being queried upon</p>
     */
    @Hl7XmlMapping({"routedDocType/value"})
    public ActCode getRoutedDocTypeValue() {
        return (ActCode) this.routedDocTypeValue.getValue();
    }

    /**
     * <p>Business Name: Routed Document Type</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.RoutedDocType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Supports the business requirement to identify the 
     * specified roleClass being queried upon</p>
     * 
     * <p>Supports the business requirement to identify the 
     * specified roleClass being queried upon</p>
     */
    public void setRoutedDocTypeValue(ActCode routedDocTypeValue) {
        this.routedDocTypeValue.setValue(routedDocTypeValue);
    }


    /**
     * <p>Business Name: Service Delivery Location Address Detail</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306010CA.ServiceDeliveryLocationAddress.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute when queried upon</p>
     * 
     * <p>Address for the Service Delivery Location</p>
     */
    @Hl7XmlMapping({"serviceDeliveryLocationAddress/value"})
    public List<PostalAddress> getServiceDeliveryLocationAddressValue() {
        return new RawListWrapper<AD, PostalAddress>(serviceDeliveryLocationAddressValue, ADImpl.class);
    }


    /**
     * <p>Business Name: Service Delivery Location Identifier</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306010CA.ServiceDeliveryLocationID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>A unique identifier for the service delivery 
     * location.</p>
     */
    @Hl7XmlMapping({"serviceDeliveryLocationID/value"})
    public List<Identifier> getServiceDeliveryLocationIDValue() {
        return new RawListWrapper<II, Identifier>(serviceDeliveryLocationIDValue, IIImpl.class);
    }


    /**
     * <p>Business Name: Service Delivery Location Type Value</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306010CA.ServiceDeliveryLocationType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the validation and 
     * identification of the service delivery location</p>
     * 
     * <p>A unique value for the service delivery location 
     * type.</p>
     */
    @Hl7XmlMapping({"serviceDeliveryLocationType/value"})
    public List<ServiceDeliveryLocationRoleType> getServiceDeliveryLocationTypeValue() {
        return new RawListWrapper<CV, ServiceDeliveryLocationRoleType>(serviceDeliveryLocationTypeValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Status Code</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.Status.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The status of the provider in the healthcare provider 
     * role i.e. Active</p>
     */
    @Hl7XmlMapping({"status/value"})
    public List<RoleStatus> getStatusValue() {
        return new RawListWrapper<CV, RoleStatus>(statusValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Telecom</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.Telecom.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The telecom for the provider when playing the role of 
     * healthcare provider.</p>
     */
    @Hl7XmlMapping({"telecom/value"})
    public List<TelecommunicationAddress> getTelecomValue() {
        return new RawListWrapper<TEL, TelecommunicationAddress>(telecomValue, TELImpl.class);
    }

}
