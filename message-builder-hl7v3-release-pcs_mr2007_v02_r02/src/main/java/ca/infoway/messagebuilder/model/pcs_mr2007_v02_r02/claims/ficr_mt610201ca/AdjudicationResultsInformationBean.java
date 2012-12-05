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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicationResultInformation"})
public class AdjudicationResultsInformationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.AdjudicationCodeChoice {

    private static final long serialVersionUID = 20121204L;
    private ST value = new STImpl();


    /**
     * <p>Business Name: AdjudicationInformationCode</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResultInformation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Domain is ActAdjudicationInformationCode.</p><p>A subset 
     * of these codes may be included in the COB CMET for 
     * downstream adjudicators due to privacy 
     * concerns/legislation.</p>
     */
    @Hl7XmlMapping({"value"})
    public String getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: AdjudicationInformationCode</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResultInformation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Domain is ActAdjudicationInformationCode.</p><p>A subset 
     * of these codes may be included in the COB CMET for 
     * downstream adjudicators due to privacy 
     * concerns/legislation.</p>
     */
    public void setValue(String value) {
        this.value.setValue(value);
    }

}
