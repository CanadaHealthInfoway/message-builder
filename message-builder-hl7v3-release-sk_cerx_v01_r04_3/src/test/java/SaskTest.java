import org.junit.Test;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.interaction.UnfilledPrescriptionsQueryBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.QueryDefinitionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt060240ca.UnfilledPrescriptionQueryParametersBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

public class SaskTest {

	@Test
	public void minimalSaskTest() {
		
		CodeResolverRegistry.register(new TrivialCodeResolver());
		
		VersionNumber version = new VersionNumber() {
			@Override
			public String getVersionLiteral() {
				return "sk_cerx_v01_r04_3";
			}
		};
		
		UnfilledPrescriptionsQueryBean queryBean = new UnfilledPrescriptionsQueryBean();
		queryBean.setControlActProcess(new TriggerEventBean<UnfilledPrescriptionQueryParametersBean>());
		queryBean.getControlActProcess().setQueryByParameter(new QueryDefinitionBean<UnfilledPrescriptionQueryParametersBean>());
		queryBean.getControlActProcess().getQueryByParameter().setParameterList(new UnfilledPrescriptionQueryParametersBean());
		queryBean.getControlActProcess().getQueryByParameter().getParameterList().setPatientName(PersonName.createFirstNameLastName("Robert", "Neville"));
		
		System.out.println(new MessageBeanTransformerImpl().transformToHl7(version, queryBean));
		
	}
	
}
