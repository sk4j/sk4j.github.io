#!/bin/bash

function __sk4j {
    COMMAND="$1"
    QUALIFIER="$2"

    case "$COMMAND" in
        execute)
            COMMAND="execute";;
        list)
            COMMAND="list";;
        help)
            COMMAND="help";;
    esac

    CMD_FOUND=""
    CMD_TARGET="${SK4J_DIR}/ext/sk4j-${COMMAND}.sh"
    if [[ -f "$CMD_TARGET" ]]; then
           CMD_FOUND="$CMD_TARGET"
    fi

    if [[ -z "$CMD_FOUND" ]]; then
            echo "Comando inválido: $COMMAND"
            __sk4j_help
    fi

    if [ -n "$CMD_FOUND" ]; then
           # It's available as a shell function
           __sk4j_"$COMMAND" $QUALIFIER
    fi
}
