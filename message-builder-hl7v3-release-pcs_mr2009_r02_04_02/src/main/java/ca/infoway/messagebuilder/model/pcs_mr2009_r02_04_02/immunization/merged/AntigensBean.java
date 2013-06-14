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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Antigens</p>
 * 
 * <p>POIZ_MT030060CA.Antigens: Antigens</p>
 * 
 * <p>Important for expressing antigen validity and counts.</p>
 * 
 * <p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p>
 * 
 * <p>POIZ_MT030050CA.Antigens: Antigens</p>
 * 
 * <p>Important for expressing antigen validity and counts.</p>
 * 
 * <p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p>
 * 
 * <p>POIZ_MT060150CA.Antigens: Antigens</p>
 * 
 * <p>Important for expressing antigen validity and counts.</p>
 * 
 * <p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Antigens","POIZ_MT030060CA.Antigens","POIZ_MT060150CA.Antigens"})
public class AntigensBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CV code = new CVImpl();
    private ST name = new STImpl();
    private HealthChartBean asHealthChart;


    /**
     * <p>Business Name: AntigenCode</p>
     * 
     * <p>Un-merged Business Name: AntigenCode</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Antigens.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>The unique code used to identify the antigen.</p>
     * 
     * <p>Un-merged Business Name: AntigenCode</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Antigens.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>The unique code used to identify the antigen.</p>
     * 
     * <p>Un-merged Business Name: AntigenCode</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Antigens.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>The unique code used to identify the antigen.</p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalDrug getCode() {
        return (ClinicalDrug) this.code.getValue();
    }

    /**
     * <p>Business Name: AntigenCode</p>
     * 
     * <p>Un-merged Business Name: AntigenCode</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Antigens.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>The unique code used to identify the antigen.</p>
     * 
     * <p>Un-merged Business Name: AntigenCode</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Antigens.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>The unique code used to identify the antigen.</p>
     * 
     * <p>Un-merged Business Name: AntigenCode</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Antigens.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>The unique code used to identify the antigen.</p>
     */
    public void setCode(ClinicalDrug code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: AntigenName</p>
     * 
     * <p>Un-merged Business Name: AntigenName</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Antigens.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the antigen contained within a vaccine.</p>
     * 
     * <p>Un-merged Business Name: AntigenName</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Antigens.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the antigen contained within a vaccine.</p>
     * 
     * <p>Un-merged Business Name: AntigenName</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Antigens.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the antigen contained within a vaccine.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: AntigenName</p>
     * 
     * <p>Un-merged Business Name: AntigenName</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Antigens.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the antigen contained within a vaccine.</p>
     * 
     * <p>Un-merged Business Name: AntigenName</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Antigens.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the antigen contained within a vaccine.</p>
     * 
     * <p>Un-merged Business Name: AntigenName</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Antigens.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the antigen contained within a vaccine.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Antigens.asHealthChart</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Antigens.asHealthChart</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Antigens.asHealthChart</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"asHealthChart"})
    public HealthChartBean getAsHealthChart() {
        return this.asHealthChart;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Antigens.asHealthChart</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Antigens.asHealthChart</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Antigens.asHealthChart</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAsHealthChart(HealthChartBean asHealthChart) {
        this.asHealthChart = asHealthChart;
    }

}
