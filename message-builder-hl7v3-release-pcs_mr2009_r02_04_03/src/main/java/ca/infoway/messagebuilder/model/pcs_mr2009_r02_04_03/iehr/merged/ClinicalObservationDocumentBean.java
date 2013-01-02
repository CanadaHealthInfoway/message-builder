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
 * <p>Business Name: ClinicalObservationDocument</p>
 * 
 * <p>REPC_MT230001CA.Observation: A: Clinical Observation 
 * Document</p>
 * 
 * <p>Provides contextual overview information for searching 
 * and filtering</p>
 * 
 * <p>Discrete information about the observation or procedure 
 * or other report or note being written</p>
 * 
 * <p>REPC_MT230003CA.Observation: A: Clinical Observation 
 * Document</p>
 * 
 * <p>Provides contextual overview information for searching 
 * and filtering</p>
 * 
 * <p>Discrete information about the observation or procedure 
 * or other report or note being written</p>
 * 
 * <p>REPC_MT230002CA.Observation: A: Clinical Observation 
 * Document</p>
 * 
 * <p>Provides contextual overview information for searching 
 * and filtering</p>
 * 
 * <p>Discrete information about the observation or procedure 
 * or other report or note being written</p>
 */
@Hl7PartTypeMapping({"REPC_MT230001CA.Observation","REPC_MT230002CA.Observation","REPC_MT230003CA.Observation"})
public class ClinicalObservationDocumentBean extends MessagePartBean implements DocumentContent_3, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.repc_mt230001ca.DocumentContent {

    private static final long serialVersionUID = 20121204L;
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private CD code = new CDImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private OccurredAtBean location;
    private Request_2Bean inFulfillmentOfActRequest;
    private ActEventBean subjectActEvent;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.DocumentContent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.DocumentContent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.DocumentContent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Business Name: ClinicalObservationDocumentType</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentType</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Observation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Clinical Observation Document Type is used for 
     * searching and for organizing Clinical Observation Document 
     * records as well as sorting them for presentation.</i> 
     * </p><p> <i>This is a key attribute for understanding the 
     * type of record and is therefore mandatory.</i> </p><p> 
     * <i>This element makes use of the CD datatype to allow for 
     * use of the SNOMED code system that in some circumstances 
     * requires the use of post-coordination. Post-coordination is 
     * only supported by the CD datatype.</i> </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record.</i> </p><p>e.g. family history, 
     * environmental history, social history, etc.</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentType</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Observation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Clinical Observation Document Type is used for 
     * searching and for organizing Clinical Observation Document 
     * records as well as sorting them for presentation.</i> 
     * </p><p> <i>This is a key attribute for understanding the 
     * type of record and is therefore mandatory.</i> </p><p> 
     * <i>This element makes use of the CD datatype to allow for 
     * use of the SNOMED code system that in some circumstances 
     * requires the use of post-coordination. Post-coordination is 
     * only supported by the CD datatype.</i> </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record.</i> </p><p>e.g. family history, 
     * environmental history, social history, etc.</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentType</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Observation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Clinical Observation Document Type is used for 
     * searching and for organizing Clinical Observation Document 
     * records as well as sorting them for presentation.</i> 
     * </p><p> <i>This is a key attribute for understanding the 
     * type of record and is therefore mandatory.</i> </p><p> 
     * <i>This element makes use of the CD datatype to allow for 
     * use of the SNOMED code system that in some circumstances 
     * requires the use of post-coordination. Post-coordination is 
     * only supported by the CD datatype.</i> </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record.</i> </p><p>e.g. family history, 
     * environmental history, social history, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalReportObservationType getCode() {
        return (ClinicalReportObservationType) this.code.getValue();
    }

    /**
     * <p>Business Name: ClinicalObservationDocumentType</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentType</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Observation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Clinical Observation Document Type is used for 
     * searching and for organizing Clinical Observation Document 
     * records as well as sorting them for presentation.</i> 
     * </p><p> <i>This is a key attribute for understanding the 
     * type of record and is therefore mandatory.</i> </p><p> 
     * <i>This element makes use of the CD datatype to allow for 
     * use of the SNOMED code system that in some circumstances 
     * requires the use of post-coordination. Post-coordination is 
     * only supported by the CD datatype.</i> </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record.</i> </p><p>e.g. family history, 
     * environmental history, social history, etc.</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentType</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Observation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Clinical Observation Document Type is used for 
     * searching and for organizing Clinical Observation Document 
     * records as well as sorting them for presentation.</i> 
     * </p><p> <i>This is a key attribute for understanding the 
     * type of record and is therefore mandatory.</i> </p><p> 
     * <i>This element makes use of the CD datatype to allow for 
     * use of the SNOMED code system that in some circumstances 
     * requires the use of post-coordination. Post-coordination is 
     * only supported by the CD datatype.</i> </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record.</i> </p><p>e.g. family history, 
     * environmental history, social history, etc.</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentType</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Observation.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p> <i>Clinical Observation Document Type is used for 
     * searching and for organizing Clinical Observation Document 
     * records as well as sorting them for presentation.</i> 
     * </p><p> <i>This is a key attribute for understanding the 
     * type of record and is therefore mandatory.</i> </p><p> 
     * <i>This element makes use of the CD datatype to allow for 
     * use of the SNOMED code system that in some circumstances 
     * requires the use of post-coordination. Post-coordination is 
     * only supported by the CD datatype.</i> </p>
     * 
     * <p> <i>Identifies the type of Clinical Observation Document 
     * represented by this record.</i> </p><p>e.g. family history, 
     * environmental history, social history, etc.</p>
     */
    public void setCode(ClinicalReportObservationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ClinicalObservationDocumentTimeRange</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentTimeRange</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Observation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>Indicates the period of time over which the assessment 
     * described by the clinical note applies. If the assessment 
     * applies over the entire life of the patient, only the end 
     * date (the point up to which the assessment is current) needs 
     * to be specified.</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentTimeRange</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Observation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>Indicates the period of time over which the assessment 
     * described by the clinical note applies. If the assessment 
     * applies over the entire life of the patient, only the end 
     * date (the point up to which the assessment is current) needs 
     * to be specified.</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentTimeRange</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Observation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>Indicates the period of time over which the assessment 
     * described by the clinical note applies. If the assessment 
     * applies over the entire life of the patient, only the end 
     * date (the point up to which the assessment is current) needs 
     * to be specified.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: ClinicalObservationDocumentTimeRange</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentTimeRange</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Observation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>Indicates the period of time over which the assessment 
     * described by the clinical note applies. If the assessment 
     * applies over the entire life of the patient, only the end 
     * date (the point up to which the assessment is current) needs 
     * to be specified.</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentTimeRange</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Observation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>Indicates the period of time over which the assessment 
     * described by the clinical note applies. If the assessment 
     * applies over the entire life of the patient, only the end 
     * date (the point up to which the assessment is current) needs 
     * to be specified.</p>
     * 
     * <p>Un-merged Business Name: ClinicalObservationDocumentTimeRange</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Observation.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p> <i>Identifies the time-period of relevance to the record 
     * that is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * timing information won't always be known, this attribute is 
     * marked as 'populated'.</i> </p>
     * 
     * <p>Indicates the period of time over which the assessment 
     * described by the clinical note applies. If the assessment 
     * applies over the entire life of the patient, only the end 
     * date (the point up to which the assessment is current) needs 
     * to be specified.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Observation.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.DocumentContent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.DocumentContent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Observation.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.DocumentContent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.DocumentContent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.InFulfillmentOf3.actRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.InFulfillmentOf3.actRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.InFulfillmentOf3.actRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_2Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.InFulfillmentOf3.actRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.InFulfillmentOf3.actRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.InFulfillmentOf3.actRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setInFulfillmentOfActRequest(Request_2Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Subject.actEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Subject.actEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Subject.actEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subject/actEvent"})
    public ActEventBean getSubjectActEvent() {
        return this.subjectActEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230001CA.Subject.actEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230003CA.Subject.actEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT230002CA.Subject.actEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectActEvent(ActEventBean subjectActEvent) {
        this.subjectActEvent = subjectActEvent;
    }

}
