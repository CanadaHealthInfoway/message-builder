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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt080100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActSpecimenTransportationCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Specimen Process Steps</p>
 * 
 * <p><p>The specimen is subject to one or more process steps. 
 * e.g. the specimen receive date is documented using a process 
 * step object, specimen action codes are also represented and 
 * communicated using this process step object.</p></p>
 * 
 * <p><p>At this time, only the transportation specimen process 
 * steps are in scope for lab messaging.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.TransportationEvent"})
public class SpecimenProcessStepsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV transportationType = new CVImpl();
    private CS transportationStatus = new CSImpl();
    private IVL<TS, Interval<Date>> transportationDateTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>P:Transportation Type</p>
     * 
     * <p><p>Describes the type of process step being documented 
     * and communicated. Value is fixed to specimen received.</p></p>
     * 
     * <p><p>Categorizes the type of transportation act being 
     * communiated.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActSpecimenTransportationCode getTransportationType() {
        return (ActSpecimenTransportationCode) this.transportationType.getValue();
    }
    public void setTransportationType(ActSpecimenTransportationCode transportationType) {
        this.transportationType.setValue(transportationType);
    }


    /**
     * <p>R:Transportation Status</p>
     * 
     * <p><p>The state or status of this transportation process 
     * step.</p></p>
     * 
     * <p><p>Indicates (along with the mood) whether this act's 
     * action has been completed or is still being acted upon (or 
     * has yet to be acted upon).</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getTransportationStatus() {
        return (ActStatus) this.transportationStatus.getValue();
    }
    public void setTransportationStatus(ActStatus transportationStatus) {
        this.transportationStatus.setValue(transportationStatus);
    }


    /**
     * <p>Q:Transportation Date/Time</p>
     * 
     * <p><p>The date/time the process step took place or the 
     * duration of that step (days or time in transit, start time, 
     * end time).</p></p>
     * 
     * <p><p>Holds the date/time the process step took place. This 
     * attribute is especially important for those process steps 
     * which document the date/time the process happened (specimen 
     * received date/time).</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getTransportationDateTime() {
        return this.transportationDateTime.getValue();
    }
    public void setTransportationDateTime(Interval<Date> transportationDateTime) {
        this.transportationDateTime.setValue(transportationDateTime);
    }

}