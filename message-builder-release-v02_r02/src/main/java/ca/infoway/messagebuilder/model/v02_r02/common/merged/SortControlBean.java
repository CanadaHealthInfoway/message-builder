/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.Sequencing;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>SortControl</p>
 * 
 * <p>MFMI_MT700751CA.SortControl: Sort Control</p>
 * 
 * <p><p>Holds specification of sort order for instance matches 
 * to a query.</p></p>
 * 
 * <p><p>Optional for systems which can receive query requests 
 * and sort the results before returning to the query 
 * requestor.</p></p>
 * 
 * <p>MFMI_MT700746CA.SortControl: Sort Control</p>
 * 
 * <p><p>Holds specification of sort order for instance matches 
 * to a query.</p></p>
 * 
 * <p><p>Optional for systems which can receive query requests 
 * and sort the results before returning to the query 
 * requestor.</p></p>
 */
@Hl7PartTypeMapping({"MFMI_MT700746CA.SortControl","MFMI_MT700751CA.SortControl"})
public class SortControlBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private INT sequenceNumber = new INTImpl();
    private ST sortElementName = new STImpl();
    private CS sortControlDirection = new CSImpl();


    /**
     * <p>SequenceNumber</p>
     * 
     * <p>Sequence Number</p>
     * 
     * <p><p>When more than one sort control is specified, this is 
     * the order of this sort element amongst the others.</p></p>
     * 
     * <p><p>This number determines which sort element is using 
     * primarily, secondary, etc. and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>SortElementName</p>
     * 
     * <p>Sort Element Name</p>
     * 
     * <p><p>Name of the element to sort.</p></p>
     * 
     * <p><p>The name of the element is mandatory.</p></p>
     */
    @Hl7XmlMapping({"elementName"})
    public String getSortElementName() {
        return this.sortElementName.getValue();
    }
    public void setSortElementName(String sortElementName) {
        this.sortElementName.setValue(sortElementName);
    }


    /**
     * <p>SortControlDirection</p>
     * 
     * <p>Sort Control Direction</p>
     * 
     * <p><p>Sets the ascending or descending nature of the sort 
     * request.</p></p>
     * 
     * <p><p>This element is required.</p></p>
     */
    @Hl7XmlMapping({"directionCode"})
    public Sequencing getSortControlDirection() {
        return (Sequencing) this.sortControlDirection.getValue();
    }
    public void setSortControlDirection(Sequencing sortControlDirection) {
        this.sortControlDirection.setValue(sortControlDirection);
    }

}
