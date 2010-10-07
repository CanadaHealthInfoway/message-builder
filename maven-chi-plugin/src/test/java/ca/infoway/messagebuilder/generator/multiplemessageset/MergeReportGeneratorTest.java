package ca.infoway.messagebuilder.generator.multiplemessageset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;


public class MergeReportGeneratorTest {
	
	private MessageSet messageSet;

	@Before
	public void setUp() throws Exception {
		this.messageSet = new MessageSet();
	}

//	@Test
//	public void shouldHandleSuperTypeDifferences() throws Exception {
//		createInteractionWithSuperTypeDifference("ABCD_IN123456CA");
//		createInteractionWithSuperTypeDifference("ABCD_IN987654CA");
//		
//		MergeReportGenerator generator = new MergeReportGenerator(this.messageSet, 
//				createTempFile(getShortClassName(getClass()), ".xls"));
//		HSSFWorkbook workbook = generator.createReportWorkbook();
//		
//		assertNotNull("workbook", workbook);
//		assertTrue("has work sheet", workbook.getNumberOfSheets() > 0);
//		
//		assertCellValueEquals("cell A1", "superType", workbook.getSheetAt(0), 0, 4);
//		assertCellValueEquals("cell A2", "superType", workbook.getSheetAt(0), 1, 4);
//	}
//
	@Test
	public void shouldHandleArgumentDifferences() throws Exception {
//		createInteractionWithArgumentDifference("ABCD_IN123456CA");
//		createInteractionWithArgumentDifference("ABCD_IN987654CA");
//		
//		MergeReportGenerator generator = new MergeReportGenerator(this.messageSet, 
//				createTempFile(getShortClassName(getClass()), ".xls"));
//		HSSFWorkbook workbook = generator.createReportWorkbook();
//		
//		assertNotNull("workbook", workbook);
//		assertTrue("has work sheet", workbook.getNumberOfSheets() > 0);
//		
//		assertCellValueEquals("cell A1", "arg", workbook.getSheetAt(0), 0, 4);
//		assertCellValueEquals("cell A2", "arg", workbook.getSheetAt(0), 1, 4);
	}
	
	private void createInteractionWithSuperTypeDifference(String interactionId) {
		Interaction interaction = new Interaction();
		Difference difference = new Difference();
		difference.setType("superType");
		interaction.addDifference(difference);
		this.messageSet.getInteractions().put(interactionId, interaction);
	}

	private void createInteractionWithArgumentDifference(String interactionId) {
		Difference difference = new Difference();
		difference.setType("arg");
		
		Argument argument = new Argument();
		argument.addDifference(difference);
		
		Interaction interaction = new Interaction();
		interaction.setArguments(Arrays.asList(argument));
		
		this.messageSet.getInteractions().put(interactionId, interaction);
	}

	private void assertCellValueEquals(String description, String expectedValue, HSSFSheet sheet, int rowNumber, int cellNumber) {
		HSSFRow row = sheet.getRow(rowNumber);
		assertNotNull(description + " row exists", row);
		HSSFCell cell = row.getCell(cellNumber);
		assertNotNull(description + " cell exists", cell);
		assertEquals(description, expectedValue, cell.getStringCellValue());
	}
}
