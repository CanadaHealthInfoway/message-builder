package ca.infoway.messagebuilder.model.cerx.query;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.QueryCriteria;

@Hl7PartTypeMapping("POME_MT010030CA.ParameterList")
public class DrugProductDetailQueryCriteriaBean extends QueryCriteria {

    private static final long serialVersionUID = 308915669755601939L;

    private CD drugCode = new CDImpl();

    @Hl7XmlMapping("drugCode/value")
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }

    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }
}
