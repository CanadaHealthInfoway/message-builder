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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.CreatedAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: ActDefinitionOrEventName</p>
 * 
 * <p>PRPM_MT303010CA.ActDefinitionOrEvent: Act Definition or 
 * Event Name</p>
 * 
 * <p>Acts are the pivot of the RIM; all domain information and 
 * processes are represented primarily in Acts. Any profession 
 * or business, including healthcare, is primarily constituted 
 * of intentional and occasionally non-intentional actions, 
 * performed and recorded by responsible actors. An 
 * Act-instance is a record of such an action.</p>
 * 
 * <p>A record of something that is being done, has been done, 
 * can be done, or is intended or requested to be done. Acts 
 * connect to Entities in their Roles through Participations 
 * and connect to other Acts through ActRelationships. 
 * Participations are the authors, performers and other 
 * responsible parties as well as subjects and beneficiaries 
 * (which includes tools and material used in the performance 
 * of the act, which are also subjects). The moodCode 
 * distinguishes between Acts that are meant as factual 
 * records, vs. records of intended or ordered services, and 
 * the other modalities in which act can appear.</p>
 * 
 * <p>PRPM_MT301010CA.ActDefinitionOrEvent: Act Definition or 
 * Event Name</p>
 * 
 * <p>Acts are the pivot of the RIM; all domain information and 
 * processes are represented primarily in Acts. Any profession 
 * or business, including healthcare, is primarily constituted 
 * of intentional and occasionally non-intentional actions, 
 * performed and recorded by responsible actors. An 
 * Act-instance is a record of such an action.</p>
 * 
 * <p>A record of something that is being done, has been done, 
 * can be done, or is intended or requested to be done. Acts 
 * connect to Entities in their Roles through Participations 
 * and connect to other Acts through ActRelationships. 
 * Participations are the authors, performers and other 
 * responsible parties as well as subjects and beneficiaries 
 * (which includes tools and material used in the performance 
 * of the act, which are also subjects). The moodCode 
 * distinguishes between Acts that are meant as factual 
 * records, vs. records of intended or ordered services, and 
 * the other modalities in which act can appear.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.ActDefinitionOrEvent","PRPM_MT303010CA.ActDefinitionOrEvent"})
public class ActDefinitionOrEventName_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<CreatedAtBean> location = new ArrayList<CreatedAtBean>();
    private List<SequelToBean> sequel = new ArrayList<SequelToBean>();


    /**
     * <p>Business Name: ActDefinitionOrEventNameEffectiveTime</p>
     * 
     * <p>Other Business Name: 
     * ActDefinitionOrEventNameEffectiveTime</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ActDefinitionOrEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute indicating effective time of this 
     * act</p>
     * 
     * <p>Effective Time with regard to the act involved</p>
     * 
     * <p>Other Business Name: 
     * ActDefinitionOrEventNameEffectiveTime</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ActDefinitionOrEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute indicating effective time of this 
     * act</p>
     * 
     * <p>Effective Time with regard to the act involved</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: ActDefinitionOrEventNameEffectiveTime</p>
     * 
     * <p>Other Business Name: 
     * ActDefinitionOrEventNameEffectiveTime</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ActDefinitionOrEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute indicating effective time of this 
     * act</p>
     * 
     * <p>Effective Time with regard to the act involved</p>
     * 
     * <p>Other Business Name: 
     * ActDefinitionOrEventNameEffectiveTime</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ActDefinitionOrEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute indicating effective time of this 
     * act</p>
     * 
     * <p>Effective Time with regard to the act involved</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.ActDefinitionOrEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-25)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.ActDefinitionOrEvent.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-25)</p>
     */
    @Hl7XmlMapping({"location"})
    public List<CreatedAtBean> getLocation() {
        return this.location;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.ActDefinitionOrEvent.sequel</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-25)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.ActDefinitionOrEvent.sequel</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-25)</p>
     */
    @Hl7XmlMapping({"sequel"})
    public List<SequelToBean> getSequel() {
        return this.sequel;
    }

}
