/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.v02_r01.claims.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.v02_r01.claims.coct_mt280001ca.CrossReferenceBean;
import ca.infoway.messagebuilder.model.v02_r01.claims.coct_mt290000ca.BillableClinicalServiceBean;
import ca.infoway.messagebuilder.model.v02_r01.claims.coct_mt300000ca.PharmacyDispenseBean;
import ca.infoway.messagebuilder.model.v02_r01.claims.coct_mt490000ca.BillableClinicalProductBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementChoice"})
public interface InvoiceElementChoice {

    public List<A_BillableActChoice> getReasonOfBillableActChoice();

}
