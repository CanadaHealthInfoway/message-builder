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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.domainvalue.controlact;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ActStatus. Codes representing the defined states of an Act as defined by the Act class state machine.
 */
public class ActStatus extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActStatus, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 7809865843109575750L;
	
	public static final ActStatus NORMAL = new ActStatus("NORMAL"); 
	/** 
	 * <p>The Act has been terminated prior to the originally intended completion.
	 */
	public static final ActStatus ABORTED = new ActStatus("ABORTED"); 
	/**
	 * <p>The Act can be performed or is being performed.
	 */
	public static final ActStatus ACTIVE = new ActStatus("ACTIVE"); 
	public static final ActStatus CANCELLED = new ActStatus("CANCELLED"); 
	/**
	 * <p>An Act that has terminated normally after all of its constituents 
	 * has been performed.
	 */
	public static final ActStatus COMPLETED = new ActStatus("COMPLETED"); 
	
	public static final ActStatus HELD = new ActStatus("HELD"); 
	
	public static final ActStatus NEW = new ActStatus("NEW"); 
	/**
	 * <p>An Act that has been activated (actions could or have been performed against 
	 * it), but has been temporarily disabled. No further action should be taken against 
	 * it until it is released
	 */
	public static final ActStatus SUSPENDED = new ActStatus("SUSPENDED"); 
	/**
	 * <p>This Act instance was created in error and has been 'removed' and is treated 
	 * as though it never existed. A record is retained for audit purposes only.
	 */
	public static final ActStatus NULLIFIED = new ActStatus("NULLIFIED"); 
	/**
	 * <p>This Act instance has been replaced by a new instance.
	 */
	public static final ActStatus OBSOLETE = new ActStatus("OBSOLETE");

	private ActStatus(String name) {
		super(name);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACT_STATUS.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		// Act Status is special in using lower case for its code values
		return name().toLowerCase();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
