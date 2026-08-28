LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dbe9fc28a36990370e12fdab76286a3a"

PV = "0.10.0"

SRC_URI = "file://draccus-${PV}.tar.gz"

S = "${WORKDIR}/draccus-${PV}"

inherit python_setuptools_build_meta

RDEPENDS:${PN} += " \
    python3-mergedeep \
    python3-pyyaml \
    python3-pyyaml-include \
    python3-toml \
    python3-typing-inspect \
"
