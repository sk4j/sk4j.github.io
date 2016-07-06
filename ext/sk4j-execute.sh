#!/bin/bash

CUR_DIR=$(pwd)

function __sk4j_execute {
    java -jar "${SK4J_HOME}/artifact/${1}.jar" ${CUR_DIR}
}
