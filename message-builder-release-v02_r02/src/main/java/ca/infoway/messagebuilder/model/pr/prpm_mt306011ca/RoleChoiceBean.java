/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.merged.ResponsiblePartyBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"PRPM_MT306011CA.RoleChoice"})
@Hl7RootType
public interface RoleChoiceBean {

    public List<ResponsiblePartyBean> getResponsibleFor();

    public List<RelatedToBean> getRelatedTo();

}
