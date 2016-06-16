#!/bin/bash

function __sk4j {
    COMMAND="$1"

    case "$COMMAND" in
        -e)
            COMMAND="execute";;
    esac

    CMD_FOUND=""
    CMD_TARGET="${SK4J_DIR}/ext/sk4j-${COMMAND}.sh"
    if [[ -f "$CMD_TARGET" ]]; then
           CMD_FOUND="$CMD_TARGET"
    fi

    if [[ -z "$CMD_FOUND" ]]; then
            echo "Invalid command: $COMMAND"
            #__sdk_help
    fi

    if [ -n "$CMD_FOUND" ]; then
           # It's available as a shell function
           __sk4j_"$COMMAND"
    fi
}
