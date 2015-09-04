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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.pr.prpm_mt306010nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
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
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.AssignedRoleType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.PlaceEntityType;
import ca.infoway.messagebuilder.domainvalue.QualifiedRoleType;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.ProviderQueryResponseObject;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.RoutedDocumentType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>This query message must include, as a minimum, either the 
 * name or partial name of a provider by including both the 
 * &ldquo;given&rdquo; and/or &ldquo;family&rdquo; name 
 * elements in the message path 
 * &ldquo;/queryByParameter/name/value&rdquo; <b>OR</b> a 
 * minimum of two other search parameters specified using the 
 * message elements &ldquo;administrativeGender&rdquo; 
 * (provider&rsquo;s gender), &ldquo;address&rdquo; 
 * (provider&rsquo;s work address with a use=&ldquo;WP&rdquo;), 
 * &ldquo;providerID&rdquo; (provider&rsquo;s provincial 
 * identifier), &ldquo;telecom&rdquo; (provider&rsquo;s phone 
 * using either &ldquo;tel:&rdquo; or &ldquo;fax:&rdquo; and a 
 * use=&ldquo;WP&rdquo;), or the &ldquo;status&rdquo; 
 * (provider&rsquo;s role status described using the RoleStatus 
 * vocabulary). The usage for the name, in the 
 * &ldquo;value&rdquo; element, shall be &lsquo;value 
 * use=&rdquo;L&rdquo; &rsquo;.</p>
 * 
 * <p>The New Brunswick Provider Index will include 
 * &ldquo;Default&rdquo; provider records for use to identify 
 * provider&rsquo;s that may not be New Brunswick providers, 
 * such as &ldquo;Out-of-province Nurse Practitioners&rdquo; 
 * for instance. Default providers may be searched for using 
 * &ldquo;default&rdquo; as a partial name search.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT306010NB.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private AD addressValue = new ADImpl();
    private CV administrativeGenderValue = new CVImpl();
    private List<CV> assignedRoleTypeValue = new ArrayList<CV>();
    private REAL confidenceValue = new REALImpl();
    private TS dOBValue = new TSImpl();
    private List<CV> jurisdictionValue = new ArrayList<CV>();
    private PN nameValue = new PNImpl();
    private II providerIDValue = new IIImpl();
    private List<CV> qualificationValue = new ArrayList<CV>();
    private List<CV> responseObjectValue = new ArrayList<CV>();
    private List<CV> roleClassValue = new ArrayList<CV>();
    private IVL<TS, Interval<Date>> roleEffectiveDateValue = new IVLImpl<TS, Interval<Date>>();
    private CV roleTypeValue = new CVImpl();
    private CV routedDocTypeValue = new CVImpl();
    private List<AD> serviceDeliveryLocationAddressValue = new ArrayList<AD>();
    private List<II> serviceDeliveryLocationIDValue = new ArrayList<II>();
    private List<CV> serviceDeliveryLocationTypeValue = new ArrayList<CV>();
    private CV statusValue = new CVImpl();
    private TEL telecomValue = new TELImpl();


    /**
     * <p>Business Name: Healthcare Provider Role Address</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.Address.value</p>
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
    public PostalAddress getAddressValue() {
        return this.addressValue.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Address</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.Address.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The address for the provider when playing the role of 
     * healthcare provider.</p>
     */
    public void setAddressValue(PostalAddress addressValue) {
        this.addressValue.setValue(addressValue);
    }


    /**
     * <p>Business Name: Principal Person Gender</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.AdministrativeGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The principal person'''s gender.</p>
     */
    @Hl7XmlMapping({"administrativeGender/value"})
    public AdministrativeGender getAdministrativeGenderValue() {
        return (AdministrativeGender) this.administrativeGenderValue.getValue();
    }

    /**
     * <p>Business Name: Principal Person Gender</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.AdministrativeGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The principal person'''s gender.</p>
     */
    public void setAdministrativeGenderValue(AdministrativeGender administrativeGenderValue) {
        this.administrativeGenderValue.setValue(administrativeGenderValue);
    }


    /**
     * <p>Business Name: Assigned Role Type Value</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.AssignedRoleType.value</p>
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
     * <p>Relationship: PRPM_MT306010NB.Confidence.value</p>
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
     * <p>Relationship: PRPM_MT306010NB.Confidence.value</p>
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
     * <p>Relationship: PRPM_MT306010NB.DOB.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The principal person'''s date of birth.</p>
     */
    @Hl7XmlMapping({"dOB/value"})
    public Date getDOBValue() {
        return this.dOBValue.getValue();
    }

    /**
     * <p>Business Name: Principal Person Date of Birth</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.DOB.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The principal person'''s date of birth.</p>
     */
    public void setDOBValue(Date dOBValue) {
        this.dOBValue.setValue(dOBValue);
    }


    /**
     * <p>Business Name: Jurisdiction Type</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.Jurisdiction.value</p>
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
    public List<PlaceEntityType> getJurisdictionValue() {
        return new RawListWrapper<CV, PlaceEntityType>(jurisdictionValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Name</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.Name.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The provider'''s name pertaining to the specific 
     * healthcare provider role.</p>
     */
    @Hl7XmlMapping({"name/value"})
    public PersonName getNameValue() {
        return this.nameValue.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Name</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.Name.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The provider'''s name pertaining to the specific 
     * healthcare provider role.</p>
     */
    public void setNameValue(PersonName nameValue) {
        this.nameValue.setValue(nameValue);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Identification</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.ProviderID.value</p>
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
     * <p>Relationship: PRPM_MT306010NB.ProviderID.value</p>
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
     * <p>Business Name: Expertise or Credentials Role Type</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.Qualification.value</p>
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
     * <p>Business Name: Provider Query Response Object</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.ResponseObject.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute provides tremendous value in giving 
     * the organization issuing the query the flexibility to 
     * request particular items in the response.</p>
     * 
     * <p>Outlines the values expected to be received by this 
     * query</p>
     */
    @Hl7XmlMapping({"responseObject/value"})
    public List<ProviderQueryResponseObject> getResponseObjectValue() {
        return new RawListWrapper<CV, ProviderQueryResponseObject>(responseObjectValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Role Class Value</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.RoleClass.value</p>
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
     * <p>Relationship: PRPM_MT306010NB.RoleEffectiveDate.value</p>
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
     * <p>Relationship: PRPM_MT306010NB.RoleEffectiveDate.value</p>
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
     * <p>Relationship: PRPM_MT306010NB.RoleType.value</p>
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
    public HealthcareProviderRoleType getRoleTypeValue() {
        return (HealthcareProviderRoleType) this.roleTypeValue.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Type</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.RoleType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The code identifying the specific healthcare provider 
     * role.</p>
     */
    public void setRoleTypeValue(HealthcareProviderRoleType roleTypeValue) {
        this.roleTypeValue.setValue(roleTypeValue);
    }


    /**
     * <p>Business Name: Routed Document Type</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.RoutedDocType.value</p>
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
    public RoutedDocumentType getRoutedDocTypeValue() {
        return (RoutedDocumentType) this.routedDocTypeValue.getValue();
    }

    /**
     * <p>Business Name: Routed Document Type</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.RoutedDocType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Supports the business requirement to identify the 
     * specified roleClass being queried upon</p>
     * 
     * <p>Supports the business requirement to identify the 
     * specified roleClass being queried upon</p>
     */
    public void setRoutedDocTypeValue(RoutedDocumentType routedDocTypeValue) {
        this.routedDocTypeValue.setValue(routedDocTypeValue);
    }


    /**
     * <p>Business Name: Service Delivery Location Address Detail</p>
     * 
     * <p>Relationship: 
     * PRPM_MT306010NB.ServiceDeliveryLocationAddress.value</p>
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
     * PRPM_MT306010NB.ServiceDeliveryLocationID.value</p>
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
     * PRPM_MT306010NB.ServiceDeliveryLocationType.value</p>
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
     * <p>Relationship: PRPM_MT306010NB.Status.value</p>
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
    public RoleStatus getStatusValue() {
        return (RoleStatus) this.statusValue.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Status Code</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.Status.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The status of the provider in the healthcare provider 
     * role i.e. Active</p>
     */
    public void setStatusValue(RoleStatus statusValue) {
        this.statusValue.setValue(statusValue);
    }


    /**
     * <p>Business Name: Healthcare Provider Role Telecom</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.Telecom.value</p>
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
    public TelecommunicationAddress getTelecomValue() {
        return this.telecomValue.getValue();
    }

    /**
     * <p>Business Name: Healthcare Provider Role Telecom</p>
     * 
     * <p>Relationship: PRPM_MT306010NB.Telecom.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The telecom for the provider when playing the role of 
     * healthcare provider.</p>
     */
    public void setTelecomValue(TelecommunicationAddress telecomValue) {
        this.telecomValue.setValue(telecomValue);
    }

}