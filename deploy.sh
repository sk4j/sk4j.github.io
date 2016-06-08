#!/bin/bash


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

#Empacota os arquivos necessários.
zip -r sk.zip artifacts/* bin/* etc/* lib/* ext/*
git add *
git commit -m "Deploy by ${USER}"
git push
