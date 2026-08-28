SUMMARY = "Sip module support for PyQt5"
DESCRIPTION = "The sip extension module provides support for the \
PyQt5 package"
AUTHOR = "Phil Thomson @ riverbank.co.uk"
HOMEPAGE = "https://www.riverbankcomputing.com/software/sip"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9cd437778ebd1c056a76b4ded73b3a6d"

PV = "12.11.1"

PYPI_PACKAGE = "PyQt5_sip"

inherit pypi setuptools3

SRC_URI[sha256sum] = "97d3fbda0f61edb1be6529ec2d5c7202ae83aee4353e4b264a159f8c9ada4369"
