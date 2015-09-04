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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.repc_mt000019ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Condition History Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response</p>
 */
@Hl7PartTypeMapping({"REPC_MT000019CA.ParameterList"})
@Hl7RootType
public class ConditionHistoryQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private II allergyIntoleranceIDValue = new IIImpl();


    /**
     * <p>Business Name: F:Allergy Intolerance Identifier</p>
     * 
     * <p>Relationship: REPC_MT000019CA.AllergyIntoleranceID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the specific allergy intolerance record to 
     * retrieve and is therefore mandatory.</p>
     * 
     * <p>Identifier of the Allergy Intolerance record to be 
     * retrieved.</p>
     */
    @Hl7XmlMapping({"allergyIntoleranceID/value"})
    public Identifier getAllergyIntoleranceIDValue() {
        return this.allergyIntoleranceIDValue.getValue();
    }

    /**
     * <p>Business Name: F:Allergy Intolerance Identifier</p>
     * 
     * <p>Relationship: REPC_MT000019CA.AllergyIntoleranceID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the specific allergy intolerance record to 
     * retrieve and is therefore mandatory.</p>
     * 
     * <p>Identifier of the Allergy Intolerance record to be 
     * retrieved.</p>
     */
    public void setAllergyIntoleranceIDValue(Identifier allergyIntoleranceIDValue) {
        this.allergyIntoleranceIDValue.setValue(allergyIntoleranceIDValue);
    }

}
