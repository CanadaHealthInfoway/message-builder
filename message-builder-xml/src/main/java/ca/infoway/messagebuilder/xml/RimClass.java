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
 * Author:        $LastChangedBy: gng $
 * Last modified: $LastChangedDate: 2012-05-24 17:49:50 -0400 (Thu, 24 May 2012) $
 * Revision:      $LastChangedRevision: 5914 $
 */

package ca.infoway.messagebuilder.xml;

import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.lang.EnumPattern;

public class RimClass extends EnumPattern{
	
	private static final long serialVersionUID = -8779975480440476740L;
	
	public final static RimClass ACT = new RimClass("ACT");
	public final static RimClass ACT_RELATIONSHIP = new RimClass("ACT_RELATIONSHIP");
	public final static RimClass ENTITY = new RimClass("ENTITY");
	public final static RimClass PARTICIPATION = new RimClass("PARTICIPATION");
	public final static RimClass ROLE = new RimClass("ROLE");
	public final static RimClass ROLE_LINK = new RimClass("ROLE_LINK");
	
	
	private RimClass(String name) {
		super(name);
	}
	
	public String getDescription() {
		return WordUtils.capitalizeFully(name());
	}
	
	public String getCode() {
		return name();
	}
}