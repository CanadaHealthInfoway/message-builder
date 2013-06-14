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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Patient consent</p>
 * 
 * <p>Information about the patient's consent.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.Subject"})
public class PatientConsentBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private ST signatureText = new STImpl();
    private BL patientConsent = new BLImpl(false);


    /**
     * <p>Business Name: Patient Keyword</p>
     * 
     * <p>Relationship: FICR_MT600201CA.Subject.signatureText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The keyword used by the Patient to indicate signature or 
     * consent.</p>
     * 
     * <p>Patient Keyword</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignatureText() {
        return this.signatureText.getValue();
    }

    /**
     * <p>Business Name: Patient Keyword</p>
     * 
     * <p>Relationship: FICR_MT600201CA.Subject.signatureText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The keyword used by the Patient to indicate signature or 
     * consent.</p>
     * 
     * <p>Patient Keyword</p>
     */
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }


    /**
     * <p>Relationship: FICR_MT600201CA.Subject.patientConsent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"patientConsent"})
    public Boolean getPatientConsent() {
        return this.patientConsent.getValue();
    }

    /**
     * <p>Relationship: FICR_MT600201CA.Subject.patientConsent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPatientConsent(Boolean patientConsent) {
        this.patientConsent.setValue(patientConsent);
    }

}
