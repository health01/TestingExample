package com.kst.testing.injectMock

import com.kst.testing.example.MyClassWithPrivateFieldAndMethod
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import java.lang.reflect.Field
import java.lang.reflect.InvocationTargetException


@RunWith(JUnit4::class)
class MyClassWithPrivateFieldAndMethodTest {
    @Spy
    val mock = MyClassWithPrivateFieldAndMethod()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }


    @Test
    @Throws(
        NoSuchFieldException::class,
        SecurityException::class,
        IllegalArgumentException::class,
        IllegalAccessException::class,
        NoSuchMethodException::class,
        InvocationTargetException::class,
        NoSuchFieldException::class
    )
    fun ensureSpyAndReflectiveAccessCanChangeAPrivateField() {
        assertEquals("initial", mock.getHiddenValue())
        mock.field1 = "Hello"
        `when`(mock.toBeMockedByMockito()).thenReturn("mocked by Mockito")
        val declaredField: Field =
            MyClassWithPrivateFieldAndMethod::class.java.getDeclaredField("hiddenField")
        declaredField.isAccessible = true
        declaredField.set(mock, "changed")
        assertEquals("Hello", mock.field1)
        assertEquals("changed", mock.getHiddenValue())
        assertEquals("mocked by Mockito", mock.toBeMockedByMockito())
    }

}