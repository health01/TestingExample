package com.kst.testing.example

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kst.testing.example.Audio.AudioManager
import com.kst.testing.example.Audio.RINGER_MODE
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock;
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.verifyNoMoreInteractions


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class VolumeUtilTests {

    @Mock
    lateinit var audioManager: AudioManager

    @Before
    fun initTest() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testNormalRingerIsMaximized() {
        // 1.) Ensure AudioManager gets mocked
        // 2.) configure Audiomanager to return RINGER_MODE_NORMAL if getRinderMode is called
        // 3.) configure Audiomanager to return 100 if getStreamMaxVolume() is called
        // 4.) call VolumeUtil.maximizeVolume with Audiomanager -> code under test
        // 5.) verify that setStreamVolume(100) was called on audioManager

        assertNotNull(audioManager)
        Mockito.`when`(audioManager.ringerMode).thenReturn(RINGER_MODE.RINGER_MODE_NORMAL)
        Mockito.`when`(audioManager.streamMaxVolume).thenReturn(100)
        VolumeUtil.maximizeVolume(audioManager)
        Mockito.verify(audioManager, times(1)).setStreamVolume(100)
    }


    @Test
    fun testSilentRingerIsNotDisturbed() {
        // 1.) Ensure AudioManager gets mocked
        // 2.) configure audiomanager to return "RINGER_MODE_SILENT" if getRingerMode is called
        // 3.) call VolumeUtil.maximizeVolume with audio manager
        // 4.) verify that getRingerMode() is called on the mock
        // 5.) Ensure that nothing more was called
        val audioManager = mock(AudioManager::class.java)

        assertNotNull(audioManager)
        Mockito.`when`(audioManager.ringerMode).thenReturn(RINGER_MODE.RINGER_MODE_SILENT)
        VolumeUtil.maximizeVolume(audioManager)
        Mockito.verify(audioManager, times(1)).ringerMode
        verifyNoMoreInteractions(audioManager);
    }
}