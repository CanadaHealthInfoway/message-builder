package ca.infoway.messagebuilder.model.cerx;

import java.io.Serializable;


public interface MedicationChoice extends Serializable {

	public MedicineBean getMedicineBean();
	public void setMedicineBean(MedicineBean medicineBean);
	
}
