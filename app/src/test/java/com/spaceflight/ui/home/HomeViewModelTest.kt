package com.spaceflight.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.spaceflight.network.response.NewsResponse
import com.spaceflight.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
@ExperimentalCoroutinesApi
class HomeViewModelTest {
    private val dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel

    @Mock
    private lateinit var repository: NewsRepository

    @Mock
    private lateinit var listener: HomeListener

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(dispatcher)
        viewModel = HomeViewModel(repository)

    }

    @Test
    fun getNews() = TestCoroutineDispatcher().runBlockingTest{
        val newsResponse : List<NewsRepository> = arrayListOf()

        Mockito. `when`(repository.getNews(1,1))

    }
}