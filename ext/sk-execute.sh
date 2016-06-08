#!/bin/bash

#Retorna o diretório atual
CUR_DIR=$(pwd)



function __sk_execute {

    if [[ -z "$JAVA_HOME" ]]; then
		echo "JAVA_HOME não encontrado."
        exit 0
	fi

    local classpath="$SK_DIR/lib:$GROOVY_HOME/"

    java -cp "$classpath" "$SK_DIR/artifacts/$1.jar" "$CUR_DIR"

}
