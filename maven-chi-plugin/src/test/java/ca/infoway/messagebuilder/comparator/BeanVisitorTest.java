package ca.infoway.messagebuilder.comparator;

import static org.junit.Assert.assertEquals;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import org.junit.Test;


public class BeanVisitorTest {

	@Test
	public void shouldFind4Methods() throws Exception {
		BeanVisitor myVisitor = new BeanVisitor();
		CompilationUnit oldCompilationUnit = JavaParser.parse(new FileInputStream(new File("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/SampleBean.java")));
		myVisitor.visit(oldCompilationUnit, oldCompilationUnit);
		Map<String, String> methodMap = myVisitor.getSignatureToReturnTypeMap();
		assertEquals(4, methodMap.size());
	}

	@Test
	public void shouldFind3Methods() throws Exception {
		BeanVisitor myVisitor = new BeanVisitor();
		CompilationUnit oldCompilationUnit = JavaParser.parse(new FileInputStream(new File("./src/test/java/ca/infoway/messagebuilder/comparator/newbean/SampleBean.java")));
		myVisitor.visit(oldCompilationUnit, oldCompilationUnit);
		Map<String, String> methodMap = myVisitor.getSignatureToReturnTypeMap();
		assertEquals(3, methodMap.size());
	}
}
