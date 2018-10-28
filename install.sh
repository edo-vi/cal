#!/bin/bash
scriptdir="$(dirname "$0")" #relative path
cd "$scriptdir"
real="$(cd "$(dirname "$1")"; pwd)/$(basename "$1")" #absolute path

echo "PATH=\$PATH:$real" >> $HOME/.bash_profile
cd $HOME
source $HOME/.bash_profile #added to path
