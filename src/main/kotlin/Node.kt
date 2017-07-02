import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by jabbslad on 29/06/2017.
 */

class NodeId: Comparable<NodeId> {

    private val bytes = ByteArray(20)

    private constructor(bytes: ByteArray) { bytes.forEachIndexed{ i, _ -> this.bytes[i] = bytes[i] } }

    constructor() : this(ByteArray(20).map { ThreadLocalRandom.current().nextInt(256).toByte() }.toByteArray())

    constructor(text: String): this(text.hexToByteArray())

    override fun toString(): String = bytes.toHexString()

    override fun compareTo(other: NodeId): Int {
        bytes.forEachIndexed{i,_ -> if(bytes[i] != other.bytes[i]) {
            return if(bytes[i] < other.bytes[i]) -1 else 1
        }}
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        if (!Arrays.equals(bytes, (other as NodeId).bytes)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(bytes)
    }
}

fun main(args: Array<String>) {
    println(String.format("%8s", Integer.toBinaryString(-128)).replace(" ", "0"))
}
