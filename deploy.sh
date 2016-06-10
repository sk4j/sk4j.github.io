#!/bin/bash

#Buscando pelo zip
echo "Procurando pelo zip..."
if [ -z $(which zip) ]; then
	echo "Não encontrado."
	echo "======================================================================================================"
	echo " Por favor instale o zip. $ apt-get install zip"
	echo ""
	echo " Reinicie o processo após a instalação."
	echo "======================================================================================================"
	echo ""
	exit 0
fi

echo "Procurando pelo git..."
if [ -z $(which git) ]; then
	echo "Não encontrado."
	echo "======================================================================================================"
	echo " Por favor instale o git. $ apt-get install git"
	echo ""
	echo " Reinicie o processo após a instalação."
	echo "======================================================================================================"
	echo ""
	exit 0
fi

#Gera os arquivos de índices
echo "Gerando arquivo de índices..."
md5sum artifact/* ext/* lib/* > ./etc/index

#Empacota os arquivos necessários.
echo "Compactando arquivos SK..."
zip -r sk4j.zip artifact/* bin/* etc/* lib/* ext/*

echo "Adicionado arquivos ao controle de versão GIT..."
git add *
git commit -m "Deploy by ${USER}"
git push
