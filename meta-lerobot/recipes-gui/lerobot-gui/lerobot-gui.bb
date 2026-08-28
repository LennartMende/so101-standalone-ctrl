SUMMARY = "LeRobot PyQt5 GUI"
LICENSE = "CLOSED"

SRC_URI = "file://src \
           file://images \
           file://scripts"

S = "${WORKDIR}"

inherit systemd

SYSTEMD_SERVICE:${PN} = "lerobot-gui.service set-system-time.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    
    install -d ${D}/opt/lerobot-gui

    cp -a --no-preserve=ownership ${WORKDIR}/src ${D}/opt/lerobot-gui/
    cp -a --no-preserve=ownership ${WORKDIR}/images ${D}/opt/lerobot-gui/

    install -d ${D}${systemd_system_unitdir}

    install -m 0644 ${WORKDIR}/scripts/lerobot-gui.service \
        ${D}${systemd_system_unitdir}/lerobot-gui.service

    install -m 0644 \
        ${WORKDIR}/scripts/set-system-time.service \
        ${D}${systemd_system_unitdir}/set-system-time.service
}

FILES:${PN} += " \
    /opt/lerobot-gui \
    ${systemd_system_unitdir}/lerobot-gui.service \
    ${systemd_system_unitdir}/set-system-time.service \
"

RDEPENDS:${PN} = " \
    python3 \
    python3-paho-mqtt \
    python3-pyudev \
    python3-pyqt5 \
    qtwayland \
    lerobot \
"
