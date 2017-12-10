#!/bin/bash

thisScriptDir=$(dirname $0)"/"
thisToolClassPath="$thisScriptDir"target/JsonSchemaExporter-0.0.1-SNAPSHOT.jar

export CLASSPATH="$CLASSPATH":"$thisToolClassPath":"$1"
echo $CLASSPATH
java irusev.exportjson.StartExporting $2
