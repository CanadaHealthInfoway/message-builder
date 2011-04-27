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
package ca.infoway.messagebuilder.model.common.ficr_mt610201ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT610201CA.PertinentInformation"})
public class PertinentInformationBean extends MessagePartBean {

    private II adjudicatorBillingTaxAccountId = new IIImpl();
    private CV<Code> detailTaxCode = new CVImpl<Code>();

    @Hl7XmlMapping({"adjudicatorBillingTaxAccount/id"})
    public Identifier getAdjudicatorBillingTaxAccountId() {
        return this.adjudicatorBillingTaxAccountId.getValue();
    }
    public void setAdjudicatorBillingTaxAccountId(Identifier adjudicatorBillingTaxAccountId) {
        this.adjudicatorBillingTaxAccountId.setValue(adjudicatorBillingTaxAccountId);
    }

    @Hl7XmlMapping({"adjudicatorBillingTaxAccount/code"})
    public Code getDetailTaxCode() {
        return this.detailTaxCode.getValue();
    }
    public void setDetailTaxCode(Code detailTaxCode) {
        this.detailTaxCode.setValue(detailTaxCode);
    }

}
