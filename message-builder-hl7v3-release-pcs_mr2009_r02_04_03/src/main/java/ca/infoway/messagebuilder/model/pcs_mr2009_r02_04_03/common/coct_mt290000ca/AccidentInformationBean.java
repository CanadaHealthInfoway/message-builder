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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt290000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.InjuryActSite;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.InjuryObservationValue;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ObservationInjuryType;



@Hl7PartTypeMapping({"COCT_MT290000CA.AccidentInformation"})
public class AccidentInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private INT sequenceNumber = new INTImpl();
    private CV accidentInjuryCodingCode = new CVImpl();
    private CV accidentInjuryCodingValue = new CVImpl();
    private CV accidentInjuryCodingTargetSiteCode = new CVImpl();


    /**
     * <p>Business Name: Injury coding priority</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.AccidentInformation.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Sets of injury observations are tied together with the 
     * same sequence number</p>
     * 
     * <p>Used for more than one set of injury coding.</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: Injury coding priority</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.AccidentInformation.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Sets of injury observations are tied together with the 
     * same sequence number</p>
     * 
     * <p>Used for more than one set of injury coding.</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
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
    @Hl7XmlMapping({"accidentInjuryCoding/code"})
    public ObservationInjuryType getAccidentInjuryCodingCode() {
        return (ObservationInjuryType) this.accidentInjuryCodingCode.getValue();
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
    public void setAccidentInjuryCodingCode(ObservationInjuryType accidentInjuryCodingCode) {
        this.accidentInjuryCodingCode.setValue(accidentInjuryCodingCode);
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
    @Hl7XmlMapping({"accidentInjuryCoding/value"})
    public InjuryObservationValue getAccidentInjuryCodingValue() {
        return (InjuryObservationValue) this.accidentInjuryCodingValue.getValue();
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
    public void setAccidentInjuryCodingValue(InjuryObservationValue accidentInjuryCodingValue) {
        this.accidentInjuryCodingValue.setValue(accidentInjuryCodingValue);
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
    @Hl7XmlMapping({"accidentInjuryCoding/targetSiteCode"})
    public InjuryActSite getAccidentInjuryCodingTargetSiteCode() {
        return (InjuryActSite) this.accidentInjuryCodingTargetSiteCode.getValue();
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
    public void setAccidentInjuryCodingTargetSiteCode(InjuryActSite accidentInjuryCodingTargetSiteCode) {
        this.accidentInjuryCodingTargetSiteCode.setValue(accidentInjuryCodingTargetSiteCode);
    }

}
