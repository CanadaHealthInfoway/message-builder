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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt470000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Access Type</p>
 * 
 * <p>Defines the types of information permission is being 
 * granted to access.</p>
 * 
 * <p>Allows discrete control over different types of 
 * information.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470000CA.InformDefinition"})
public class AccessTypeBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private ConsentGivenToBean receiver;
    private List<CV> subjectActDefinitionCode = new ArrayList<CV>();


    /**
     * <p>Relationship: COCT_MT470000CA.InformDefinition.receiver</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"receiver"})
    public ConsentGivenToBean getReceiver() {
        return this.receiver;
    }

    /**
     * <p>Relationship: COCT_MT470000CA.InformDefinition.receiver</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setReceiver(ConsentGivenToBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>Business Name: B:Consent Information Types</p>
     * 
     * <p>Relationship: COCT_MT470000CA.ActDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The type of patient information that can be accessed or 
     * modified.</p>
     * 
     * <p>Different consents (or even keywords) may be needed to 
     * access different types of patient information (e.g. 
     * demographics, medications, allergies, lab results). 
     * Understanding the type of information the consent applies to 
     * is critical, and therefore the attribute is mandatory.</p>
     */
    @Hl7XmlMapping({"subject/actDefinition/code"})
    public List<ActInformationAccessTypeCode> getSubjectActDefinitionCode() {
        return new RawListWrapper<CV, ActInformationAccessTypeCode>(subjectActDefinitionCode, CVImpl.class);
    }

}
