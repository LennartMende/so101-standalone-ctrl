SUMMARY = "This is source code from official feetech repository"
HOMEPAGE = "https://github.com/Adam-Software/FEETECH-Servo-Python-SDK"

LICENSE = "Unlicense"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d512eeaf0d5285acc53d4569054cbb08"

PV = "1.0.0"

SRC_URI = "file://feetech-servo-sdk-${PV}.tar.gz"

S = "${WORKDIR}/feetech-servo-sdk-${PV}"

inherit setuptools3

RDEPENDS:${PN} += "python3-pyserial"
