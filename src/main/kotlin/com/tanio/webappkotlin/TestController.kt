package com.tanio.webappkotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TestController(@Autowired private val testsService: TestsService) {

    @GetMapping("/tests")
    fun tests(model: Model): String {
        model["title"] = testsService.getTitle()
        model["tests"] = testsService.getTests()
        return "tests"
    }

}