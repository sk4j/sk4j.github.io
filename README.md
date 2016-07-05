# sk4j.github.io
O projeto sk4j tem como objetivo ser uma ferramenta de produtividade em Java. Suas principais funcionalidades sao:

* Geração de código (java, xhtml, xml etc...) através de templates [jtwig](http://jtwig.org/)
* Analisador de código fonte java.
* Gerador de diagrama UML de entidades JPA.
* Gerador de archetypes de projetos (demoiselle, maven-quickstart e etc.)

###Dependências
Para instalar o projeto sk4j é necessário antes possuir os seguintes programas instalados no máquina:

* **git** (*sudo apt-get install git*)
* **curl** (*sudo apt-get install curl*)

### Instalação do sk4j
Com as depedências satisfeitas o próximo passo é a efetiva instalação do sk4j. No console do linux digite o comando abaixo:
```bash
    $ curl -s "https://sk4j.github.io/install.sh" | bash
```
Caso o procedimento ocorra sem problemas é necessário digitar o comando a seguir:
```bash
    $ source ~/.bashrc
```
Com isso o comando **sk4j** estará disponível no console.

###Utilização do sk4j
O sk4j possui uma paleta de comandos bem simples. Abaixo segue os principais comandos:
```bash
    $ sk4j -h
```
O comando acima exibe o help do sistema com o modo de uso.
```bash
    $ sk4j -l
```
Lista todos os artefatos que podem ser executados pelo sk4j.
```bash
    $ sk4j -e [nome_artefato]
```
Executa um artefato sk4j. *Precionando a tecla tab após 'sk4j -e' é listado todas as opções de artefatos diponíveis*
