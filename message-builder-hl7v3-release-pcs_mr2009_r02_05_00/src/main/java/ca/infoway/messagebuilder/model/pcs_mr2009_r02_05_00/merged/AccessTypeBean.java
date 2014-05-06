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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ActInformationAccessCode;

import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: AccessType</p>
 * 
 * <p>COCT_MT470012CA.InformDefinition: Access Type</p>
 * 
 * <p>Allows discrete control over different types of 
 * information.</p>
 * 
 * <p>Defines the types of information permission is being 
 * granted to access.</p>
 * 
 * <p>COCT_MT470002CA.InformDefinition: Access Type</p>
 * 
 * <p>Allows discrete control over different types of 
 * information.</p>
 * 
 * <p>Defines the types of information permission is being 
 * granted to access.</p>
 */
@Hl7PartTypeMapping({"COCT_MT470002CA.InformDefinition","COCT_MT470012CA.InformDefinition"})
public class AccessTypeBean extends MessagePartBean {

    private static final long serialVersionUID = 20140506L;
    private ConsentGivenToBean receiver;
    private List<CV> subjectActDefinitionCode = new ArrayList<CV>();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470012CA.InformDefinition.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470002CA.InformDefinition.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"receiver"})
    public ConsentGivenToBean getReceiver() {
        return this.receiver;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470012CA.InformDefinition.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470002CA.InformDefinition.receiver</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReceiver(ConsentGivenToBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>Business Name: ConsentInformationTypes</p>
     * 
     * <p>Un-merged Business Name: ConsentInformationTypes</p>
     * 
     * <p>Relationship: COCT_MT470012CA.ActDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Different consents (or even keywords) may be needed to 
     * access different types of patient, client, or provider 
     * information (e.g. demographics, medications, allergies, lab 
     * results). Understanding the type of information the consent 
     * applies to is critical, and therefore the attribute is 
     * mandatory.</p>
     * 
     * <p>The type of patient, client, or provider information that 
     * can be accessed or modified.</p>
     * 
     * <p>Un-merged Business Name: ConsentInformationTypes</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ActDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Different consents (or even keywords) may be needed to 
     * access different types of patient information (e.g. 
     * demographics, medications, allergies, lab results). 
     * Understanding the type of information the consent applies to 
     * is critical, and therefore the attribute is mandatory.</p>
     * 
     * <p>The type of patient information that can be accessed or 
     * modified.</p>
     */
    @Hl7XmlMapping({"subject/actDefinition/code"})
    public List<ActInformationAccessCode> getSubjectActDefinitionCode() {
        return new RawListWrapper<CV, ActInformationAccessCode>(subjectActDefinitionCode, CVImpl.class);
    }

}