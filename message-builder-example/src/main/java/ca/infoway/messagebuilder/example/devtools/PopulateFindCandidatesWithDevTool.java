package ca.infoway.messagebuilder.example.devtools;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.devtools.DefaultValueHolder;
import ca.infoway.messagebuilder.devtools.MessageBeanFactory;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.model.r02_04_02.interaction.FindCandidatesQueryBean;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class PopulateFindCandidatesWithDevTool {
	
	public static void main(String[] args) throws Exception {
		MessageBeanFactory beanFactory = new MessageBeanFactory(new DefaultValueHolder());
		FindCandidatesQueryBean bean = beanFactory.populate(new FindCandidatesQueryBean());
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
		ModelToXmlResult xmlQuery = createTransformer().transformToHl7AndReturnResult(
				SpecificationVersion.R02_04_02, 
				bean);
		
		System.out.println("Here's the query:");
		System.out.println(xmlQuery.getXmlMessage());		
	}
	
	private static MessageBeanTransformerImpl createTransformer() {
		return new MessageBeanTransformerImpl();
	}	

}
