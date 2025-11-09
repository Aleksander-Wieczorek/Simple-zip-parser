package com.`simple-zip-parser`

import model.ZipEntryInfo
import java.io.File
import java.util.zip.ZipEntry
import java.util.zip.ZipFile

fun parseZipStructure(file: File) : List<ZipEntryInfo> {
    ZipFile(file).use { zipFile ->
        return zipFile.entries().asSequence().map {
            entry ->
            ZipEntryInfo(
                name = entry.name,
                size = entry.size,
                compressedSize = entry.compressedSize,
                crc = entry.crc
            )
        }.toList()
    }
}