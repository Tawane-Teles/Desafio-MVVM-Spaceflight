package com.spaceflight.ui.dialog

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.spaceflight.network.response.NewsResponse
import com.spaceflight.repository.NewsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
@ExperimentalCoroutinesApi
class DialogDetailsViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DialogDetailsViewModel

    @Mock
    private lateinit var repository: NewsRepository

    @Mock
    private lateinit var listener: DialogListener

    @Mock
    private lateinit var newObservable: Observer<NewsResponse>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = DialogDetailsViewModel(repository)
        viewModel.listener = listener
    }

    @Test
    fun initViewModel() {
        // isso aqui eu que espero
        val esperado = null

        // vinculo meu obeto com o obejto da viewmodel
        viewModel.newList.observeForever(newObservable)

        //chama a funcao para verificar o teste
        viewModel.initViewModel()

        //verifica se esta igual a meu esperado
        verify(newObservable).onChanged(esperado)
    }

    @Test
    fun close() {
        viewModel.onClose()
        verify(listener).onClose()
    }

}