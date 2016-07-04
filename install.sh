#!/bin/bash

echo "Procurando pelo git..."
if [ -z $(which git) ]; then
	echo "Git não encontrado. Tentando instalação via apt-get"
	echo "======================================================================================================"
	sudo apt-get install git
fi

echo "Clonando diretório sk4j..."
git clone "https://github.com/sk4j/sk4j.github.io.git"

echo "Instalando o SK4J..."
echo "SK4J_HOME=~/git/sk4j.github.io" >> ~/.bashrc
echo "PATH=$PATH:$SK4J_HOME/bin" >> ~/.bashrc

source ~/.bashrc
