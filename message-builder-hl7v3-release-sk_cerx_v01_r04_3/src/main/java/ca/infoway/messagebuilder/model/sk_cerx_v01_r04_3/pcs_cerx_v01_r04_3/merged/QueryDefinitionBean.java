/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>QueryDefinition</p>
 * 
 * <p>QUQI_MT020000CA.QueryByParameter: Query definition</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
 * the content desired within a query.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * support for queries</p></p>
 * 
 * <p>QUQI_MT120000CA.QueryByParameter: Query definition</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
 * the content desired within a query.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * support for queries</p></p>
 */
@Hl7PartTypeMapping({"QUQI_MT020000CA.QueryByParameter","QUQI_MT120000CA.QueryByParameter"})
public class QueryDefinitionBean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private II queryIdentifier = new IIImpl();
    private INT queryLimit = new INTImpl();
    private PL parameterList;


    /**
     * <p>QueryIdentifier</p>
     * 
     * <p>H:Query Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Unique 
     * number for this particular query.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Needed to 
     * allow continuation of queries and linking of query requests 
     * and responses and therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }


    /**
     * <p>QueryLimit</p>
     * 
     * <p>I:Query Limit</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The number 
     * of response item repetitions that should be included in the 
     * initial response.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">There may be 
     * a very large number of matching rows. To manage 
     * communication bandwidth, a limited set may initially be 
     * returned with further data retrieved by using query 
     * continuations.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">If not 
     * specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p></p>
     * 
     * <p>I:Query Limit</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The number 
     * of response item repetitions that should be included in the 
     * initial response.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">There may be 
     * a very large number of matching rows. To manage 
     * communication bandwidth, a limited set may initially be 
     * returned with further data retrieved by using query 
     * continuations. If not specified, the default behavior is to 
     * return all repetitions. However the recipient of a query may 
     * always choose to limit the quantity returned to be less than 
     * the number requested.</p></p>
     */
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
