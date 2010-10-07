package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.HasDifferences;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

public class MergeReportGenerator {

	private final MessageSet messageSet;
	private final File reportFile;
	private final Stack<String> reportContext = new Stack<String>();
	

	public MergeReportGenerator(MessageSet messageSet, File reportFile) {
		this.messageSet = messageSet;
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
		HSSFSheet sheet = workbook.createSheet("Difference Analysis");
		createHeaderRows(sheet);

		for (Interaction interaction : this.messageSet.getInteractions().values()) {
			this.reportContext.push(interaction.getName());
			analyzeDifferences(sheet, interaction, interaction);
			processArguments(sheet, interaction.getArguments());
			this.reportContext.pop();
		}
		
		for (PackageLocation packageLocation : this.messageSet.getPackageLocations().values()) {
			this.reportContext.push(packageLocation.getName());
			analyzeDifferences(sheet, packageLocation, packageLocation);
			for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
				this.reportContext.push(messagePart.getName());
				analyzeDifferences(sheet, messagePart, messagePart);
				for (Relationship relationship : messagePart.getRelationships()) {
					this.reportContext.push(relationship.getName());
					analyzeDifferences(sheet, relationship, relationship);
					this.reportContext.pop();
				}
				this.reportContext.pop();
			}
			this.reportContext.pop();
		}
		
		adjustColumnWidths(sheet);
		return workbook;
	}

	private void adjustColumnWidths(HSSFSheet sheet) {
		for (int i = 0; i < 8; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	private void createHeaderRows(HSSFSheet sheet) {
		int cell = 0;
		HSSFRow firstHeaderRow = getNextRow(sheet);
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Interaction"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Argument"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Nested Argument"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Difference"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Version1"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Value1"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Version2"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Value2"));
		
		cell = 0;
		HSSFRow secondHeaderRow = getNextRow(sheet);
		secondHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Package Location"));
		secondHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Message Part"));
		secondHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Relationship"));
		
		// empty row
		getNextRow(sheet);
	}

	private void processArguments(HSSFSheet sheet, Iterable<Argument> arguments) {
		for (Argument argument : arguments) {
			this.reportContext.push(argument.getName());
			analyzeDifferences(sheet, argument, argument);
			processArguments(sheet, argument.getArguments());
			this.reportContext.pop();
		}
	}

	private void analyzeDifferences(HSSFSheet sheet, Named named, HasDifferences different) {
		for (Difference difference : different.getDifferences()) {
			DifferenceAnalyzer analyzer = getDifferenceAnalyzer(difference);
			analyzer.analyze(difference);
			writeDifference(getNextRow(sheet), named, difference);
		}
	}

	private DifferenceAnalyzer getDifferenceAnalyzer(Difference difference) {
		return new DifferenceAnalyzer() {
			public void analyze(Difference difference) {
				difference.setOk(true);
			}
		};
	}

	private HSSFRow getNextRow(HSSFSheet sheet) {
		int rowNumber = sheet.getPhysicalNumberOfRows() == 0 ? 0 : sheet.getLastRowNum() + 1;
		HSSFRow row = sheet.createRow(rowNumber);
		return row;
	}

	private void writeDifference(HSSFRow row, Named named, Difference difference) {
		int cell = 0;
		
		for (String string : this.reportContext) {
			row.createCell(cell++).setCellValue(new HSSFRichTextString(string));
		}
		
		cell = 3;
		
		// not currently needed since we track and report on our context (above)
		// row.createCell(cell++).setCellValue(new HSSFRichTextString(named.getName()));
		row.createCell(cell++).setCellValue(new HSSFRichTextString(difference.getType()));
		for (DifferenceValue value : difference.getDifferences()) {
			row.createCell(cell++).setCellValue(new HSSFRichTextString(value.getVersion()));
			row.createCell(cell++).setCellValue(new HSSFRichTextString(value.getValue()));
		}
	}

}
