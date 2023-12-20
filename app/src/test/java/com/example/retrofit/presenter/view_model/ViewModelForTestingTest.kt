package com.example.retrofit.presenter.view_model

import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test


class ViewModelForTestingTest {

    private lateinit var viewModel: ViewModelForTesting

    @Before
    fun setUp() {
        viewModel = ViewModelForTesting()
    }

    @Test
    fun `test if number value set correctly`() {
        val number = "123"

        val result = viewModel.enterNumber(number)

        assertEquals("123", result)
    }

    @Test
    fun `test if number value is incorrect`() {
        val number = "123"
        val result = viewModel.enterNumber(number)
        assertNotEquals("124", result)
    }

    @Test
    fun `test if value clean correctly`() {
        val result = viewModel.enterNumber("1234")
        assertNotEquals("1234", result)

        assertEquals("", viewModel.clear())
    }

}