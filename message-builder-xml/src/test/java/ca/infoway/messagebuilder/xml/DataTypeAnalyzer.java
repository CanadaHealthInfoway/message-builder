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

package ca.infoway.messagebuilder.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.j5goodies.Counter;

/**
 * <p>A tool to gather statistics about data type usage across message sets.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore translated manually
 */
public class DataTypeAnalyzer {
	
	class Key implements Comparable<Key> {
		private final String category;
		private final String dataType;

		Key(String category, String dataType) {
			this.category = category;
			this.dataType = dataType;
		}
		public int compareTo(Key o) {
			return new CompareToBuilder()
					.append(this.dataType, o.dataType)
					.append(this.category, o.category)
					.toComparison();
		}
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
					.append(this.dataType)
					.append(this.category)
					.toHashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			} else if (obj == this) {
				return true;
			} else if (obj.getClass() != getClass()) {
				return false;
			} else {
				Key that = (Key) obj;
				return new EqualsBuilder()
						.append(this.dataType, that.dataType)
						.append(this.category, that.category)
						.isEquals();
			}
		}
	}
	
	private Map<Key,Counter<String>> records = new TreeMap<Key,Counter<String>>();
	private Set<String> version = new LinkedHashSet<String>();
	
	
	public static void main(String[] args) throws Exception {
		
		DataTypeAnalyzer analyzer = new DataTypeAnalyzer();
		analyzer.add(new File("../message-builder-hl7v3-release-pcs_cerx_v01_r04_3/src/main/resources/messageSet_v01r04_3_hotfix3.xml"));
		analyzer.add(new File("../message-builder-hl7v3-release-pcs_mr2007_v02_r02/src/main/resources/messageSet_v02_r02.xml"));
		analyzer.add(new File("../message-builder-hl7v3-release-pcs_mr2007_v02_r01/src/main/resources/messageSet_v02_r01.xml"));
		analyzer.add(new File("../message-builder-hl7v3-release-pcs_mr2009_r02_04_02/src/main/resources/messageSet_r02_04_02.xml"));
		analyzer.writeOutput();
		
	}

	private void writeOutput() {
		List<Integer> columns = createColumns();
		
		writeSeparator(columns);
		writeHeader(columns);
		writeSeparator(columns);
		
		for (Map.Entry<Key, Counter<String>> entry : this.records.entrySet()) {
			writeRow(entry.getKey(), entry.getValue(), columns);
			writeSeparator(columns);
		}
	}

	private void writeHeader(List<Integer> columns) {
		StringBuilder builder = new StringBuilder("| ");
		builder.append(StringUtils.rightPad("Data type", columns.get(0))).append(" | ");
		builder.append(StringUtils.rightPad("Cat.", columns.get(1)));
		
		int index = 0;
		for (String version : this.version) {
			builder.append(" | ");
			Integer width = columns.get(index + 2);
			builder.append(StringUtils.rightPad(version.replace('_', '.'), width));
			index++;
		}
		builder.append(" |");
		System.out.println(builder.toString());
	}

	private void writeRow(Key key, Counter<String> value, List<Integer> columns) {
		StringBuilder builder = new StringBuilder("| ");
		builder.append(StringUtils.rightPad(escape(key.dataType), columns.get(0))).append(" | ");
		builder.append(StringUtils.rightPad(key.category, columns.get(1)));
		
		int index = 0;
		for (String version : this.version) {
			builder.append(" | ");
			int count = value.get(version);
			Integer width = columns.get(index + 2);
			if (count > 0) {
				builder.append(StringUtils.leftPad("" + count, width));
			} else {
				builder.append(StringUtils.repeat(" ", width));
			}
			index++;
		}
		builder.append(" |");
		System.out.println(builder.toString());
	}

	private void writeSeparator(List<Integer> columns) {
		StringBuilder builder = new StringBuilder("*");
		String alignmentIndicator = "+";
		for (Integer integer : columns) {
			builder.append(StringUtils.repeat("-", integer + 2));
			builder.append(alignmentIndicator);
			alignmentIndicator = "*";
		}
		System.out.println(builder.toString());
	}

	private List<Integer> createColumns() {
		List<Integer> result = new ArrayList<Integer>();
		
		int firstColumn = 0;
		int secondColumn = 0;
		
		for (Key key : this.records.keySet()) {
			firstColumn = Math.max(firstColumn, escape(key.dataType).length());
			secondColumn = Math.max(secondColumn, key.category.length());
		}
		result.add(firstColumn);
		result.add(secondColumn);
		for (String version : this.version) {
			result.add(version.length());
		}
		return result;
	}

	private String escape(String dataType) {
		return StringUtils.replace(
				StringUtils.replace(dataType, "<", "\\<"), ">", "\\>");
	}

	private void add(File file) throws Exception {
		MessageSet messageSet = new MessageSetMarshaller().unmarshall(file);
		this.version.add(messageSet.getVersion());
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			for (Relationship relationship : messagePart.getRelationships()) {
				if (relationship.isAttribute() && StringUtils.isNotBlank(relationship.getType())) {
					count(messageSet.getVersion(), getCategory(messagePart), relationship.getType());
				}
			}
		}
	}

	private void count(String version, String category, String type) {
		Key key = new Key(category, type);
		if (!this.records.containsKey(key)) {
			this.records.put(key, new Counter<String>());
		}
		this.records.get(key).increment(version);
	}

	private String getCategory(MessagePart messagePart) {
		String prefix = StringUtils.left(messagePart.getName(), 4);
		if ("PRPA".equals(prefix)) {
			return "cr";
		} else if ("PRLO".equals(prefix)) {
			return "lr";
		} else if ("PRPM".equals(prefix)) {
			return "pr";
		} else if ("FICR".equals(prefix)) {
			return "claims";
		} else if ("QUCR".equals(prefix)) {
			return "claims";
		} else if ("COCT".equals(prefix)) {
			return "common";
		} else if ("MCAI".equals(prefix)) {
			return "common";
		} else if ("MCCI".equals(prefix)) {
			return "common";
		} else if ("MFMI".equals(prefix)) {
			return "common";
		} else if ("QUQI".equals(prefix)) {
			return "common";
		} else if ("RCMR".equals(prefix)) {
			return "consent";
		} else if ("COMT".equals(prefix)) {
			return "iehr";
		} else if ("REPC".equals(prefix)) {
			return "iehr";
		} else if ("POIZ".equals(prefix)) {
			return "iehr";
		} else if ("POLB".equals(prefix)) {
			return "lab";
		} else if ("POME".equals(prefix)) {
			return "pharm";
		} else if ("PORR".equals(prefix)) {
			return "pharm";
		} else if ("PORX".equals(prefix)) {
			return "pharm";
		} else {
			System.out.println(prefix);
			return "";
		}
	}
}
