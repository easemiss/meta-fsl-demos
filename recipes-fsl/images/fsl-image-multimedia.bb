DESCRIPTION = "A console-only image that includes gstreamer packages and \
Freescale's multimedia packages (VPU and GPU) when available for the specific \
machine."

IMAGE_FEATURES += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11-base', '', d)} \
    debug-tweaks \
    tools-testapps \
    tools-profile \
"

LICENSE = "MIT"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', \
                      bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                                    'weston weston-init weston-examples \
                                         gtk+3-demo clutter-1.0-examples', '', d), d)} \
"

CORE_IMAGE_EXTRA_INSTALL_remove_mx6sl = "clutter-1.0-examples"
