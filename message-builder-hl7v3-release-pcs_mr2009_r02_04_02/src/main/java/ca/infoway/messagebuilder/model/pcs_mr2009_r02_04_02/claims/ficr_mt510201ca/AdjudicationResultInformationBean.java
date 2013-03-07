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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.AdjudicationResultRequiredActBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicationResultInformation"})
public class AdjudicationResultInformationBean extends MessagePartBean implements AdjudicationCodeChoice {

    private static final long serialVersionUID = 20130307L;
    private List<AdjudicationResultRequiredActBean> triggerAdjudicationResultRequiredAct = new ArrayList<AdjudicationResultRequiredActBean>();
    private ED<EncapsulatedData> value = new EDImpl<EncapsulatedData>();


    /**
     * <p>Relationship: 
     * FICR_MT510201CA.Trigger2.adjudicationResultRequiredAct</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"trigger/adjudicationResultRequiredAct"})
    public List<AdjudicationResultRequiredActBean> getTriggerAdjudicationResultRequiredAct() {
        return this.triggerAdjudicationResultRequiredAct;
    }


    /**
     * <p>Business Name: Adjudicated Result Info.</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.AdjudicationResultInformation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"value"})
    public EncapsulatedData getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: Adjudicated Result Info.</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.AdjudicationResultInformation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setValue(EncapsulatedData value) {
        this.value.setValue(value);
    }

}
