package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer.DifferenceAnalyzer;
import ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer.DifferenceAnalyzerRegistry;
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
		
		HSSFSheet interactionOkSheet = workbook.createSheet("Interactions - Minor differences");
		HSSFSheet interactionNotOkSheet = workbook.createSheet("Interactions - Major Differences");
		HSSFSheet otherOkSheet = workbook.createSheet("Non-Interactions - Minor Differences");
		HSSFSheet otherNotOkSheet = workbook.createSheet("Non-Interactions - Major Differences");
		
		createInteractionHeaderRows(interactionOkSheet);
		createInteractionHeaderRows(interactionNotOkSheet);
		createOtherHeaderRows(otherOkSheet);
		createOtherHeaderRows(otherNotOkSheet);

		for (Interaction interaction : this.messageSet.getInteractions().values()) {
			this.reportContext.push(interaction.getName());
			analyzeDifferences(interactionOkSheet, interactionNotOkSheet, interaction, interaction);
			processArguments(interactionOkSheet, interactionNotOkSheet, interaction.getArguments());
			this.reportContext.pop();
		}
		
		for (PackageLocation packageLocation : this.messageSet.getPackageLocations().values()) {
			this.reportContext.push(packageLocation.getName());
			analyzeDifferences(otherOkSheet, otherNotOkSheet, packageLocation, packageLocation);
			for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
				this.reportContext.push(messagePart.getName());
				analyzeDifferences(otherOkSheet, otherNotOkSheet, messagePart, messagePart);
				for (Relationship relationship : messagePart.getRelationships()) {
					this.reportContext.push(relationship.getName());
					analyzeDifferences(otherOkSheet, otherNotOkSheet, relationship, relationship);
					List<Relationship> choices = relationship.getChoices();
					processChoices(otherOkSheet, otherNotOkSheet, choices);
					this.reportContext.pop();
				}
				this.reportContext.pop();
			}
			this.reportContext.pop();
		}
		
		adjustColumnWidths(interactionOkSheet, interactionNotOkSheet, otherOkSheet, otherNotOkSheet);
		return workbook;
	}

	private void processChoices(HSSFSheet okSheet, HSSFSheet notOkSheet, List<Relationship> choices) {
		for (Relationship choice : choices) {
			analyzeDifferences(okSheet, notOkSheet, choice, choice);
			processChoices(okSheet, notOkSheet, choice.getChoices());
		}
	}

	private void adjustColumnWidths(HSSFSheet... sheet) {
		for (int i = 0; i < sheet.length; i++) {
			for (int j = 0; j < 10; j++) {
				sheet[i].autoSizeColumn(j);
			}
		}
	}

	private void createInteractionHeaderRows(HSSFSheet sheet) {
		int cell = 0;
		HSSFRow firstHeaderRow = getNextRow(sheet);
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Interaction"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Argument"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Nested Argument"));
		
		createStandardHeaders(sheet, cell, firstHeaderRow);
	}

	private void createOtherHeaderRows(HSSFSheet sheet) {
		int cell = 0;
		HSSFRow firstHeaderRow = getNextRow(sheet);
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Package Location"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Message Part"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Relationship"));
		
		createStandardHeaders(sheet, cell, firstHeaderRow);
	}

	private void createStandardHeaders(HSSFSheet sheet, int cell, HSSFRow firstHeaderRow) {
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Difference"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("isOk"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("matchConf"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Version1"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Value1"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Version2"));
		firstHeaderRow.createCell(cell++).setCellValue(new HSSFRichTextString("Value2"));
		
		// empty row
		getNextRow(sheet);
	}

	private void processArguments(HSSFSheet okSheet, HSSFSheet notOkSheet, Iterable<Argument> arguments) {
		for (Argument argument : arguments) {
			this.reportContext.push(argument.getName());
			analyzeDifferences(okSheet, notOkSheet, argument, argument);
			processChoices(okSheet, notOkSheet, argument.getChoices());
			processArguments(okSheet, notOkSheet, argument.getArguments());
			this.reportContext.pop();
		}
	}

	private void analyzeDifferences(HSSFSheet okSheet, HSSFSheet notOkSheet, Named named, HasDifferences different) {
		for (Difference difference : different.getDifferences()) {
			DifferenceAnalyzer analyzer = getDifferenceAnalyzer(difference);
			analyzer.analyze(difference);
			writeDifference(getNextRow(difference.isOk() ? okSheet : notOkSheet), named, difference);
		}
	}

	private DifferenceAnalyzer getDifferenceAnalyzer(Difference difference) {
		return DifferenceAnalyzerRegistry.getInstance().get(difference.getType());
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
		row.createCell(cell++).setCellValue(new HSSFRichTextString(difference.getType().toString()));
		row.createCell(cell++).setCellValue(new HSSFRichTextString(difference.isOk() ? "Y" : "N"));
		row.createCell(cell++).setCellValue(new HSSFRichTextString(difference.getMatchConfidence() == null ? "" : difference.getMatchConfidence().toString()));
		for (DifferenceValue value : difference.getDifferences()) {
			row.createCell(cell++).setCellValue(new HSSFRichTextString(value.getVersion()));
			row.createCell(cell++).setCellValue(new HSSFRichTextString(value.getValue()));
		}
	}

}
