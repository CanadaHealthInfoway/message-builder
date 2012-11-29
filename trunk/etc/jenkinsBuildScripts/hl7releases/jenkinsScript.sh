#!/bin/bash

#######################################
# Input Arguments: 
#  param1: messageSetSuffix 
#  param2: either svnPathForMIF or svnPathForMessageSet 
#  
#######################################

if [ -z $1 ] || [ -z $2 ] || [ -z $3 ]; then
	echo "ERROR: missing input parameters. This script is intended to be run by Jenkins only."
	exit 1
fi

isParam1Found=$(echo $1 | grep -o "messageSetSuffix=[^,^[:space:]]*" | wc -w)
isParam2Found=$(echo $2 | grep -o "svnPathForMIF=[^&^[:space:]]*" | wc -w)
isParam3Found=$(echo $3 | grep -o "svnPathForMessageSet=[^,^[:space:]]*" | wc -w)

# parse input parameters
messageSetSuffix=$(echo $1 | sed -r 's/messageSetSuffix=(.*)/\1/')
svnPathForMIF=$(echo $2 | sed -r 's/svnPathForMIF=(.*)/\1/')
svnPathForMessageSet=$(echo $3 | sed -r 's/svnPathForMessageSet=(.*)/\1/')

echo "messageSetSuffix is $messageSetSuffix"	
echo "svnPathForMIF is $svnPathForMIF"	
echo "svnPathForMessageSet is $svnPathForMessageSet"

#echo isParam2aFound is $isParam2aFound
#echo isParam2bFound is $isParam2bFound

if [ $isParam1Found -eq 0 ]; then
	echo "ERROR: messageSetSuffix input parameter is missing."
	exit 1
fi

if [ $isParam2Found -eq 0 ] && [ $isParam3Found -eq 0 ]; then
	echo "ERROR: svnPathForMIF or svnPathForMessageSet input parameter is missing."
	exit 1
fi

echo "creating folders..."
mkdir -v -p src/main/java
mkdir -v -p src/main/resources
mkdir -v -p target/input/mifs
mkdir -v -p target/output/messageSet
mkdir -v -p target/output/javaSource
mkdir -v -p target/output/xsdSource
mkdir -v -p target/output/csSource
mkdir -v -p temp/messageSet

if [ "$svnPathForMIF" != "" ] && [ "$svnPathForMessageSet" != "" ]; then
	echo "ERROR: svnPathForMIF or svnPathForMessageSet input parameter values are provided.  Only one should be provided."
	exit 1
fi

if [ "$svnPathForMIF" != "" ]; then		
	svn co "$svnPathForMIF" target/input/mifs
	if [ $? -ne 0 ]; then
		echo "ERROR: failed to checkout MIF from svn"
		exit 1
	fi

fi

if [ "$svnPathForMessageSet" != "" ]; then	
	svn co "$svnPathForMessageSet" temp/messageSet

	if [ $? -ne 0 ]; then
		echo "ERROR: failed to checkout messageSet from svn"
		exit 1
	fi
	
	if [ $(ls temp/messageSet/*.xml | wc -w) -ne 1 ]; then
		echo "ERROR: Either MessagSet is missing or multiple messageSet are found."
		exit 1
	fi
		
	mv -v temp/messageSet/*.xml "src/main/resources/messageSet_$messageSetSuffix.xml"
fi

exit 0
