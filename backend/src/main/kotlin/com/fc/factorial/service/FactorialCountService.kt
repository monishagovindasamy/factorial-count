package com.fc.factorial.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

@Service
class FactorialCountService {

    fun countFactorials(file: MultipartFile): Map<String, Int> {
        val content = BufferedReader(InputStreamReader(file.inputStream)).readLines()
            .filter { it.isNumber() && isPrime(it.toBigInteger()) }.map { it.toBigInteger() }.toSet()
        return mapOf("fc" to content.size)
    }

    private fun String.isNumber(): Boolean {
        return this.isNotEmpty() && this.matches(Regex("\\d+"))
    }

    private fun isPrime(number: BigInteger): Boolean {
        return number.isProbablePrime(100)
    }
}