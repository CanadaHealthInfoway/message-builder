package ca.infoway.messagebuilder.model.cerx;

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
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.NoteBean;
import ca.infoway.messagebuilder.model.cerx.deviceprescription.ClinicalDeviceBean;

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
