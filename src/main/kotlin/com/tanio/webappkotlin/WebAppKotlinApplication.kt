package com.tanio.webappkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebAppKotlinApplication

fun main(args: Array<String>) {
	runApplication<WebAppKotlinApplication>(*args)
}
