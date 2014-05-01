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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.polb_mt004100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.domainvalue.CultureObservationCode;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.lab.merged.ResultStatusProcessStepBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Organism Identificaton Observations</p>
 * 
 * <p>Describes the observation associated with the 
 * identification of the organism.</p>
 */
@Hl7PartTypeMapping({"POLB_MT004100CA.OrganismIdentificationEvent"})
public class OrganismIdentificatonObservationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private IsolateParticipationBean specimen;
    private List<IncludesBean> subjectOf1 = new ArrayList<IncludesBean>();
    private ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep;


    /**
     * <p>Business Name: Organism Identification Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.OrganismIdentificationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Describes the type of organism identification observation 
     * and is bound to the LOINC code domain (e.g. 612-2).</p>
     */
    @Hl7XmlMapping({"code"})
    public CultureObservationCode getCode() {
        return (CultureObservationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Organism Identification Type</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.OrganismIdentificationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Describes the type of organism identification observation 
     * and is bound to the LOINC code domain (e.g. 612-2).</p>
     */
    public void setCode(CultureObservationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Organsim Identification Observation Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.OrganismIdentificationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Status associated with the organism identification 
     * observation.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Organsim Identification Observation Status</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.OrganismIdentificationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Status associated with the organism identification 
     * observation.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Organism Observation Effective Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.OrganismIdentificationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Effective time of the Organism Observation.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Organism Observation Effective Time</p>
     * 
     * <p>Relationship: 
     * POLB_MT004100CA.OrganismIdentificationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Effective time of the Organism Observation.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: 
     * POLB_MT004100CA.OrganismIdentificationEvent.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"specimen"})
    public IsolateParticipationBean getSpecimen() {
        return this.specimen;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004100CA.OrganismIdentificationEvent.specimen</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSpecimen(IsolateParticipationBean specimen) {
        this.specimen = specimen;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004100CA.OrganismIdentificationEvent.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf1"})
    public List<IncludesBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    /**
     * <p>Relationship: 
     * POLB_MT004100CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/resultStatusProcessStep"})
    public ResultStatusProcessStepBean getSubjectOf2ResultStatusProcessStep() {
        return this.subjectOf2ResultStatusProcessStep;
    }

    /**
     * <p>Relationship: 
     * POLB_MT004100CA.Subject3.resultStatusProcessStep</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2ResultStatusProcessStep(ResultStatusProcessStepBean subjectOf2ResultStatusProcessStep) {
        this.subjectOf2ResultStatusProcessStep = subjectOf2ResultStatusProcessStep;
    }

}
