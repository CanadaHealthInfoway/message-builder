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

package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;

class PackageLocationMerger implements Merger<PackageLocation> {

	private MessageSetMergeHelper mergeHelper;
	private MessagePartMerger messagePartMerger;
	private PackageLocation result;
	private final MergeContext context;

	PackageLocationMerger(MergeContext context) {
		this(context, new MessagePartMerger(context));
	}

	PackageLocationMerger(MergeContext context, MessagePartMerger messagePartMerger) {
		this.context = context;
		this.messagePartMerger = messagePartMerger;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public PackageLocation merge(PackageLocation primaryPackageLocation, PackageLocation secondaryPackageLocation) {
		if (primaryPackageLocation == null || secondaryPackageLocation == null) {
			this.result = (secondaryPackageLocation == null ? primaryPackageLocation : secondaryPackageLocation);
		} else {
			this.result = new PackageLocation();
			mergeCategory(primaryPackageLocation.getCategory(), secondaryPackageLocation.getCategory());
			mergeDescriptiveName(primaryPackageLocation.getDescriptiveName(), secondaryPackageLocation.getDescriptiveName());
			mergeName(primaryPackageLocation.getName(), secondaryPackageLocation.getName());
			mergeRootType(primaryPackageLocation.getRootType(), secondaryPackageLocation.getRootType());
			mergeMessageParts(primaryPackageLocation.getMessageParts(), secondaryPackageLocation.getMessageParts());
		}
		
		return this.result;
	}

	private void mergeMessageParts(Map<String, MessagePart> messageParts, Map<String, MessagePart> messageParts2) {
		Map<String, MessagePart> messageParts2copy = new HashMap<String, MessagePart>(messageParts2);
		
		for (String messagePartName : messageParts.keySet()) {
			this.context.setCurrentMessagePart(messagePartName);
			MessagePart primaryMessagePart = messageParts.get(messagePartName);
			MessagePart secondaryMessagePart = messageParts2copy.remove(messagePartName);
			MessagePart mergedMessagePart = this.messagePartMerger.merge(primaryMessagePart, secondaryMessagePart);
			this.result.getMessageParts().put(messagePartName, mergedMessagePart);
		}

		for (String messagePartName : messageParts2copy.keySet()) {
			this.context.setCurrentMessagePart(messagePartName);
			MessagePart mergedMessagePart = this.messagePartMerger.merge(null, messageParts2copy.get(messagePartName));
			this.result.getMessageParts().put(messagePartName, mergedMessagePart);
		}
	}

	private void mergeRootType(String rootType, String rootType2) {
		if (rootType != null && rootType2 != null && !StringUtils.equals(rootType, rootType2)) {
			this.mergeHelper.addDifference(this.context, this.result, DifferenceType.PACKAGE_LOCATION_ROOT_TYPE, rootType, rootType2);
		}
		String mergedRootType = this.mergeHelper.standardMerge(rootType, rootType2);
		this.result.setRootType(mergedRootType);
	}

	private void mergeName(String name, String name2) {
		// should not normally be merging package locations with different names
		if (name != null && name2 != null && !StringUtils.equals(name, name2)) {
			this.context.logError("Merging two package locations with different names: " + name + " / " + name2);
		}
		String mergedName = this.mergeHelper.standardMerge(name, name2);
		this.result.setName(mergedName);
	}

	private void mergeDescriptiveName(String descriptiveName, String descriptiveName2) {
		String mergedDescriptiveName = this.mergeHelper.standardMerge(descriptiveName, descriptiveName2);
		this.result.setDescriptiveName(mergedDescriptiveName);
	}

	private void mergeCategory(String category, String category2) {
		String mergedCategory = this.mergeHelper.standardMerge(category, category2);
		this.result.setCategory(mergedCategory);
	}

}
