# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "A library for controlling OpenDPS via UART"
HOMEPAGE = "https://github.com/darnia/libopendps"
LICENSE = "MIT"
SECTION = "libs"

LIC_FILES_CHKSUM = "file://LICENSE;md5=6af043bab0ae4b49a5c6602ab3f385dc"

SRC_URI = "git://git@github.com/darnia/libopendps;protocol=https"
SRCREV = "7951e58abdd473d2b2744849ec449e88cda91701"

S = "${WORKDIR}/git"

inherit cmake

PACKAGES = "${PN} ${PN}-dbg ${PN}-tool"

FILES_${PN} = "${libdir} ${includedir}"
FILES_${PN}-tool = "${bindir}"

RDEPENDS_${PN}-tool = "${PN}"
