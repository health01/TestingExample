package com.kst.testing.injectMock

import com.kst.testing.example.article.ArticleDatabase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.kst.testing.example.article.ArticleManager
import com.kst.testing.example.article.User
import org.mockito.*
import com.kst.testing.example.article.ArticleListener
import org.mockito.Mockito.*


@RunWith(JUnit4::class)
class ArticleManagerTest {

    @Mock
    lateinit var user: User

    @Mock
    lateinit var articleDatabase: ArticleDatabase

    @InjectMocks
    lateinit var manager: ArticleManager

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun ensureInjectMockWorks() {
        // calls addListener with an instance of ArticleListener
        manager.initialize()
        // TODO verify that addListener was called with any (instance) of ArticleListener.class
        // TODO

        Mockito.verify(articleDatabase, times(1)).addListener(any(ArticleListener::class.java))
        Mockito.verify(articleDatabase).setUser(user);
    }
}