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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: RefersTo</p>
 * 
 * <p>QUQI_MT120006CA.Subject2: f:refers to</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700222CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions where the state transition is 
 * null-&gt;active, contextConductionInd must be true, 
 * otherwise it must be false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>QUQI_MT120008CA.Subject2: f:refers to</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700211CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions where the state transition is 
 * null-&gt;active, contextConductionInd must be true, 
 * otherwise it must be false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700221CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions where the state transition is 
 * null-&gt;active, contextConductionInd must be true, 
 * otherwise it must be false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700212CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions where the state transition is 
 * null-&gt;active, contextConductionInd must be true, 
 * otherwise it must be false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700217CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions where the state transition is 
 * null-&gt;active, contextConductionInd must be true, 
 * otherwise it must be false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700218CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions where the state transition is 
 * null-&gt;active, contextConductionInd must be true, 
 * otherwise it must be false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700226CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions where the state transition is 
 * null-&gt;active, contextConductionInd must be true, 
 * otherwise it must be false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700210CA.Subject2: f:refers to</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p><p>If true, associations 
 * in the parent act are conducted across the ActRelationship 
 * to the message payload (act). Conduction for each 
 * association is specifically indicated by each associations' 
 * contextControlCode value.</p><p>In other words, if the 
 * &quot;subject&quot; act relationship has 
 * contextConductionInd=true; THEN the dataEnterer association 
 * is carried according to the dataEnterer.contextControlCode 
 * (propogate to the payload and add to any data enterer(s) 
 * already present in the payload).</p>
 * 
 * <p>MCAI_MT700216CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions where the state transition is 
 * null-&gt;active, contextConductionInd must be true, 
 * otherwise it must be false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700228CA.Subject2: f:refers to</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700227CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions where the state transition is 
 * null-&gt;active, contextConductionInd must be true, 
 * otherwise it must be false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MCAI_MT700220CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions where the state transition is 
 * null-&gt;active, contextConductionInd must be true, 
 * otherwise it must be false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 */
@Hl7PartTypeMapping({"MCAI_MT700210CA.Subject2","MCAI_MT700211CA.Subject2","MCAI_MT700212CA.Subject2","MCAI_MT700216CA.Subject2","MCAI_MT700217CA.Subject2","MCAI_MT700218CA.Subject2","MCAI_MT700220CA.Subject2","MCAI_MT700221CA.Subject2","MCAI_MT700222CA.Subject2","MCAI_MT700226CA.Subject2","MCAI_MT700227CA.Subject2","MCAI_MT700228CA.Subject2","QUQI_MT120006CA.Subject2","QUQI_MT120008CA.Subject2"})
public class RefersTo_1Bean<ACT> extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private BL contextConductionInd = new BLImpl();
    private ACT act;


    /**
     * <p>Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationEvent act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * event and add to any subject(s) (issues) already 
     * present).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700222CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the dataEnterer association 
     * is carried (to the payload) according to the 
     * dataEnterer.contextControlCode (AP = propogate to the 
     * payload and add to any data enterer(s) already present in 
     * the payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationEvent act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * event and add to any subject(s) (issues) already 
     * present).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700211CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the dataEnterer association 
     * is carried (to the payload) according to the 
     * dataEnterer.contextControlCode (AP = propogate to the 
     * payload and add to any data enterer(s) already present in 
     * the payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700221CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the dataEnterer association 
     * is carried (to the payload) according to the 
     * dataEnterer.contextControlCode (AP = propogate to the 
     * payload and add to any data enterer(s) already present in 
     * the payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700212CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the dataEnterer association 
     * is carried (to the payload) according to the 
     * dataEnterer.contextControlCode (AP = propogate to the 
     * payload and add to any data enterer(s) already present in 
     * the payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700217CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the payload) according to the 
     * subjectOf.contextControlCode (AP = propogate to the payload 
     * and add to any subject(s) (issues) already present in the 
     * payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700218CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the payload) according to the 
     * subjectOf.contextControlCode (AP = propogate to the payload 
     * and add to any subject(s) (issues) already present in the 
     * payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700226CA.Subject2.contextConductionInd</p>
     * 
     * <p>
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    /**
     * <p>Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationEvent act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * event and add to any subject(s) (issues) already 
     * present).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700222CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the dataEnterer association 
     * is carried (to the payload) according to the 
     * dataEnterer.contextControlCode (AP = propogate to the 
     * payload and add to any data enterer(s) already present in 
     * the payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationEvent act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * event and add to any subject(s) (issues) already 
     * present).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700211CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the dataEnterer association 
     * is carried (to the payload) according to the 
     * dataEnterer.contextControlCode (AP = propogate to the 
     * payload and add to any data enterer(s) already present in 
     * the payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700221CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the dataEnterer association 
     * is carried (to the payload) according to the 
     * dataEnterer.contextControlCode (AP = propogate to the 
     * payload and add to any data enterer(s) already present in 
     * the payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700212CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the dataEnterer association 
     * is carried (to the payload) according to the 
     * dataEnterer.contextControlCode (AP = propogate to the 
     * payload and add to any data enterer(s) already present in 
     * the payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700217CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the payload) according to the 
     * subjectOf.contextControlCode (AP = propogate to the payload 
     * and add to any subject(s) (issues) already present in the 
     * payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700218CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the payload) according to the 
     * subjectOf.contextControlCode (AP = propogate to the payload 
     * and add to any subject(s) (issues) already present in the 
     * payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700226CA.Subject2.contextConductionInd</p>
     * 
     * <p>
     * ... [rest of documentation truncated due to excessive length]
     */
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700222CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700212CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700217CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700218CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700226CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700216CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700228CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700227CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"act"})
    public ACT getAct() {
        return this.act;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700222CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700212CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700217CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700218CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700226CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700216CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700228CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700227CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.Subject2.act</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAct(ACT act) {
        this.act = act;
    }

}
