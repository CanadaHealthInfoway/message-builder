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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionNotAllowedReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010120CA.SubstitutionPermission","PORX_MT060160CA.SubstitutionPermission","PORX_MT060340CA.SubstitutionPermission"})
public class AllowedSubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private BL negationInd = new BLImpl();
    private CV reasonCode = new CVImpl();


    /**
     * <p>A:Substitution Not Allowed?</p>
     * 
     * <p>A:Substitution Not Allowed Indicator</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>B:Substitution Not Allowed Reason</p>
     * 
     * <p>Not Allowed Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionNotAllowedReason getReasonCode() {
        return (SubstanceAdminSubstitutionNotAllowedReason) this.reasonCode.getValue();
    }
    public void setReasonCode(SubstanceAdminSubstitutionNotAllowedReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

}
