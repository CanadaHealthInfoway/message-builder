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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.repc_mt000004ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.util.CollapsedToDataTypeListHelper;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



/**
 * <p>Allergy/Intolerance Query Parameters 
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response 
 * 
 * <p>Root class for query definition 
 */
@Hl7PartTypeMapping({"REPC_MT000004CA.ParameterList"})
@Hl7RootType
public class AllergyIntoleranceQueryParametersBean extends MessagePartBean {

    private CV<ActStatus> allergyIntoleranceStatus = new CVImpl<ActStatus>();
    private CD<ObservationIntoleranceType> allergyIntoleranceType = new CDImpl<ObservationIntoleranceType>();
    private IVL<TS, Interval<Date>> allergyIntoleranceChangePeriod = new IVLImpl<TS, Interval<Date>>();
    private List<II> careCompositionIDs = new ArrayList<II>();
    private List<CV<ActCareEventType>> careCompositionTypes = new ArrayList<CV<ActCareEventType>>();
    private BL includeNotesIndicator = new BLImpl();
    private CV<SubjectReaction> reaction = new CVImpl<SubjectReaction>();

    @Hl7XmlMapping({"allergyIntoleranceStatus/value"})
    public ActStatus getAllergyIntoleranceStatus() {
        return this.allergyIntoleranceStatus.getValue();
    }
    public void setAllergyIntoleranceStatus(ActStatus allergyIntoleranceStatus) {
        this.allergyIntoleranceStatus.setValue(allergyIntoleranceStatus);
    }

    @Hl7XmlMapping({"allergyIntoleranceType/value"})
    public ObservationIntoleranceType getAllergyIntoleranceType() {
        return this.allergyIntoleranceType.getValue();
    }
    public void setAllergyIntoleranceType(ObservationIntoleranceType allergyIntoleranceType) {
        this.allergyIntoleranceType.setValue(allergyIntoleranceType);
    }

    @Hl7XmlMapping({"alllergyIntoleranceChangePeriod/value"})
    public Interval<Date> getAllergyIntoleranceChangePeriod() {
        return this.allergyIntoleranceChangePeriod.getValue();
    }
    public void setAllergyIntoleranceChangePeriod(Interval<Date> allergyIntoleranceChangePeriod) {
        this.allergyIntoleranceChangePeriod.setValue(allergyIntoleranceChangePeriod);
    }

    @Hl7XmlMapping({"careCompositionID/value"})
    public List<Identifier> getCareCompositionIDs() {
        return new CollapsedToDataTypeListHelper(IIImpl.class, this.careCompositionIDs).rawList();
    }

    @Hl7XmlMapping({"careCompositionType/value"})
    public List<ActCareEventType> getCareCompositionTypes() {
        return new CollapsedToDataTypeListHelper(CVImpl.class, this.careCompositionTypes).rawList();
    }

    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public java.lang.Boolean getIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }
    public void setIncludeNotesIndicator(java.lang.Boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

    @Hl7XmlMapping({"reactionType/value"})
    public SubjectReaction getReaction() {
        return this.reaction.getValue();
    }
    public void setReaction(SubjectReaction reaction) {
        this.reaction.setValue(reaction);
    }

}
