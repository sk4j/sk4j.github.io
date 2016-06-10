#!/bin/bash


function __sk_index {
    #Gera os arquivos de índices
    echo "Gerando arquivo de índices..."
    md5sum artifact/* ext/* lib/* etc/* bin/* > ./etc/index

}

function __sk_zip {
    #Empacota os arquivos necessários.
    echo "Compactando arquivos SK..."
    zip -r sk4j.zip artifact/* bin/* etc/* lib/* ext/*

}

function __sk_git {
    echo "Adicionado arquivos ao controle de versão GIT..."
    git add *
    git commit -m "Deploy by ${USER}"
    git push
}
