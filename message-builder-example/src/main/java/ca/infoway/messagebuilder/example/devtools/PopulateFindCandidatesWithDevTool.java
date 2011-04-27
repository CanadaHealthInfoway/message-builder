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

package ca.infoway.messagebuilder.example.devtools;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.devtools.DefaultValueHolder;
import ca.infoway.messagebuilder.devtools.MessageBeanFactory;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.FindCandidatesQueryBean;
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
