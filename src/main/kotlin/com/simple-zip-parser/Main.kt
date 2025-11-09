package com.`simple-zip-parser`
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands

class MainCommand : CliktCommand() {
    override fun run() {
        //empty - all logic in main
    }
}

fun main(args: Array<String>) =
    MainCommand().subcommands(
        DiffCommand(),
        InspectCommand()
    ).main(args)