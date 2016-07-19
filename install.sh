#!/bin/bash

SK4J_HOME="$HOME/git/sk4j.github.io"

if [[ $(grep -q SK4J_HOME "$HOME/.bashrc") -eq 1 ]]; then
	echo "export SK4J_HOME=$HOME/git/sk4j.github.io" >> "$HOME/.bashrc"
	echo "PATH=$PATH:$SK4J_HOME/bin" >> "$HOME/.bashrc"
fi

sudo cp "$SK4J_HOME/conf/sk-autocomplete.sh" /etc/bash_completion.d/

echo ""
echo "======================================================================================================"
echo "digite no console: source ~/.bashrc"
