/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.iehr.repc_mt000012ca.Choice;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.Consenter;
import java.util.Date;



/**
 * <p>ReportedBy</p>
 * 
 * <p>REPC_MT000005CA.Informant: d:reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this information came from. The possible 3 
 * sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>The original source of the information can be 
 * important in evaluating its accuracy and importance.</p></p>
 * 
 * <p>REPC_MT000003CA.Informant: c:reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this information came from. The possible 3 
 * sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>ZPB2.5</p></p>
 * 
 * <p><p>The original source of the information can be 
 * important in evaluating its accuracy and importance.</p></p>
 * 
 * <p>REPC_MT000001CA.Informant: d:reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this information came from. The possible 3 
 * sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>The original source of the information can be 
 * important in evaluating its accuracy and importance.</p></p>
 * 
 * <p>REPC_MT000013CA.Informant: d:reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this information came from. The possible 3 
 * sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>The original source of the information can be 
 * important in evaluating its accuracy and importance.</p></p>
 * 
 * <p>REPC_MT000006CA.Informant: d:reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this information came from. The possible 3 
 * sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>The original source of the information can be 
 * important in evaluating its accuracy and importance.</p></p>
 * 
 * <p>REPC_MT000007CA.Informant: reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this medical condition came from. The possible 
 * 3 sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>The original source of the information can be 
 * important in evaluating its accuracy and importance.</p></p>
 * 
 * <p>REPC_MT000012CA.Informant: d:reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this information came from. The possible 3 
 * sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>The original source of the information can be 
 * important in evaluating its accuracy and importance.</p></p>
 * 
 * <p>REPC_MT000014CA.Informant: b:reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this information came from. The possible 3 
 * sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>Allows for establishment of timelines between reported 
 * date and recorded date.</p></p>
 * 
 * <p>REPC_MT000009CA.Informant: d:reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this information came from. The possible 3 
 * sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>The original source of the information can be 
 * important in evaluating its accuracy and importance.</p></p>
 * 
 * <p>REPC_MT000010CA.Informant: d:reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this information came from. The possible 3 
 * sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>ZPB2.5</p></p>
 * 
 * <p><p>The original source of the information can be 
 * important in evaluating its accuracy and importance.</p></p>
 * 
 * <p>REPC_MT000002CA.Informant: d:reported by</p>
 * 
 * <p><p>Indicates where the information that led to the 
 * recording of this information came from. The possible 3 
 * sources of the information are: the patient, the patient's 
 * representative or a health-care provider.</p></p>
 * 
 * <p><p>The original source of the information can be 
 * important in evaluating its accuracy and importance.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000001CA.Informant","REPC_MT000002CA.Informant","REPC_MT000003CA.Informant","REPC_MT000005CA.Informant","REPC_MT000006CA.Informant","REPC_MT000007CA.Informant","REPC_MT000009CA.Informant","REPC_MT000010CA.Informant","REPC_MT000012CA.Informant","REPC_MT000013CA.Informant","REPC_MT000014CA.Informant"})
public class ReportedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20120301L;
    private TS time = new TSImpl();
    private Party party;
    private Consenter consenter;
    private Choice choice;


    /**
     * <p>Reported Timestamp</p>
     * 
     * <p><p>The date on which the medical condition was 
     * reported.</p></p>
     * 
     * <p><p>Allows for establishment of timelines between 
     * condition onset date, reported date and recorded date.</p></p>
     * 
     * <p>Reported Date</p>
     * 
     * <p></p></p>
     * 
     * <p><p>Allows for establishment of timelines between onset 
     * date, reported date and recorded date, and is therefore 
     * mandatory.</p></p>
     * 
     * <p>Reported Date</p>
     * 
     * <p><p>The date on which the adverse reaction was 
     * reported.</p></p>
     * 
     * <p><p>Allows for establishment of timelines between onset 
     * date, reported date and recorded date, and is therefore 
     * mandatory.</p></p>
     * 
     * <p>Reported Timestamp</p>
     * 
     * <p><p>The date on which the adverse reaction was 
     * reported.</p></p>
     * 
     * <p><p>Allows for establishment of timelines between onset 
     * date, reported date and recorded date, and is therefore 
     * mandatory.</p></p>
     * 
     * <p>Reported Date</p>
     * 
     * <p><p>The date on which the medical condition was 
     * reported.</p></p>
     * 
     * <p><p>Allows for establishment of timelines between onset 
     * date, reported date and recorded date, and is therefore 
     * mandatory.</p></p>
     * 
     * <p>Reported Date</p>
     * 
     * <p><p>This is the date&nbsp;when&nbsp;the recorded 
     * allergy/intolerance was reported.</p></p>
     * 
     * <p><p>Allows for establishment of timelines between onset 
     * date, reported date and recorded date, and is therefore 
     * mandatory.</p></p>
     * 
     * <p>Reported Date</p>
     * 
     * <p><p>The date on which the allergy/intolerance was 
     * reported.</p></p>
     * 
     * <p><p>Allows for establishment of timelines between onset 
     * date, reported date and recorded date, and is therefore 
     * mandatory.</p></p>
     * 
     * <p>Reported date</p>
     * 
     * <p><p>The date on which the adverse reaction was 
     * reported.</p></p>
     * 
     * <p><p>Allows for establishment of timelines between reaction 
     * onset date, reported date and recorded date, and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><div>It can be the patient, the patient&rsquo;s 
     * representative, or a&nbsp;health-care provider.&nbsp;</div></p>
     * 
     * <p>(no business name)</p>
     * 
     * <p><div>This is the party that reported the 
     * allergy/intolerance.&nbsp;It can be the patient, the 
     * patient&rsquo;s representative, or a&nbsp;health-care 
     * provider.&nbsp;</div></p>
     * 
     * <p>(no business name)</p>
     * 
     * <p><p>This is the party that reported the 
     * alleryg/intolerance. It can be the patient, the patient's 
     * representative, or a healthcare provider.<strong> If a 
     * Patient is specified here, it must match the patient 
     * specified in IntoleranceCondition.subject or a BUS error 
     * issue will be returned.</strong></p></p>
     * 
     * <p>(no business name)</p>
     * 
     * <p><div>health-care provider.</div></p>
     */
    @Hl7XmlMapping({"party"})
    public Party getParty() {
        return this.party;
    }
    public void setParty(Party party) {
        this.party = party;
    }


    @Hl7XmlMapping({"consenter"})
    public Consenter getConsenter() {
        return this.consenter;
    }
    public void setConsenter(Consenter consenter) {
        this.consenter = consenter;
    }


    @Hl7XmlMapping({"choice"})
    public Choice getChoice() {
        return this.choice;
    }
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

}
