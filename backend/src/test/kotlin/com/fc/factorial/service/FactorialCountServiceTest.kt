package com.fc.factorial.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.mock.web.MockMultipartFile
import java.io.File


@ExtendWith(MockitoExtension::class)
class FactorialCountServiceTest {

    private var factorialCountService = FactorialCountService()

    @Test
    fun `Test That 'CountFactorials' Returns Count of Factorials in Given File`() {

        var testFile = MockMultipartFile(
            "file",
            "test_input.txt",
            "text/plain",
            File("src/test/resources/test_input.txt").readBytes()
        )

        val fcCount = factorialCountService.countFactorials(testFile)

        assertEquals(fcCount["fc"], 17)
    }
}