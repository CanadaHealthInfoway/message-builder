/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * <p>Antigens</p>
 * 
 * <p>POIZ_MT030060CA.Antigens: Antigens</p>
 * 
 * <p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p>
 * 
 * <p>Important for expressing antigen validity and counts.</p>
 * 
 * <p>POIZ_MT030050CA.Antigens: Antigens</p>
 * 
 * <p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p>
 * 
 * <p>Important for expressing antigen validity and counts.</p>
 * 
 * <p>POIZ_MT060150CA.Antigens: Antigens</p>
 * 
 * <p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p>
 * 
 * <p>Important for expressing antigen validity and counts.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Antigens","POIZ_MT030060CA.Antigens","POIZ_MT060150CA.Antigens"})
public class AntigensBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();
    private ST name = new STImpl();
    private HealthChartBean asHealthChart;


    /**
     * <p>AntigenCode</p>
     * 
     * <p>Antigen Code</p>
     * 
     * <p>The unique code used to identify the antigen.</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalDrug getCode() {
        return (ClinicalDrug) this.code.getValue();
    }

    /**
     * <p>AntigenCode</p>
     * 
     * <p>Antigen Code</p>
     * 
     * <p>The unique code used to identify the antigen.</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     */
    public void setCode(ClinicalDrug code) {
        this.code.setValue(code);
    }


    /**
     * <p>AntigenName</p>
     * 
     * <p>Antigen Name</p>
     * 
     * <p>The name of the antigen contained within a vaccine.</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>AntigenName</p>
     * 
     * <p>Antigen Name</p>
     * 
     * <p>The name of the antigen contained within a vaccine.</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    @Hl7XmlMapping({"asHealthChart"})
    public HealthChartBean getAsHealthChart() {
        return this.asHealthChart;
    }

    public void setAsHealthChart(HealthChartBean asHealthChart) {
        this.asHealthChart = asHealthChart;
    }

}
