package com.kst.testing.mockFinal;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;


import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public class StaticDemoTest {

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testStaticMockVoid() {
        try (MockedStatic<Dummy> dummy = Mockito.mockStatic(Dummy.class)) {
            dummy.when(Dummy::foo).thenReturn("mocked");
            dummy.when(() -> Dummy.foo(anyString())).thenReturn("mockedValue");
            assertEquals("mocked", Dummy.foo());
            assertEquals("mockedValue", Dummy.foo("para"));
            dummy.verify(() -> Dummy.foo());
            dummy.verify(() -> Dummy.foo(anyString()));
        }
    }

    public static final class Dummy {
        public int testing() {
            return var1.length();
        }

        static String var1 = null;

        static String foo() {
            return "foo";
        }

        static String foo(String var2) {
            var1 = var2;
            return "SUCCESS";
        }
    }
}