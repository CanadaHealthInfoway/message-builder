/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120402ca.DiagnosisIndicationsBean;
import ca.infoway.messagebuilder.model.common.coct_mt120402ca.IndicationsBean;
import ca.infoway.messagebuilder.model.common.coct_mt120402ca.OtherIndicationsBean;



@Hl7PartTypeMapping({"POME_MT010040CA.Reason","PORX_MT010110CA.Reason2","PORX_MT010120CA.Reason2","PORX_MT030040CA.Reason","PORX_MT060040CA.Reason2","PORX_MT060060CA.Reason","PORX_MT060160CA.Reason2","PORX_MT060190CA.Reason","PORX_MT060340CA.Reason2","REPC_MT210001CA.Reason","REPC_MT210002CA.Reason","REPC_MT210003CA.Reason","REPC_MT220001CA.Reason","REPC_MT220002CA.Reason","REPC_MT220003CA.Reason","REPC_MT230001CA.Reason","REPC_MT230002CA.Reason","REPC_MT230003CA.Reason","REPC_MT410001CA.Reason","REPC_MT410003CA.Reason","REPC_MT420001CA.Reason","REPC_MT420003CA.Reason","REPC_MT500001CA.Reason","REPC_MT500002CA.Reason","REPC_MT500003CA.Reason","REPC_MT500004CA.Reason","REPC_MT610001CA.Reason","REPC_MT610002CA.Reason"})
public class BecauseOfBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private IndicationsBean indications;
    private INT indicationPriority = new INTImpl();

    @Hl7XmlMapping({"indications"})
    public IndicationsBean getIndications() {
        return this.indications;
    }
    public void setIndications(IndicationsBean indications) {
        this.indications = indications;
    }

    public DiagnosisIndicationsBean getIndicationsAsObservationProblem() {
        return this.indications instanceof DiagnosisIndicationsBean ? (DiagnosisIndicationsBean) this.indications : null;
    }
    public boolean hasIndicationsAsObservationProblem() {
        return (this.indications instanceof DiagnosisIndicationsBean);
    }

    public OtherIndicationsBean getIndicationsAsOtherIndication() {
        return this.indications instanceof OtherIndicationsBean ? (OtherIndicationsBean) this.indications : null;
    }
    public boolean hasIndicationsAsOtherIndication() {
        return (this.indications instanceof OtherIndicationsBean);
    }

    @Hl7XmlMapping({"priorityNumber"})
    public Integer getIndicationPriority() {
        return this.indicationPriority.getValue();
    }
    public void setIndicationPriority(Integer indicationPriority) {
        this.indicationPriority.setValue(indicationPriority);
    }

}
