/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt240003ca.ServiceLocationBean;
import java.util.Date;



@Hl7PartTypeMapping({"COMT_MT300003CA.Location","MCAI_MT700210CA.Location","MCAI_MT700221CA.Location","MCAI_MT700223CA.Location","POIZ_MT060150CA.Location","PORX_MT010110CA.Location2","PORX_MT010120CA.Location2","PORX_MT010140CA.Location","PORX_MT030040CA.Location","PORX_MT030040CA.Location2","PORX_MT060010CA.Location","PORX_MT060020CA.Location","PORX_MT060040CA.Location","PORX_MT060040CA.Location2","PORX_MT060040CA.Location3","PORX_MT060040CA.Location4","PORX_MT060060CA.Location","PORX_MT060060CA.Location2","PORX_MT060090CA.Location","PORX_MT060100CA.Location","PORX_MT060160CA.Location","PORX_MT060160CA.Location2","PORX_MT060160CA.Location3","PORX_MT060160CA.Location4","PORX_MT060160CA.Location5","PORX_MT060190CA.Location2","PORX_MT060190CA.Location3","PORX_MT060190CA.Location4","PORX_MT060210CA.Location2","PORX_MT060340CA.Location","PORX_MT060340CA.Location2","PORX_MT060340CA.Location3","PORX_MT060340CA.Location4","PORX_MT980010CA.Location","PORX_MT980020CA.Location","PORX_MT980030CA.Location","QUQI_MT020000CA.Location","REPC_MT000005CA.Location","REPC_MT000006CA.Location","REPC_MT000007CA.Location","REPC_MT000009CA.Location","REPC_MT000010CA.Location","REPC_MT100001CA.Location","REPC_MT100002CA.Location"})
public class RecordedAtBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private ServiceLocationBean serviceDeliveryLocation;
    private IVL<TS, Interval<Date>> time = new IVLImpl<TS, Interval<Date>>();
    private CV substitutionConditionCode = new CVImpl();


    @Hl7XmlMapping({"serviceDeliveryLocation"})
    public ServiceLocationBean getServiceDeliveryLocation() {
        return this.serviceDeliveryLocation;
    }
    public void setServiceDeliveryLocation(ServiceLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }


    /**
     * <p>ToBePickedUpWhen</p>
     * 
     * <p>to be picked up when</p>
     * 
     * <p>To be picked up when</p>
     */
    @Hl7XmlMapping({"time"})
    public Interval<Date> getTime() {
        return this.time.getValue();
    }
    public void setTime(Interval<Date> time) {
        this.time.setValue(time);
    }


    /**
     * <p>Dispense Facility Not Reassignable</p>
     * 
     * <p>Assigned Facility Not Reassignable Indicator</p>
     * 
     * <p>Dispense Facility Not Assignable Indicator</p>
     */
    @Hl7XmlMapping({"substitutionConditionCode"})
    public x_SubstitutionConditionNoneOrUnconditional getSubstitutionConditionCode() {
        return (x_SubstitutionConditionNoneOrUnconditional) this.substitutionConditionCode.getValue();
    }
    public void setSubstitutionConditionCode(x_SubstitutionConditionNoneOrUnconditional substitutionConditionCode) {
        this.substitutionConditionCode.setValue(substitutionConditionCode);
    }

}
