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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.immunization.poiz_mt061150ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.VaccineType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.immunization.merged.AntigenCountBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.immunization.merged.AntigenValidityBean;



/**
 * <p>Business Name: Antigen</p>
 * 
 * <p>Important for expressing antigen validity and counts.</p>
 * 
 * <p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT061150CA.Antigen"})
public class AntigenBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();
    private ST name = new STImpl();
    private AntigenValidityBean asHealthChartSubjectOf1AntigenValidity;
    private AntigenCountBean asHealthChartSubjectOf2AntigenCount;


    /**
     * <p>Business Name: Antigen Code</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Antigen.code</p>
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
    public VaccineType getCode() {
        return (VaccineType) this.code.getValue();
    }

    /**
     * <p>Business Name: Antigen Code</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Antigen.code</p>
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
    public void setCode(VaccineType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Antigen Name</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Antigen.name</p>
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
     * <p>Business Name: Antigen Name</p>
     * 
     * <p>Relationship: POIZ_MT061150CA.Antigen.name</p>
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
     * <p>Relationship: POIZ_MT061150CA.Subject4.antigenValidity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"asHealthChart/subjectOf1/antigenValidity"})
    public AntigenValidityBean getAsHealthChartSubjectOf1AntigenValidity() {
        return this.asHealthChartSubjectOf1AntigenValidity;
    }

    /**
     * <p>Relationship: POIZ_MT061150CA.Subject4.antigenValidity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAsHealthChartSubjectOf1AntigenValidity(AntigenValidityBean asHealthChartSubjectOf1AntigenValidity) {
        this.asHealthChartSubjectOf1AntigenValidity = asHealthChartSubjectOf1AntigenValidity;
    }


    /**
     * <p>Relationship: POIZ_MT061150CA.Subject.antigenCount</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"asHealthChart/subjectOf2/antigenCount"})
    public AntigenCountBean getAsHealthChartSubjectOf2AntigenCount() {
        return this.asHealthChartSubjectOf2AntigenCount;
    }

    /**
     * <p>Relationship: POIZ_MT061150CA.Subject.antigenCount</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAsHealthChartSubjectOf2AntigenCount(AntigenCountBean asHealthChartSubjectOf2AntigenCount) {
        this.asHealthChartSubjectOf2AntigenCount = asHealthChartSubjectOf2AntigenCount;
    }

}
