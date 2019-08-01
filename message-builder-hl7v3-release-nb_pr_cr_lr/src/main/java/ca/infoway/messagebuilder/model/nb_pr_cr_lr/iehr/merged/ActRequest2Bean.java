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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT210001CA.ActRequest2","REPC_MT210002CA.ActRequest2","REPC_MT210003CA.ActRequest2"})
public class ActRequest2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private CD code = new CDImpl();


    /**
     * <p>Business Name: RequestedService</p>
     * 
     * <p>Un-merged Business Name: RequestedService</p>
     * 
     * <p>Relationship: REPC_MT210002CA.ActRequest2.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps to reconcile to service that is subsequently 
     * performed.</p><p> <i>This element makes use of the CD 
     * datatype because some terminologies used for the domain 
     * require use of modifiers.</i> </p><p> <i>The element uses 
     * CWE to allow for the capture of Requested Service concepts 
     * not presently supported by the approved code system(s). In 
     * this case, the human-to-human benefit of capturing 
     * additional non-coded values outweighs the penalties of 
     * capturing some information that will not be amenable to 
     * searching or categorizing.</i> </p>
     * 
     * <p>Acoded value denoting the specific service taht has been 
     * order through the referral.</p>
     * 
     * <p>Un-merged Business Name: RequestedService</p>
     * 
     * <p>Relationship: REPC_MT210003CA.ActRequest2.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps to reconcile to service that is subsequently 
     * performed.</p><p> <i>This element makes use of the CD 
     * datatype because some terminologies used for the domain 
     * require use of modifiers.</i> </p><p> <i>The element uses 
     * CWE to allow for the capture of Requested Service concepts 
     * not presently supported by the approved code system(s). In 
     * this case, the human-to-human benefit of capturing 
     * additional non-coded values outweighs the penalties of 
     * capturing some information that will not be amenable to 
     * searching or categorizing.</i> </p>
     * 
     * <p>Acoded value denoting the specific service taht has been 
     * order through the referral.</p>
     * 
     * <p>Un-merged Business Name: RequestedService</p>
     * 
     * <p>Relationship: REPC_MT210001CA.ActRequest2.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps to reconcile to service that is subsequently 
     * performed.</p><p> <i>This element makes use of the CD 
     * datatype because some terminologies used for the domain 
     * require use of modifiers.</i> </p><p> <i>The element uses 
     * CWE to allow for the capture of Requested Service concepts 
     * not presently supported by the approved code system(s). In 
     * this case, the human-to-human benefit of capturing 
     * additional non-coded values outweighs the penalties of 
     * capturing some information that will not be amenable to 
     * searching or categorizing.</i> </p>
     * 
     * <p>Acoded value denoting the specific service taht has been 
     * order through the referral.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActProfessionalServiceCode getCode() {
        return (ActProfessionalServiceCode) this.code.getValue();
    }

    /**
     * <p>Business Name: RequestedService</p>
     * 
     * <p>Un-merged Business Name: RequestedService</p>
     * 
     * <p>Relationship: REPC_MT210002CA.ActRequest2.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps to reconcile to service that is subsequently 
     * performed.</p><p> <i>This element makes use of the CD 
     * datatype because some terminologies used for the domain 
     * require use of modifiers.</i> </p><p> <i>The element uses 
     * CWE to allow for the capture of Requested Service concepts 
     * not presently supported by the approved code system(s). In 
     * this case, the human-to-human benefit of capturing 
     * additional non-coded values outweighs the penalties of 
     * capturing some information that will not be amenable to 
     * searching or categorizing.</i> </p>
     * 
     * <p>Acoded value denoting the specific service taht has been 
     * order through the referral.</p>
     * 
     * <p>Un-merged Business Name: RequestedService</p>
     * 
     * <p>Relationship: REPC_MT210003CA.ActRequest2.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps to reconcile to service that is subsequently 
     * performed.</p><p> <i>This element makes use of the CD 
     * datatype because some terminologies used for the domain 
     * require use of modifiers.</i> </p><p> <i>The element uses 
     * CWE to allow for the capture of Requested Service concepts 
     * not presently supported by the approved code system(s). In 
     * this case, the human-to-human benefit of capturing 
     * additional non-coded values outweighs the penalties of 
     * capturing some information that will not be amenable to 
     * searching or categorizing.</i> </p>
     * 
     * <p>Acoded value denoting the specific service taht has been 
     * order through the referral.</p>
     * 
     * <p>Un-merged Business Name: RequestedService</p>
     * 
     * <p>Relationship: REPC_MT210001CA.ActRequest2.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps to reconcile to service that is subsequently 
     * performed.</p><p> <i>This element makes use of the CD 
     * datatype because some terminologies used for the domain 
     * require use of modifiers.</i> </p><p> <i>The element uses 
     * CWE to allow for the capture of Requested Service concepts 
     * not presently supported by the approved code system(s). In 
     * this case, the human-to-human benefit of capturing 
     * additional non-coded values outweighs the penalties of 
     * capturing some information that will not be amenable to 
     * searching or categorizing.</i> </p>
     * 
     * <p>Acoded value denoting the specific service taht has been 
     * order through the referral.</p>
     */
    public void setCode(ActProfessionalServiceCode code) {
        this.code.setValue(code);
    }

}
