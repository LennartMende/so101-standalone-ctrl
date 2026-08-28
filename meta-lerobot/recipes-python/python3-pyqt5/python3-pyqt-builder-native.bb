SUMMARY = "PEP 517 compliant PyQt build system for PyQt"
DESCRIPTION = "PyQt-builder is the PEP 517 compliant build system \
for PyQt and projects that extend PyQt. It extends the SIP build \
system and uses Qt’s qmake to perform the actual compilation and \
installation of extension modules. \
\
Projects that use PyQt-builder provide an appropriate pyproject.toml \
file and an optional project.py script. Any PEP 517 compliant \
frontend, for example sip-install or pip can then be used to build \
and install the project."
AUTHOR = "Phil Thomson @ riverbank.co.uk"
HOMEPAGE = "https://www.riverbankcomputing.com/software/pyqt-builder"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9cd437778ebd1c056a76b4ded73b3a6d"

PV = "1.15.1"

PYPI_PACKAGE = "PyQt-builder"

inherit pypi setuptools3 native

SRC_URI[sha256sum] = "a2bd3cfbf952e959141dfe55b44b451aa945ca8916d1b773850bb2f9c0fa2985"
