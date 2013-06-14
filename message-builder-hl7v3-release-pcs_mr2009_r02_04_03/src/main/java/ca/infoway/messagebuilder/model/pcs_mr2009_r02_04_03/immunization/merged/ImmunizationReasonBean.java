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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActImmunizationReason;



/**
 * <p>POIZ_MT030060CA.ImmunizationReason: (no business name)</p>
 * 
 * <p>Needed for explicitly communicating the reason why a 
 * patient was administered as vaccine.</p>
 * 
 * <p>The reason why an immunization event occurred.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.ImmunizationReason","POIZ_MT030060CA.ImmunizationReason","POIZ_MT060150CA.ImmunizationReason"})
public class ImmunizationReasonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Choice {

    private static final long serialVersionUID = 20130613L;
    private ST text = new STImpl();
    private CV reasonCode = new CVImpl();


    /**
     * <p>Business Name: ImmunizationReasonText</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReasonText</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.ImmunizationReason.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReasonText</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.ImmunizationReason.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides additional context and description relating to 
     * the reason for immunization. Not all implementations will 
     * support text. As a result, this attribute is optional.</p>
     * 
     * <p>A textual or multimedia description (or reference to a 
     * description) of the reason.</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReasonText</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.ImmunizationReason.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: ImmunizationReasonText</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReasonText</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.ImmunizationReason.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReasonText</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.ImmunizationReason.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Provides additional context and description relating to 
     * the reason for immunization. Not all implementations will 
     * support text. As a result, this attribute is optional.</p>
     * 
     * <p>A textual or multimedia description (or reference to a 
     * description) of the reason.</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReasonText</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.ImmunizationReason.text</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: ImmunizationReason</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReason</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.ImmunizationReason.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReason</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.ImmunizationReason.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows sorting and categorizing different kinds of 
     * immunization reasons. Ensures that reasons are gathered in a 
     * consistent analyzable manner. As a result, this attribute is 
     * mandatory.</p>
     * 
     * <p>A coded value denoting a reason for immunizing a 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReason</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.ImmunizationReason.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActImmunizationReason getReasonCode() {
        return (ActImmunizationReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: ImmunizationReason</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReason</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.ImmunizationReason.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReason</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.ImmunizationReason.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows sorting and categorizing different kinds of 
     * immunization reasons. Ensures that reasons are gathered in a 
     * consistent analyzable manner. As a result, this attribute is 
     * mandatory.</p>
     * 
     * <p>A coded value denoting a reason for immunizing a 
     * patient.</p>
     * 
     * <p>Un-merged Business Name: ImmunizationReason</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.ImmunizationReason.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setReasonCode(ActImmunizationReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

}
