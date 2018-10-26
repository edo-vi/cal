#!/bin/bash
scriptdir="$(dirname "$0")" #relative path
cd "$scriptdir"
real="$(cd "$(dirname "$1")"; pwd)/$(basename "$1")" #absolute path

echo "PATH=\$PATH:$real" >> $HOME/.bashrc
cd $HOME
source ".bashrc" #added to path
