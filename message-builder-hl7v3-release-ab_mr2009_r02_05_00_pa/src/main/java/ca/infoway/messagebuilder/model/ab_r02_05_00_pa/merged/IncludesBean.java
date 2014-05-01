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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.coct_mt120600ca.NotesBean;



/**
 * <p>POLB_MT001001CA.Subject1: has notes</p>
 * 
 * <p>Associates notes or annotations about an action with that 
 * act object.</p>
 * 
 * <p>REPC_MT000001CA.Subject3: *c:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this allergy/intolerance.</p>
 * 
 * <p>REPC_MT000003CA.Subject3: *g:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Health Condition.</i> </p>
 * 
 * <p>POLB_MT001010CA.Subject1: has notes</p>
 * 
 * <p>Associates notes or annotations about an action with that 
 * act object.</p>
 * 
 * <p>REPC_MT000010CA.Subject3: *g:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Health Condition.</i> </p>
 * 
 * <p>REPC_MT610001CA.Subject2: l:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Professional Service.</i> </p>
 * 
 * <p>REPC_MT220001CA.Subject4: *g:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Discharge-Care Summary.</i> </p>
 * 
 * <p>REPC_MT210002CA.Subject4: *g:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Referral.</i> </p>
 * 
 * <p>PORX_MT010120CA.Subject4: k:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange uncoded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this prescription.</p>
 * 
 * <p>PORX_MT060340CA.Subject4: k:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this prescription.</p>
 * 
 * <p>COCT_MT080100CA.Subject1: has notes</p>
 * 
 * <p>To capture, communicate collector's notes.</p>
 * 
 * <p>Associates notes or annotations with the specimen 
 * collection procedure event act.</p>
 * 
 * <p>REPC_MT500001CA.Subject2: l:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Care Composition.</i> </p>
 * 
 * <p>PORX_MT020050CA.Subject7: *c:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this office supply.</p>
 * 
 * <p>PORX_MT060340CA.Subject7: k:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this dispense record.</p>
 * 
 * <p>REPC_MT230001CA.Subject4: *g:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Clinical Observation Document.</i> </p>
 * 
 * <p>REPC_MT000002CA.Subject3: *c:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this adverse reaction.</p>
 * 
 * <p>REPC_MT000005CA.Subject4: *c:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this allergy or intolerance record.</p>
 * 
 * <p>PORX_MT060010CA.Subject7: k:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this dispense record.</p>
 * 
 * <p>PORX_MT060210CA.Subject14: k:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this medication record.</p>
 * 
 * <p>POLB_MT001999CA.Subject1: has notes</p>
 * 
 * <p>Associates notes or annotations about an action with that 
 * act object.</p>
 * 
 * <p>REPC_MT500004CA.Subject2: l:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Care Composition.</i> </p>
 * 
 * <p>REPC_MT220003CA.Subject4: *g:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Discharge-Care Summary.</i> </p>
 * 
 * <p>REPC_MT000006CA.Subject3: *c:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this adverse reaction.</p>
 * 
 * <p>REPC_MT610002CA.Subject2: l:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Professional Service.</i> </p>
 * 
 * <p>PORX_MT060160CA.Subject7: k:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this dispense record.</p>
 * 
 * <p>REPC_MT420001CA.Subject: *k:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Coded Observation.</i> </p>
 * 
 * <p>PORX_MT060160CA.Subject4: k:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this prescription.</p>
 * 
 * <p>REPC_MT420003CA.Subject: *k:includes</p>
 * 
 * <p> <i>Allows for additional free-text comments to be 
 * communicated. Such notes can be added by the provider at the 
 * time the record is created and by any provider at any time 
 * after the record is created.</i> </p>
 * 
 * <p> <i>This indicates comments that providers have recorded 
 * about the Coded Observation.</i> </p>
 * 
 * <p>POLB_MT004000CA.Subject2: has notes</p>
 * 
 * <p>Associates notes or annotations with and about the target 
 * act.</p>
 * 
 * <p>PORX_MT020070CA.Subject7: i:commented on as</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers make about 
 * a particular prescription dispense.</p>
 * 
 * <p>PORX_MT060040CA.Subject7: k:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange un-coded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this dispense record.</p>
 * 
 * <p>PORX_MT010110CA.Subject4: k:includes</p>
 * 
 * <p>Improves communication between providers by allowing a 
 * mechanism to exchange uncoded free-form information.</p>
 * 
 * <p>Indicates the various comments that providers have 
 * recorded about this prescription.</p>
 * 
 * <p>POIZ_MT030060CA.Subject2: (no business name)</p>
 * 
 * <p>Supports the communication of nurses notes and other 
 * annotations to the immunization record. As a result, this 
 * association is required.</p>
 * 
 * <p>The notes associated wit
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.Subject1","FICR_MT400001CA.Subject","FICR_MT400003CA.Subject2","FICR_MT400004CA.Subject2","FICR_MT490102CA.Subject","FICR_MT490102CA.Subject2","POIZ_MT030050CA.Subject2","POIZ_MT030060CA.Subject2","POIZ_MT060150CA.Subject2","POLB_MT001000CA.Subject1","POLB_MT001001CA.Subject1","POLB_MT001010CA.Subject1","POLB_MT001999CA.Subject1","POLB_MT002000CA.Subject2","POLB_MT004000CA.Subject2","POLB_MT004100CA.Subject2","POLB_MT004200CA.Subject2","PORX_MT010110CA.Subject4","PORX_MT010120CA.Subject4","PORX_MT020050CA.Subject7","PORX_MT020060CA.Subject7","PORX_MT020070CA.Subject7","PORX_MT040010CA.Subject9","PORX_MT060010CA.Subject7","PORX_MT060040CA.Subject4","PORX_MT060040CA.Subject7","PORX_MT060090CA.Subject7","PORX_MT060160CA.Subject14","PORX_MT060160CA.Subject4","PORX_MT060160CA.Subject7","PORX_MT060210CA.Subject14","PORX_MT060340CA.Subject4","PORX_MT060340CA.Subject7","REPC_MT000001CA.Subject3","REPC_MT000002CA.Subject3","REPC_MT000003CA.Subject3","REPC_MT000005CA.Subject4","REPC_MT000006CA.Subject3","REPC_MT000009CA.Subject3","REPC_MT000010CA.Subject3","REPC_MT210001CA.Subject4","REPC_MT210002CA.Subject4","REPC_MT210003CA.Subject4","REPC_MT220001CA.Subject4","REPC_MT220002CA.Subject4","REPC_MT220003CA.Subject4","REPC_MT230001CA.Subject4","REPC_MT230002CA.Subject4","REPC_MT230003CA.Subject4","REPC_MT410001CA.Subject","REPC_MT410003CA.Subject","REPC_MT420001CA.Subject","REPC_MT420003CA.Subject","REPC_MT500001CA.Subject2","REPC_MT500004CA.Subject2","REPC_MT610001CA.Subject2","REPC_MT610002CA.Subject2"})
public class IncludesBean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private NotesBean annotation;
    private BL contextConductionInd = new BLImpl();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT001001CA.Subject1.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000003CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT001010CA.Subject1.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000010CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610001CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT490102CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Subject1.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT490102CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500001CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000002CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060210CA.Subject14.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060010CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT001999CA.Subject1.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500004CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220003CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000006CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610002CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT420001CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT420003CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004000CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004200CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220002CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT410003CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT040010CA.Subject9.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"annotation"})
    public NotesBean getAnnotation() {
        return this.annotation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT001001CA.Subject1.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000001CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000003CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT001010CA.Subject1.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000010CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610001CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220001CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT490102CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210002CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Subject1.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT490102CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500001CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020050CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000005CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000002CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060210CA.Subject14.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060010CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT001999CA.Subject1.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT500004CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220003CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000006CA.Subject3.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT610002CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT420001CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT420003CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004000CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT020070CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POLB_MT004200CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Subject2.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Subject7.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220002CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT210003CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT410003CA.Subject.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT040010CA.Subject9.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un
     * ... [rest of documentation truncated due to excessive length]
     */
    public void setAnnotation(NotesBean annotation) {
        this.annotation = annotation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }

}
