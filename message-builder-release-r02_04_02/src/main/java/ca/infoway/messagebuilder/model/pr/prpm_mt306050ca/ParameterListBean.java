/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt306050ca;

import ca.infoway.messagebuilder.Code;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PRPM_MT306050CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private List<CV> assignedRoleTypeValue = new ArrayList<CV>();
    private List<AD> healthcareProviderRoleAddress = new ArrayList<AD>();
    private List<CV> healthcareProviderRoleType = new ArrayList<CV>();
    private PN healthcareProviderRoleName = new PNImpl();
    private List<CV> roleClassValue = new ArrayList<CV>();
    private TS principalPersonDateOfBirth = new TSImpl();
    private II healthcareProviderRoleIdentification = new IIImpl();
    private List<CV> jurisdictionType = new ArrayList<CV>();
    private CV principalPersonGender = new CVImpl();
    private REAL confidenceValue = new REALImpl();


    /**
     * <p>Assigned Role Type Value</p>
     * 
     * <p><p>The code identifying the specific functional role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"assignedRoleType/value"})
    public List<AssignedRoleType> getAssignedRoleTypeValue() {
        return new RawListWrapper<CV, AssignedRoleType>(assignedRoleTypeValue, CVImpl.class);
    }


    /**
     * <p>Healthcare Provider Role Address</p>
     * 
     * <p><p>The address for the provider when playing the role of 
     * healthcare provider.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"address/value"})
    public List<PostalAddress> getHealthcareProviderRoleAddress() {
        return new RawListWrapper<AD, PostalAddress>(healthcareProviderRoleAddress, ADImpl.class);
    }


    /**
     * <p>Healthcare Provider Role Type</p>
     * 
     * <p><p>The code identifying the specific healthcare provider 
     * role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"roleType/value"})
    public List<HealthcareProviderRoleType> getHealthcareProviderRoleType() {
        return new RawListWrapper<CV, HealthcareProviderRoleType>(healthcareProviderRoleType, CVImpl.class);
    }


    /**
     * <p>Healthcare Provider Role Name</p>
     * 
     * <p><p>The provider'''s name pertaining to the specific 
     * healthcare provider role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"name/value"})
    public PersonName getHealthcareProviderRoleName() {
        return this.healthcareProviderRoleName.getValue();
    }
    public void setHealthcareProviderRoleName(PersonName healthcareProviderRoleName) {
        this.healthcareProviderRoleName.setValue(healthcareProviderRoleName);
    }


    /**
     * <p>Role Class Value</p>
     * 
     * <p><p>Indicates Role Class being queried upon</p></p>
     * 
     * <p><p>Mandatory attribute where queried upon</p></p>
     */
    @Hl7XmlMapping({"roleClass/value"})
    public List<Code> getRoleClassValue() {
        return new RawListWrapper<CV, Code>(roleClassValue, CVImpl.class);
    }


    /**
     * <p>Principal Person Date of Birth</p>
     * 
     * <p><p>The principal person'''s date of birth.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"dOB/value"})
    public Date getPrincipalPersonDateOfBirth() {
        return this.principalPersonDateOfBirth.getValue();
    }
    public void setPrincipalPersonDateOfBirth(Date principalPersonDateOfBirth) {
        this.principalPersonDateOfBirth.setValue(principalPersonDateOfBirth);
    }


    /**
     * <p>Healthcare Provider Role Identification</p>
     * 
     * <p><p>A unique identifier for a provider in a specific 
     * healthcare role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"providerID/value"})
    public Identifier getHealthcareProviderRoleIdentification() {
        return this.healthcareProviderRoleIdentification.getValue();
    }
    public void setHealthcareProviderRoleIdentification(Identifier healthcareProviderRoleIdentification) {
        this.healthcareProviderRoleIdentification.setValue(healthcareProviderRoleIdentification);
    }


    /**
     * <p>Jurisdiction Type</p>
     * 
     * <p><p>A character value that represents the Canadian 
     * provincial or territorial geographical area within which the 
     * Provider is operating.</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p></p>
     */
    @Hl7XmlMapping({"jurisdiction/value"})
    public List<Code> getJurisdictionType() {
        return new RawListWrapper<CV, Code>(jurisdictionType, CVImpl.class);
    }


    /**
     * <p>Principal Person Gender</p>
     * 
     * <p><p>The principal person'''s gender.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"administrativeGender/value"})
    public AdministrativeGender getPrincipalPersonGender() {
        return (AdministrativeGender) this.principalPersonGender.getValue();
    }
    public void setPrincipalPersonGender(AdministrativeGender principalPersonGender) {
        this.principalPersonGender.setValue(principalPersonGender);
    }


    /**
     * <p>Confidence Value</p>
     * 
     * <p><p>A real number value indicating the confidence of the 
     * query with regard to finding the intended target provider 
     * i.e. the value would be the computed confidence value.</p></p>
     * 
     * <p><p>Mandatory attribute to provide information about 
     * success of query</p></p>
     */
    @Hl7XmlMapping({"confidence/value"})
    public BigDecimal getConfidenceValue() {
        return this.confidenceValue.getValue();
    }
    public void setConfidenceValue(BigDecimal confidenceValue) {
        this.confidenceValue.setValue(confidenceValue);
    }

}
