SUMMARY = "LeRobot Python module (copied into site-packages)"
LICENSE = "CLOSED"

SRC_URI = "file://lerobot \
           file://lerobot/calibration \
           file://certs \
           file://scripts/99-lerobot.rules"

S = "${WORKDIR}"

inherit allarch useradd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "-r weston"

do_compile[noexec] = "1"

do_install() {
    # python site-packages as destination
    install -d ${D}${libdir}/python3.11/site-packages/lerobot

    # copy lerobot package
    cp -r --no-preserve=ownership \
        ${S}/lerobot/lerobot/. \
        ${D}${libdir}/python3.11/site-packages/lerobot/


    # copy LICENSE
    install -d ${D}${datadir}/licenses/${PN}

    install -m 0644 \
        ${S}/lerobot/LICENSE \
        ${D}${datadir}/licenses/${PN}/


    # install calibration scripts
    install -d ${D}${datadir}/lerobot/calibration

    cp -r --no-preserve=ownership \
        ${S}/lerobot/calibration/. \
        ${D}${datadir}/lerobot/calibration/


    # install certificates CLEAN (no host contamination)
    install -d ${D}${libdir}/python3.11/site-packages/certs

    # copy all cert files WITHOUT metadata
    for f in ${WORKDIR}/certs/*; do
        install -m 0644 "$f" ${D}${libdir}/python3.11/site-packages/certs/
    done

    # fix permissions
    chmod 0644 ${D}${libdir}/python3.11/site-packages/certs/*.crt
    chmod 0640 ${D}${libdir}/python3.11/site-packages/certs/*.key


    # install udev rules
    install -d ${D}/etc/udev/rules.d

    install -m 0644 \
        ${WORKDIR}/scripts/99-lerobot.rules \
        ${D}/etc/udev/rules.d/


    # remove python cache files
    find ${D} -name "__pycache__" -type d -exec rm -rf {} +
    find ${D} -name "*.pyc" -delete
}

FILES:${PN} += " \
    ${libdir}/python3.11/site-packages/lerobot \
    ${datadir}/lerobot \
    ${datadir}/licenses/${PN} \
    ${libdir}/python3.11/site-packages/certs \
    ${sysconfdir}/udev/rules.d/99-lerobot.rules \
"

PACKAGE_PREPROCESS_FUNCS += "fix_cert_permissions"

fix_cert_permissions() {
    chown root:weston ${PKGD}${libdir}/python3.11/site-packages/certs/*.key || true
}

RDEPENDS:${PN} += " \
    python3-draccus \
    python3-feetech-servo-sdk \
    udev \
    weston-init \
"
