package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExciseReportGenerator {

	private final File reportFile;
	private final List<String> excisedItems;

	public ExciseReportGenerator(Set<String> excisedItems, File reportFile) {
		this.excisedItems = new ArrayList<String>(excisedItems);
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

	HSSFWorkbook createReportWorkbook() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		HSSFSheet interactionsSheet = workbook.createSheet("Excised Interactions");
		HSSFSheet packageLocationSheet = workbook.createSheet("Excised Package Locations");
		HSSFSheet messagePartSheet = workbook.createSheet("Excised Message Parts");
		
		createHeaderRows(interactionsSheet);
		createHeaderRows(packageLocationSheet);
		createHeaderRows(messagePartSheet);

		writeInteractions(interactionsSheet);
		writePackageLocations(packageLocationSheet);
		writeMessageParts(messagePartSheet);
		
		adjustColumnWidths(interactionsSheet, packageLocationSheet, messagePartSheet);
		
		return workbook;
	}

	private void writeMessageParts(HSSFSheet messagePartSheet) {
		for (String item : this.excisedItems) {
			if (isMessagePart(item)) {
				getNextRow(messagePartSheet).createCell(0).setCellValue(new HSSFRichTextString(item));
			}
		}
	}

	private boolean isMessagePart(String item) {
		return item.contains("_MT") && item.contains(".");
	}

	private void writePackageLocations(HSSFSheet packageLocationSheet) {
		for (String item : this.excisedItems) {
			if (isPackageLocation(item)) {
				getNextRow(packageLocationSheet).createCell(0).setCellValue(new HSSFRichTextString(item));
			}
		}
	}

	private boolean isPackageLocation(String item) {
		return item.contains("_MT") && !item.contains(".");
	}

	private void writeInteractions(HSSFSheet interactionsSheet) {
		for (String item : this.excisedItems) {
			if (isInteraction(item)) {
				getNextRow(interactionsSheet).createCell(0).setCellValue(new HSSFRichTextString(item));
			}
		}
	}

	private boolean isInteraction(String item) {
		return item.contains("_IN");
	}

	private void adjustColumnWidths(HSSFSheet... sheet) {
		for (int i = 0; i < sheet.length; i++) {
			for (int j = 0; j < 9; j++) {
				sheet[i].autoSizeColumn(j);
			}
		}
	}

	private void createHeaderRows(HSSFSheet sheet) {
		int cell = 0;
		HSSFRow firstHeaderRow = getNextRow(sheet);
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Component"));
	}

	private HSSFRow getNextRow(HSSFSheet sheet) {
		int rowNumber = sheet.getPhysicalNumberOfRows() == 0 ? 0 : sheet.getLastRowNum() + 1;
		HSSFRow row = sheet.createRow(rowNumber);
		return row;
	}

}
