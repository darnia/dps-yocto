FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

#LINUX_VERSION = "4.19.71"

#SRCREV = "6de367fd7236049b74a55970186543d37699ab8b"
SRC_URI += "file://iwd.cfg"

CMDLINE_append = "elevator=deadline"

