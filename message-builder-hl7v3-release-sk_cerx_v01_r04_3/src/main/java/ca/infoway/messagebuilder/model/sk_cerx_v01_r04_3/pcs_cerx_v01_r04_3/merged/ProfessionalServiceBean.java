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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt090107ca.ProviderBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>ProfessionalService</p>
 * 
 * <p>REPC_MT000017CA.ProcedureEvent: Professional Service</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * information that is recorded and maintained on a 
 * consultative service provided to a patient. This service may 
 * or may not be related to a prescribed, dispensed or 
 * administered drug.</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May be 
 * pertinent information with respect to a patient's drug 
 * therapy regime.</p></p>
 * 
 * <p>REPC_MT100001CA.ProcedureEvent: Professional Service</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * information that is recorded and maintained on a 
 * consultative service provided to a patient. This service may 
 * or may not be related to a prescribed, dispensed or 
 * administered drug.</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May be 
 * pertinent information with respect to a patient's drug 
 * therapy regime.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000017CA.ProcedureEvent","REPC_MT100001CA.ProcedureEvent"})
@Hl7RootType
public class ProfessionalServiceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private CV serviceCode = new CVImpl();
    private IVL<TS, Interval<Date>> consultationTimeAndLength = new IVLImpl<TS, Interval<Date>>();
    private CV professionalServiceMaskingIndicator = new CVImpl();
    private OrderForServiceBean inFulfillmentOfActRequest;
    private Patient_1Bean subjectPatient;
    private List<CommentBean> subjectOf2Annotation = new ArrayList<CommentBean>();
    private II serviceRecordIdentifier = new IIImpl();
    private RecordedAtBean location;
    private ProviderBean performerAssignedPerson;
    private ProviderBean responsiblePartyAssignedPerson;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);


    /**
     * <p>ServiceCode</p>
     * 
     * <p>B:Service Code</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
     * the specific service that has been performed. This is 
     * obtained from the professional service catalog pertaining to 
     * the discipline of the health service provider.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.category</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D57</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2 
     * (experience handled as qualifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.436-E1 (code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.407-D7 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.459-ER 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.418-DI 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.474-8E 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.category</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D57</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2 
     * (experience handled as qualifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.436-E1 (code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.407-D7 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.459-ER 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.418-DI 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.474-8E 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.category</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D57</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2 
     * (experience handled as qualifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.436-E1 (code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.407-D7 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.459-ER 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.418-DI 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.474-8E 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.category</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D57</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2 
     * (experience handled as qualifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.436-E1 (code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.407-D7 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.459-ER 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.418-DI 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.474-8E 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.category</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D57</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2 
     * (experience handled as qualifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.436-E1 (code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.407-D7 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.459-ER 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.418-DI 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.474-8E 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.category</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D57</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2 
     * (experience handled as qualifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.436-E1 (code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.407-D7 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.459-ER 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.418-DI 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.474-8E 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.category</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D57</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2 
     * (experience handled as qualifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.436-E1 (code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.407-D7 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.459-ER 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.418-DI 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.474-8E 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.category</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D57</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2 
     * (experience handled as qualifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.436-E1 (code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.407-D7 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.459-ER 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.418-DI 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.474-8E 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.category</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D57</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2 
     * (experience handled as qualifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.436-E1 (code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.407-D7 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.459-ER 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.418-DI 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.474-8E 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.category</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D57</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2 
     * (experience handled as qualifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.436-E1 (code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.407-D7 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.459-ER 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.418-DI 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.474-8E 
     * (modifier)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * service to be sorted and filtered. Ensures consistency for 
     * analysis and reporting purposes and is therefore 
     * mandatory</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActProfessionalServiceCode getServiceCode() {
        return (ActProfessionalServiceCode) this.serviceCode.getValue();
    }
    public void setServiceCode(ActProfessionalServiceCode serviceCode) {
        this.serviceCode.setValue(serviceCode);
    }


    /**
     * <p>ConsultationTimeAndLength</p>
     * 
     * <p>C:Consultation Time and Length</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date and 
     * time on which the professional service was performed, as 
     * well as the duration of the service.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.eventTime(Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patientConsultation.eventDuration(Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.4 
     * (center)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2(timing 
     * portion of code set)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.457-EP</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.eventTime(Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patientConsultation.eventDuration(Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.4 
     * (center)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2(timing 
     * portion of code set)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.457-EP</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.eventTime(Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patientConsultation.eventDuration(Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.4 
     * (center)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2(timing 
     * portion of code set)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.457-EP</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.eventTime(Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patientConsultation.eventDuration(Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.4 
     * (center)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2(timing 
     * portion of code set)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.457-EP</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.eventTime(Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patientConsultation.eventDuration(Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.4 
     * (center)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2(timing 
     * portion of code set)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.457-EP</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.eventTime(Low)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patientConsultation.eventDuration(Width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.4 
     * (center)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.5.2(timing 
     * portion of code set)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.457-EP</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * service-event to be located in a particular time. Because a 
     * time won't always be known, the attribute is only marked as 
     * &quot;populated&quot;. The duration of the consultation may 
     * also be of clinical interest.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getConsultationTimeAndLength() {
        return this.consultationTimeAndLength.getValue();
    }
    public void setConsultationTimeAndLength(Interval<Date> consultationTimeAndLength) {
        this.consultationTimeAndLength.setValue(consultationTimeAndLength);
    }


    /**
     * <p>ProfessionalServiceMaskingIndicator</p>
     * 
     * <p>D:Professional Service Masking Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent of the patient to restrict access to their 
     * professional service record. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information. Valid values are: 'NORMAL' 
     * (denotes 'Not Masked'); and 'RESTRICTED' (denotes 'Masked'). 
     * The default is 'NORMAL' signifying 'Not Masked'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * medication data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * medication data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p>D:Professional Service Masking Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent of the patient to restrict access to their 
     * professional service records. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information. Valid values are: 
     * 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' (denotes 
     * 'Masked'). The default is 'NORMAL' signifying 'Not 
     * Masked'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * medication data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * medication data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getProfessionalServiceMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.professionalServiceMaskingIndicator.getValue();
    }
    public void setProfessionalServiceMaskingIndicator(x_VeryBasicConfidentialityKind professionalServiceMaskingIndicator) {
        this.professionalServiceMaskingIndicator.setValue(professionalServiceMaskingIndicator);
    }


    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public OrderForServiceBean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }
    public void setInFulfillmentOfActRequest(OrderForServiceBean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    @Hl7XmlMapping({"subject/patient"})
    public Patient_1Bean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(Patient_1Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"subjectOf/annotation","subjectOf2/annotation"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="REPC_MT000017CA.Subject2"),
        @Hl7MapByPartType(name="subjectOf/annotation", type="COCT_MT120600CA.Annotation"),
        @Hl7MapByPartType(name="subjectOf2", type="REPC_MT100001CA.Subject2"),
        @Hl7MapByPartType(name="subjectOf2/annotation", type="COCT_MT120600CA.Annotation")})
    public List<CommentBean> getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }


    /**
     * <p>ServiceRecordIdentifier</p>
     * 
     * <p>A:Service Record Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A unique 
     * identifier for a patient consultation service record.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.patientConsultationkey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.externalId</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.patientConsultationkey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.externalId</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.patientConsultationkey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.externalId</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.patientConsultationkey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.externalId</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.patientConsultationkey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.externalId</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.patientConsultationkey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.externalId</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.patientConsultationkey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.externalId</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.patientConsultationkey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PatientConsultation.externalId</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZRV.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.455-EM 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.402-D2 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillableClinicalService</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * cognitive services to be uniquely referenced and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getServiceRecordIdentifier() {
        return this.serviceRecordIdentifier.getValue();
    }
    public void setServiceRecordIdentifier(Identifier serviceRecordIdentifier) {
        this.serviceRecordIdentifier.setValue(serviceRecordIdentifier);
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"performer/assignedPerson"})
    public ProviderBean getPerformerAssignedPerson() {
        return this.performerAssignedPerson;
    }
    public void setPerformerAssignedPerson(ProviderBean performerAssignedPerson) {
        this.performerAssignedPerson = performerAssignedPerson;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }

}
