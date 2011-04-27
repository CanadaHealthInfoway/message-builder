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

package ca.infoway.messagebuilder.marshalling;

import org.junit.Before;

import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public abstract class BaseTealMlTransformerTestCase {
	
	protected MessageBeanTransformerImpl transformer;
	protected DocumentFactory factory;

	@Before
	public void setUp() throws Exception {
		this.transformer = new MessageBeanTransformerImpl();
		this.factory = new DocumentFactory();
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}

	@Before
	public void tearDown() throws Exception {
		CodeResolverRegistry.unregisterAll();
	}
}
