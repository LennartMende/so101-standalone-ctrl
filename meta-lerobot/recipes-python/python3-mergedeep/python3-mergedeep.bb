SUMMARY = "A deep merge function for 🐍."
HOMEPAGE = "https://github.com/clarketm/mergedeep"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d28407baa6c4b0d3cf0041589ab2ed95"

PV = "1.3.4"

SRC_URI = "file://mergedeep-${PV}.tar.gz"

S = "${WORKDIR}/mergedeep-${PV}"

inherit setuptools3
