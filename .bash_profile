#
# ~/.bash_profile
#

[[ -f ~/.bashrc ]] && . ~/.bashrc

if ! vainfo &> /dev/null; then
	export LIBVA_DRIVER_NAME=iHD
fi

export TERM=termite
export LD_PRELOAD=/usr/lib/libpulsedsp.so
