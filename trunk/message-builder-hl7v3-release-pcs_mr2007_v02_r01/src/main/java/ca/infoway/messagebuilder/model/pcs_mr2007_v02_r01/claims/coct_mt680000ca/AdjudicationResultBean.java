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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.domainvalue.ActAdjudicationCode;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicationResult"})
public class AdjudicationResultBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();
    private List<AdjudicationCodeChoice> pertinentInformationAdjudicationCodeChoice = new ArrayList<AdjudicationCodeChoice>();
    private List<AdjudicationResultReferenceBean> reference = new ArrayList<AdjudicationResultReferenceBean>();


    /**
     * <p>(Summary of the adjudication processing - as submitted, 
     * w/ adjust, refuse adjust, refuse</p>
     */
    @Hl7XmlMapping({"code"})
    public ActAdjudicationCode getCode() {
        return (ActAdjudicationCode) this.code.getValue();
    }

    /**
     * <p>(Summary of the adjudication processing - as submitted, 
     * w/ adjust, refuse adjust, refuse</p>
     */
    public void setCode(ActAdjudicationCode code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"pertinentInformation/adjudicationCodeChoice"})
    public List<AdjudicationCodeChoice> getPertinentInformationAdjudicationCodeChoice() {
        return this.pertinentInformationAdjudicationCodeChoice;
    }


    @Hl7XmlMapping({"reference"})
    public List<AdjudicationResultReferenceBean> getReference() {
        return this.reference;
    }

}
