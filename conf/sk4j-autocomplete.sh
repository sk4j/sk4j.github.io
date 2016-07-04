#!/bin/bash

SK4J_DIR="${HOME}/git/sk4j.github.io"
__sk_autocomplete ()   #  By convention, the function name
{                 #+ starts with an underscore.
  local cur artifacts
  # Pointer to current completion word.
  # By convention, it's named "cur" but this isn't strictly necessary.

  COMPREPLY=()   # Array variable storing the possible completions.
  cur=${COMP_WORDS[COMP_CWORD]}

  case "$cur" in
    -e)
        for f in $(find "${SK4J_DIR}/artifact" -type f -name '*.jar' -exec basename {} \;); do
            artifacts="$artifacts $f"
        done
        COMPREPLY=( $( compgen -W "$artifacts" -- $cur ) );;
    -*)
        COMPREPLY=( $( compgen -W '-e -l -h' -- $cur ) );;
  esac

  return 0
}

complete -F __sk_autocomplete sk4j
