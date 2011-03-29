/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT410003CA.Component2","REPC_MT420003CA.Component2","REPC_MT610002CA.Component"})
public class Component2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private WorkingListEventBean workingListEvent;


    @Hl7XmlMapping({"workingListEvent"})
    public WorkingListEventBean getWorkingListEvent() {
        return this.workingListEvent;
    }
    public void setWorkingListEvent(WorkingListEventBean workingListEvent) {
        this.workingListEvent = workingListEvent;
    }

}