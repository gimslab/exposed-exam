package com.gimslab.exposedexam

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExposedExamApplication(
		val applicationArguments: ApplicationArguments,
		val localDbExam: LocalDbExam,
		val cpDbExam: CpDbExam) {
	init {
		println("start Exposed Test")
//		localDbExam.testktorm()
		cpDbExam.testExposed(pwd())
	}

	fun pwd(): String {
		val args = applicationArguments.getNonOptionArgs()
		return if (args.size > 0) args.get(0) else ""
	}
}

fun main(args: Array<String>) {
	runApplication<ExposedExamApplication>(*args)
}
