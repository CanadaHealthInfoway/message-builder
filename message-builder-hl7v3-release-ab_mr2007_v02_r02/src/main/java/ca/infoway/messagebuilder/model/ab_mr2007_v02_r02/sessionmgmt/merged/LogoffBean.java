/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.comt_mt900004ab.TransactionPermissionBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>COMT_MT900002AB.ActPermission: Logoff</p>
 * 
 * <p><p>Represents the ending of a request for access to a 
 * system.</p></p>
 * 
 * <p><p>For security reasons, access permissions should be 
 * revoked when they are no longer required</p></p>
 * 
 * <p>COMT_MT900004AB.ActPermission: Logon</p>
 * 
 * <p><p>Represents a request to being given permission to 
 * access a system.</p></p>
 * 
 * <p><p>Rather than relying on local PoS applications for user 
 * authentication, some jurisdictions will require direct 
 * authentication to the central EHR application. This message 
 * is used where that authentication does not occur via other 
 * standards.</p></p>
 */
@Hl7PartTypeMapping({"COMT_MT900002AB.ActPermission","COMT_MT900004AB.ActPermission"})
@Hl7RootType
public class LogoffBean extends MessagePartBean {

    private static final long serialVersionUID = 20120122L;
    private II id = new IIImpl();
    private IVL<TS, Interval<Date>> performerTime = new IVLImpl<TS, Interval<Date>>();
    private II performerAssignedEntityId = new IIImpl();
    private List<TransactionPermissionBean> componentTransactionPermission = new ArrayList<TransactionPermissionBean>();


    /**
     * <p>A:Security Token</p>
     * 
     * <p><p>A unique token indicating that the user has been 
     * authenticated to the system.</p></p>
     * 
     * <p><p>The token is needed for inclusion in subsequent 
     * messages to identify that the transaction is being performed 
     * under the auspices of an authenticated user.</p></p>
     * 
     * <p>Authentication Token</p>
     * 
     * <p><p>Indicates the authentication token to be 
     * revoked/ended</p></p>
     * 
     * <p><p>Needed to identify which session is to be logged 
     * off.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>PasswordExpiryDate</p>
     * 
     * <p>C: Password Expiry Date</p>
     * 
     * <p><p>Indicates the last date that the current password for 
     * the authenticating user will be considered valid.</p></p>
     * 
     * <p><p>Ensures the user is aware of when their password is 
     * next scheduled to expire.</p></p>
     */
    @Hl7XmlMapping({"performer/time"})
    public Interval<Date> getPerformerTime() {
        return this.performerTime.getValue();
    }
    public void setPerformerTime(Interval<Date> performerTime) {
        this.performerTime.setValue(performerTime);
    }


    /**
     * <p>ProviderId</p>
     * 
     * <p>B: Provider id</p>
     * 
     * <p><p>The identifier of the provider logged on</p></p>
     * 
     * <p><p>Links the user id to the provider id</p></p>
     * 
     * <p><p>The Wellnet Provider Id of the assigned person is 
     * returned.</p></p>
     */
    @Hl7XmlMapping({"performer/assignedEntity/id"})
    public Identifier getPerformerAssignedEntityId() {
        return this.performerAssignedEntityId.getValue();
    }
    public void setPerformerAssignedEntityId(Identifier performerAssignedEntityId) {
        this.performerAssignedEntityId.setValue(performerAssignedEntityId);
    }


    @Hl7XmlMapping({"component/transactionPermission"})
    public List<TransactionPermissionBean> getComponentTransactionPermission() {
        return this.componentTransactionPermission;
    }

}
