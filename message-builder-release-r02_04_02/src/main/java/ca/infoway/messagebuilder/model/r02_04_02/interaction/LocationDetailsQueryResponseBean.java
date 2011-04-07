/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.common.mfmi_mt700746ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.r02_04_02.lr.merged.QueryDefinitionBean;
import ca.infoway.messagebuilder.model.r02_04_02.lr.prpa_mt202303ca.LocationBean;



@Hl7PartTypeMapping({"PRPA_IN202308CA"})
public class LocationDetailsQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<QueryDefinitionBean,LocationBean>> implements InteractionBean {

    private static final long serialVersionUID = 20110407L;

}
