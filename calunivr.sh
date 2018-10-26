#!/bin/bash
scriptdir="$(dirname "$0")"
cd "$scriptdir"
java -jar ./calunivr.jar "$@"
