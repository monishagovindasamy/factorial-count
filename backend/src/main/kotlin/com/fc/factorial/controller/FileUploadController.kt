package com.fc.factorial.controller

import com.fc.factorial.service.FactorialCountService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class FileUploadController(private val factorialCountService: FactorialCountService) {

    @PostMapping("/upload")
    fun handleFileUpload(@RequestParam("file") file: MultipartFile) = factorialCountService.countFactorials(file)


}