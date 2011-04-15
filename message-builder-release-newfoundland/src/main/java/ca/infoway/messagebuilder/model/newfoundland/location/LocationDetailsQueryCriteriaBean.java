package ca.infoway.messagebuilder.model.newfoundland.location;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.newfoundland.QueryCriteria;

public class LocationDetailsQueryCriteriaBean extends QueryCriteria {

    private static final long serialVersionUID = 2015306038028268909L;

    private List<II> recordIds = new ArrayList<II>();

    private List<II> protocolIds = new ArrayList<II>();

    @Hl7XmlMapping("recordId/value")
    public List<Identifier> getRecordIds() {
    	return new RawListWrapper<II, Identifier>(this.recordIds, IIImpl.class);
    }

    @Hl7XmlMapping("protocolId/value")
    public List<Identifier> getProtocolIds() {
    	return new RawListWrapper<II, Identifier>(this.protocolIds, IIImpl.class);
    }
}
