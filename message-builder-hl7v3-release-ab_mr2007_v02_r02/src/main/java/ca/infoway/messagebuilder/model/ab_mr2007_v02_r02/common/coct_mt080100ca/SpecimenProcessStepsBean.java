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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt080100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActSpecimenTransportationCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: Specimen Process Steps</p>
 * 
 * <p>The specimen is subject to one or more process steps. 
 * e.g. the specimen receive date is documented using a process 
 * step object, specimen action codes are also represented and 
 * communicated using this process step object.</p>
 * 
 * <p>At this time, only the transportation specimen process 
 * steps are in scope for lab messaging.</p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.TransportationEvent"})
public class SpecimenProcessStepsBean extends MessagePartBean {

    private static final long serialVersionUID = 20140514L;
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: P:Transportation Type</p>
     * 
     * <p>Relationship: COCT_MT080100CA.TransportationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Describes the type of process step being documented and 
     * communicated e.g. specimen received data, specimen action 
     * codes, transportation type.</p>
     * 
     * <p>Categorizes the type of transportation act being 
     * communiated.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSpecimenTransportationCode getCode() {
        return (ActSpecimenTransportationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: P:Transportation Type</p>
     * 
     * <p>Relationship: COCT_MT080100CA.TransportationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Describes the type of process step being documented and 
     * communicated e.g. specimen received data, specimen action 
     * codes, transportation type.</p>
     * 
     * <p>Categorizes the type of transportation act being 
     * communiated.</p>
     */
    public void setCode(ActSpecimenTransportationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: R:Transportation Status</p>
     * 
     * <p>Relationship: 
     * COCT_MT080100CA.TransportationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The state or status of this transportation process 
     * step.</p>
     * 
     * <p>Indicates (along with the mood) whether this act's action 
     * has been completed or is still being acted upon (or has yet 
     * to be acted upon).</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: R:Transportation Status</p>
     * 
     * <p>Relationship: 
     * COCT_MT080100CA.TransportationEvent.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The state or status of this transportation process 
     * step.</p>
     * 
     * <p>Indicates (along with the mood) whether this act's action 
     * has been completed or is still being acted upon (or has yet 
     * to be acted upon).</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Q:Transportation Date/Time</p>
     * 
     * <p>Relationship: 
     * COCT_MT080100CA.TransportationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time the process step took place or the duration 
     * of that step (days or time in transit, start time, end 
     * time).</p>
     * 
     * <p>Holds the date/time the process step took place. This 
     * attribute is especially important for those process steps 
     * which document the date/time the process happened (specimen 
     * received date/time).</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Q:Transportation Date/Time</p>
     * 
     * <p>Relationship: 
     * COCT_MT080100CA.TransportationEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date/time the process step took place or the duration 
     * of that step (days or time in transit, start time, end 
     * time).</p>
     * 
     * <p>Holds the date/time the process step took place. This 
     * attribute is especially important for those process steps 
     * which document the date/time the process happened (specimen 
     * received date/time).</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

}
