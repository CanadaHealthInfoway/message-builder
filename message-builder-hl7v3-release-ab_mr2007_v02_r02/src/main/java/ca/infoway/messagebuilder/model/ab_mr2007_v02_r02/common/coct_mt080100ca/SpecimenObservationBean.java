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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt080100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Specimen Observation</p>
 * 
 * <p><p>One or more observation acts which describe aspects of 
 * a specimen (color, adequacy, etc.)</p></p>
 * 
 * <p><p>It is sometimes relevant to know certain specimen 
 * characteristics when evaluating a result regarding a 
 * specimen.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.SpecimenObservationEvent"})
public class SpecimenObservationBean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ANY<Object> value = new ANYImpl<Object>();


    /**
     * <p>Specimen Observation Type</p>
     * 
     * <p><p>Describes the specific observation being 
     * performed/documented.</p></p>
     * 
     * <p><p>Type of observation.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Specimen Observation Date/Time</p>
     * 
     * <p><p>When this observation took place (or over what time 
     * interval; for collection).</p></p>
     * 
     * <p><p>The date/time when the observation took place. The 
     * date and time of the specimen observation can be relevant in 
     * the result.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Specimen Observation Value</p>
     */
    @Hl7XmlMapping({"value"})
    public Object getValue() {
        return this.value.getValue();
    }
    public void setValue(Object value) {
        this.value.setValue(value);
    }

}