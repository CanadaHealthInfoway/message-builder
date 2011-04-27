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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActMood;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt011001ca.CareCompositionsBean;
import java.util.Date;



@Hl7PartTypeMapping({"MCAI_MT700210CA.Component","MCAI_MT700211CA.Component","PORX_MT010110CA.Component","PORX_MT020070CA.Component2","PORX_MT030040CA.Component","PORX_MT030040CA.Component6","PORX_MT060040CA.Component2","PORX_MT060040CA.Component3","PORX_MT060060CA.Component","PORX_MT060160CA.Component10","PORX_MT060160CA.Component9","PORX_MT060190CA.Component","PORX_MT060190CA.Component2","PORX_MT060190CA.Component6","PORX_MT060210CA.Component2","PORX_MT060340CA.Component5","QUQI_MT020000CA.Component","QUQI_MT120006CA.Component","REPC_MT000005CA.Component","REPC_MT000006CA.Component","REPC_MT000009CA.Component"})
public class IsPartOfBean extends MessagePartBean {

    private BL contextConductionInd = new BLImpl();
    private CareCompositionsBean patientCareProvisionEvent;
    private CS<ActRelationshipType> typeCode = new CSImpl<ActRelationshipType>();
    private CS<ContextControl> contextControlCode = new CSImpl<ContextControl>();
    private CS<ActStatus> prescriptionDispensableIndicator = new CSImpl<ActStatus>();
    private PQ totalPrescribedQuantity = new PQImpl();
    private CreatedAtBean supplyRequestLocation;
    private IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private CS<ActClass> supplementalFillInformationClassCode = new CSImpl<ActClass>();
    private CS<ActMood> supplementalFillInformationMoodCode = new CSImpl<ActMood>();
    private INT numberOfFills = new INTImpl();
    private INT fillQuantity = new INTImpl();

    @Hl7XmlMapping({"contextConductionInd"})
    public java.lang.Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }
    public void setContextConductionInd(java.lang.Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }

    @Hl7XmlMapping({"patientCareProvisionEvent"})
    public CareCompositionsBean getPatientCareProvisionEvent() {
        return this.patientCareProvisionEvent;
    }
    public void setPatientCareProvisionEvent(CareCompositionsBean patientCareProvisionEvent) {
        this.patientCareProvisionEvent = patientCareProvisionEvent;
    }

    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return this.typeCode.getValue();
    }
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }

    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return this.contextControlCode.getValue();
    }
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }

    @Hl7XmlMapping({"supplyRequest/statusCode"})
    public ActStatus getPrescriptionDispensableIndicator() {
        return this.prescriptionDispensableIndicator.getValue();
    }
    public void setPrescriptionDispensableIndicator(ActStatus prescriptionDispensableIndicator) {
        this.prescriptionDispensableIndicator.setValue(prescriptionDispensableIndicator);
    }

    @Hl7XmlMapping({"supplyRequest/quantity"})
    public PhysicalQuantity getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(PhysicalQuantity totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }

    @Hl7XmlMapping({"supplyRequest/location"})
    public CreatedAtBean getSupplyRequestLocation() {
        return this.supplyRequestLocation;
    }
    public void setSupplyRequestLocation(CreatedAtBean supplyRequestLocation) {
        this.supplyRequestLocation = supplyRequestLocation;
    }

    @Hl7XmlMapping({"supplyRequest/expectedUseTime"})
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }
    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
    }

    @Hl7XmlMapping({"supplementalFillInformation/classCode"})
    public ActClass getSupplementalFillInformationClassCode() {
        return this.supplementalFillInformationClassCode.getValue();
    }
    public void setSupplementalFillInformationClassCode(ActClass supplementalFillInformationClassCode) {
        this.supplementalFillInformationClassCode.setValue(supplementalFillInformationClassCode);
    }

    @Hl7XmlMapping({"supplementalFillInformation/moodCode"})
    public ActMood getSupplementalFillInformationMoodCode() {
        return this.supplementalFillInformationMoodCode.getValue();
    }
    public void setSupplementalFillInformationMoodCode(ActMood supplementalFillInformationMoodCode) {
        this.supplementalFillInformationMoodCode.setValue(supplementalFillInformationMoodCode);
    }

    @Hl7XmlMapping({"supplementalFillInformation/repeatNumber"})
    public java.lang.Integer getNumberOfFills() {
        return this.numberOfFills.getValue();
    }
    public void setNumberOfFills(java.lang.Integer numberOfFills) {
        this.numberOfFills.setValue(numberOfFills);
    }

    @Hl7XmlMapping({"supplementalFillInformation/quantity"})
    public java.lang.Integer getFillQuantity() {
        return this.fillQuantity.getValue();
    }
    public void setFillQuantity(java.lang.Integer fillQuantity) {
        this.fillQuantity.setValue(fillQuantity);
    }

}
