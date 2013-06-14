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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.Subject3","FICR_MT400003CA.Subject","FICR_MT400003CA.Subject3","FICR_MT400004CA.Subject","FICR_MT400004CA.Subject3","FICR_MT490101CA.Subject3","FICR_MT490102CA.Subject3","FICR_MT490102CA.Subject4"})
public class Subject3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private BL negationInd = new BLImpl();
    private SpecialAuthorizationChoice specialAuthorizationChoice;


    /**
     * <p>Business Name: IncludesExcludesProduct</p>
     * 
     * <p>Un-merged Business Name: IncludesExcludesProduct</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Subject.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: IncludesExcludesProduct</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Subject.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: IncludesExcludesProduct</p>
     * 
     * <p>Relationship: FICR_MT490102CA.Subject4.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: IncludesExcludesProduct</p>
     * 
     * <p>Un-merged Business Name: IncludesExcludesProduct</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Subject.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: IncludesExcludesProduct</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Subject.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: IncludesExcludesProduct</p>
     * 
     * <p>Relationship: FICR_MT490102CA.Subject4.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.Subject.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.Subject.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.Subject4.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"specialAuthorizationChoice"})
    public SpecialAuthorizationChoice getSpecialAuthorizationChoice() {
        return this.specialAuthorizationChoice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.Subject.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.Subject.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.Subject4.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSpecialAuthorizationChoice(SpecialAuthorizationChoice specialAuthorizationChoice) {
        this.specialAuthorizationChoice = specialAuthorizationChoice;
    }

}
