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
import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ClinicalDeviceBean;

public class BaseDispenseRequestBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -2095634015394561160L;

    private II idAssignedByPharmacy = new IIImpl();

    private SET<CV, Code> confidentialityCode = 
    	new SETImpl<CV, Code>(CVImpl.class);

    private IdentifiedPersonBean patient;

    private SupplyEventBean supplyEvent;

    private NoteBean note;

    @Hl7XmlMapping("id")
    public Identifier getIdAssignedByPharmacy() {
        return this.idAssignedByPharmacy.getValue();
    }

    public void setIdAssignedByPharmacy(Identifier idAssignedByPharmacy) {
        this.idAssignedByPharmacy.setValue(idAssignedByPharmacy);
    }

    @Hl7XmlMapping("confidentialityCode")
    public Set<x_VeryBasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_VeryBasicConfidentialityKind.class);
    }

    /**
	 * Since we are not supporting animal dispenses, we can resolve the specified choice to 'patient1'.
	 * We can also safely ignore the recordTarget property which is only used to identify the animal's owner.
	 * LAR 2009-07-20
	 */
    @Hl7XmlMapping("subject/patient1")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping({ "subjectOf/annotation" })
    public NoteBean getNote() {
        return note;
    }

    public void setNote(NoteBean note) {
        this.note = note;
    }

    public ClinicalDeviceBean getDevice() {
        ClinicalDeviceBean result;
        if (this.supplyEvent == null) {
            result = null;
        } else {
            result = this.supplyEvent.getClinicalDevice();
        }
        return result;
    }

    public MedicineBean getMedicine() {
        MedicineBean result;
        if (this.supplyEvent == null) {
            result = null;
        } else {
            result = this.supplyEvent.getMedication();
        }
        return result;
    }

    public boolean isCompound() {
        if (this.supplyEvent != null && this.supplyEvent.getMedication() != null && this.supplyEvent.getMedication().getCode() == null) {
            return true;
        }
        return false;
    }
}
