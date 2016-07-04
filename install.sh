#!/bin/bash

SK4J_HOME="$HOME/git/sk4j.github.io/"
GIT_HOME="$HOME/git/"

echo "Procurando pelo git..."
if [ -z $(which git) ]; then
	echo "Git não encontrado. Tente instalar via apt-get depois reinicie o procedimento."
	echo "======================================================================================================"
	exit 0
fi

if [ ! -d "$GIT_HOME" ]; then
	mkdir -p "$GIT_HOME"
fi


if [ -d "$SK4J_HOME" ]; then
	echo "O sk4j já está instalado!"
	echo "======================================================================================================"
	exit 0
fi



echo "Clonando diretório sk4j..."
cd "$GIT_HOME"
git clone "https://github.com/sk4j/sk4j.github.io.git"

echo "Instalando o SK4J..."
echo "SK4J_HOME=$HOME/git/sk4j.github.io" >> ~/.bashrc
echo "PATH=$PATH:$HOME/git/sk4j.github.io/bin" >> ~/.bashrc

source ~/.bashrc

sudo cp "$SK4J_HOME/conf/sk4j-autocomplete.sh" /etc/bash_completion.d/

echo ""
echo "======================================================================================================"
echo "digite no console: source ~/.bashrc"
