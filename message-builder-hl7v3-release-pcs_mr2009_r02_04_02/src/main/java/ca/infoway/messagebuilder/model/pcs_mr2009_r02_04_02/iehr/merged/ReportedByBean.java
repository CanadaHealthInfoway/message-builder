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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.Choice;
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
@Hl7PartTypeMapping({"REPC_MT000001CA.Informant","REPC_MT000002CA.Informant","REPC_MT000005CA.Informant","REPC_MT000006CA.Informant","REPC_MT000009CA.Informant","REPC_MT000012CA.Informant","REPC_MT000013CA.Informant"})
public class ReportedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private TS time = new TSImpl();
    private Party party;
    private Choice choice;


    /**
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


    @Hl7XmlMapping({"party"})
    public Party getParty() {
        return this.party;
    }
    public void setParty(Party party) {
        this.party = party;
    }


    @Hl7XmlMapping({"choice"})
    public Choice getChoice() {
        return this.choice;
    }
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

}
