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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.prpm_mt306011ca.SequelToBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>ActDefinitionOrEventName</p>
 * 
 * <p>PRPM_MT309000CA.ActDefinitionOrEvent: Act Definition or 
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
 * <p>PRPM_MT306011CA.ActDefinitionOrEvent: Act Definition or 
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
@Hl7PartTypeMapping({"PRPM_MT306011CA.ActDefinitionOrEvent","PRPM_MT309000CA.ActDefinitionOrEvent"})
public class ActDefinitionOrEventName_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<LocationBean> location = new ArrayList<LocationBean>();
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
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"location"})
    public List<LocationBean> getLocation() {
        return this.location;
    }


    @Hl7XmlMapping({"sequel"})
    public List<SequelToBean> getSequel() {
        return this.sequel;
    }

}
