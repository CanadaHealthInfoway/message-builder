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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.prpm_mt301010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.Location_1Bean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PRPM_MT301010CA.PrimaryPerformer3"})
public class PrimaryPerformer3Bean extends MessagePartBean {

    private IVL<TS, Interval<Date>> actDefinitionOrEventNameEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<Location_1Bean> actDefinitionOrEventLocation = new ArrayList<Location_1Bean>();
    private List<SequelToBean> actDefinitionOrEventSequel = new ArrayList<SequelToBean>();

    @Hl7XmlMapping({"actDefinitionOrEvent/effectiveTime"})
    public Interval<Date> getActDefinitionOrEventNameEffectiveTime() {
        return this.actDefinitionOrEventNameEffectiveTime.getValue();
    }
    public void setActDefinitionOrEventNameEffectiveTime(Interval<Date> actDefinitionOrEventNameEffectiveTime) {
        this.actDefinitionOrEventNameEffectiveTime.setValue(actDefinitionOrEventNameEffectiveTime);
    }

    @Hl7XmlMapping({"actDefinitionOrEvent/location"})
    public List<Location_1Bean> getActDefinitionOrEventLocation() {
        return this.actDefinitionOrEventLocation;
    }

    @Hl7XmlMapping({"actDefinitionOrEvent/sequel"})
    public List<SequelToBean> getActDefinitionOrEventSequel() {
        return this.actDefinitionOrEventSequel;
    }

}
