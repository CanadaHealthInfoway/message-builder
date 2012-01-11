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
 * <p>Codes representing the defined possible states of an Role, as defined by the Role 
 * class state machine.
 * 
 * @author BC Holmes
 */
public class RoleStatus extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.RoleStatus, Describable {
	
	private static final long serialVersionUID = 8923741098580990602L;

	/**
	 * The 'typical' state. Excludes "nullified" which represents the termination state 
	 * of a Role instance that was created in error.
	 */
	public static final RoleStatus NORMAL = new RoleStatus("NORMAL");
	
	/**
	 * The state representing the fact that the Entity is currently active in the Role.
	 */
	public static final RoleStatus ACTIVE = new RoleStatus("ACTIVE");
	
	/**
	 * The terminal state resulting from cancellation of the role prior to activation.
	 */
	public static final RoleStatus CANCELLED = new RoleStatus("CANCELLED");
	
	/**
	 * The state representing that fact that the role has not yet become active.
	 */
	public static final RoleStatus PENDING = new RoleStatus("PENDING");
	
	/**
	 * The state that represents a suspension of the Entity playing the Role. 
	 * This state is arrived at from the "active" state.
	 */
	public static final RoleStatus SUSPENDED = new RoleStatus("SUSPENDED");
	
	/**
	 * The state representing the successful termination of the Role.
	 */
	public static final RoleStatus TERMINATED = new RoleStatus("TERMINATED");
	
	/**
	 * The state representing the termination of a Role instance that was created 
	 * in error.
	 */
	public static final RoleStatus NULLIFIED = new RoleStatus("NULLIFIED");

	private RoleStatus(String name) {
		super(name);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ROLE_STATUS.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		// another unusual case where the code value is in lower case
		return name().toLowerCase();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}

}
