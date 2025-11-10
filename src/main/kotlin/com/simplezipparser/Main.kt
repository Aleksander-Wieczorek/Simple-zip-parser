package com.simplezipparser
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands

class MainCommand : CliktCommand(
    name = "zipparser",
    help = "CLI tool for inspecting and comparing plugin artifacts (.jar)"
) {

    override fun run() {
        //empty - all logic in main
    }
}

fun main(args: Array<String>) =
    MainCommand().subcommands(
        DiffCommand(),
        InspectCommand()
    ).main(args)