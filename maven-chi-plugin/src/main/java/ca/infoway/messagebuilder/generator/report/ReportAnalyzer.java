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

package ca.infoway.messagebuilder.generator.report;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import ca.infoway.messagebuilder.generator.java.Matcher;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Documentable;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.Relationship;

public class ReportAnalyzer {
	
	private static final int A = 0;
	private static final int B = 1;
	private static final int C = 2;
	
	private Map<String,HSSFCellStyle> styles = new HashMap<String,HSSFCellStyle>();
	
	public static void main(String[] args) throws Exception {
		MessageSet messageSet1 = new MessageSetMarshaller().unmarshall(new File("../message-builder-hl7v3-release-pcs_mr2009_r02_04_02/src/main/resources/messageSet_r02_04_02.xml"));
//		MessageSet messageSet2 = new MessageSetMarshaller().unmarshall(new File("../message-builder-hl7v3-release-pcs_mr2009_r02_04_02/src/main/resources/messageSet_r02_04_00.xml"));
		MessageSet messageSet3 = new MessageSetMarshaller().unmarshall(new File("../message-builder-hl7v3-release-pcs_mr2007_v02_r02/src/main/resources/messageSet_v02_r02.xml"));
		MessageSet messageSet4 = new MessageSetMarshaller().unmarshall(new File("../message-builder-hl7v3-release-pcs_cerx_v01_r04_3/src/main/resources/messageSet_v01_r04_3_hotfix3.xml"));
//		MessageSet messageSet5 = new MessageSetMarshaller().unmarshall(new File("../message-builder-hl7v3-release-pcs_cerx_v01_r04_3/src/main/resources/messageSet_v01_r04_2.xml"));
		HSSFWorkbook report = new ReportAnalyzer().createReport(messageSet1, 
	//			messageSet2, 
				messageSet3, messageSet4
	//			, messageSet5
				);
		
		FileOutputStream output = new FileOutputStream(new File(new File(SystemUtils.USER_HOME), "report.xls"));
		try {
			report.write(output);
		} finally {
			IOUtils.closeQuietly(output);
		}
	}

	public HSSFWorkbook createReport(MessageSet... messageSet) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		createReport(workbook, messageSet);
		return workbook;
	}

	private void createReport(HSSFWorkbook workbook, MessageSet... messageSet) {
		createInteractionSheet(workbook, messageSet);
		createMessagePartSheet(workbook, messageSet);
		createMessagePartMergeSheet(workbook, messageSet);
	}

	private void createMessagePartMergeSheet(HSSFWorkbook workbook, MessageSet[] messageSet) {
		
		HSSFSheet sheet = workbook.createSheet("Match results");
		
	}

	private void createMessagePartSheet(HSSFWorkbook workbook, MessageSet... messageSets) {
		for (String prefix : getPackageLocationPrefixes(messageSets)) {
			HSSFSheet sheet = workbook.createSheet("Message Parts - " + prefix);
			HSSFRow headerRow = sheet.createRow(0);
			createCell(workbook, headerRow, A, "Name", Style.HEADER);
			sheet.createRow(1);
			for (String messagePartName : getMessagePartIds(messageSets, prefix)) {
				createSingleMessagePart(workbook, sheet, messagePartName,
						messageSets);
			}
			autosize(sheet);
		}
	}

	private Set<String> getPackageLocationPrefixes(MessageSet... messageSets) {
		Set<String> result = new TreeSet<String>();
		for (MessageSet messageSet : messageSets) {
			Set<String> keys = messageSet.getPackageLocations().keySet();
			for (String packageName : keys) {
				result.add(StringUtils.left(packageName, 4));
			}
		}
		return result;
	}

	private void createSingleMessagePart(HSSFWorkbook workbook, HSSFSheet sheet,
			String messagePartName, MessageSet... messageSets) {
		int firstRow = sheet.getLastRowNum() + 1;
		int column = C;
		System.out.println("Now working on message part: " + messagePartName);
		MessagePartReportMatcher matcher = null;
		for (MessageSet messageSet : messageSets) {
			createCell(workbook, getRow(sheet, 0), column, messageSet.getVersion(), Style.HEADER);
			
			MessagePart messagePart = messageSet.getMessagePart(messagePartName);
			if (messagePart != null) {
				if (matcher == null) {
					matcher = new MessagePartReportMatcher(messagePart);
				}
				HSSFRow row = getRow(sheet, firstRow);
				createCell(workbook, row, A, messagePartName, Style.HEADER);
				createCell(workbook, getRow(sheet, firstRow + 1), column, getBusinessName(messagePart));
				List<String> relationshipNames = new ArrayList<String>(getRelationshipNames(messageSets, messagePartName));
				for (int i = 0, length = relationshipNames.size(); i < length; i++) {
					row = getRow(sheet, firstRow+i+1);
					String relationshipName = relationshipNames.get(i);
					createCell(workbook, row, B, relationshipName);
					Relationship relationship = messagePart.getRelationship(relationshipName);
					createCell(workbook, getRow(sheet, 1), column, "Business name", Style.HEADER);
					createCell(workbook, getRow(sheet, 1), column+1, "Relationship Type", Style.HEADER);
					createCell(workbook, getRow(sheet, 1), column+2, "Card", Style.HEADER);
					createCell(workbook, getRow(sheet, 1), column+3, "Conf", Style.HEADER);
					createCell(workbook, getRow(sheet, 1), column+4, "Choice Differences", Style.HEADER);
					if (relationship != null) {
//						System.out.println("Relationship " + relationshipName + " for messageset " + messageSet.getVersion());
						createCell(workbook, row, column, getBusinessName(relationship), matcher.getBusinessNameMatchStyle(relationship));
						createCell(workbook, row, column+1, Renderer.createPartDefinitionSummary(relationship), matcher.getTypeMatchStyle(relationship));
						createCell(workbook, row, column+2, relationship.getCardinality() == null ? "" : relationship.getCardinality().toString(), matcher.getTypeMatchStyle(relationship));
						createCell(workbook, row, column+3, relationship.getConformance() == null ? "" : relationship.getConformance().getDescription(), matcher.getTypeMatchStyle(relationship));
						
						Relationship baseline = matcher.getBaseline().getRelationship(relationshipName);
						String choiceDifferences = renderChoiceDifferences(relationship, baseline);
						createCell(workbook, row, column+4, choiceDifferences, getDifferenceStyleArgumentChoices(choiceDifferences));
					} else {
						createCell(workbook, row, column, "", Style.NOT_APPLICABLE);
						createCell(workbook, row, column+1, "", Style.NOT_APPLICABLE);
						createCell(workbook, row, column+2, "", Style.NOT_APPLICABLE);
						createCell(workbook, row, column+3, "", Style.NOT_APPLICABLE);
						createCell(workbook, row, column+4, "", Style.NOT_APPLICABLE);
					}
				}
			}
			column += 5;
		}
		createEmptyRow(sheet);
	}

	private String getBusinessName(Documentable documentable) {
		return documentable.getDocumentation() == null 
				? null : documentable.getDocumentation().getBusinessName();
	}

	private HSSFRow createEmptyRow(HSSFSheet sheet) {
		return getRow(sheet, sheet.getLastRowNum() + 1);
	}

	private String getBusinessName(Relationship relationship) {
		return relationship.getDocumentation() == null ? null : relationship.getDocumentation().getBusinessName();
	}

	// TODO: BCH: maintain original order?
	private Set<String> getRelationshipNames(MessageSet[] messageSets, String messagePartName) {
		Set<String> result = new HashSet<String>();
		for (MessageSet messageSet : messageSets) {
			MessagePart part = messageSet.getMessagePart(messagePartName);
			if (part != null) {
				for (Relationship relationship : part.getRelationships()) {
					result.add(relationship.getName());
				}
			}
		}
		return result;
	}

	private Set<String> getMessagePartIds(MessageSet[] messageSets, String prefix) {
		Set<String> result = new TreeSet<String>();
		for (MessageSet messageSet : messageSets) {
			for (MessagePart messagePart : messageSet.getAllMessageParts()) {
				if (StringUtils.startsWith(messagePart.getName(), prefix)) {
					result.add(messagePart.getName());
				}
			}
		}
		return result;
	}

	private void createInteractionSheet(HSSFWorkbook workbook, MessageSet... messageSets) {
		HSSFSheet sheet = workbook.createSheet("Interactions");
		HSSFRow headerRow = sheet.createRow(0);
		createCell(workbook, headerRow, A, "Name", Style.HEADER);
		
		for (String interactionId : getInteractionIds(messageSets)) {
			int mainRow = sheet.getLastRowNum() + 1;
			int column = C;
			for (MessageSet messageSet : messageSets) {
				createCell(workbook, headerRow, column, messageSet.getVersion(), Style.HEADER);
				createCell(workbook, headerRow, column+1, "Traversal Name", Style.HEADER);
				createCell(workbook, headerRow, column+2, "Choice Differences", Style.HEADER);
			
				Interaction interaction = messageSet.getInteractions().get(interactionId);
				if (interaction != null) {
					HSSFRow row = getRow(sheet, mainRow);
					createCell(workbook, row, A, interactionId, Style.HEADER);
					createCell(workbook, row, B, "Name", Style.HEADER);
					createCell(workbook, row, column, interaction.getBusinessName(), getDifferenceStyleBusinessName(interaction, messageSets));
					row = getRow(sheet, mainRow+1);
					createCell(workbook, row, B, "Transport Wrapper:", Style.HEADER);
					createCell(workbook, row, column, interaction.getSuperTypeName(), getDifferenceStyle(new Matcher().matchesTypeName(interaction.getSuperTypeName(), getBaselineInteraction(interaction, messageSets).getSuperTypeName())));
					addArguments(workbook, sheet, mainRow+1, column, interaction.getArguments(), 0, getBaselineInteraction(interaction, messageSets).getArguments());
				}
				column += 3;
			}
			sheet.createRow(sheet.getLastRowNum()+1);
		}
		autosize(sheet);
	}

	private void autosize(HSSFSheet sheet) {
		int columnNumber = A;
		for (int i = 0, length = sheet.getLastRowNum(); i < length; i++) {
			columnNumber = Math.max(columnNumber, sheet.getRow(i).getLastCellNum());
		}
		for (int i = 0; i < columnNumber; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	private Style getDifferenceStyleBusinessName(Interaction interaction, MessageSet[] messageSets) {
		return getDifferenceStyle(new Matcher().matchesBusinessName(
				getBaselineInteraction(interaction.getName(), messageSets), interaction));
	}

	private Style getDifferenceStyle(boolean different) {
		return different 
				? Style.NO_DIFFERENCE : Style.DIFFERENCE;
	}

	private Interaction getBaselineInteraction(Interaction interaction, MessageSet[] messageSets) {
		return getBaselineInteraction(interaction.getName(), messageSets);
	}
	private Interaction getBaselineInteraction(String name, MessageSet[] messageSets) {
		Interaction result = null;
		for (MessageSet messageSet : messageSets) {
			result = messageSet.getInteractions().get(name);
			if (result != null) {
				break;
			}
		}
		return result;
	}

	private Set<String> getInteractionIds(MessageSet... messageSets) {
		Set<String> interactionIds = new TreeSet<String>();
		for (MessageSet messageSet : messageSets) {
			interactionIds.addAll(messageSet.getInteractions().keySet());
		}
		return interactionIds;
	}

	private void addArguments(HSSFWorkbook workbook, HSSFSheet sheet, int rowNumber, int columnNumber, List<Argument> arguments, int depth, List<Argument> baselineArguments) {
		String[] labels = new String[] { "Trigger event:", "Payload:" };
		for (int i = 0, length = arguments.size(); i < length; i++) {
			Argument argument = arguments.get(i);
			HSSFRow row = getRow(sheet, rowNumber+1+i);
			createCell(workbook, row, B, labels[depth], Style.HEADER);
			Argument baseline = safeListGet(baselineArguments, i);
			createCell(workbook, row, columnNumber, argument.getName(), getDifferenceStyleArgument(argument, baseline));
			createCell(workbook, row, columnNumber+1, argument.getTraversalName(), getDifferenceStyleArgumentTraversalName(argument, baseline));
			String choiceDifferences = renderChoiceDifferences(argument, baseline);
			createCell(workbook, row, columnNumber+2, choiceDifferences, getDifferenceStyleArgumentChoices(choiceDifferences));
			
			addArguments(workbook, sheet, rowNumber+1, columnNumber, argument.getArguments(), depth+1, baseline == null ? null : baseline.getArguments());
		}
	}

	private String renderChoiceDifferences(Argument argument, Argument baseline) {
		String result = null; 
		if (argument != baseline) {
			List<Relationship> choices = (argument == null ? Collections.<Relationship>emptyList() : argument.getChoices());
			List<Relationship> baselineChoices = (baseline == null ? Collections.<Relationship>emptyList() : baseline.getChoices());
			result = renderChoiceDifferences(choices, baselineChoices, "");
			if (StringUtils.isNotBlank(result)) {
				System.out.println("arg: " + result);
			}
		}
		return result;
	}

	private String renderChoiceDifferences(Relationship relationship, Relationship baseline) {
		String result = null; 
		if (relationship != baseline) {
			List<Relationship> choices = (relationship == null ? Collections.<Relationship>emptyList() : relationship.getChoices());
			List<Relationship> baselineChoices = (baseline == null ? Collections.<Relationship>emptyList() : baseline.getChoices());
			result = renderChoiceDifferences(choices, baselineChoices, "");
			if (StringUtils.isNotBlank(result)) {
				String rel = baseline == null ? relationship.getType() : baseline.getType();
				System.out.println(rel + ": \n" + result);
			}
		}
		return result;
	}

	private String renderChoiceDifferences(List<Relationship> choices, List<Relationship> baselineChoices, String prefix) {
		StringBuffer sb = new StringBuffer();
		
		Map<String, Relationship> baselineChoiceMap = new HashMap<String, Relationship>(); 

		for (Relationship relationship : baselineChoices) {
			baselineChoiceMap.put(relationship.getName(), relationship);
		}
		
		for (Relationship relationship : choices) {
			Relationship baselineRelationship = baselineChoiceMap.remove(relationship.getName());
			if (baselineRelationship == null) {
				sb.append("choice option " + prefix + relationship.getName() + " additional to this version; ");
			} else if (!StringUtils.equals(relationship.getType(), baselineRelationship.getType())) {
				sb.append("choice option " + prefix + relationship.getName() + " is different type (" + relationship.getType() + " versus " + baselineRelationship.getType() + "); ");
			} else if (relationship.isChoice() && !baselineRelationship.isChoice()) {
				sb.append("choice option " + prefix + relationship.getName() + " is itself a choice in this version, but not in baseline version; ");
			} else if (!relationship.isChoice() && baselineRelationship.isChoice()) {
				sb.append("choice option " + prefix + relationship.getName() + " is itself a choice in baseline version, but not in this version; ");
			} else {
				sb.append(renderChoiceDifferences(relationship.getChoices(), baselineRelationship.getChoices(), relationship.getName() + "."));
			}
		}

		Collection<Relationship> values = baselineChoiceMap.values();
		for (Relationship relationship : values) {
			sb.append("choice option " + relationship.getName() + " not in this version; ");
		}
		
		return sb.toString();
	}

	private Style getDifferenceStyleArgumentChoices(String choiceDifferences) {
		return StringUtils.isBlank(choiceDifferences) ? Style.NO_DIFFERENCE : Style.DIFFERENCE;
	}
	
	private Style getDifferenceStyleArgument(Argument argument, Argument baseline) {
		return new Matcher().matchesArgumentRoot(argument, baseline)
				? Style.NO_DIFFERENCE : Style.DIFFERENCE;
	}

	private Style getDifferenceStyleArgumentTraversalName(Argument argument, Argument baseline) {
		return new Matcher().matchesArgumentTraversalName(argument, baseline)
				? Style.NO_DIFFERENCE : Style.DIFFERENCE;
	}

	private <T> T safeListGet(List<T> list, int i) {
		if (list == null) {
			return null;
		} else if (i >= list.size()) {
			return null;
		} else {
			return list.get(i);
		}
	}

	private HSSFRow getRow(HSSFSheet sheet, int rowNumber) {
		HSSFRow row = sheet.getRow(rowNumber);
		if (row == null) {
			row = sheet.createRow(rowNumber);
		}
		return row;
	}

	private void createCell(HSSFWorkbook workbook, HSSFRow row, int columnNumber, String value, Style... styles) {
		HSSFCell cell = row.createCell(columnNumber);
		cell.setCellValue(new HSSFRichTextString(value));
		HSSFCellStyle style = getStyle(workbook, styles);
		if (style != null) {
			cell.setCellStyle(style);
		}
	}

	private HSSFCellStyle getStyle(HSSFWorkbook workbook, Style[] styles) {
		if (styles.length > 0) {
			return findOrCreateStyle(workbook, styles);
		} else {
			return null;
		}
	}

	private HSSFCellStyle findOrCreateStyle(HSSFWorkbook workbook, Style[] styles) {
		String name = Style.makeName(styles);
		HSSFCellStyle result = this.styles.get(name);
		if (result == null) {
			result = createStyle(name, workbook, styles);
		}
		return result;
	}

	private HSSFCellStyle createStyle(String name, HSSFWorkbook workbook, Style[] styles) {
		HSSFCellStyle result = workbook.createCellStyle();
		for (Style style : styles) {
			switch (style) {
			case HEADER:
				HSSFFont font = workbook.createFont();
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				result.setFont(font);
				break;
				
			case MINOR_DIFFERENCE:
				result.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
				result.setFillPattern(CellStyle.SOLID_FOREGROUND);
				break;
				
			case DIFFERENCE:
				result.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
				result.setFillPattern(CellStyle.SOLID_FOREGROUND);
				break;
				
			case NOT_APPLICABLE:
				result.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				result.setFillPattern(CellStyle.SOLID_FOREGROUND);
				break;
			}
		}
		this.styles.put(name, result);
		return result;
	}
}
