package com.fc.factorial.controller

import com.fc.factorial.service.FactorialCountService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders


@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileUploadControllerTest {

    private var factorialCountService = mock<FactorialCountService>()

    private var fileUploadController = FileUploadController(factorialCountService)

    private var mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(fileUploadController).build()

    @Test
    fun `Test That 'HandleFileUpload' Returns Factorial Count of File`() {

        var testFile = MockMultipartFile("file", "filename.txt", "text/plain", "some xml".toByteArray())
        whenever(factorialCountService.countFactorials(testFile)).thenReturn(mapOf("fc" to 17))

        mockMvc.perform(
            MockMvcRequestBuilders.multipart("/upload").file(testFile)
        ).andExpect(MockMvcResultMatchers.status().isOk)
    }
}