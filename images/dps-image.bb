SUMMARY = "DPS Power Supply console image"
LICENSE = "GPLv2"

require images/basic-image.bb

inherit extrausers

DPS_TOOLS = " \
    dpsctl \
    nginx \
"

IMAGE_INSTALL += " \
	${DPS_TOOLS} \
"

EXTRA_USERS_PARAMS = " \
        usermod -P '\$6\$Nox70m8xer9YqXp0\$p0X.VU5jGnl580eY0g7OIjF5anDSF2AY7TfsuN/Zerd4H8NECs.6asTk1Mg/R2SoAGC0Kt/JrCzjE9GdUsdHG.' root; \
        useradd -m -d /home/dpsoper -s /bin/sh -p '\$6\$Nox70m8xer9YqXp0\$p0X.VU5jGnl580eY0g7OIjF5anDSF2AY7TfsuN/Zerd4H8NECs.6asTk1Mg/R2SoAGC0Kt/JrCzjE9GdUsdHG.' dpsoper; \
        usermod -a -G sudo dpsoper; \ 
"

export IMAGE_BASENAME = "dps-image"
