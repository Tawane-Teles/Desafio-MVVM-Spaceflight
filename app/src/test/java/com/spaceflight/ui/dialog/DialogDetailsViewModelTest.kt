package com.spaceflight.ui.dialog

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.TestCase
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.spaceflight.network.response.NewsResponse
import com.spaceflight.repository.NewsRepository
import com.spaceflight.ui.fragment.NewsListener
import com.spaceflight.ui.fragment.NewsViewModel
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
import retrofit2.Response

@RunWith(MockitoJUnitRunner.Silent::class)
@ExperimentalCoroutinesApi
class DialogDetailsViewModelTest {
    private val dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DialogDetailsViewModel

    @Mock
    private lateinit var repository: NewsRepository

    @Mock
    private lateinit var listener: DialogListener

    @Mock
    private lateinit var newObservable: Observer<List<NewsResponse>>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(dispatcher)
        viewModel = DialogDetailsViewModel(repository)

    }

    @Test
    fun initViewModel() {
        val newsResponse: List<NewsResponse> = arrayListOf()
        viewModel.listener = listener
        viewModel.newList.observeForever(newObservable)
        viewModel.initViewModel()

        verify(newObservable).onChanged(newsResponse)
        verify(listener).onSearch()

    }


    @Test
    fun initViewModel() {
        viewModel.listener = listener
        viewModel.saveClick(
            NewsResponse(
                id = "1",
                title = "teste",
                summary = "teste descrição",
                newsSite = "",
                imageUrl = "",
                featured = false,
                url = "",
                events = arrayListOf(),
                launcher = arrayListOf()
            )
        )
    }

    @Test
    fun getClick() = TestCoroutineDispatcher().runBlockingTest {
        val newsResponse: List<NewsResponse> = arrayListOf()
        Mockito.`when`(repository.getNews(1, 1)).thenReturn(Response.success(newsResponse))

        viewModel.listener = listener
        viewModel.newList.observeForever(newObservable)
        viewModel.getNewsPage(16)

        verify(newObservable).onChanged(newsResponse)
    }

}