/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt280001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;



/**
 * <p>Previous Billable Act Cross Reference 
 * 
 * <p>Used to reference a previous act (e.g. billable act) by 
 * including its Act.id. May only be used to reference a 
 * billable act in the SAME message, not for past messages 
 * (this would require adjudicators to keep a lot of history). 
 * 
 * <p>Used to reference a previous act (e.g. billable act) by 
 * including its Act.id. May only be used to reference a 
 * billable act in the SAME message, not for past messages 
 * (this would require adjudicators to keep a lot of history). 
 */
@Hl7PartTypeMapping({"COCT_MT280001CA.CrossReference"})
public class PreviousBillableActCrossReferenceBean extends MessagePartBean implements A_BillableActChoiceBean {

    private SET<II, Identifier> actId = new SETImpl<II, Identifier>(IIImpl.class);

    @Hl7XmlMapping({"id"})
    public Set<Identifier> getActId() {
        return this.actId.rawSet();
    }

}
