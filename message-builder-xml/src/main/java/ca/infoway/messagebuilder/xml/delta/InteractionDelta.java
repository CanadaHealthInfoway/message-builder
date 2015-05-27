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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.xml.delta;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * For one class provides all the information regarding to model changes.
 *
 * @sharpen.ignore - only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
@Entity
@DiscriminatorValue("INTERACTION")
public class InteractionDelta extends Delta {

	private static final long serialVersionUID = -6315368236172207496L;

	@Override
	public MessagePartType getType() {
		return MessagePartType.INTERACTION;
	}
}
