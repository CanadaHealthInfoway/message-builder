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
