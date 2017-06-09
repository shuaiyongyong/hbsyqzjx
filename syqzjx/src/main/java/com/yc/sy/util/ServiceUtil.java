package com.yc.sy.util;

import javax.sound.midi.VoiceStatus;

public class ServiceUtil {
	public static String getPath(String upath) {
		int index=upath.lastIndexOf("/");
		return (upath.substring(index+1));
	}
}
