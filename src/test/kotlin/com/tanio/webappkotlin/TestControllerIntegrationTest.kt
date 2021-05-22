package com.tanio.webappkotlin

import org.junit.jupiter.api.Test
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class TestControllerIntegrationTest(@Autowired val mockMvc: MockMvc) {
    @MockBean
    lateinit var testsService: TestsService

    @Test
    fun `list tests`() {
        val pageTitle = "aTitle"
        val tests = listOf(
            Test("firstTestName", "firstTestContent"),
            Test("secondTestName", "secondTestContent")
        )
        whenever(testsService.getTitle()).thenReturn(pageTitle)
        whenever(testsService.getTests()).thenReturn(tests)

        mockMvc.perform(get("/tests"))
            .andExpect(status().isOk)
            .andExpect(model().attribute("title", pageTitle))
            .andExpect(model().attribute("tests", tests))
            .andExpect(view().name("tests"))
    }
}