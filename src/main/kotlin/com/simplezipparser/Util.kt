package com.simplezipparser

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import model.ZipEntryInfo
import java.io.File

private val json = Json { prettyPrint = true; ignoreUnknownKeys = true }
fun saveAsJson(entries: List<ZipEntryInfo>, output: File){
    output.writeText(json.encodeToString(entries))
}
fun zipToJson(file: File) : String
{
    val entries= parseZipStructure(file)
    return json.encodeToString(entries)
}
fun compareJsons(file1:String, file2: String)
{
    val entries1 = json.decodeFromString<List<ZipEntryInfo>>(file1)
    val entries2 = json.decodeFromString<List<ZipEntryInfo>>(file2)

    val names1 = entries1.map { it.name }.toSet()
    val names2 = entries2.map { it.name }.toSet()

    val added=names2-names1
    val removed=names1-names2

    if(added.isEmpty() && removed.isEmpty()){
        println("No differences found.")
    }
    else{
        if(added.isNotEmpty()){
            println("Added:\n ${added.joinToString("\n ")}\n")
        }
        if(removed.isNotEmpty()){
            println("Removed:\n ${removed.joinToString("\n ")}\n")
        }
    }
}