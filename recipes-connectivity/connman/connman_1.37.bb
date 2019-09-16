require connman.inc

SRC_URI  = "${KERNELORG_MIRROR}/linux/network/${BPN}/${BP}.tar.xz \
            file://0001-plugin.h-Change-visibility-to-default-for-debug-symb.patch \
            file://connman \
            file://no-version-scripts.patch \
            file://0005-service.patch \
            "

SRC_URI_append_libc-musl = " file://0002-resolve-musl-does-not-implement-res_ninit.patch \
                             file://0001-Fix-compile-on-musl-with-kernel-4.9-headers.patch"

SRC_URI[md5sum] = "75012084f14fb63a84b116e66c6e94fb"
SRC_URI[sha256sum] = "6ce29b3eb0bb16a7387bc609c39455fd13064bdcde5a4d185fab3a0c71946e16"

RRECOMMENDS_${PN} = "connman-conf"
