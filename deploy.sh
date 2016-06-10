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

source "ext/sk-util.sh"

__sk_index
__sk_zip
__sk_git
