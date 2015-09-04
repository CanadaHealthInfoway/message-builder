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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.LabResultReportingProcessStepCode;



/**
 * <p>POLB_MT004200CA.ResultStatusProcessStep: Result Status</p>
 * 
 * <p>Used to designate &quot;preliminary&quot; and 
 * &quot;final&quot; result statuses.</p>
 * 
 * <p>POLB_MT004100CA.ResultStatusProcessStep: Result Status 
 * Process Step</p>
 * 
 * <p>Used to communicate report &quot;preliminary&quot; and 
 * &quot;final&quot; result statuses.</p>
 */
@Hl7PartTypeMapping({"POLB_MT002000CA.ResultStatusProcessStep","POLB_MT004000CA.ResultStatusProcessStep","POLB_MT004100CA.ResultStatusProcessStep","POLB_MT004200CA.ResultStatusProcessStep"})
public class ResultStatusProcessStepBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private CD code = new CDImpl();


    /**
     * <p>Business Name: ResultStatusProcessStepCode</p>
     * 
     * <p>Un-merged Business Name: ResultStatusProcessStepCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     * 
     * <p>Un-merged Business Name: ResultStatusProcessStepCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT002000CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Preliminary or Final.</p>
     * 
     * <p>Un-merged Business Name: ResultStatusProcessStepCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     * 
     * <p>Un-merged Business Name: ResultStatusProcessStepCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     */
    @Hl7XmlMapping({"code"})
    public LabResultReportingProcessStepCode getCode() {
        return (LabResultReportingProcessStepCode) this.code.getValue();
    }

    /**
     * <p>Business Name: ResultStatusProcessStepCode</p>
     * 
     * <p>Un-merged Business Name: ResultStatusProcessStepCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004000CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     * 
     * <p>Un-merged Business Name: ResultStatusProcessStepCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT002000CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Preliminary or Final.</p>
     * 
     * <p>Un-merged Business Name: ResultStatusProcessStepCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004200CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     * 
     * <p>Un-merged Business Name: ResultStatusProcessStepCode</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.ResultStatusProcessStep.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to designate &quot;preliminary&quot; and 
     * &quot;final&quot; result statuses.</p>
     */
    public void setCode(LabResultReportingProcessStepCode code) {
        this.code.setValue(code);
    }

}
