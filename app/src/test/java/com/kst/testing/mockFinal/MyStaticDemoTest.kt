package com.kst.testing.mockFinal

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


import org.mockito.Mockito
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class MyStaticDemoTest {


    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Mockito.mockStatic(DummyClass::class.java).use { dummy ->
            dummy.`when`<Any> { DummyClass.foo() }.thenReturn("mocked")}
    }

    @Test
    fun testStaticMockVoid() {
//        Mockito.mockStatic(Dummy::class.java).use { dummy ->
//            dummy.`when`<Any> { Dummy.foo() }.thenReturn("mocked")
//            dummy.`when`<Any> { Dummy.foo(anyString()) }
//                .thenReturn("mockedValue")
//            assertEquals("mocked", Dummy.foo())
//            assertEquals("mockedValue", Dummy.foo("para"))
//            dummy.verify { Dummy.foo() }
//            dummy.verify { Dummy.foo(anyString()) }
//        }
    }

   open class DummyClass {
        fun testing(): Int {
            return var1!!.length
        }

        companion object {
            var var1: String? = null
           public fun foo(): String {
                return "foo"
            }

            fun foo(var2: String?): String {
                var1 = var2
                return "SUCCESS"
            }
        }
    }
}

