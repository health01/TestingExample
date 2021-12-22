package com.kst.testing.spy

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import java.util.*


@RunWith(JUnit4::class)
class TestingSpy {
    @Spy
    var list: List<String> = LinkedList()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        // Alternative way of creating a spy
        // List<String> list = new LinkedList<>();
        // List<String> spy = spy(list);
    }

    @Test
    fun ensureToLearnAboutSpy() {
        val id = 20
        doReturn("10000000").`when`(list)[id]
        assertEquals("10000000", list[id]);

    }

}