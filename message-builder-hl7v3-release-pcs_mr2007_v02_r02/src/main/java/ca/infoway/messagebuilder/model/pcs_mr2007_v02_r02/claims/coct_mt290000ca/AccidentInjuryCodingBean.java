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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt290000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.InjuryActSite;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.InjuryObservationValue;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ObservationInjuryType;



/**
 * <p>Business Name: Accident Injury coding</p>
 * 
 * <p>Accident Information</p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.AccidentInjuryCoding"})
public class AccidentInjuryCodingBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private CV code = new CVImpl();
    private CV value = new CVImpl();
    private CV targetSiteCode = new CVImpl();


    /**
     * <p>Business Name: Observation Injury type</p>
     * 
     * <p>Relationship: COCT_MT290000CA.AccidentInjuryCoding.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Injury Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationInjuryType getCode() {
        return (ObservationInjuryType) this.code.getValue();
    }

    /**
     * <p>Business Name: Observation Injury type</p>
     * 
     * <p>Relationship: COCT_MT290000CA.AccidentInjuryCoding.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Injury Type</p>
     */
    public void setCode(ObservationInjuryType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Injury code</p>
     * 
     * <p>Relationship: COCT_MT290000CA.AccidentInjuryCoding.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Nature of Injury</p>
     */
    @Hl7XmlMapping({"value"})
    public InjuryObservationValue getValue() {
        return (InjuryObservationValue) this.value.getValue();
    }

    /**
     * <p>Business Name: Injury code</p>
     * 
     * <p>Relationship: COCT_MT290000CA.AccidentInjuryCoding.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Nature of Injury</p>
     */
    public void setValue(InjuryObservationValue value) {
        this.value.setValue(value);
    }


    /**
     * <p>Business Name: Act Injury Site</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.AccidentInjuryCoding.targetSiteCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Body Part + modifier = Side of Body</p>
     */
    @Hl7XmlMapping({"targetSiteCode"})
    public InjuryActSite getTargetSiteCode() {
        return (InjuryActSite) this.targetSiteCode.getValue();
    }

    /**
     * <p>Business Name: Act Injury Site</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.AccidentInjuryCoding.targetSiteCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Body Part + modifier = Side of Body</p>
     */
    public void setTargetSiteCode(InjuryActSite targetSiteCode) {
        this.targetSiteCode.setValue(targetSiteCode);
    }

}
