FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LINUX_VERSION = "4.19.73"

SRCREV = "4d486c17f636bb339c10cd73a07292220a973e01"
SRC_URI += "file://iwd.cfg"

CMDLINE_append = "elevator=deadline"

