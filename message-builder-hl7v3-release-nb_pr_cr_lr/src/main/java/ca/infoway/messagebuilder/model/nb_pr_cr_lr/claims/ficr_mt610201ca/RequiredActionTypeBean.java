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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.domainvalue.ActAdjudicationResultActionCode;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicationResultRequiredAct"})
public class RequiredActionTypeBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private CV code = new CVImpl();


    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResultRequiredAct.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Required Action Type -e.g. print on EOB, allow override. 
     * Only specify a URL to instruct the Rx s/w vendor to pick up 
     * the form from the adjudicator's web site.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActAdjudicationResultActionCode getCode() {
        return (ActAdjudicationResultActionCode) this.code.getValue();
    }

    /**
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResultRequiredAct.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Required Action Type -e.g. print on EOB, allow override. 
     * Only specify a URL to instruct the Rx s/w vendor to pick up 
     * the form from the adjudicator's web site.</p>
     */
    public void setCode(ActAdjudicationResultActionCode code) {
        this.code.setValue(code);
    }

}
