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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt050020ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Generic Query Parameters</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 * 
 * <p>Root class for query definition</p>
 */
@Hl7PartTypeMapping({"PORX_MT050020CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CV drugCodeValue = new CVImpl();


    /**
     * <p>Business Name: E:Drug Code</p>
     * 
     * <p>Relationship: PORX_MT050020CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those contraindications pertaining to the 
     * specified drug.</p><p>The code may refer to an 
     * administerable medication, an orderable medication or a 
     * higher level drug classification.</p><p>The contraindication 
     * records retrieve would comprise the drug-drug interactions 
     * between this specified and each of the drugs on the 
     * patient's profile, as well as drug-disease and drug-allergy 
     * contraindications that might result (based on the 
     * information on the patient's profile).</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those contraindications pertaining to the 
     * specified drug.</p><p>The code may refer to an 
     * administerable medication, an orderable medication or a 
     * higher level drug classification.</p><p>The contraindication 
     * records retrieve would comprise the drug-drug interactions 
     * between this specified and each of the drugs on the 
     * patient's profile, as well as drug-disease and drug-allergy 
     * contraindications that might result (based on the 
     * information on the patient's profile).</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those contraindications pertaining to the 
     * specified drug.</p><p>The code may refer to an 
     * administerable medication, an orderable medication or a 
     * higher level drug classification.</p><p>The contraindication 
     * records retrieve would comprise the drug-drug interactions 
     * between this specified and each of the drugs on the 
     * patient's profile, as well as drug-disease and drug-allergy 
     * contraindications that might result (based on the 
     * information on the patient's profile).</p>
     * 
     * <p>Allows for the retrieval of all potential 
     * contraindications based on a specific medication being 
     * introduced onto the patient's medication profile. 
     * Contraindications can't be found without specifying the 
     * medication, therefore this attribute is 
     * mandatory.</p><p>This will most commonly be used by 
     * providers to test the viability of prescribing/dispensing a 
     * medication to a patient (in view of the patient's existing 
     * medication profile).</p>
     * 
     * <p>Allows for the retrieval of all potential 
     * contraindications based on a specific medication being 
     * introduced onto the patient's medication profile. 
     * Contraindications can't be found without specifying the 
     * medication, therefore this attribute is 
     * mandatory.</p><p>This will most commonly be used by 
     * providers to test the viability of prescribing/dispensing a 
     * medication to a patient (in view of the patient's existing 
     * medication profile).</p>
     */
    @Hl7XmlMapping({"drugCode/value"})
    public ClinicalDrug getDrugCodeValue() {
        return (ClinicalDrug) this.drugCodeValue.getValue();
    }

    /**
     * <p>Business Name: E:Drug Code</p>
     * 
     * <p>Relationship: PORX_MT050020CA.DrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those contraindications pertaining to the 
     * specified drug.</p><p>The code may refer to an 
     * administerable medication, an orderable medication or a 
     * higher level drug classification.</p><p>The contraindication 
     * records retrieve would comprise the drug-drug interactions 
     * between this specified and each of the drugs on the 
     * patient's profile, as well as drug-disease and drug-allergy 
     * contraindications that might result (based on the 
     * information on the patient's profile).</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those contraindications pertaining to the 
     * specified drug.</p><p>The code may refer to an 
     * administerable medication, an orderable medication or a 
     * higher level drug classification.</p><p>The contraindication 
     * records retrieve would comprise the drug-drug interactions 
     * between this specified and each of the drugs on the 
     * patient's profile, as well as drug-disease and drug-allergy 
     * contraindications that might result (based on the 
     * information on the patient's profile).</p>
     * 
     * <p>Indicates that the result set is to be filtered to 
     * include only those contraindications pertaining to the 
     * specified drug.</p><p>The code may refer to an 
     * administerable medication, an orderable medication or a 
     * higher level drug classification.</p><p>The contraindication 
     * records retrieve would comprise the drug-drug interactions 
     * between this specified and each of the drugs on the 
     * patient's profile, as well as drug-disease and drug-allergy 
     * contraindications that might result (based on the 
     * information on the patient's profile).</p>
     * 
     * <p>Allows for the retrieval of all potential 
     * contraindications based on a specific medication being 
     * introduced onto the patient's medication profile. 
     * Contraindications can't be found without specifying the 
     * medication, therefore this attribute is 
     * mandatory.</p><p>This will most commonly be used by 
     * providers to test the viability of prescribing/dispensing a 
     * medication to a patient (in view of the patient's existing 
     * medication profile).</p>
     * 
     * <p>Allows for the retrieval of all potential 
     * contraindications based on a specific medication being 
     * introduced onto the patient's medication profile. 
     * Contraindications can't be found without specifying the 
     * medication, therefore this attribute is 
     * mandatory.</p><p>This will most commonly be used by 
     * providers to test the viability of prescribing/dispensing a 
     * medication to a patient (in view of the patient's existing 
     * medication profile).</p>
     */
    public void setDrugCodeValue(ClinicalDrug drugCodeValue) {
        this.drugCodeValue.setValue(drugCodeValue);
    }

}
