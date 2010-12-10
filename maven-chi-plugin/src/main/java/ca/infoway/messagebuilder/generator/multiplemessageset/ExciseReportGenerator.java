package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.HasDifferences;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

public class ExciseReportGenerator {

	private final File reportFile;
	private final List<ExcisedItem> excisedItems;
	private final boolean createFile;

	public ExciseReportGenerator(Set<ExcisedItem> excisedItems, File reportFile) {
		this(excisedItems, reportFile, true);
	}
	
	public ExciseReportGenerator(Set<ExcisedItem> excisedItems, File reportFile, boolean createFile) {
		this.createFile = createFile;
		this.excisedItems = new ArrayList<ExcisedItem>(excisedItems);
		Collections.sort(this.excisedItems);
		this.reportFile = reportFile;
	}

	public void create() throws IOException {
		HSSFWorkbook workbook = createReportWorkbook();
		FileOutputStream output = new FileOutputStream(this.reportFile);
		try {
			workbook.write(output);
		} finally {
			IOUtils.closeQuietly(output);
		}
	}

	HSSFWorkbook createReportWorkbook() throws IOException {
		HSSFWorkbook workbook = obtainWorkbook();
		
		HSSFSheet interactionsSheet = obtainSheet(workbook, "Excised Interactions");
		HSSFSheet packageLocationSheet = obtainSheet(workbook, "Excised Package Locations");
		HSSFSheet messagePartSheet = obtainSheet(workbook, "Excised Message Parts");
		
		writeInteractions(interactionsSheet);
		writePackageLocations(packageLocationSheet);
		writeMessageParts(messagePartSheet);
		
		adjustColumnWidths(interactionsSheet, packageLocationSheet, messagePartSheet);
		
		return workbook;
	}

	private HSSFSheet obtainSheet(HSSFWorkbook workbook, String name) {
		HSSFSheet result = null;
		if (this.createFile) {
			result = workbook.createSheet(name);
			createHeaderRow(result);
		} else {
			result = workbook.getSheet(name);
		}
		return result;
	}
	
	private HSSFWorkbook obtainWorkbook() throws IOException {
		HSSFWorkbook result = null;
		if (!this.createFile && this.reportFile.exists()) {
			FileInputStream input = new FileInputStream(this.reportFile);
			try {
				result = new HSSFWorkbook(input);
			} finally {
				IOUtils.closeQuietly(input);
			}
		} else {
			result = new HSSFWorkbook();
		}
		return result;
	}

	private void writeMessageParts(HSSFSheet messagePartSheet) {
		for (ExcisedItem item : this.excisedItems) {
			if (isMessagePart(item)) {
				int cell = 0;
				HSSFRow row = getNextRow(messagePartSheet);
				cell = writeExcisedInfo(row, cell, messagePartSheet, item);
				
				MessagePart removedMessagePart = (MessagePart) item.getItemWithDifferences();
				cell = writeDifferences(row, cell, removedMessagePart);
				for (Relationship relationship : removedMessagePart.getRelationships()) {
					cell = writeDifferences(row, cell, relationship);
				}
			}
		}
	}

	private int writeExcisedInfo(HSSFRow row, int cell, HSSFSheet workSheet, ExcisedItem item) {
		row.createCell(cell++).setCellValue(new HSSFRichTextString(item.getName()));
		row.createCell(cell++).setCellValue(new HSSFRichTextString(StringUtils.equals(item.getName(), item.getExciseSourceName()) ? "SELF" : item.getExciseSourceName()));
		cell = writeDifferences(row, cell, item.getItemWithDifferences());
		
		return cell;
	}

	private int writeDifferences(HSSFRow row, int cell, HasDifferences itemWithDifferences) {
		for (Difference difference : itemWithDifferences.getDifferences()) {
			if (!difference.isOk()) {
				row.createCell(cell++).setCellValue(new HSSFRichTextString(difference.getType().toString()));
				for (DifferenceValue differenceValue : difference.getDifferences()) {
					row.createCell(cell++).setCellValue(new HSSFRichTextString(differenceValue.getValue()));
				}
			}
		}
		return cell;
	}

	private boolean isMessagePart(ExcisedItem item) {
		String itemName = item.getName();
		return itemName.contains("_MT") && itemName.contains(".");
	}

	private void writePackageLocations(HSSFSheet packageLocationSheet) {
		for (ExcisedItem item : this.excisedItems) {
			if (isPackageLocation(item)) {
				int cell = 0;
				HSSFRow row = getNextRow(packageLocationSheet);
				writeExcisedInfo(row, cell, packageLocationSheet, item);
			}
		}
	}

	private boolean isPackageLocation(ExcisedItem item) {
		String itemName = item.getName();
		return itemName.contains("_MT") && !itemName.contains(".");
	}

	private void writeInteractions(HSSFSheet interactionsSheet) {
		for (ExcisedItem item : this.excisedItems) {
			if (isInteraction(item)) {
				int cell = 0;
				HSSFRow row = getNextRow(interactionsSheet);
				cell = writeExcisedInfo(row, cell, interactionsSheet, item);
				
				Interaction interaction = (Interaction) item.getItemWithDifferences();
				writeArgumentDifferences(row, cell, interaction.getArguments());
			}
		}
	}

	private int writeArgumentDifferences(HSSFRow row, int cell, List<Argument> arguments) {
		for (Argument argument : arguments) {
			cell = writeDifferences(row, cell, argument);
			writeArgumentDifferences(row, cell, argument.getArguments());
		}
		return cell;
	}

	private boolean isInteraction(ExcisedItem item) {
		return item.getName().contains("_IN");
	}

	private void adjustColumnWidths(HSSFSheet... sheet) {
		for (int i = 0; i < sheet.length; i++) {
			for (int j = 0; j < 20; j++) {
				sheet[i].autoSizeColumn(j);
			}
		}
	}

	private void createHeaderRow(HSSFSheet sheet) {
		int cell = 0;
		HSSFRow firstHeaderRow = getNextRow(sheet);
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Component"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Rejection Source"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Difference"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Value1"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Value2"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("(etc.)"));
		getNextRow(sheet);
	}

	private HSSFRow getNextRow(HSSFSheet sheet) {
		int lastRowNum = sheet.getLastRowNum();
		int rowNumber = (lastRowNum == 0 && sheet.getPhysicalNumberOfRows() == 0) ? 0 : lastRowNum + 1;
		return sheet.createRow(rowNumber);
	}

}
