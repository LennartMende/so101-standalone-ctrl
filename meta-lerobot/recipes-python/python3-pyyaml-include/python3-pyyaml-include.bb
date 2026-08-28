SUMMARY = "Extending PyYAML with a custom constructor for including YAML files within YAML files"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3c34afdc3adf82d2448f12715a255122"

PV = "1.4.1"

SRC_URI = "file://pyyaml-include-${PV}.tar.gz"

S = "${WORKDIR}/pyyaml-include-${PV}"

inherit setuptools3
