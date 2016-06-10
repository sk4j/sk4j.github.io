#!/bin/bash

SK_SERVICE="http://sk4j.github.io/"
SK_VERSION="1.0"

if [ -z "$SK_DIR" ]; then
    SK_DIR="$HOME/.sk"
fi

sk_bin_folder="${SK_DIR}/bin"
sk_etc_folder="${SK_DIR}/etc"
sk_lib_folder="${SK_DIR}/lib"
sk_src_folder="${SK_DIR}/src"
sk_ext_folder="${SK_DIR}/ext"
sk_artifact_folder="${SK_DIR}/artifact"
sk_tmp_folder="${SK_DIR}/tmp"


echo "Procurando pelo java..."
if [ -z $(which java) ]; then
	echo "Não encontrado."
	echo "======================================================================================================"
	echo " Por favor instale o jdk. $ apt-get install openjdk-7-jdk"
	echo ""
	echo " Reinicie o processo após a instalação."
	echo "======================================================================================================"
	echo ""
	exit 0
fi

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

echo "Procurando pelo unzip..."
if [ -z $(which unzip) ]; then
	echo "Não encontrado."
	echo "======================================================================================================"
	echo " Por favor instale o unzip. $ apt-get install unzip"
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

echo "Procurando pelo curl..."
if [ -z $(which curl) ]; then
	echo "Não encontrado."
	echo "======================================================================================================"
	echo " Por favor instale o curl. $ apt-get install curl"
	echo ""
	echo " Reinicie o processo após a instalação."
	echo "======================================================================================================"
	echo ""
	exit 0
fi

echo "Procurando pelo md5sum..."
if [ -z $(which md5sum) ]; then
	echo "Não encontrado."
	echo "======================================================================================================"
	echo " Por favor instale o md5sum. $ apt-get install md5sum"
	echo ""
	echo " Reinicie o processo após a instalação."
	echo "======================================================================================================"
	echo ""
	exit 0
fi

echo "Procurando pelo sdkman..."
if [ -z $(which sdk) ]; then
	echo "Não encontrado."
	echo "======================================================================================================"
	echo " Por favor instale o sdkman. ver http://sdkman.io/install.html"
	echo ""
	echo " Reinicie o processo após a instalação."
	echo "======================================================================================================"
	echo ""
	exit 0
fi

echo "Procurando pelo gradle..."
if [ -z $(which gradle) ]; then
	echo "Não encontrado."
	echo "======================================================================================================"
	echo " Por favor instale o gradle. $ sdk install gradle"
	echo ""
	echo " Reinicie o processo após a instalação."
	echo "======================================================================================================"
	echo ""
	exit 0
fi

echo "Procurando pelo groovy..."
if [ -z $(which groovy) ]; then
	echo "Não encontrado."
	echo "======================================================================================================"
	echo " Por favor instale o groovy. $ sdk install groovy"
	echo ""
	echo " Reinicie o processo após a instalação."
	echo "======================================================================================================"
	echo ""
	exit 0
fi

echo "Criando diretórios SK..."
mkdir -p "$sk_bin_folder"
mkdir -p "$sk_etc_folder"
mkdir -p "$sk_artifact_folder"
mkdir -p "$sk_lib_folder"
mkdir -p "$sk_src_folder"
mkdir -p "$sk_ext_folder"
mkdir -p "$sk_tmp_folder"

echo "Baixando SK..."
curl -s $SK_SERVICE/sk.zip > $SK_DIR/tmp
cd $SK_DIR/tmp
echo "Extraindo arquivos SK..."
unzip sk.zip

echo "Copiando dados..."
cp -r $SK_DIR/tmp/bin $sk_bin_folder
cp -r $SK_DIR/tmp/etc $sk_etc_folder
cp -r $SK_DIR/tmp/lib $sk_lib_folder
cp -r $SK_DIR/tmp/src $sk_src_folder
