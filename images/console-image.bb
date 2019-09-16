SUMMARY = "DPS Power Supply console image"
LICENSE = "GPLv2"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"
IMAGE_FSTYPES = "wic wic.bmap"

inherit image extrausers

DEFAULT_TIMEZONE = "UTC"

PACKAGE_CLASSES = "package_ipk"

DEPENDS += "bcm2835-bootfiles"

CORE_OS = " \
    packagegroup-core-boot \
    kernel-modules udev-rules-rpi \
    openssh openssh-keygen openssh-sftp-server \
    tzdata \
    sudo \
    rng-tools \
    lmsensors-sensord lmsensors-sensorsdetect lmsensors-fancontrol lmsensors-pwmconfig \
    lmsensors-config-sensord lmsensors-config-fancontrol \
    systemd-conf \
"

WIFI_SUPPORT = " \
    iw \
    linux-firmware-rpidistro-bcm43430 \
    linux-firmware-rpidistro-bcm43455 \
    bluez-firmware-rpidistro-bcm43430a1-hcd \
    bluez-firmware-rpidistro-bcm4345c0-hcd \
    iwd \
    wireless-regdb-static \
"

CONN_PKGS = " \
    iptables \
    avahi-daemon \
    connman connman-client \
    connman-conf \
    bluez5 \
"

GRAPHICS_PKGS = " \
    kmscube \
    mesa \
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
    ${WIFI_SUPPORT} \
    ${TOOLS_PKGS} \
    ${GRAPHICS_PKGS} \
"

EXTRA_USERS_PARAMS = " \
        usermod -P '\$6\$Nox70m8xer9YqXp0\$p0X.VU5jGnl580eY0g7OIjF5anDSF2AY7TfsuN/Zerd4H8NECs.6asTk1Mg/R2SoAGC0Kt/JrCzjE9GdUsdHG.' root; \
        useradd -m -d /home/dpsoper -s /bin/bash -p '\$6\$Nox70m8xer9YqXp0\$p0X.VU5jGnl580eY0g7OIjF5anDSF2AY7TfsuN/Zerd4H8NECs.6asTk1Mg/R2SoAGC0Kt/JrCzjE9GdUsdHG.' dpsoper; \
        usermod -a -G sudo dpsoper; \ 
"

export IMAGE_BASENAME = "console-image"
