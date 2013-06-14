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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt050010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Generic Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"PORX_MT050010CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private List<CV> drugCodeValue = new ArrayList<CV>();


    /**
     * <p>Business Name: Drug Codes</p>
     * 
     * <p>Relationship: PORX_MT050010CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for the retrieval of all potential 
     * contraindications that would result from drug profile 
     * scenarios.</p><p>This will most commonly be used by 
     * providers to test the viability of prescribing/dispensing 
     * medications into profile scenarios.</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those contraindications involving the specified 
     * drugs.</p><p>The codes may refer to administerable 
     * medications, orderable medications or higher level drug 
     * classifications.</p><p>The set of contraindication records 
     * retrieved would include all potential DDI between and 
     * amongst the drugs.</p>
     */
    @Hl7XmlMapping({"drugCode/value"})
    public List<ClinicalDrug> getDrugCodeValue() {
        return new RawListWrapper<CV, ClinicalDrug>(drugCodeValue, CVImpl.class);
    }

}
