package com.`simple-zip-parser`

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.github.ajalt.clikt.parameters.types.file
import java.io.File

class DiffCommand : CliktCommand() {
    private val file1 by argument(help = "First file to compare")
    private val file2 by argument(help = "Second file to compare")
    override fun run() {
        compareJsonFiles(File(file1),File(file2))

    }
}