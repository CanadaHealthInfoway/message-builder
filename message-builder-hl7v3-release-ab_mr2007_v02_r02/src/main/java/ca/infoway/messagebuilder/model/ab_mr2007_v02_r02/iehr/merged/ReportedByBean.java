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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.iehr.repc_mt000012ca.Choice;
import java.util.Date;



/**
 * <p>Business Name: ReportedBy</p>
 * 
 * <p>REPC_MT000005CA.Informant: d:reported by</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>REPC_MT000001CA.Informant: d:reported by</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>REPC_MT000013CA.Informant: d:reported by</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>REPC_MT000006CA.Informant: d:reported by</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>REPC_MT000012CA.Informant: d:reported by</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>REPC_MT000009CA.Informant: d:reported by</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>REPC_MT000002CA.Informant: d:reported by</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000001CA.Informant","REPC_MT000002CA.Informant","REPC_MT000005CA.Informant","REPC_MT000006CA.Informant","REPC_MT000009CA.Informant","REPC_MT000012CA.Informant","REPC_MT000013CA.Informant"})
public class ReportedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private TS time = new TSImpl();
    private Party party;
    private Choice choice;


    /**
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000013CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000006CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000012CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Allows for establishment of timelines between reaction 
     * onset date, reported date and recorded date, and is 
     * therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000002CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000013CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedTimestamp</p>
     * 
     * <p>Relationship: REPC_MT000006CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000012CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Allows for establishment of timelines between reaction 
     * onset date, reported date and recorded date, and is 
     * therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the allergy/intolerance was 
     * reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ReportedDate</p>
     * 
     * <p>Relationship: REPC_MT000002CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     * 
     * <p>Allows for establishment of timelines between onset date, 
     * reported date and recorded date, and is therefore 
     * mandatory.</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000013CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000006CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000002CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"party"})
    public Party getParty() {
        return this.party;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000013CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000006CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000009CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000002CA.Informant.party</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setParty(Party party) {
        this.party = party;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000012CA.Informant.choice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"choice"})
    public Choice getChoice() {
        return this.choice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000012CA.Informant.choice</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

}
