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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicatedInvoiceAuthor"})
public class AdjudicatedInvoiceAuthorBean extends MessagePartBean {

    private static final long serialVersionUID = 20150325L;
    private ED<String> signatureText = new EDImpl<String>();
    private ST adjudicatorRolePlayingAdjudicatorDeviceSoftwareName = new STImpl();


    /**
     * <p>Business Name: EOB signature</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceAuthor.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>EOB signature</p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getSignatureText() {
        return this.signatureText.getValue();
    }

    /**
     * <p>Business Name: EOB signature</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatedInvoiceAuthor.signatureText</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>EOB signature</p>
     */
    public void setSignatureText(String signatureText) {
        this.signatureText.setValue(signatureText);
    }


    /**
     * <p>Business Name: Adjudicator Device Software Name</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatorDevice.softwareName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(COB Source. Which s/w rules were used to create the COB 
     * CMET such as CPhA, NeCST. Use modifier for Invoice or 
     * PreDet</p>
     */
    @Hl7XmlMapping({"adjudicatorRole/playingAdjudicatorDevice/softwareName"})
    public String getAdjudicatorRolePlayingAdjudicatorDeviceSoftwareName() {
        return this.adjudicatorRolePlayingAdjudicatorDeviceSoftwareName.getValue();
    }

    /**
     * <p>Business Name: Adjudicator Device Software Name</p>
     * 
     * <p>Relationship: 
     * COCT_MT680000CA.AdjudicatorDevice.softwareName</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>(COB Source. Which s/w rules were used to create the COB 
     * CMET such as CPhA, NeCST. Use modifier for Invoice or 
     * PreDet</p>
     */
    public void setAdjudicatorRolePlayingAdjudicatorDeviceSoftwareName(String adjudicatorRolePlayingAdjudicatorDeviceSoftwareName) {
        this.adjudicatorRolePlayingAdjudicatorDeviceSoftwareName.setValue(adjudicatorRolePlayingAdjudicatorDeviceSoftwareName);
    }

}
