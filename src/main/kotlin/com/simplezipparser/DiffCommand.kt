package com.simplezipparser

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.github.ajalt.clikt.parameters.types.file
import java.io.File

class DiffCommand : CliktCommand() {
    private val file1 by argument(help = "First .zip file to compare")
    private val file2 by argument(help = "Second .zip file to compare")
    override fun run() {
        compareJsons(zipToJson(File(file1)) ,zipToJson(File(file2)))

    }
}