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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: CareCompositions</p>
 * 
 * <p>QUQI_MT020000CA.Component: Care Compositions</p>
 * 
 * <p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p>
 * 
 * <p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p>
 * 
 * <p>Allows linking records to encounters, condition and 
 * care-based compositions. Useful for searching and navigation 
 * of the patient's record.</p>
 * 
 * <p>MCAI_MT700211CA.Component: Care Compositions</p>
 * 
 * <p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p>
 * 
 * <p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p>
 * 
 * <p>Allows linking records to encounters, condition and 
 * care-based compositions. Useful for searching and navigation 
 * of the patient's record.</p>
 * 
 * <p>QUQI_MT120006CA.Component: Care Compositions</p>
 * 
 * <p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p>
 * 
 * <p>A care composition is a record, which summarizes the 
 * events that happened during care including who is 
 * responsible for the care provided.</p><p>Examples include 
 * encounters, health condition (episode)-based collections and 
 * general care-based collections such as &quot;gynecological 
 * care&quot;.</p>
 * 
 * <p>Allows linking records to encounters, condition and 
 * care-based compositions. Useful for searching and navigation 
 * of the patient's record.</p>
 */
@Hl7PartTypeMapping({"MCAI_MT700211CA.Component","QUQI_MT020000CA.Component","QUQI_MT120006CA.Component"})
public class CareCompositionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20131210L;
    private BL contextConductionInd = new BLImpl();
    private ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt011001ca.CareCompositionsBean patientCareProvisionEvent;
    private CS typeCode = new CSImpl();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.Component.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700211CA.Component.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.Component.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.Component.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700211CA.Component.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.Component.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700211CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"patientCareProvisionEvent"})
    public ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt011001ca.CareCompositionsBean getPatientCareProvisionEvent() {
        return this.patientCareProvisionEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700211CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.Component.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPatientCareProvisionEvent(ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt011001ca.CareCompositionsBean patientCareProvisionEvent) {
        this.patientCareProvisionEvent = patientCareProvisionEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.Component.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.Component.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.Component.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.Component.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }

}
