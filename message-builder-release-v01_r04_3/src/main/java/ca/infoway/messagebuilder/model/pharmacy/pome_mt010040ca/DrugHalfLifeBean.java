/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POME_MT010040CA.HalfLife"})
public class DrugHalfLifeBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private PQ halfLifePeriod = new PQImpl();


    /**
     * <p>Half-Life Period</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getHalfLifePeriod() {
        return this.halfLifePeriod.getValue();
    }
    public void setHalfLifePeriod(PhysicalQuantity halfLifePeriod) {
        this.halfLifePeriod.setValue(halfLifePeriod);
    }

}
