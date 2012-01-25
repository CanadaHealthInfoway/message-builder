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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum SubscriptionStatus.
 */
public class SubscriptionStatus extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.SubscriptionStatus, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }

	private static final long serialVersionUID = -8472481397627274517L;
	
	public static final SubscriptionStatus SUBSCRIBED = new SubscriptionStatus("SUBSCRIBED", "1"); 
	public static final SubscriptionStatus UNSUBSCRIBED = new SubscriptionStatus("UNSUBSCRIBED", "2");

	private final String codeValue;

	private SubscriptionStatus(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;

	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.SUBSCRIPTION_STATUS.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
