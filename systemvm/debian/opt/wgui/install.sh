#!/usr/bin/env bash

set -e
set -x

WG_UI_URL=https://github.com/ngoduykhanh/wireguard-ui/releases/download/v0.6.2/wireguard-ui-v0.6.2-linux-amd64.tar.gz
ARCHIVE_NAME=wireguard-ui-v0.6.2-linux-amd64.tar.gz

function download_bin() {
  # download archive
  wget "$WG_UI_URL"

  # untar
  tar -xvzf "$ARCHIVE_NAME"

  # delete arch
  rm -f "$ARCHIVE_NAME"

  # permissions
  chmod +x wireguard-ui
}

#########################################
 # MAIN
#########################################


if [ ! -f wireguard-ui ]; then
  download_bin
fi








