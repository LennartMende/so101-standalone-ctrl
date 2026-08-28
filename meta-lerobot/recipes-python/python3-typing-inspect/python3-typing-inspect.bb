SUMMARY = "Runtime inspection utilities for typing module."
HOMEPAGE = "https://github.com/ilevkivskyi/typing_inspect"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=38939e40df14ccacab135b023198167a"

PV = "0.9.0"

SRC_URI = "file://typing_inspect-${PV}.tar.gz"

S = "${WORKDIR}/typing_inspect-${PV}"

inherit setuptools3

RDEPENDS:${PN} += " python3-mypy-extensions python3-typing-extensions"
