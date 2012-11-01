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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ClinicalReportObservationType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ActEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>ClinicalObservationDocument</p>
 * 
 * <p>REPC_MT230001CA.Observation: A: Clinical Observation 
 * Document</p>
 * 
 * <p><p>Discrete information about the observation or 
 * procedure or other report or note being written</p></p>
 * 
 * <p><p>Provides contextual overview information for searching 
 * and filtering</p></p>
 * 
 * <p>REPC_MT230003CA.Observation: A: Clinical Observation 
 * Document</p>
 * 
 * <p><p>Discrete information about the observation or 
 * procedure or other report or note being written</p></p>
 * 
 * <p><p>Provides contextual overview information for searching 
 * and filtering</p></p>
 * 
 * <p>REPC_MT230002CA.Observation: A: Clinical Observation 
 * Document</p>
 * 
 * <p><p>Discrete information about the observation or 
 * procedure or other report or note being written</p></p>
 * 
 * <p><p>Provides contextual overview information for searching 
 * and filtering</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT230001CA.Observation","REPC_MT230002CA.Observation","REPC_MT230003CA.Observation"})
public class ClinicalObservationDocumentBean extends MessagePartBean implements DocumentContent_3, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.repc_mt230001ca.DocumentContent {

    private static final long serialVersionUID = 20120106L;
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private CD code = new CDImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private OccurredAtBean location;
    private Request_2Bean inFulfillmentOfActRequest;
    private ActEventBean subjectActEvent;


    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>ClinicalObservationDocumentType</p>
     * 
     * <p>C: Clinical Observation Document Type</p>
     * 
     * <p></p><p>e.g. family history, environmental history, social 
     * history, etc.</p></p>
     * 
     * <p></p><p>e.g. family history, environmental history, social 
     * history, etc.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalReportObservationType getCode() {
        return (ClinicalReportObservationType) this.code.getValue();
    }
    public void setCode(ClinicalReportObservationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>ClinicalObservationDocumentTimeRange</p>
     * 
     * <p>F: Clinical Observation Document Time Range</p>
     * 
     * <p><p>Indicates the period of time over which the assessment 
     * described by the clinical note applies. If the assessment 
     * applies over the entire life of the patient, only the end 
     * date (the point up to which the assessment is current) needs 
     * to be specified.</p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_2Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }
    public void setInFulfillmentOfActRequest(Request_2Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    @Hl7XmlMapping({"subject/actEvent"})
    public ActEventBean getSubjectActEvent() {
        return this.subjectActEvent;
    }
    public void setSubjectActEvent(ActEventBean subjectActEvent) {
        this.subjectActEvent = subjectActEvent;
    }

}