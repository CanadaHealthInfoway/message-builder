/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"PRPA_MT202307CA.ParameterList","REPC_MT500006CA.ParameterList"})
@Hl7RootType
public class ParameterList_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private List<II> protocolIds = new ArrayList<II>();
    private List<II> recordIds = new ArrayList<II>();
    private BL includeHistoryIndicator = new BLImpl();
    private BL includeNotesIndicator = new BLImpl();

    @Hl7XmlMapping({"protocolId/value"})
    public List<Identifier> getProtocolIds() {
        return new RawListWrapper<II, Identifier>(protocolIds, IIImpl.class);
    }

    @Hl7XmlMapping({"recordId/value"})
    public List<Identifier> getRecordIds() {
        return new RawListWrapper<II, Identifier>(recordIds, IIImpl.class);
    }

    @Hl7XmlMapping({"includeHistoryIndicator/value"})
    public Boolean getIncludeHistoryIndicator() {
        return this.includeHistoryIndicator.getValue();
    }
    public void setIncludeHistoryIndicator(Boolean includeHistoryIndicator) {
        this.includeHistoryIndicator.setValue(includeHistoryIndicator);
    }

    @Hl7XmlMapping({"includeNotesIndicator/value"})
    public Boolean getIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }
    public void setIncludeNotesIndicator(Boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

}
