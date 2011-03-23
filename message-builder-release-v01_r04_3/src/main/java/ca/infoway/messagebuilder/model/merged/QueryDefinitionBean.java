/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"QUQI_MT020000CA.QueryByParameter","QUQI_MT120000CA.QueryByParameter"})
public class QueryDefinitionBean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II queryIdentifier = new IIImpl();
    private INT queryLimit = new INTImpl();
    private PL parameterList;

    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }

    @Hl7XmlMapping({"initialQuantity"})
    public Integer getQueryLimit() {
        return this.queryLimit.getValue();
    }
    public void setQueryLimit(Integer queryLimit) {
        this.queryLimit.setValue(queryLimit);
    }

    @Hl7XmlMapping({"parameterList"})
    public PL getParameterList() {
        return this.parameterList;
    }
    public void setParameterList(PL parameterList) {
        this.parameterList = parameterList;
    }

}
