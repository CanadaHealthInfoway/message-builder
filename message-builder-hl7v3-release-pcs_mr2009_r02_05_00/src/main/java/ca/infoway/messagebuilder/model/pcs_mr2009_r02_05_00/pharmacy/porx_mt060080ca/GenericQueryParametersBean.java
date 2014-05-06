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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pharmacy.porx_mt060080ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pharmacy.merged.PrescriptionOrderNumberBean;



/**
 * <p>Business Name: Generic Query Parameters</p>
 * 
 * <p>Root class for query definition</p>
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060080CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20140506L;
    private CV issueFilterCodeValue = new CVImpl();
    private PrescriptionOrderNumberBean prescriptionOrderNumber;


    /**
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060080CA.IssueFilterCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>By filtering returned records to include only those which 
     * have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p>
     * 
     * <p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p>
     */
    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCodeValue() {
        return (IssueFilterCode) this.issueFilterCodeValue.getValue();
    }

    /**
     * <p>Business Name: Issue Filter Code</p>
     * 
     * <p>Relationship: PORX_MT060080CA.IssueFilterCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>By filtering returned records to include only those which 
     * have unmanaged issues or any issues at all, allows a 
     * provider to focus on those aspects of care where extra 
     * attention is needed. Because the attribute must be known, it 
     * is mandatory.</p>
     * 
     * <p>Indicates whether records to be returned (e.g. 
     * prescription order, prescription dispense and/or other 
     * medication) should be filtered to those with at least one 
     * persistent un-managed issue (against the record), with at 
     * least one persistent issues or should return all records, 
     * independent of the presence of persistent issues.</p>
     */
    public void setIssueFilterCodeValue(IssueFilterCode issueFilterCodeValue) {
        this.issueFilterCodeValue.setValue(issueFilterCodeValue);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060080CA.ParameterList.prescriptionOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"prescriptionOrderNumber"})
    public PrescriptionOrderNumberBean getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060080CA.ParameterList.prescriptionOrderNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPrescriptionOrderNumber(PrescriptionOrderNumberBean prescriptionOrderNumber) {
        this.prescriptionOrderNumber = prescriptionOrderNumber;
    }

}
