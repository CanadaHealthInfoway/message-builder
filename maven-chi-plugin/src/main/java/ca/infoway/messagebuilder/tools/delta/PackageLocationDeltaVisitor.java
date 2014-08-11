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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.tools.delta;

import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.delta.Constraint;
import ca.infoway.messagebuilder.xml.delta.PackageLocationDelta;

public class PackageLocationDeltaVisitor extends ConstraintVisitor {

	private final MessageSet messageSet;
	private final PackageLocationDelta delta;

	public PackageLocationDeltaVisitor(PackageLocationDelta delta, MessageSet messageSet) {
		this.messageSet = messageSet;
		this.delta = delta;
	}

	
	@Override
	public void visit(Constraint constraint) {
		super.visit(constraint);
	}
	
	@Override
	Documentation getDocumentation() {
		PackageLocation packageLocation = this.messageSet.getPackageLocation(this.delta.getClassName());
		if (packageLocation != null && packageLocation.getDocumentation() == null) {
			packageLocation.setDocumentation(new Documentation());
		}
		return packageLocation == null ? null : packageLocation.getDocumentation();
	}

}
