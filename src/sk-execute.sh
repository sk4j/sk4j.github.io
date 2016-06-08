#!/bin/bash

#Retorna o diretório atual
CUR_DIR=$(pwd)

function __sk_execute {
    echo -e "Execute Command. $CUR_DIR $1"
}
