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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.AdjudicationResultRequiredActBean;



/**
 * <p><p>Select association below for required acts that do not 
 * have associated adjudication reason &amp; adjudication 
 * information codes.</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.Trigger1"})
public class Trigger1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private BL negationInd = new BLImpl();
    private AdjudicationResultRequiredActBean adjudicationResultRequiredAct;


    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    @Hl7XmlMapping({"adjudicationResultRequiredAct"})
    public AdjudicationResultRequiredActBean getAdjudicationResultRequiredAct() {
        return this.adjudicationResultRequiredAct;
    }
    public void setAdjudicationResultRequiredAct(AdjudicationResultRequiredActBean adjudicationResultRequiredAct) {
        this.adjudicationResultRequiredAct = adjudicationResultRequiredAct;
    }

}
