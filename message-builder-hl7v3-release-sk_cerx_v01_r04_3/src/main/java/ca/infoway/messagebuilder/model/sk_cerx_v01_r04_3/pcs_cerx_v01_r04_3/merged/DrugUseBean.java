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

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>DrugUse</p>
 * 
 * <p>PORX_MT060340CA.WorkingListEvent: Drug Use</p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Categorization of 
 * prescriptions based on the intended duration of the 
 * prescribed therapy.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
 * establishing compliance for drug renewals and refills.</p></p>
 * 
 * <p>PORX_MT060160CA.WorkingListEvent: Drug Use</p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Categorization of 
 * prescriptions based on the intended duration of the 
 * prescribed therapy.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
 * establishing compliance for drug renewals and refills.</p></p>
 * 
 * <p>PORX_MT030040CA.WorkingListEvent: Drug Use</p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Categorization of 
 * prescriptions based on the intended duration of the 
 * prescribed therapy.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
 * establishing compliance for drug renewals and refills.</p></p>
 * 
 * <p>PORX_MT060190CA.WorkingListEvent: Drug Use</p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">Categorization of 
 * prescriptions based on the intended duration of the 
 * prescribed therapy.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
 * establishing compliance for drug renewals and refills.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.WorkingListEvent","PORX_MT030040CA.WorkingListEvent","PORX_MT060160CA.WorkingListEvent","PORX_MT060190CA.WorkingListEvent","PORX_MT060340CA.WorkingListEvent"})
public class DrugUseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private CV code = new CVImpl();


    /**
     * <p>D:Treatment Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Describes 
     * the categorization of the therapy envisioned by this 
     * prescription (e.g. Continuous/Chronic, Short-Term/Acute and 
     * &quot;As-Needed).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Prescription 
     * type PIN:Prescription.drugUseIndicator</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * categorizing prescription for presentation. May influence 
     * detection of duplicate therapy. May also be used to affect 
     * how DUR processing is completed. The field is marked as 
     * &quot;populated&quot; because the intended duration of the 
     * therapy should generally be known at prescribe time. However 
     * in some circumstances, it may not be known whether a therapy 
     * will be short-term or long-term.</p></p>
     * 
     * <p>D:Treatment Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Describes 
     * the categorization of the therapy envisioned by this 
     * prescription (e.g. Continuous/Chronic, Short-Term/Acute and 
     * &quot;As-Needed).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Prescription 
     * type</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.drugUseIndicator</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Prescription 
     * type</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.drugUseIndicator</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * categorizing prescription for presentation. May influence 
     * detection of duplicate therapy. May also be used to affect 
     * how DUR processing is completed. The field is marked as 
     * &quot;populated&quot; because the intended duration of the 
     * therapy should generally be known at prescribe time. However 
     * in some circumstances, it may not be known whether a therapy 
     * will be short-term or long-term.</p></p>
     * 
     * <p>D:Treatment Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Describes 
     * the categorization of the therapy envisioned by this 
     * prescription (e.g Continuous/Chronic, Short-Term/Acute and 
     * &quot;As-Needed).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Prescription 
     * type</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.drugUseIndicator</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Prescription 
     * type</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.drugUseIndicator</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * categorizing prescription for presentation. May influence 
     * detection of duplicate therapy. May also be used to affect 
     * how DUR processing is completed.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The field is 
     * marked as &quot;populated&quot; because the intended 
     * duration of the therapy should generally be known at 
     * prescribe time. However in some circumstances, it may not be 
     * known whether a therapy will be short-term or long-term.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * categorizing prescription for presentation. May influence 
     * detection of duplicate therapy. May also be used to affect 
     * how DUR processing is completed.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The field is 
     * marked as &quot;populated&quot; because the intended 
     * duration of the therapy should generally be known at 
     * prescribe time. However in some circumstances, it may not be 
     * known whether a therapy will be short-term or long-term.</p></p>
     * 
     * <p>D:Prescription Treatment Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Describes 
     * the categorization of the therapy envisioned by this 
     * prescription (e.g. Continuous/Chronic, Short-Term/Acute and 
     * &quot;As-Needed).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Prescription 
     * type</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.drugUseIndicator</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Prescription 
     * type</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.drugUseIndicator</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * categorizing prescription for presentation. May influence 
     * detection of duplicate therapy. May also be used to affect 
     * how DUR processing is completed. The field is marked as 
     * &quot;populated&quot; because the intended duration of the 
     * therapy should generally be known at prescribe time. However 
     * in some circumstances, it may not be known whether a therapy 
     * will be short-term or long-term.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActTherapyDurationWorkingListCode getCode() {
        return (ActTherapyDurationWorkingListCode) this.code.getValue();
    }
    public void setCode(ActTherapyDurationWorkingListCode code) {
        this.code.setValue(code);
    }

}
