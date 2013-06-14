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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.iehr.repc_mt000012on.Choice;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.merged.Consenter;
import java.util.Date;



/**
 * <p>Business Name: ReportedBy</p>
 * 
 * <p>REPC_MT000003ON.Informant: c:reported by</p>
 * 
 * <p>ZPB2.5</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>REPC_MT000006ON.Informant: d:reported by</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>REPC_MT000002ON.Informant: d:reported by</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>REPC_MT000005ON.Informant: d:reported by</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>REPC_MT000007ON.Informant: reported by</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this medical condition came from. The possible 3 sources 
 * of the information are: the patient, the patient's 
 * representative or a health-care provider.</p>
 * 
 * <p>REPC_MT000001ON.Informant: d:reported by</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>REPC_MT000012ON.Informant: d:reported by</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>REPC_MT000010ON.Informant: d:reported by</p>
 * 
 * <p>ZPB2.5</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>REPC_MT000009ON.Informant: d:reported by</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>REPC_MT000014ON.Informant: b:reported by</p>
 * 
 * <p>Allows for establishment of timelines between reported 
 * date and recorded date.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>REPC_MT000013ON.Informant: d:reported by</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000001ON.Informant","REPC_MT000002ON.Informant","REPC_MT000003ON.Informant","REPC_MT000005ON.Informant","REPC_MT000006ON.Informant","REPC_MT000007ON.Informant","REPC_MT000009ON.Informant","REPC_MT000010ON.Informant","REPC_MT000012ON.Informant","REPC_MT000013ON.Informant","REPC_MT000014ON.Informant"})
public class ReportedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private TS time = new TSImpl();
    private Party party;
    private Consenter consenter;
    private Choice choice;


    /**
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000003ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the medical condition was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000006ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000002ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000005ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000001ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000007ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for establishment of timelines between condition 
     * onset date, reported date and recorded date.</p>
     * 
     * <p>The date on which the medical condition was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000012ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between reaction 
     * onset date, reported date and recorded date, and is 
     * therefore mandatory.</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000009ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000010ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the medical condition was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000013ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000014ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the medical condition was reported.</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000003ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the medical condition was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000006ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000002ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000005ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000001ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000007ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for establishment of timelines between condition 
     * onset date, reported date and recorded date.</p>
     * 
     * <p>The date on which the medical condition was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000012ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between reaction 
     * onset date, reported date and recorded date, and is 
     * therefore mandatory.</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000009ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000010ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the medical condition was reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000013ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000014ON.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>The date on which the medical condition was reported.</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000003ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000006ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000002ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000005ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000001ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000009ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000010ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000013ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000014ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"party"})
    public Party getParty() {
        return this.party;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000003ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000006ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000002ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000005ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000001ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000009ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000010ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000013ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000014ON.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setParty(Party party) {
        this.party = party;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000007ON.Informant.consenter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"consenter"})
    public Consenter getConsenter() {
        return this.consenter;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000007ON.Informant.consenter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setConsenter(Consenter consenter) {
        this.consenter = consenter;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000012ON.Informant.choice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"choice"})
    public Choice getChoice() {
        return this.choice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000012ON.Informant.choice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

}
