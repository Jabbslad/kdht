import java.security.MessageDigest

/**
 * Created by jabbslad on 29/06/2017.
 */

private fun hexDigit(c: Char): Int = Character.digit(c, 16)

fun String.hexToByteArray(): ByteArray {
    val data = ByteArray(length / 2)
    var i = 0
    while (i < length)
        data[i / 2] = hexDigit(this[i++]).shl(4).or(hexDigit(this[i++])).toByte()
    return data
}

fun ByteArray.toHexString(): String = map { String.format("%02x", (it.toInt() and 0xFF)) }.joinToString("")

fun ByteArray.sha1(): String {
    val md = MessageDigest.getInstance("SHA-1")
    return md.digest(this).map { String.format("%02x", it) }.joinToString("")
}

fun main(args: Array<String>) {
    println("Rosetta Code".toByteArray().sha1())
}

