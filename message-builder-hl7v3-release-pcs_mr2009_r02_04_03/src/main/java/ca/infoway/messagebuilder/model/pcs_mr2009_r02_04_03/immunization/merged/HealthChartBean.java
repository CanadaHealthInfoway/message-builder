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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POIZ_MT030050CA.HealthChart","POIZ_MT030060CA.HealthChart","POIZ_MT060150CA.HealthChart"})
public class HealthChartBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private AntigenValidityBean subjectOf1AntigenValidity;
    private INT subjectOf2AntigenCountValue = new INTImpl();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Subject4.antigenValidity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Subject4.antigenValidity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Subject4.antigenValidity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/antigenValidity"})
    public AntigenValidityBean getSubjectOf1AntigenValidity() {
        return this.subjectOf1AntigenValidity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.Subject4.antigenValidity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Subject4.antigenValidity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Subject4.antigenValidity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1AntigenValidity(AntigenValidityBean subjectOf1AntigenValidity) {
        this.subjectOf1AntigenValidity = subjectOf1AntigenValidity;
    }


    /**
     * <p>Business Name: AntigenCountValue</p>
     * 
     * <p>Un-merged Business Name: AntigenCountValue</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AntigenCount.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to communicate the 
     * current antigen count value.</p>
     * 
     * <p>Represents the asserted antigen count.</p>
     * 
     * <p>Un-merged Business Name: AntigenCountValue</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AntigenCount.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to communicate the 
     * current antigen count value.</p>
     * 
     * <p>Represents the asserted antigen count.</p>
     * 
     * <p>Un-merged Business Name: AntigenCountValue</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AntigenCount.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to communicate the 
     * current antigen count value.</p>
     * 
     * <p>Represents the asserted antigen count.</p>
     */
    @Hl7XmlMapping({"subjectOf2/antigenCount/value"})
    public Integer getSubjectOf2AntigenCountValue() {
        return this.subjectOf2AntigenCountValue.getValue();
    }

    /**
     * <p>Business Name: AntigenCountValue</p>
     * 
     * <p>Un-merged Business Name: AntigenCountValue</p>
     * 
     * <p>Relationship: POIZ_MT060150CA.AntigenCount.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to communicate the 
     * current antigen count value.</p>
     * 
     * <p>Represents the asserted antigen count.</p>
     * 
     * <p>Un-merged Business Name: AntigenCountValue</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.AntigenCount.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to communicate the 
     * current antigen count value.</p>
     * 
     * <p>Represents the asserted antigen count.</p>
     * 
     * <p>Un-merged Business Name: AntigenCountValue</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.AntigenCount.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for an immunization registry to communicate the 
     * current antigen count value.</p>
     * 
     * <p>Represents the asserted antigen count.</p>
     */
    public void setSubjectOf2AntigenCountValue(Integer subjectOf2AntigenCountValue) {
        this.subjectOf2AntigenCountValue.setValue(subjectOf2AntigenCountValue);
    }

}
