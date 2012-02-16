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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.si.rcmr_mt010001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.ConsentGivenToBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Information Access</p>
 * 
 * <p><p>Describes the type of information access being 
 * consented to.</p></p>
 * 
 * <p><p>Allows fine-grained control over the types of 
 * information access is granted to and who is granted 
 * access.</p></p>
 */
@Hl7PartTypeMapping({"RCMR_MT010001CA.PermissionToInform"})
public class InformationAccessBean extends MessagePartBean {

    private static final long serialVersionUID = 20120215L;
    private ConsentGivenToBean receiver;
    private List<CV> subjectRecordTypeCode = new ArrayList<CV>();


    @Hl7XmlMapping({"receiver"})
    public ConsentGivenToBean getReceiver() {
        return this.receiver;
    }
    public void setReceiver(ConsentGivenToBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>B:Consent Information Types</p>
     * 
     * <p><p>The type of patient information that can be accessed 
     * or modified.</p></p>
     * 
     * <p><p>Different consents may need access to different types 
     * of patient information (e.g. demographics, medications, 
     * allergies, lab results). Understanding the type of 
     * information the consent applies to is critical to 
     * controlling access, and therefore the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"subject/recordType/code"})
    public List<ActInformationAccessTypeCode> getSubjectRecordTypeCode() {
        return new RawListWrapper<CV, ActInformationAccessTypeCode>(subjectRecordTypeCode, CVImpl.class);
    }

}
