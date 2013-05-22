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
package ca.infoway.demiftifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;

public class PackageLocationLayout implements Layout {

	private List<MessagePartLayoutItem> choiceItems = new ArrayList<MessagePartLayoutItem>();
	private Map<String,MessagePartLayoutItem> items = new HashMap<String,MessagePartLayoutItem>();
	List<MessagePartLayoutItem> duplicates = new ArrayList<MessagePartLayoutItem>();
	private MessageSet messageSet;
	private String packageLocationName;
	
	public PackageLocationLayout(MessageSet messageSet, String packageLocationName) {
		this.messageSet = messageSet;
		this.packageLocationName = packageLocationName;
	}

	@Override
	public Collection<LayoutItem> getItems() {
		Collection<LayoutItem> result = new ArrayList<LayoutItem>();
		result.add(new EntryPointLayoutItem(getPackageLocation()));
		result.addAll(getMessagePartLayoutItems());
		return result;
	}

	public Collection<MessagePartLayoutItem> getMessagePartLayoutItems() {
		Collection<MessagePartLayoutItem> result = new ArrayList<MessagePartLayoutItem>();
		for (MessagePartLayoutItem layoutItem : this.choiceItems) {
			if (layoutItem.isAlreadyLayedOut()) {
				result.add(layoutItem);
			}
		}
		for (MessagePartLayoutItem layoutItem : items.values()) {
			if (layoutItem.isAlreadyLayedOut()) {
				result.add(layoutItem);
			}
		}
		for (MessagePartLayoutItem layoutItem : this.duplicates) {
			if (layoutItem.isAlreadyLayedOut()) {
				result.add(layoutItem);
			}
		}
		return result;
	}

	void addItem(MessagePartLayoutItem layoutItem) {
		this.duplicates.add(layoutItem);
	}

	public MessageSet getMessageSet() {
		return this.messageSet;
	}
	
	Collection<MessagePartLayoutItem> getSpecializationChildsFor(MessagePartLayoutItem parent) {
		Collection<MessagePartLayoutItem> result = new ArrayList<MessagePartLayoutItem>();
		for (LayoutItem item : this.choiceItems) {
			if (item instanceof MessagePartLayoutItem) {
				MessagePartLayoutItem layoutItem = (MessagePartLayoutItem) item;
				if (layoutItem.isSpecialization() && StringUtils.equals(layoutItem.getParentItem().getName(), parent.getName())) {
					result.add(layoutItem);
				}
			}
		}
		return result;
	}
	
	public MessagePartLayoutItem createChoiceItem(MessagePartLayoutItem parentItem, MessagePart messagePart) {
		MessagePartLayoutItem result = null;
		for (MessagePartLayoutItem item : this.choiceItems) {
			if (StringUtils.equals(messagePart.getName(), item.getMessagePart().getName()) &&
					StringUtils.equals(parentItem.getMessagePart().getName(), item.getParentItem().getName())) {
				result = item;
				break;
			}
		}
		if (result == null) {
			this.choiceItems.add(result = new MessagePartLayoutItem(parentItem, messagePart, this));
		}
		return result;
	}
	public MessagePartLayoutItem createItem(MessagePart messagePart) {
		if (!this.items.containsKey(messagePart.getName())) {
			this.items.put(messagePart.getName(), new MessagePartLayoutItem(messagePart, this));
		}
		return this.items.get(messagePart.getName());
	}

	public PackageLocation getPackageLocation() {
		return this.messageSet.getPackageLocation(this.packageLocationName);
	}

	public boolean containsItemFor(MessagePart messagePart) {
		return this.items.containsKey(messagePart.getName());
	}

	public void removeDuplicate(MessagePartLayoutItem layoutItem) {
		this.duplicates.remove(layoutItem);
	}

}
