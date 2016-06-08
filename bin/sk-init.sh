#!/bin/bash

export SK_VERSION="1.0.0"

if [ -z "$SK_DIR" ]; then
	export SK_DIR="$HOME/.sk"
fi

export SK_ARTIFACTIS_DIR="${SK_DIR}/artifacts"
export SK_LIB_DIR="${SK_DIR}/lib"

# Source sk module scripts.
for f in $(find "${SK_DIR}/src" -type f -name 'sk-*' -exec basename {} \;); do
    source "${SK_DIR}/src/${f}"
done

# Load the sk config.
if [ -f "${SK_DIR}/etc/config" ]; then
	source "${SK_DIR}/etc/config"
fi
