#!/bin/bash

SK4J_HOME="$HOME/.sk4j"
SK4J_SERVICE="https://sk4j.github.io"

#Verifica se o curl está instalado na máquina
if [ -z $(which curl) ]; then
	echo -e "comando 'curl' não instalado. instale pelo gereciador de pacotes."
	exit 0
fi

#Verifica a existência do diretório SK4J
if [ ! -d "$SK4J_HOME" ]; then
	echo -e "Criando diretórios sk4j em $SK4J_HOME ..."
	mkdir -p "$SK4J_HOME"
	mkdir -p "$SK4J_HOME/artifact"
	mkdir -p "$SK4J_HOME/bin"
	mkdir -p "$SK4J_HOME/conf"
	mkdir -p "$SK4J_HOME/ext"
	mkdir -p "$SK4J_HOME/help"
	mkdir -p "$SK4J_HOME/lib"
	mkdir -p "$SK4J_HOME/tmp"
fi

echo -e "Baixando arquivos sk4j da internet. Aguarde..."
cd "$SK4J_HOME/bin"
curl -s -O "$SK4J_SERVICE/bin/sk4j"
cd "$SK4J_HOME/ext"
curl -s -O "$SK4J_SERVICE/ext/sk4j-execute.sh"
curl -s -O "$SK4J_SERVICE/ext/sk4j-help.sh"
curl -s -O "$SK4J_SERVICE/ext/sk4j-list.sh"
curl -s -O "$SK4J_SERVICE/ext/sk4j-main.sh"
curl -s -O "$SK4J_SERVICE/ext/sk4j-update.sh"
cd "$SK4J_HOME/conf"
curl -s -O "$SK4J_SERVICE/conf/sk4j-autocomplete.sh"
curl -s -O "$SK4J_SERVICE/conf/sk4j-profile"

echo "Instalando o SK4J..."

cat "$SK4J_HOME/conf/sk4j-profile.sh" >> $HOME/.bashrc
sudo cp "$SK4J_HOME/conf/sk4j-autocomplete.sh" /etc/bash_completion.d/
source ~/.bashrc

echo ""
echo "======================================================================================================"
echo "digite no console: source ~/.bashrc"
