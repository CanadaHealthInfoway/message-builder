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
package ca.infoway.messagebuilder.model.ab_r02_04_03_imm.immunization.poiz_mt060140ab;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Immunization Query Parameters</p>
 * 
 * <p>Root class for query.</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT060140AB.ParameterList"})
@Hl7RootType
public class ImmunizationQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20140514L;
    private II immunizationEventIDValue = new IIImpl();


    /**
     * <p>Business Name: A:Immunization Event ID</p>
     * 
     * <p>Relationship: POIZ_MT060140AB.ImmunizationEventID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for filtering of queries by immuniation event ID. 
     * As a result, this attribute is mandatory.</p>
     * 
     * <p>Specifies the identifier of the immunization event</p>
     */
    @Hl7XmlMapping({"immunizationEventID/value"})
    public Identifier getImmunizationEventIDValue() {
        return this.immunizationEventIDValue.getValue();
    }

    /**
     * <p>Business Name: A:Immunization Event ID</p>
     * 
     * <p>Relationship: POIZ_MT060140AB.ImmunizationEventID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for filtering of queries by immuniation event ID. 
     * As a result, this attribute is mandatory.</p>
     * 
     * <p>Specifies the identifier of the immunization event</p>
     */
    public void setImmunizationEventIDValue(Identifier immunizationEventIDValue) {
        this.immunizationEventIDValue.setValue(immunizationEventIDValue);
    }

}
