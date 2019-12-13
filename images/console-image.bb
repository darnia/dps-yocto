SUMMARY = "DPS Power Supply console image"
LICENSE = "GPLv2"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"
IMAGE_FSTYPES = "wic wic.bmap"

inherit image extrausers

DEFAULT_TIMEZONE = "UTC"

PACKAGE_CLASSES = "package_ipk"

DEPENDS_append_rpi = " bcm2835-bootfiles"

CORE_OS = " \
    packagegroup-core-boot \
    kernel-modules \
    openssh openssh-keygen openssh-sftp-server \
    tzdata \
    sudo \
"
#    lmsensors-sensord lmsensors-sensorsdetect lmsensors-fancontrol lmsensors-pwmconfig 
#    lmsensors-config-sensord lmsensors-config-fancontrol 

WIFI_SUPPORT = " \
    iw \
    iwd \
    wireless-regdb-static \
"

BLUETOOTH_SUPPORT = " \
    bluez5 \
"

CONN_PKGS = " \
    iptables \
    avahi-daemon \
    connman connman-client \
    connman-conf \
"

GRAPHICS_PKGS = " \
    mesa \
"

DPS_TOOLS = " \
    dpsctl \
"

TOOLS_PKGS = " \
    bzip2 \
    dosfstools \
    ethtool \
    findutils \
    grep \
    i2c-tools \
    iperf3 \
    iproute2 \
    iptables \
    less \
    lsof \
    nmap \
    powertop \
    procps \
    sysfsutils \
    systemd-analyze \
    tcpdump \
    unzip \
    util-linux \
    wget \
    zip \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${CONN_PKGS} \
    ${DPS_TOOLS} \
    ${TOOLS_PKGS} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '${GRAPHICS_PKGS}', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', '${BLUETOOTH_SUPPORT}', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', '${WIFI_SUPPORT}', '', d)} \
"

IMAGE_INSTALL_rpi += " \
    udev-rules-rpi \
    rng-tools \
    linux-firmware-rpidistro-bcm43430 \
    linux-firmware-rpidistro-bcm43455 \
    bluez-firmware-rpidistro-bcm43430a1-hcd \
    bluez-firmware-rpidistro-bcm4345c0-hcd \
"

EXTRA_USERS_PARAMS = " \
        usermod -P '\$6\$Nox70m8xer9YqXp0\$p0X.VU5jGnl580eY0g7OIjF5anDSF2AY7TfsuN/Zerd4H8NECs.6asTk1Mg/R2SoAGC0Kt/JrCzjE9GdUsdHG.' root; \
        useradd -m -d /home/dpsoper -s /bin/sh -p '\$6\$Nox70m8xer9YqXp0\$p0X.VU5jGnl580eY0g7OIjF5anDSF2AY7TfsuN/Zerd4H8NECs.6asTk1Mg/R2SoAGC0Kt/JrCzjE9GdUsdHG.' dpsoper; \
        usermod -a -G sudo dpsoper; \ 
"

export IMAGE_BASENAME = "console-image"
