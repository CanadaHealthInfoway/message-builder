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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActAdjudicationResultsActionType;



/**
 * <p>Id allows for consolidating identical required acts on 1 
 * form</p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicationResultRequiredAct"})
public class AdjudicationResultRequiredActBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CV code = new CVImpl();
    private FormBean directTargetFormRolePlayingForm;


    /**
     * <p>Business Name: Required Action Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.AdjudicationResultRequiredAct.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActAdjudicationResultsActionType getCode() {
        return (ActAdjudicationResultsActionType) this.code.getValue();
    }

    /**
     * <p>Business Name: Required Action Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.AdjudicationResultRequiredAct.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActAdjudicationResultsActionType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: FICR_MT510201CA.FormRole.playingForm</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"directTarget/formRole/playingForm"})
    public FormBean getDirectTargetFormRolePlayingForm() {
        return this.directTargetFormRolePlayingForm;
    }

    /**
     * <p>Relationship: FICR_MT510201CA.FormRole.playingForm</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setDirectTargetFormRolePlayingForm(FormBean directTargetFormRolePlayingForm) {
        this.directTargetFormRolePlayingForm = directTargetFormRolePlayingForm;
    }

}
