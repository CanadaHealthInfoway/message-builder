/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"COMT_MT001101CA.ActRequest","COMT_MT001103CA.ActEvent","COMT_MT001201CA.Role"})
@Hl7RootType
public class ReferencedRecordBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private SET<II, Identifier> recordIds = new SETImpl<II, Identifier>(IIImpl.class);


    /**
     * <p>RecordIds</p>
     * 
     * <p>Record Ids</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getRecordIds() {
        return this.recordIds.rawSet();
    }

}
