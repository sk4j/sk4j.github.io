#!/bin/bash

#Retorna o diretório atual
CUR_DIR=$(pwd)

function __sk_execute {

    if [[ -z "$JAVA_HOME" ]]; then
		echo "JAVA_HOME não encontrado."
        exit 0
	fi
    
    #Chama o artefato correspondente
    java -jar "$SK_DIR/artifact/$1.jar" "$CUR_DIR"

}
