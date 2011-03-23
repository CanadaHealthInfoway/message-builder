/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT220100CA.Content","COCT_MT220110CA.Content","COCT_MT220200CA.Content","COCT_MT220210CA.Content","POME_MT010040CA.Content","POME_MT010100CA.Content"})
public class DispensedInBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private PQ drugPackageQuantity = new PQImpl();
    private DrugPackageBean containerPackagedMedicine;

    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getDrugPackageQuantity() {
        return this.drugPackageQuantity.getValue();
    }
    public void setDrugPackageQuantity(PhysicalQuantity drugPackageQuantity) {
        this.drugPackageQuantity.setValue(drugPackageQuantity);
    }

    @Hl7XmlMapping({"containerPackagedMedicine"})
    public DrugPackageBean getContainerPackagedMedicine() {
        return this.containerPackagedMedicine;
    }
    public void setContainerPackagedMedicine(DrugPackageBean containerPackagedMedicine) {
        this.containerPackagedMedicine = containerPackagedMedicine;
    }

}
