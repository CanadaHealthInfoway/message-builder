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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.porx_mt060360ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Generic Query Parameters</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 * 
 * <p>Root class for query definition</p>
 */
@Hl7PartTypeMapping({"PORX_MT060360CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private BL includeIssuesIndicatorValue = new BLImpl();
    private BL includeNotesIndicatorValue = new BLImpl();
    private II prescriptionDispenseNumberValue = new IIImpl();


    /**
     * <p>Business Name: Include Issues Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060360CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not Issues (detected and/or managed) 
     * attached to the prescription dispense record to be returned 
     * along with the detailed information.</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of patient medication data.</p><p>Because 
     * the attribute is boolean, it must explicitly indicate a 
     * 'TRUE' or 'FALSE', and thus it is mandatory.</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of patient medication data.</p><p>Because 
     * the attribute is boolean, it must explicitly indicate a 
     * 'TRUE' or 'FALSE', and thus it is mandatory.</p>
     */
    @Hl7XmlMapping({"includeIssuesIndicator/value"})
    public Boolean getIncludeIssuesIndicatorValue() {
        return this.includeIssuesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Issues Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060360CA.IncludeIssuesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not Issues (detected and/or managed) 
     * attached to the prescription dispense record to be returned 
     * along with the detailed information.</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of patient medication data.</p><p>Because 
     * the attribute is boolean, it must explicitly indicate a 
     * 'TRUE' or 'FALSE', and thus it is mandatory.</p>
     * 
     * <p>Allows for the flexibility of omitting/including issues 
     * in the retrieval of patient medication data.</p><p>Because 
     * the attribute is boolean, it must explicitly indicate a 
     * 'TRUE' or 'FALSE', and thus it is mandatory.</p>
     */
    public void setIncludeIssuesIndicatorValue(Boolean includeIssuesIndicatorValue) {
        this.includeIssuesIndicatorValue.setValue(includeIssuesIndicatorValue);
    }


    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: PORX_MT060360CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * prescription dispense record are to be returned along with 
     * the detailed information.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicatorValue() {
        return this.includeNotesIndicatorValue.getValue();
    }

    /**
     * <p>Business Name: Include Notes Indicator</p>
     * 
     * <p>Relationship: PORX_MT060360CA.IncludeNotesIndicator.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether or not notes attached to the 
     * prescription dispense record are to be returned along with 
     * the detailed information.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     * 
     * <p>Allows for the flexibility of omitting/including notes in 
     * the retrieval of information for medication detail 
     * data.</p><p>Because the attribute is boolean, it must 
     * explicitly indicate a 'TRUE' or 'FALSE', and thus it is 
     * mandatory.</p>
     */
    public void setIncludeNotesIndicatorValue(Boolean includeNotesIndicatorValue) {
        this.includeNotesIndicatorValue.setValue(includeNotesIndicatorValue);
    }


    /**
     * <p>Business Name: D:Prescription Dispense Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060360CA.PrescriptionDispenseNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies which prescription dispense record should be 
     * retrieved.</p>
     * 
     * <p>Allows for the retrieval of medication records relating 
     * to a specific dispense record. A dispense cannot be 
     * retrieved without the identifier of the record, and the 
     * attribute is therefore mandatory.</p>
     */
    @Hl7XmlMapping({"prescriptionDispenseNumber/value"})
    public Identifier getPrescriptionDispenseNumberValue() {
        return this.prescriptionDispenseNumberValue.getValue();
    }

    /**
     * <p>Business Name: D:Prescription Dispense Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060360CA.PrescriptionDispenseNumber.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies which prescription dispense record should be 
     * retrieved.</p>
     * 
     * <p>Allows for the retrieval of medication records relating 
     * to a specific dispense record. A dispense cannot be 
     * retrieved without the identifier of the record, and the 
     * attribute is therefore mandatory.</p>
     */
    public void setPrescriptionDispenseNumberValue(Identifier prescriptionDispenseNumberValue) {
        this.prescriptionDispenseNumberValue.setValue(prescriptionDispenseNumberValue);
    }

}
