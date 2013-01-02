/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CreatedAtBean;



/**
 * <p>Business Name: Logon</p>
 * 
 * <p>COMT_MT900001AB.ActPermissionRequest: Logon</p>
 * 
 * <p>Represents a request to being given permission to access 
 * a system.</p>
 * 
 * <p>Rather than relying on local PoS applications for user 
 * authentication, some jurisdictions will require direct 
 * authentication to the central EHR application. This message 
 * is used where that authentication does not occur via other 
 * standards.</p>
 * 
 * <p>COMT_MT900003AB.ActPermissionRequest: Logon</p>
 * 
 * <p>Represents a request to being given permission to access 
 * a system.</p>
 * 
 * <p>Rather than relying on local PoS applications for user 
 * authentication, some jurisdictions will require direct 
 * authentication to the central EHR application. This message 
 * is used where that authentication does not occur via other 
 * standards.</p>
 */
@Hl7PartTypeMapping({"COMT_MT900001AB.ActPermissionRequest","COMT_MT900003AB.ActPermissionRequest"})
@Hl7RootType
public class ActPermissionRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II subjectAssignedDeviceAssignedDeviceId = new IIImpl();
    private ST performerSignatureText = new STImpl();
    private II performerAssignedEntityId = new IIImpl();
    private CreatedAtBean location;
    private ST performer1SignatureText = new STImpl();
    private II performer1AssignedEntityId = new IIImpl();
    private ST performer2SignatureText = new STImpl();
    private II performer2AssignedEntityId = new IIImpl();


    /**
     * <p>Business Name: LogonApplication</p>
     * 
     * <p>Un-merged Business Name: LogonApplication</p>
     * 
     * <p>Relationship: COMT_MT900001AB.Device.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This must be the &quot;receiving application&quot; from 
     * the transmission wrapper</p>
     * 
     * <p>Indicates the application to which the user is logging 
     * on.</p>
     * 
     * <p>This is mandatory, as logons must be associated with a 
     * particular application. Note that the application might be a 
     * &quot;logical&quot; construct providing access to numerous 
     * physical systems, or might only provide access to a part of 
     * a physical system.</p>
     * 
     * <p>Un-merged Business Name: LogonApplication</p>
     * 
     * <p>Relationship: COMT_MT900003AB.Device.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the application to which the password change 
     * applies</p>
     * 
     * <p>This is mandatory, as passwords must be associated with a 
     * particular application. Note that the application might be a 
     * &quot;logical&quot; construct providing access to numerous 
     * physical systems, or might only provide access to a part of 
     * a physical system.</p>
     */
    @Hl7XmlMapping({"subject/assignedDevice/assignedDevice/id"})
    public Identifier getSubjectAssignedDeviceAssignedDeviceId() {
        return this.subjectAssignedDeviceAssignedDeviceId.getValue();
    }

    /**
     * <p>Business Name: LogonApplication</p>
     * 
     * <p>Un-merged Business Name: LogonApplication</p>
     * 
     * <p>Relationship: COMT_MT900001AB.Device.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This must be the &quot;receiving application&quot; from 
     * the transmission wrapper</p>
     * 
     * <p>Indicates the application to which the user is logging 
     * on.</p>
     * 
     * <p>This is mandatory, as logons must be associated with a 
     * particular application. Note that the application might be a 
     * &quot;logical&quot; construct providing access to numerous 
     * physical systems, or might only provide access to a part of 
     * a physical system.</p>
     * 
     * <p>Un-merged Business Name: LogonApplication</p>
     * 
     * <p>Relationship: COMT_MT900003AB.Device.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the application to which the password change 
     * applies</p>
     * 
     * <p>This is mandatory, as passwords must be associated with a 
     * particular application. Note that the application might be a 
     * &quot;logical&quot; construct providing access to numerous 
     * physical systems, or might only provide access to a part of 
     * a physical system.</p>
     */
    public void setSubjectAssignedDeviceAssignedDeviceId(Identifier subjectAssignedDeviceAssignedDeviceId) {
        this.subjectAssignedDeviceAssignedDeviceId.setValue(subjectAssignedDeviceAssignedDeviceId);
    }


    /**
     * <p>Business Name: Password</p>
     * 
     * <p>Un-merged Business Name: Password</p>
     * 
     * <p>Relationship: COMT_MT900001AB.Performer.signatureText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the current password associated with the user id 
     * used to authenticate the user to the application.</p>
     * 
     * <p>This element is mandatory because validating identity is 
     * the key function of the logon transaction.</p>
     */
    @Hl7XmlMapping({"performer/signatureText"})
    public String getPerformerSignatureText() {
        return this.performerSignatureText.getValue();
    }

    /**
     * <p>Business Name: Password</p>
     * 
     * <p>Un-merged Business Name: Password</p>
     * 
     * <p>Relationship: COMT_MT900001AB.Performer.signatureText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the current password associated with the user id 
     * used to authenticate the user to the application.</p>
     * 
     * <p>This element is mandatory because validating identity is 
     * the key function of the logon transaction.</p>
     */
    public void setPerformerSignatureText(String performerSignatureText) {
        this.performerSignatureText.setValue(performerSignatureText);
    }


    /**
     * <p>Business Name: LogonUser</p>
     * 
     * <p>Un-merged Business Name: LogonUser</p>
     * 
     * <p>Relationship: COMT_MT900001AB.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the userid of the person being logged on.</p>
     * 
     * <p>This is mandatory because you can't log someone on if you 
     * don't know who they are . . .</p>
     */
    @Hl7XmlMapping({"performer/assignedEntity/id"})
    public Identifier getPerformerAssignedEntityId() {
        return this.performerAssignedEntityId.getValue();
    }

    /**
     * <p>Business Name: LogonUser</p>
     * 
     * <p>Un-merged Business Name: LogonUser</p>
     * 
     * <p>Relationship: COMT_MT900001AB.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the userid of the person being logged on.</p>
     * 
     * <p>This is mandatory because you can't log someone on if you 
     * don't know who they are . . .</p>
     */
    public void setPerformerAssignedEntityId(Identifier performerAssignedEntityId) {
        this.performerAssignedEntityId.setValue(performerAssignedEntityId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COMT_MT900001AB.ActPermissionRequest.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COMT_MT900001AB.ActPermissionRequest.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Business Name: OldPassword</p>
     * 
     * <p>Un-merged Business Name: OldPassword</p>
     * 
     * <p>Relationship: COMT_MT900003AB.Performer.signatureText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the original password associated with the user id 
     * previously used to authenticate the user to the 
     * application.</p>
     * 
     * <p>This element is mandatory to validate that the password 
     * is being changed by the original user.</p>
     */
    @Hl7XmlMapping({"performer1/signatureText"})
    public String getPerformer1SignatureText() {
        return this.performer1SignatureText.getValue();
    }

    /**
     * <p>Business Name: OldPassword</p>
     * 
     * <p>Un-merged Business Name: OldPassword</p>
     * 
     * <p>Relationship: COMT_MT900003AB.Performer.signatureText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is the original password associated with the user id 
     * previously used to authenticate the user to the 
     * application.</p>
     * 
     * <p>This element is mandatory to validate that the password 
     * is being changed by the original user.</p>
     */
    public void setPerformer1SignatureText(String performer1SignatureText) {
        this.performer1SignatureText.setValue(performer1SignatureText);
    }


    /**
     * <p>Business Name: LogonUser</p>
     * 
     * <p>Un-merged Business Name: LogonUser</p>
     * 
     * <p>Relationship: COMT_MT900003AB.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the userid of the person being logged on.</p>
     * 
     * <p>This is mandatory because you can't log someone on if you 
     * don't know who they are . . .</p>
     */
    @Hl7XmlMapping({"performer1/assignedEntity/id"})
    public Identifier getPerformer1AssignedEntityId() {
        return this.performer1AssignedEntityId.getValue();
    }

    /**
     * <p>Business Name: LogonUser</p>
     * 
     * <p>Un-merged Business Name: LogonUser</p>
     * 
     * <p>Relationship: COMT_MT900003AB.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the userid of the person being logged on.</p>
     * 
     * <p>This is mandatory because you can't log someone on if you 
     * don't know who they are . . .</p>
     */
    public void setPerformer1AssignedEntityId(Identifier performer1AssignedEntityId) {
        this.performer1AssignedEntityId.setValue(performer1AssignedEntityId);
    }


    /**
     * <p>Business Name: NewPassword</p>
     * 
     * <p>Un-merged Business Name: NewPassword</p>
     * 
     * <p>Relationship: COMT_MT900003AB.Performer2.signatureText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the value the password should be changed to</p>
     * 
     * <p>Mandatory because a null password is not allowed</p>
     */
    @Hl7XmlMapping({"performer2/signatureText"})
    public String getPerformer2SignatureText() {
        return this.performer2SignatureText.getValue();
    }

    /**
     * <p>Business Name: NewPassword</p>
     * 
     * <p>Un-merged Business Name: NewPassword</p>
     * 
     * <p>Relationship: COMT_MT900003AB.Performer2.signatureText</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the value the password should be changed to</p>
     * 
     * <p>Mandatory because a null password is not allowed</p>
     */
    public void setPerformer2SignatureText(String performer2SignatureText) {
        this.performer2SignatureText.setValue(performer2SignatureText);
    }


    /**
     * <p>Business Name: LogonUser</p>
     * 
     * <p>Un-merged Business Name: LogonUser</p>
     * 
     * <p>Relationship: COMT_MT900003AB.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the userid of the person being logged on.</p>
     * 
     * <p>This is mandatory because you can't log someone on if you 
     * don't know who they are . . .</p>
     */
    @Hl7XmlMapping({"performer2/assignedEntity/id"})
    public Identifier getPerformer2AssignedEntityId() {
        return this.performer2AssignedEntityId.getValue();
    }

    /**
     * <p>Business Name: LogonUser</p>
     * 
     * <p>Un-merged Business Name: LogonUser</p>
     * 
     * <p>Relationship: COMT_MT900003AB.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the userid of the person being logged on.</p>
     * 
     * <p>This is mandatory because you can't log someone on if you 
     * don't know who they are . . .</p>
     */
    public void setPerformer2AssignedEntityId(Identifier performer2AssignedEntityId) {
        this.performer2AssignedEntityId.setValue(performer2AssignedEntityId);
    }

}
