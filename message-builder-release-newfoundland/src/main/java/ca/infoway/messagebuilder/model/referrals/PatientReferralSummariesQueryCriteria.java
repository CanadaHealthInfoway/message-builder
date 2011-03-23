package ca.infoway.messagebuilder.model.referrals;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.QueryCriteria;

public class PatientReferralSummariesQueryCriteria extends QueryCriteria {

    private static final long serialVersionUID = 8347085172294469697L;

    private final BL mostRecentByTypeIndicator = new BLImpl(false);

    @Hl7XmlMapping("mostRecentByTypeIndicator/value")
    public boolean isMostRecentByTypeIndicator() {
        return this.mostRecentByTypeIndicator.getValue();
    }

    public void setMostRecentByTypeIndicator(boolean mostRecentByTypeIndicator) {
        this.mostRecentByTypeIndicator.setValue(mostRecentByTypeIndicator);
    }
}
