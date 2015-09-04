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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.pome_mt010030ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Drug Query Parameters</p>
 * 
 * <p>Root class for query parameters</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"POME_MT010030CA.ParameterList"})
@Hl7RootType
public class DrugQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private CV drugCodeValue = new CVImpl();


    /**
     * <p>Business Name: B:Drug Code</p>
     * 
     * <p>Relationship: POME_MT010030CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve detail information about 
     * a specific drug product.</p>
     * 
     * <p>An identifier for a specific drug product. Types of drugs 
     * identified by drug code include: Manufactured drug, generic 
     * formulation, generic, therapeutic class, etc.</p>
     */
    @Hl7XmlMapping({"drugCode/value"})
    public ClinicalDrug getDrugCodeValue() {
        return (ClinicalDrug) this.drugCodeValue.getValue();
    }

    /**
     * <p>Business Name: B:Drug Code</p>
     * 
     * <p>Relationship: POME_MT010030CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the requester to retrieve detail information about 
     * a specific drug product.</p>
     * 
     * <p>An identifier for a specific drug product. Types of drugs 
     * identified by drug code include: Manufactured drug, generic 
     * formulation, generic, therapeutic class, etc.</p>
     */
    public void setDrugCodeValue(ClinicalDrug drugCodeValue) {
        this.drugCodeValue.setValue(drugCodeValue);
    }

}
