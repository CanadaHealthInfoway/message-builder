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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.ficr_mt510201ca.AdjudicationResultRequiredActBean;



/**
 * <p>FICR_MT510201CA.Trigger2: (no business name)</p>
 * 
 * <p>Required actions apply to all associated adjudication 
 * result reason codes and adjudicate result information 
 * codes</p>
 * 
 * <p>FICR_MT510201CA.Trigger1: (no business name)</p>
 * 
 * <p>Select association below for required acts that do not 
 * have associated adjudication reason &amp; adjudication 
 * information codes.</p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.Trigger1","FICR_MT510201CA.Trigger2"})
public class Trigger2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private AdjudicationResultRequiredActBean adjudicationResultRequiredAct;
    private BL negationInd = new BLImpl();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.Trigger2.adjudicationResultRequiredAct</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.Trigger1.adjudicationResultRequiredAct</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"adjudicationResultRequiredAct"})
    public AdjudicationResultRequiredActBean getAdjudicationResultRequiredAct() {
        return this.adjudicationResultRequiredAct;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.Trigger2.adjudicationResultRequiredAct</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT510201CA.Trigger1.adjudicationResultRequiredAct</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAdjudicationResultRequiredAct(AdjudicationResultRequiredActBean adjudicationResultRequiredAct) {
        this.adjudicationResultRequiredAct = adjudicationResultRequiredAct;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT510201CA.Trigger1.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT510201CA.Trigger1.negationInd</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }

}
