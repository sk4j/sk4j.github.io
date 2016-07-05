#!/bin/bash

SK4J_DIR="${HOME}/git/sk4j.github.io"
__sk_autocomplete ()   #  By convention, the function name
{                 #+ starts with an underscore.
    local cur prev opts
    local artifacts

    COMPREPLY=()   # Array variable storing the possible completions.
    cur=${COMP_WORDS[COMP_CWORD]}
    prev=${COMP_WORDS[COMP_CWORD-1]}
    opts="-e -h -l"

    case "$prev" in

        -e)
            for f in $(find "${SK4J_DIR}/artifact" -type f -name '*.jar' -exec basename -s .jar {} \;); do
                artifacts="$f $artifacts"
            done
            COMPREPLY=( $( compgen -W "$artifacts" -- $cur ) )
    	    return 0
    	    ;;
        -l)
            ;;
        -h)
            ;;
    esac

    if [[ $COMP_CWORD -eq 1 ]] ; then
        COMPREPLY=($(compgen -W "$opts" -- "$cur"))
    fi
    return 0
}

complete -F __sk_autocomplete sk4j
