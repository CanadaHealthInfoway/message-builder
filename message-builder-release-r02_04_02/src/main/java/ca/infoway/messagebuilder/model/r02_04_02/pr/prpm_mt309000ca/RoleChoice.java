/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.pr.prpm_mt309000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.r02_04_02.pr.merged.PrivilegeBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"PRPM_MT309000CA.RoleChoice"})
@Hl7RootType
public interface RoleChoice {

    public List<PrivilegeBean> getResponsibleForPrivilege();

    public List<RoleChoice> getRelatedToRoleChoice();

}