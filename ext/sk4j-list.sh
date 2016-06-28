#!/bin/bash

function __sk4j_list {
    echo -e ""
    local desc count
    for f in $(find "${SK4J_DIR}/help" -type f -exec basename {} \;); do
        desc=$(cat "${SK4J_DIR}/help/${f}")
        echo -e "\e[96m> \e[39m${f} - \e[32m${desc}\e[39m"
        count=$[$count+1]
    done
    echo -e "\n  ${count} Artefatos encontrados."
}
