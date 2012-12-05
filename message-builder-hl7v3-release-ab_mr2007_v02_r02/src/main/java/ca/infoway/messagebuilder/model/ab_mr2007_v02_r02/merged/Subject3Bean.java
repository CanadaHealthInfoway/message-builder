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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.domainvalue.ActMood;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT470000CA.Subject3","COCT_MT470002CA.Subject3","COCT_MT470012CA.Subject3"})
public class Subject3Bean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CV actDefinitionCode = new CVImpl();
    private CS typeCode = new CSImpl();
    private CS contextControlCode = new CSImpl();
    private CS actDefinitionClassCode = new CSImpl();
    private CS actDefinitionMoodCode = new CSImpl();


    /**
     * <p>Business Name: ConsentInformationTypes</p>
     * 
     * <p>Other Business Name: ConsentInformationTypes</p>
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
     * 
     * <p>Other Business Name: ConsentInformationTypes</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ActDefinition.code</p>
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
     * 
     * <p>Other Business Name: ConsentInformationTypes</p>
     * 
     * <p>Relationship: COCT_MT470012CA.ActDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The type of patient, client, or provider information that 
     * can be accessed or modified.</p>
     * 
     * <p>Different consents (or even keywords) may be needed to 
     * access different types of patient, client, or provider 
     * information (e.g. demographics, medications, allergies, lab 
     * results). Understanding the type of information the consent 
     * applies to is critical, and therefore the attribute is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"actDefinition/code"})
    public ActInformationAccessTypeCode getActDefinitionCode() {
        return (ActInformationAccessTypeCode) this.actDefinitionCode.getValue();
    }

    /**
     * <p>Business Name: ConsentInformationTypes</p>
     * 
     * <p>Other Business Name: ConsentInformationTypes</p>
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
     * 
     * <p>Other Business Name: ConsentInformationTypes</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ActDefinition.code</p>
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
     * 
     * <p>Other Business Name: ConsentInformationTypes</p>
     * 
     * <p>Relationship: COCT_MT470012CA.ActDefinition.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The type of patient, client, or provider information that 
     * can be accessed or modified.</p>
     * 
     * <p>Different consents (or even keywords) may be needed to 
     * access different types of patient, client, or provider 
     * information (e.g. demographics, medications, allergies, lab 
     * results). Understanding the type of information the consent 
     * applies to is critical, and therefore the attribute is 
     * mandatory.</p>
     */
    public void setActDefinitionCode(ActInformationAccessTypeCode actDefinitionCode) {
        this.actDefinitionCode.setValue(actDefinitionCode);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470002CA.Subject3.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470002CA.Subject3.typeCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470002CA.Subject3.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470002CA.Subject3.contextControlCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ActDefinition.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"actDefinition/classCode"})
    public ActClass getActDefinitionClassCode() {
        return (ActClass) this.actDefinitionClassCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ActDefinition.classCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setActDefinitionClassCode(ActClass actDefinitionClassCode) {
        this.actDefinitionClassCode.setValue(actDefinitionClassCode);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ActDefinition.moodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"actDefinition/moodCode"})
    public ActMood getActDefinitionMoodCode() {
        return (ActMood) this.actDefinitionMoodCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT470002CA.ActDefinition.moodCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setActDefinitionMoodCode(ActMood actDefinitionMoodCode) {
        this.actDefinitionMoodCode.setValue(actDefinitionMoodCode);
    }

}
