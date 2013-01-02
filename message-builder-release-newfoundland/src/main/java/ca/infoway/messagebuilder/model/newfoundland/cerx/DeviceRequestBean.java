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

package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.OfPatient;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ClinicalDeviceBean;

@Hl7PartTypeMapping({ "PORX_MT010110CA.DeviceRequest" })
public class DeviceRequestBean extends MessagePartBean implements Serializable, OfPatient {

    private static final long serialVersionUID = 1574760558059972803L;

    private final II id = new IIImpl();

    private final CD statusCode = new CDImpl();

    private final SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);

    private ClinicalDeviceBean directTarget;

    private IdentifiedPersonBean patient;

    private final II predecessorId = new IIImpl();

    private final List<ReasonBean> reasons = Collections.synchronizedList(new ArrayList<ReasonBean>());

    private final ST usageInstructions = new STImpl();

    private DeviceDispenseInstructionsBean supplyRequest;

    private NoteBean note;

    private BL verificationEventCriterion = new BLImpl(false);

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier idAssignedByEhr) {
        this.id.setValue(idAssignedByEhr);
    }

    @Hl7XmlMapping("statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("confidentialityCode")
    public Set<x_VeryBasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_VeryBasicConfidentialityKind.class);
    }

    @Hl7XmlMapping("directTarget/manufacturedProduct/manufacturedClinicalDevice")
    public ClinicalDeviceBean getDirectTarget() {
        return this.directTarget;
    }

    public void setDirectTarget(ClinicalDeviceBean directTarget) {
        this.directTarget = directTarget;
    }

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping("predecessor/priorDeviceRequest/id")
    public Identifier getPredecessorId() {
        return this.predecessorId.getValue();
    }

    public void setPredecessorId(Identifier predecessorId) {
        this.predecessorId.setValue(predecessorId);
    }

    @Hl7XmlMapping("reason")
    public List<ReasonBean> getReasons() {
        return reasons;
    }

    @Hl7XmlMapping("component1/procedureRequest/text")
    public String getUsageInstructions() {
        return this.usageInstructions.getValue();
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions.setValue(usageInstructions);
    }

    @Hl7XmlMapping({ "component2/supplyRequest", "component/supplyRequest" })
    public DeviceDispenseInstructionsBean getSupplyRequest() {
        return this.supplyRequest;
    }

    public void setSupplyRequest(DeviceDispenseInstructionsBean supplyRequest) {
        this.supplyRequest = supplyRequest;
    }

    @Hl7XmlMapping({ "subjectOf/annotation" })
    public NoteBean getNote() {
        return note;
    }

    public void setNote(NoteBean note) {
        this.note = note;
    }

    @Hl7XmlMapping("precondition/verificationEventCriterion")
    public Boolean getVerificationEventCriterion() {
        return verificationEventCriterion.getValue();
    }

    public void setVerificationEventCriterion(Boolean verificationEventCriterion) {
        this.verificationEventCriterion.setValue(verificationEventCriterion);
    }
}
