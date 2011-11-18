/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueManagementCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT980010CA.DetectedIssueManagement","PORX_MT980020CA.DetectedIssueManagement","PORX_MT980030CA.DetectedIssueManagement"})
public class IssueManagementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private TS authorTime = new TSImpl();
    private ProviderBean authorAssignedPerson;


    /**
     * <p>ManagementType</p>
     * 
     * <p>A:Management Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueManagementCode getCode() {
        return (ActDetectedIssueManagementCode) this.code.getValue();
    }
    public void setCode(ActDetectedIssueManagementCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>ManagementDescription</p>
     * 
     * <p>C:Management Description</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>ManagementDate</p>
     * 
     * <p>B:Management Date</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getAuthorTime() {
        return this.authorTime.getValue();
    }
    public void setAuthorTime(Date authorTime) {
        this.authorTime.setValue(authorTime);
    }


    @Hl7XmlMapping({"author/assignedPerson"})
    public ProviderBean getAuthorAssignedPerson() {
        return this.authorAssignedPerson;
    }
    public void setAuthorAssignedPerson(ProviderBean authorAssignedPerson) {
        this.authorAssignedPerson = authorAssignedPerson;
    }

}
