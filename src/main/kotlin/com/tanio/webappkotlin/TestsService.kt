package com.tanio.webappkotlin

import org.springframework.stereotype.Service

@Service
class TestsService {
    fun getTitle() = "Tests"

    fun getTests () : List<Test>{
        return listOf(
            Test("firstTestName", "firstTestContent"),
            Test("secondTestName", "secondTestContent")
        )
    }
}