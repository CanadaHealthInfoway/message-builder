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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicatedInvoiceAuthor"})
public class AdjudicatedInvoiceAuthorBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private ED<String> signatureText = new EDImpl<String>();
    private ST adjudicatorRolePlayingAdjudicatorDeviceSoftwareName = new STImpl();


    /**
     * <p>EOB signature</p>
     * 
     * <p><p>EOB signature</p></p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignatureText() {
        return this.signatureText.getValue();
    }
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }


    /**
     * <p>Adjudicator Device Software Name</p>
     * 
     * <p><p>(COB Source. Which s/w rules were used to create the 
     * COB CMET such as CPhA, NeCST. Use modifier for Invoice or 
     * PreDet</p></p>
     */
    @Hl7XmlMapping({"adjudicatorRole/playingAdjudicatorDevice/softwareName"})
    public String getAdjudicatorRolePlayingAdjudicatorDeviceSoftwareName() {
        return this.adjudicatorRolePlayingAdjudicatorDeviceSoftwareName.getValue();
    }
    public void setAdjudicatorRolePlayingAdjudicatorDeviceSoftwareName(String adjudicatorRolePlayingAdjudicatorDeviceSoftwareName) {
        this.adjudicatorRolePlayingAdjudicatorDeviceSoftwareName.setValue(adjudicatorRolePlayingAdjudicatorDeviceSoftwareName);
    }

}
