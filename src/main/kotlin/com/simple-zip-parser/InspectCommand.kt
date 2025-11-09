package com.`simple-zip-parser`

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import java.io.File

class InspectCommand : CliktCommand(help = "Inspect plugin artifact (.jar/.zip)") {
    private val input by argument(help = "Path to input JAR/ZIP file")
    private val output by option("-o", "--output", help = "Output JSON file").required()
    override fun run() {
        val zips = parseZipStructure(File(input))
        saveAsJson(zips,File(output))
    }
}