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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActProfessionalServiceCode;
import ca.infoway.messagebuilder.model.newfoundland.PatientDetailsQueryCriteria;

@Hl7PartTypeMapping("REPC_MT120001CA.ParameterList")
public class ProfessionalServicesQueryCriteria extends PatientDetailsQueryCriteria {

    private static final long serialVersionUID = 2649248907656226309L;

    private final BL includeNotesIndicator = new BLImpl();

    private final List<CD> types = new ArrayList<CD>();

    private final IVL<TS, Interval<Date>> servicePeriod = new IVLImpl<TS, Interval<Date>>();

    @Hl7XmlMapping("includeNotesIndicator/value")
    public boolean isIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }

    public void setIncludeNotesIndicator(boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

    @Hl7XmlMapping("servicePeriod/value")
    public Interval<Date> getServicePeriod() {
        return this.servicePeriod.getValue();
    }

    public void setServicePeriod(Interval<Date> servicePeriod) {
        this.servicePeriod.setValue(servicePeriod);
    }

    @Hl7XmlMapping("professionalServiceCode/value")
    public List<ActProfessionalServiceCode> getTypes() {
    	return new RawListWrapper<CD, ActProfessionalServiceCode>(this.types, CDImpl.class);
    }
}
