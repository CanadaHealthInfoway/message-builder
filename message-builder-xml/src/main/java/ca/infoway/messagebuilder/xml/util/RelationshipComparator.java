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
 * Author:        $LastChangedBy: spd $
 * Last modified: $LastChangedDate: 2012-01-10 20:35:55 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3319 $
 */

package ca.infoway.messagebuilder.xml.util;

import java.util.Comparator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;

public class RelationshipComparator implements Comparator<RelationshipComparable> {
	public int compare(RelationshipComparable o1, RelationshipComparable o2) {
		CompareToBuilder builder = new CompareToBuilder();
		builder.append(o1.isAssociation(), o2.isAssociation());
		if (o1.isAttribute()) {
			builder.append(o1.getSortOrder(), o2.getSortOrder());
		}
		if (o1.isAssociation()) {
			if (StringUtils.isBlank(o1.getAssociationSortKey()) && StringUtils.isBlank(o2.getAssociationSortKey())) {
				// assume this is a legacy NFLD test; otherwise, associationSortKey should never be blank for an association
				builder.append(o1.getSortOrder(), o2.getSortOrder());
			} else {
				builder.append(o1.getAssociationSortKey(), o2.getAssociationSortKey());
			}
			
			builder.append(o1.getName(), o2.getName());
		}
		return builder.toComparison();
	}
}
