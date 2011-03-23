package ca.infoway.messagebuilder.comparator;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanVisitor extends VoidVisitorAdapter<Object> {
	
	private final Map<String,String> signatureToReturnTypeMap = new HashMap<String,String>();
	private List<ClassOrInterfaceType> implementsList = new ArrayList<ClassOrInterfaceType>();
	private List<ClassOrInterfaceType> extendsList = new ArrayList<ClassOrInterfaceType>();
	private boolean isClassOrInterfacePublic;

	@Override
	public void visit(CompilationUnit compilationUnit, Object arg) {
		ClassOrInterfaceDeclaration mainTypeDeclaration = (ClassOrInterfaceDeclaration) compilationUnit.getTypes().get(0);
		this.isClassOrInterfacePublic = ModifierSet.isPublic(mainTypeDeclaration.getModifiers());
		if (mainTypeDeclaration.getImplements() != null) {
			this.implementsList = mainTypeDeclaration.getImplements();
		}
		if (mainTypeDeclaration.getExtends() != null) {
			this.extendsList = mainTypeDeclaration.getExtends();
		}
		
		List<BodyDeclaration> members = mainTypeDeclaration.getMembers();
		if (members != null) {
			for (BodyDeclaration bodyDeclaration : members) {
				if (bodyDeclaration instanceof MethodDeclaration) {
					MethodDeclaration methodDeclaration = (MethodDeclaration)bodyDeclaration;
					if (ModifierSet.isPublic(methodDeclaration.getModifiers())) {
						String name = methodDeclaration.getName();
						List<Parameter> parameters = methodDeclaration.getParameters();
						StringBuilder stringBuilder = new StringBuilder();
						stringBuilder.append(name);
						if (parameters != null) {
							for (Parameter parameter : parameters) {
								stringBuilder.append(",");
								stringBuilder.append(TypeUtil.getTypeName(parameter.getType()));
							}
						}
						this.signatureToReturnTypeMap.put(stringBuilder.toString(), TypeUtil.getTypeName(methodDeclaration.getType()));
					}
				}
			}
		}
	}

	public boolean isClassOrInterfacePublic() {
		return isClassOrInterfacePublic;
	}

	public List<ClassOrInterfaceType> getImplementsList() {
		return implementsList;
	}

	public List<ClassOrInterfaceType> getExtendsList() {
		return extendsList;
	}

	public Map<String, String> getSignatureToReturnTypeMap() {
		return signatureToReturnTypeMap;
	}	
}
