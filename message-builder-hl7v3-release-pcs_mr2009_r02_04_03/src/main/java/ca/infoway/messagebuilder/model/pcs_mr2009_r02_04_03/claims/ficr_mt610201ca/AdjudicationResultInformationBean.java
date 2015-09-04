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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicationResultInformation"})
public class AdjudicationResultInformationBean extends MessagePartBean implements AdjudicationCodeChoice {

    private static final long serialVersionUID = 20150903L;
    private ED<EncapsulatedData> value = new EDImpl<EncapsulatedData>();


    /**
     * <p>Business Name: Adjudicated result information</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResultInformation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"value"})
    public EncapsulatedData getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: Adjudicated result information</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.AdjudicationResultInformation.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setValue(EncapsulatedData value) {
        this.value.setValue(value);
    }

}
