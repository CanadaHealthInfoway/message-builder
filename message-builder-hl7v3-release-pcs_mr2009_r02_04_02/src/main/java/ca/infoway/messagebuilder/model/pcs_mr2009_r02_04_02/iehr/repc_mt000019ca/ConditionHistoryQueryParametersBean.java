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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt000019ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Condition History Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT000019CA.ParameterList"})
@Hl7RootType
public class ConditionHistoryQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II allergyIntoleranceIdentifier = new IIImpl();


    /**
     * <p>F:Allergy Intolerance Identifier</p>
     * 
     * <p><p>Identifier of the Allergy Intolerance record to be 
     * retrieved.</p></p>
     * 
     * <p><p>Identifies the specific allergy intolerance record to 
     * retrieve and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"allergyIntoleranceID/value"})
    public Identifier getAllergyIntoleranceIdentifier() {
        return this.allergyIntoleranceIdentifier.getValue();
    }
    public void setAllergyIntoleranceIdentifier(Identifier allergyIntoleranceIdentifier) {
        this.allergyIntoleranceIdentifier.setValue(allergyIntoleranceIdentifier);
    }

}
