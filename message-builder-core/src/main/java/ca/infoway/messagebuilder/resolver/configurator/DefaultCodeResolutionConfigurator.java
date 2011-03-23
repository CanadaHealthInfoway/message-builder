package ca.infoway.messagebuilder.resolver.configurator;

import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailCode;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailType;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.Confidentiality;
import ca.infoway.messagebuilder.domainvalue.HL7StandardVersionCode;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.ObservationQueryMatchType;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.QueryResponse;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.domainvalue.SubscriptionStatus;
import ca.infoway.messagebuilder.domainvalue.TopicPriority;
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
		
		CodeResolverRegistry.registerResolver(AcknowledgementCondition.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition.class));
		CodeResolverRegistry.registerResolver(AcknowledgementDetailCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailCode.class));
		CodeResolverRegistry.registerResolver(AcknowledgementDetailType.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailType.class));
		CodeResolverRegistry.registerResolver(HL7StandardVersionCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.HL7StandardVersionCode.class));
		CodeResolverRegistry.registerResolver(ProcessingID.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.class));
		CodeResolverRegistry.registerResolver(ProcessingMode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode.class));
		CodeResolverRegistry.registerResolver(ResponseMode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.transport.ResponseMode.class));
		
		CodeResolverRegistry.registerResolver(NullFlavor.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.class));
		
		CodeResolverRegistry.registerResolver(ActCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActCode.class));
		CodeResolverRegistry.registerResolver(ActStatus.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActStatus.class));
		CodeResolverRegistry.registerResolver(ActDetectedIssueCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActDetectedIssueCode.class));
		CodeResolverRegistry.registerResolver(ActIssuePriority.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActIssuePriority.class));
		CodeResolverRegistry.registerResolver(ActConsentInformationAccessReason.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.controlact.ActConsentInformationAccessReason.class));
		
		CodeResolverRegistry.registerResolver(AdministrativeGender.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender.class));
		CodeResolverRegistry.registerResolver(Confidentiality.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.Confidentiality.class));
		CodeResolverRegistry.registerResolver(IssueFilterCode.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.IssueFilterCode.class));
		CodeResolverRegistry.registerResolver(ObservationQueryMatchType.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.ProbabilityMatchCode.class));
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.QuantityRequestLimit.class));
		CodeResolverRegistry.registerResolver(QueryResponse.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.QueryResponse.class));
		CodeResolverRegistry.registerResolver(SeverityObservation.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.SeverityObservation.class));
		CodeResolverRegistry.registerResolver(SubscriptionStatus.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.SubscriptionStatus.class));
		CodeResolverRegistry.registerResolver(TopicPriority.class, 
				new EnumBasedCodeResolver(ca.infoway.messagebuilder.domainvalue.payload.TopicPriority.class));
		
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
}
