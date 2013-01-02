@REM
@REM Copyright 2013 Canada Health Infoway, Inc.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM        http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM
@REM Author:        $LastChangedBy$
@REM Last modified: $LastChangedDate$
@REM Revision:      $LastChangedRevision$
@REM

call mvn install:install-file -Dfile=./pom/message-builder-pom.xml -DpomFile=./pom/message-builder-pom.xml -DgeneratePom=false
call mvn install:install-file -Dfile=message-builder-util-${project.version}.jar -DpomFile=./pom/message-builder-util-pom.xml -DgeneratePom=false
call mvn install:install-file -Dfile=message-builder-xml-${project.version}.jar -DpomFile=./pom/message-builder-xml-pom.xml -DgeneratePom=false
call mvn install:install-file -Dfile=message-builder-core-${project.version}.jar -DpomFile=./pom/message-builder-core-pom.xml -DgeneratePom=false
call mvn install:install-file -Dfile=message-builder-terminology-${project.version}.jar -DpomFile=./pom/message-builder-terminology-pom.xml -DgeneratePom=false
if "%1"=="terminology" (
	copy pom\obtain-core-dependencies-with-terminology-pom.xml pom.xml
) else (
	copy pom\obtain-core-dependencies-pom.xml pom.xml
)
rd /s/q message_builder_lib
call mvn dependency:copy-dependencies -DoutputDirectory=message_builder_lib
