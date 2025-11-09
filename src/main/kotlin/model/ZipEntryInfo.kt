package model
import kotlinx.serialization.Serializable

@Serializable
data class ZipEntryInfo(
    val name: String,
    val size: Long,
    val compressedSize: Long,
    val crc: Long
)