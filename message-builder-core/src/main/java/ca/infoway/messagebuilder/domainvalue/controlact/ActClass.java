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
 * <p>The Enum ActClass. 
 */
public class ActClass extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActClass, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 584607967819653758L;
	
	public static final ActClass ACT = new ActClass("ACT"); 
	public static final ActClass ALRT = new ActClass("ALRT"); 
	public static final ActClass CACT = new ActClass("CACT"); 
	public static final ActClass CONC = new ActClass("CONC"); 
	public static final ActClass COND = new ActClass("COND"); 
	public static final ActClass CONS = new ActClass("CONS"); 
	public static final ActClass COV = new ActClass("COV"); 
	public static final ActClass DOC = new ActClass("DOC"); 
	public static final ActClass DOCBODY = new ActClass("DOCBODY"); 
	public static final ActClass ENC = new ActClass("ENC"); 
	public static final ActClass INFRM = new ActClass("INFRM"); 
	public static final ActClass INVE = new ActClass("INVE"); 
	public static final ActClass LIST = new ActClass("LIST");
	public static final ActClass MPROT = new ActClass("MPROT");
	public static final ActClass OBS = new ActClass("OBS");
	public static final ActClass PROC = new ActClass("PROC");
	public static final ActClass SBADM = new ActClass("SBADM");
	public static final ActClass SPLY = new ActClass("SPLY");
	public static final ActClass STORE = new ActClass("STORE");
	public static final ActClass SUBST = new ActClass("SUBST");
	public static final ActClass VERIF = new ActClass("VERIF");
	
	private ActClass(String name) {
		super(name);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACT_CLASS.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return name();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
