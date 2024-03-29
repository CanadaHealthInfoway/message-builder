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
package ca.infoway.messagebuilder.model.nb_drug.iehr.repc_mt120001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Professional Service Query Parameters</p>
 * 
 * <p>Root class for query parameters.</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"REPC_MT120001CA.ParameterList"})
@Hl7RootType
public class ProfessionalServiceQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private BL includeNotesIndicatorValue = new BLImpl();
    private TS patientBirthDateValue = new TSImpl();
    private CV patientGenderValue = new CVImpl();
    private II patientIDValue = new IIImpl();
    private PN patientNameValue = new PNImpl();
    private List<CV> professionalServiceCodeValue = new ArrayList<CV>();
    private IVL<TS, Interval<Date>> servicePeriodValue = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: REPC_MT120001CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for professional service 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * professional service record are to be returned along with 
     * the detailed information.</p>
     * 
     * <p>This should always be set to &ldquo;true&rdquo;.</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: REPC_MT120001CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for professional service 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * professional service record are to be returned along with 
     * the detailed information.</p>
     * 
     * <p>This should always be set to &ldquo;true&rdquo;.</p>
     */
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>Business Name: Patient Birth Date</p>
     * 
     * <p>Relationship: REPC_MT120001CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDateValue() {
        return this.patientBirthDateValue.getValue();
    }

    /**
     * <p>Business Name: Patient Birth Date</p>
     * 
     * <p>Relationship: REPC_MT120001CA.PatientBirthDate.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the date on which the patient was born.</p>
     */
    public void setPatientBirthDateValue(Date patientBirthDateValue) {
        this.patientBirthDateValue.setValue(patientBirthDateValue);
    }


    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: REPC_MT120001CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGenderValue() {
        return (AdministrativeGender) this.patientGenderValue.getValue();
    }

    /**
     * <p>Business Name: Patient Gender</p>
     * 
     * <p>Relationship: REPC_MT120001CA.PatientGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to confirm the identity of the patient for the query 
     * and is therefore mandatory.</p>
     * 
     * <p>Indicates the gender (sex) of the patient.</p>
     */
    public void setPatientGenderValue(AdministrativeGender patientGenderValue) {
        this.patientGenderValue.setValue(patientGenderValue);
    }


    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: REPC_MT120001CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * patient drug contraindication query. Filter the result set 
     * to include only those records pertaining to the patient with 
     * this Id.</p>
     * 
     * <p>This must always reference a valid patient identifier 
     * (PDID) that exists in the provincial client registry.</p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientIDValue() {
        return this.patientIDValue.getValue();
    }

    /**
     * <p>Business Name: B:Patient ID</p>
     * 
     * <p>Relationship: REPC_MT120001CA.PatientID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient Id. This is a 
     * mandatory field because a patient must be specified for the 
     * query to be valid</p>
     * 
     * <p>Identifier of the patient who is the subject of the 
     * patient drug contraindication query. Filter the result set 
     * to include only those records pertaining to the patient with 
     * this Id.</p>
     * 
     * <p>This must always reference a valid patient identifier 
     * (PDID) that exists in the provincial client registry.</p>
     */
    public void setPatientIDValue(Identifier patientIDValue) {
        this.patientIDValue.setValue(patientIDValue);
    }


    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: REPC_MT120001CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     * 
     * <p>The name of the patient who is the subject of the drug 
     * contraindication query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientNameValue() {
        return this.patientNameValue.getValue();
    }

    /**
     * <p>Business Name: C:Patient Name</p>
     * 
     * <p>Relationship: REPC_MT120001CA.PatientName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows filtering of result set by patient name. This is a 
     * mandatory field because a patient name must match the 
     * patient Id for the query to be valid.</p>
     * 
     * <p>The name of the patient who is the subject of the drug 
     * contraindication query.</p><p>Filter the result set to 
     * include only those records pertaining to the patient with 
     * this name.</p>
     */
    public void setPatientNameValue(PersonName patientNameValue) {
        this.patientNameValue.setValue(patientNameValue);
    }


    /**
     * <p>Business Name: Professional Service Codes</p>
     * 
     * <p>Relationship: 
     * REPC_MT120001CA.ProfessionalServiceCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of patient professional services 
     * pertaining to specific professional service or category of 
     * professional services.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those records pertaining to the specified 
     * professional service code.</p><p>The service code may refer 
     * to a specific service or to a higher level classification 
     * professional service within the service hierarchy.</p>
     */
    @Hl7XmlMapping({"professionalServiceCode/value"})
    public List<ActProfessionalServiceCode> getProfessionalServiceCodeValue() {
        return new RawListWrapper<CV, ActProfessionalServiceCode>(professionalServiceCodeValue, CVImpl.class);
    }


    /**
     * <p>Business Name: Service Period</p>
     * 
     * <p>Relationship: REPC_MT120001CA.ServicePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of patient professional service 
     * records.</p><p>Useful for constraining run-away queries.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those professional services rendered to the 
     * patient within the indicated time-period.</p>
     */
    @Hl7XmlMapping({"servicePeriod/value"})
    public Interval<Date> getServicePeriodValue() {
        return this.servicePeriodValue.getValue();
    }

    /**
     * <p>Business Name: Service Period</p>
     * 
     * <p>Relationship: REPC_MT120001CA.ServicePeriod.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to specify the event period of 
     * interest for the retrieval of patient professional service 
     * records.</p><p>Useful for constraining run-away queries.</p>
     * 
     * <p>Indicates that the returned records should be filtered to 
     * only include those professional services rendered to the 
     * patient within the indicated time-period.</p>
     */
    public void setServicePeriodValue(Interval<Date> servicePeriodValue) {
        this.servicePeriodValue.setValue(servicePeriodValue);
    }

}
