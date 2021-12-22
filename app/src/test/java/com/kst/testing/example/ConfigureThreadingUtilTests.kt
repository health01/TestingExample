package com.kst.testing.example

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.only
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class ConfigureThreadingUtilTests {

    @Mock
    lateinit var myApplication: MyApplication

    @Before
    fun initTest() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun ensureThatThreadPoolCanBeConfigured() {
        // mock MyApplication
        // call ConfigureThreadingUtil.configureThreadPool
        // verify that getNumberOfThreads was the only one called on app
        ConfigureThreadingUtil.configureThreadPool(myApplication)
        Mockito.verify(myApplication, only()).numberOfThreads
    }
}