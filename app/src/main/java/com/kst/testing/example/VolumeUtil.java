package com.kst.testing.example;

import com.kst.testing.example.Audio.AudioManager;
import com.kst.testing.example.Audio.RINGER_MODE;

public class VolumeUtil {
    public static void maximizeVolume(AudioManager audioManager) {
        if (audioManager.getRingerMode() != RINGER_MODE.RINGER_MODE_SILENT) {
            int max = audioManager.getStreamMaxVolume();
            audioManager.setStreamVolume(max);
        }
    }
}