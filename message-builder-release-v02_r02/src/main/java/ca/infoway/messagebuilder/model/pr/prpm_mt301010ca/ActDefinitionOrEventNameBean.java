/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt301010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.LocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Act Definition or Event Name</p>
 * 
 * <p>A record of something that is being done, has been done, 
 * can be done, or is intended or requested to be done. Acts 
 * connect to Entities in their Roles through Participations 
 * and connect to other Acts through ActRelationships. 
 * Participations are the authors, performers and other 
 * responsible parties as well as subjects and beneficiaries 
 * (which includes tools and material used in the performance 
 * of the act, which are also subjects). The moodCode 
 * distinguishes between Acts that are meant as factual 
 * records, vs. records of intended or ordered services, and 
 * the other modalities in which act can appear.</p>
 * 
 * <p>Acts are the pivot of the RIM; all domain information and 
 * processes are represented primarily in Acts. Any profession 
 * or business, including healthcare, is primarily constituted 
 * of intentional and occasionally non-intentional actions, 
 * performed and recorded by responsible actors. An 
 * Act-instance is a record of such an action.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.ActDefinitionOrEvent"})
public class ActDefinitionOrEventNameBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private IVL<TS, Interval<Date>> actDefinitionOrEventNameEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private List<LocationBean> location = new ArrayList<LocationBean>();
    private List<SequelToBean> sequel = new ArrayList<SequelToBean>();

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getActDefinitionOrEventNameEffectiveTime() {
        return this.actDefinitionOrEventNameEffectiveTime.getValue();
    }
    public void setActDefinitionOrEventNameEffectiveTime(Interval<Date> actDefinitionOrEventNameEffectiveTime) {
        this.actDefinitionOrEventNameEffectiveTime.setValue(actDefinitionOrEventNameEffectiveTime);
    }

    @Hl7XmlMapping({"location"})
    public List<LocationBean> getLocation() {
        return this.location;
    }

    @Hl7XmlMapping({"sequel"})
    public List<SequelToBean> getSequel() {
        return this.sequel;
    }

}
