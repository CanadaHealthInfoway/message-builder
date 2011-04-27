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

package ca.infoway.messagebuilder.resolver.configurator;

import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailCode;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailType;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementType;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.domainvalue.ActReason;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipSubset;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.Confidentiality;
import ca.infoway.messagebuilder.domainvalue.Country;
import ca.infoway.messagebuilder.domainvalue.HL7StandardVersionCode;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.MessageWaitingPriority;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.ObservationQueryMatchType;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.QueryResponse;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;
import ca.infoway.messagebuilder.domainvalue.RoleClass;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.RoleStatusNormal;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.domainvalue.State;
import ca.infoway.messagebuilder.domainvalue.SubscriptionStatus;
import ca.infoway.messagebuilder.domainvalue.TopicPriority;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodIntentEvent;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.domainvalue.basic.Iso3166Alpha2Country;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

/**
 * <p>The Class DefaultCodeResolutionConfigurator.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - terminology - translated manually
 */
public class DefaultCodeResolutionConfigurator {
	
	/**
	 * <p>Configure code resolvers with trivial default.
	 */
	public static void configureCodeResolversWithTrivialDefault() {
		
		CodeResolverRegistry.registerResolver(Country.class, 
				new EnumBasedCodeResolver(Iso3166Alpha2Country.class));
		CodeResolverRegistry.registerResolver(AcknowledgementCondition.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition.class));
		CodeResolverRegistry.registerResolver(AcknowledgementDetailCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailCode.class));
		CodeResolverRegistry.registerResolver(AcknowledgementDetailType.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailType.class));
		CodeResolverRegistry.registerResolver(AcknowledgementType.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementType.class));
		CodeResolverRegistry.registerResolver(ActCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActCode.class));
		CodeResolverRegistry.registerResolver(ActConsentInformationAccessReason.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActConsentInformationAccessReason.class));
		CodeResolverRegistry.registerResolver(ActDetectedIssueCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActDetectedIssueCode.class));
		CodeResolverRegistry.registerResolver(ActIssuePriority.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActIssuePriority.class));
		CodeResolverRegistry.registerResolver(ActPharmacySupplyType.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.ActPharmacySupplyType.class));
		CodeResolverRegistry.registerResolver(ActReason.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.ActReason.class));
		CodeResolverRegistry.registerResolver(ActRelationshipSubset.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.ActRelationshipSubset.class));
		CodeResolverRegistry.registerResolver(ActStatus.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActStatus.class));
		CodeResolverRegistry.registerResolver(AdministrativeGender.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender.class));
		CodeResolverRegistry.registerResolver(Confidentiality.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.Confidentiality.class));
		CodeResolverRegistry.registerResolver(HL7StandardVersionCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.HL7StandardVersionCode.class));
		CodeResolverRegistry.registerResolver(HL7TriggerEventCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.class));
		CodeResolverRegistry.registerResolver(IssueFilterCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.IssueFilterCode.class));
		CodeResolverRegistry.registerResolver(MessageWaitingPriority.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.MessageWaitingPriority.class));
		CodeResolverRegistry.registerResolver(NullFlavor.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.class));
		CodeResolverRegistry.registerResolver(ObservationQueryMatchType.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.ProbabilityMatchCode.class));
		CodeResolverRegistry.registerResolver(ProcessingID.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.class));
		CodeResolverRegistry.registerResolver(ProcessingMode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode.class));
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.QuantityRequestLimit.class));
		CodeResolverRegistry.registerResolver(QueryResponse.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.QueryResponse.class));
		CodeResolverRegistry.registerResolver(ResponseMode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.ResponseMode.class));
		CodeResolverRegistry.registerResolver(RoleClass.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.RoleClass.class));
		CodeResolverRegistry.registerResolver(RoleStatus.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.RoleStatus.class));
		CodeResolverRegistry.registerResolver(RoleStatusNormal.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.RoleStatusNormal.class));
		CodeResolverRegistry.registerResolver(SeverityObservation.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.SeverityObservation.class));
		CodeResolverRegistry.registerResolver(State.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.basic.State.class));
		CodeResolverRegistry.registerResolver(SubscriptionStatus.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.SubscriptionStatus.class));
		CodeResolverRegistry.registerResolver(TopicPriority.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.TopicPriority.class));
		CodeResolverRegistry.registerResolver(x_ActMoodIntentEvent.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.x_ActMoodIntentEvent.class));
		CodeResolverRegistry.registerResolver(x_ActMoodOrderEvent.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.x_ActMoodOrderEvent.class));
		
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
}
