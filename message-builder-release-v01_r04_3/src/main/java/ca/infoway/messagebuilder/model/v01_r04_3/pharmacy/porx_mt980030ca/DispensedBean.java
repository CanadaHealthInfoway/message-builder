/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt980030ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt220210ca.DrugProductBean;



@Hl7PartTypeMapping({"PORX_MT980030CA.Product"})
public class DispensedBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private DrugProductBean medication;


    @Hl7XmlMapping({"medication"})
    public DrugProductBean getMedication() {
        return this.medication;
    }
    public void setMedication(DrugProductBean medication) {
        this.medication = medication;
    }

}
