/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>ActDefinitionOrEventName</p>
 * 
 * <p>PRPM_MT303010CA.ActDefinitionOrEvent: Act Definition or 
 * Event Name</p>
 * 
 * <p><p>A record of something that is being done, has been 
 * done, can be done, or is intended or requested to be done. 
 * Acts connect to Entities in their Roles through 
 * Participations and connect to other Acts through 
 * ActRelationships. Participations are the authors, performers 
 * and other responsible parties as well as subjects and 
 * beneficiaries (which includes tools and material used in the 
 * performance of the act, which are also subjects). The 
 * moodCode distinguishes between Acts that are meant as 
 * factual records, vs. records of intended or ordered 
 * services, and the other modalities in which act can 
 * appear.</p></p>
 * 
 * <p><p>Acts are the pivot of the RIM; all domain information 
 * and processes are represented primarily in Acts. Any 
 * profession or business, including healthcare, is primarily 
 * constituted of intentional and occasionally non-intentional 
 * actions, performed and recorded by responsible actors. An 
 * Act-instance is a record of such an action.</p></p>
 * 
 * <p>PRPM_MT301010CA.ActDefinitionOrEvent: Act Definition or 
 * Event Name</p>
 * 
 * <p><p>A record of something that is being done, has been 
 * done, can be done, or is intended or requested to be done. 
 * Acts connect to Entities in their Roles through 
 * Participations and connect to other Acts through 
 * ActRelationships. Participations are the authors, performers 
 * and other responsible parties as well as subjects and 
 * beneficiaries (which includes tools and material used in the 
 * performance of the act, which are also subjects). The 
 * moodCode distinguishes between Acts that are meant as 
 * factual records, vs. records of intended or ordered 
 * services, and the other modalities in which act can 
 * appear.</p></p>
 * 
 * <p><p>Acts are the pivot of the RIM; all domain information 
 * and processes are represented primarily in Acts. Any 
 * profession or business, including healthcare, is primarily 
 * constituted of intentional and occasionally non-intentional 
 * actions, performed and recorded by responsible actors. An 
 * Act-instance is a record of such an action.</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.ActDefinitionOrEvent","PRPM_MT303010CA.ActDefinitionOrEvent"})
public class ActDefinitionOrEventName_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private IVL<TS, Interval<Date>> actDefinitionOrEventNameEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<Location_1Bean> location = new ArrayList<Location_1Bean>();
    private List<SequelToBean> sequel = new ArrayList<SequelToBean>();


    /**
     * <p>ActDefinitionOrEventNameEffectiveTime</p>
     * 
     * <p>Act Definition or Event Name Effective Time</p>
     * 
     * <p><p>Effective Time with regard to the act involved</p></p>
     * 
     * <p><p>Required attribute indicating effective time of this 
     * act</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getActDefinitionOrEventNameEffectiveTime() {
        return this.actDefinitionOrEventNameEffectiveTime.getValue();
    }
    public void setActDefinitionOrEventNameEffectiveTime(Interval<Date> actDefinitionOrEventNameEffectiveTime) {
        this.actDefinitionOrEventNameEffectiveTime.setValue(actDefinitionOrEventNameEffectiveTime);
    }


    @Hl7XmlMapping({"location"})
    public List<Location_1Bean> getLocation() {
        return this.location;
    }


    @Hl7XmlMapping({"sequel"})
    public List<SequelToBean> getSequel() {
        return this.sequel;
    }

}