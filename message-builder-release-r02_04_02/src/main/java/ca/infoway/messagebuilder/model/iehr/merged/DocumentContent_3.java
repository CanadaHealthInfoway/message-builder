/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT230002CA.DocumentContent","REPC_MT230003CA.DocumentContent"})
public interface DocumentContent_3 {

    public OccurredAtBean getLocation();
    public void setLocation(OccurredAtBean location);

    public List<BecauseOfBean> getReason();

}
