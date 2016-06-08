#!/bin/bash

function sk {
    COMMAND="$1"
    ARTIFACT="$2"

    case "$COMMAND" in
        -e)
            COMMAND="execute";;
        -l)
            COMMAND="list";;
        -h)
            COMMAND="help";;
        -v)
            COMMAND="version";;
        -u)
            COMMAND="update";;
        -t)
            COMMAND="test";;
    esac

    # Load the sdkman config if it exists.
	if [ -f "${SK_DIR}/etc/config" ]; then
		source "${SK_DIR}/etc/config"
	fi

  CMD_TARGET="${SK_DIR}/ext/sk-${COMMAND}.sh"
	if [[ -f "$CMD_TARGET" ]]; then
		CMD_FOUND="$CMD_TARGET"
	fi

  if [[ -z "$CMD_FOUND" ]]; then
		echo "Commando Inválido: $COMMAND"
		__sk_help
	fi

  #Execute the requested command
	if [ -n "$CMD_FOUND" ]; then
		# It's available as a shell function
		__sk_"$COMMAND" "$2"
	fi

}
