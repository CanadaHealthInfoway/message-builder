package ca.infoway.messagebuilder.comparator;

import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.type.PrimitiveType;
import japa.parser.ast.type.ReferenceType;
import japa.parser.ast.type.Type;
import japa.parser.ast.type.VoidType;

public class TypeUtil {

	public static String getTypeName(Type type) {
		if (type instanceof ClassOrInterfaceType) {
			return ((ClassOrInterfaceType)type).getName();
		} else if (type instanceof PrimitiveType) {
			return ((PrimitiveType)type).getType().name();
		} else if (type instanceof ReferenceType) {
			return ((ClassOrInterfaceType)((ReferenceType)type).getType()).getName();
		} else if (type instanceof VoidType) {
			return "void";
		} else {
			return null;
		}
	}

}
