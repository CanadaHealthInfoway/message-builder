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
package ca.infoway.messagebuilder.model.common.coct_mt080100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.merged.HealthcareWorkerBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



/**
 * <p>Specimen Collection Procedure 
 * 
 * <p>This is the procedure act which describes the 
 * process/procedure used to collect the associated specimen. 
 * 
 * <p>For certain laboratory tests, the specimen collection 
 * procedure information is relevant in determining the result 
 * value. 
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.SpecimenCollectionProcedureEvent"})
public class SpecimenCollectionProcedureBean extends MessagePartBean {

    private ST specimenCollectionText = new STImpl();
    private IVL<TS, Interval<Date>> specimenCollectionDateTime = new IVLImpl<TS, Interval<Date>>();
    private List<NotesBean> subjectOfAnnotation = new ArrayList<NotesBean>();
    private HealthcareWorkerBean performerAssignedEntity;

    @Hl7XmlMapping({"text"})
    public java.lang.String getSpecimenCollectionText() {
        return this.specimenCollectionText.getValue();
    }
    public void setSpecimenCollectionText(java.lang.String specimenCollectionText) {
        this.specimenCollectionText.setValue(specimenCollectionText);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getSpecimenCollectionDateTime() {
        return this.specimenCollectionDateTime.getValue();
    }
    public void setSpecimenCollectionDateTime(Interval<Date> specimenCollectionDateTime) {
        this.specimenCollectionDateTime.setValue(specimenCollectionDateTime);
    }

    @Hl7XmlMapping({"subjectOf/annotation"})
    public List<NotesBean> getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }

    @Hl7XmlMapping({"performer/assignedEntity"})
    public HealthcareWorkerBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }
    public void setPerformerAssignedEntity(HealthcareWorkerBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }

}
