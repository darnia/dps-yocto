# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "A library for controlling OpenDPS via UART"
HOMEPAGE = "https://github.com/darnia/libopendps"
LICENSE = "MIT"
SECTION = "libs"

LIC_FILES_CHKSUM = "file://LICENSE;md5=6af043bab0ae4b49a5c6602ab3f385dc"

SRC_URI = "git://git@github.com/darnia/libopendps;protocol=https"
SRCREV = "9545f40d3a841aaad7f59b253bbb3a541ba165df"

S = "${WORKDIR}/git"

inherit cmake

PACKAGES = "${PN} ${PN}-dbg dpsctl"

FILES_${PN} = "${libdir} ${includedir}"
FILES_dpsctl = "${bindir}"

RDEPENDS_dpsctl = "${PN}"
