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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueManagementCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.ChangedByBean;



@Hl7PartTypeMapping({"COCT_MT260010CA.DetectedIssueManagement","COCT_MT260012CA.DetectedIssueManagement","COCT_MT260020CA.DetectedIssueManagement","COCT_MT260022CA.DetectedIssueManagement","COCT_MT260030CA.DetectedIssueManagement"})
public class IssueManagementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV managementType = new CVImpl();
    private ST managementDescription = new STImpl();
    private ChangedByBean author;


    /**
     * <p>ManagementType</p>
     * 
     * <p>A:Management Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueManagementCode getManagementType() {
        return (ActDetectedIssueManagementCode) this.managementType.getValue();
    }
    public void setManagementType(ActDetectedIssueManagementCode managementType) {
        this.managementType.setValue(managementType);
    }


    /**
     * <p>ManagementDescription</p>
     * 
     * <p>C:Management Description</p>
     */
    @Hl7XmlMapping({"text"})
    public String getManagementDescription() {
        return this.managementDescription.getValue();
    }
    public void setManagementDescription(String managementDescription) {
        this.managementDescription.setValue(managementDescription);
    }


    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }

}
