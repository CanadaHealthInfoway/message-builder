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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt080100ca;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.EntityRisk;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.OtherSpecimenIdentificationsBean;



@Hl7PartTypeMapping({"COCT_MT080100CA.Specimen"})
@Hl7RootType
public class SpecimenRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CS classCode = new CSImpl();
    private II specimenIdentifier = new IIImpl();
    private CV specimenCode = new CVImpl();
    private ST specimenText = new STImpl();
    private List<OtherSpecimenIdentificationsBean> specimenMaterialAsIdentifiedEntity = new ArrayList<OtherSpecimenIdentificationsBean>();
    private CV specimenContainerRisk = new CVImpl();
    private List<SpecimenProcessStepsBean> subjectOf1TransportationEvent = new ArrayList<SpecimenProcessStepsBean>();
    private List<SpecimenObservationBean> subjectOf2SpecimenObservationEvent = new ArrayList<SpecimenObservationBean>();
    private SpecimenCollectionProcedureBean productOfSpecimenCollectionProcedureEvent;


    @Hl7XmlMapping({"classCode"})
    public RoleClass getClassCode() {
        return (RoleClass) this.classCode.getValue();
    }
    public void setClassCode(RoleClass classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>A:Specimen Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getSpecimenIdentifier() {
        return this.specimenIdentifier.getValue();
    }
    public void setSpecimenIdentifier(Identifier specimenIdentifier) {
        this.specimenIdentifier.setValue(specimenIdentifier);
    }


    /**
     * <p>V:Specimen Code</p>
     */
    @Hl7XmlMapping({"specimenMaterial/code"})
    public Code getSpecimenCode() {
        return (Code) this.specimenCode.getValue();
    }
    public void setSpecimenCode(Code specimenCode) {
        this.specimenCode.setValue(specimenCode);
    }


    /**
     * <p>W:Specimen Text</p>
     */
    @Hl7XmlMapping({"specimenMaterial/desc"})
    public String getSpecimenText() {
        return this.specimenText.getValue();
    }
    public void setSpecimenText(String specimenText) {
        this.specimenText.setValue(specimenText);
    }


    @Hl7XmlMapping({"specimenMaterial/asIdentifiedEntity"})
    public List<OtherSpecimenIdentificationsBean> getSpecimenMaterialAsIdentifiedEntity() {
        return this.specimenMaterialAsIdentifiedEntity;
    }


    /**
     * <p>Y:Specimen Container Risk</p>
     */
    @Hl7XmlMapping({"specimenMaterial/asContent/container/riskCode"})
    public EntityRisk getSpecimenContainerRisk() {
        return (EntityRisk) this.specimenContainerRisk.getValue();
    }
    public void setSpecimenContainerRisk(EntityRisk specimenContainerRisk) {
        this.specimenContainerRisk.setValue(specimenContainerRisk);
    }


    @Hl7XmlMapping({"subjectOf1/transportationEvent"})
    public List<SpecimenProcessStepsBean> getSubjectOf1TransportationEvent() {
        return this.subjectOf1TransportationEvent;
    }


    @Hl7XmlMapping({"subjectOf2/specimenObservationEvent"})
    public List<SpecimenObservationBean> getSubjectOf2SpecimenObservationEvent() {
        return this.subjectOf2SpecimenObservationEvent;
    }


    @Hl7XmlMapping({"productOf/specimenCollectionProcedureEvent"})
    public SpecimenCollectionProcedureBean getProductOfSpecimenCollectionProcedureEvent() {
        return this.productOfSpecimenCollectionProcedureEvent;
    }
    public void setProductOfSpecimenCollectionProcedureEvent(SpecimenCollectionProcedureBean productOfSpecimenCollectionProcedureEvent) {
        this.productOfSpecimenCollectionProcedureEvent = productOfSpecimenCollectionProcedureEvent;
    }

}
