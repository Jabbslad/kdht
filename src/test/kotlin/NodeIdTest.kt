import org.junit.Assert.*
import java.util.*

/**
 * Created by jabbslad on 29/06/2017.
 */
class NodeIdTest {

    @org.junit.Test
    fun testNodeIdSetCorrectly() {
        assertEquals("b1d9647ad9ee7fa6347bf7f3614d8b72b6ed28c3", NodeId("b1d9647ad9ee7fa6347bf7f3614d8b72b6ed28c3").toString())
    }

    @org.junit.Test
    fun testNodeIdLength() {
        val nodeId = NodeId()
        assertEquals("nodeId: $nodeId", 40, nodeId.toString().length)
    }

    @org.junit.Test
    fun testComparison() {
        val nodeId1 = NodeId("b1d9647ad9ee7fa6347bf7f3614d8b72b6ed28c3")
        val nodeId2 = NodeId("b1d9647ad9ee7fa6347bf7f3614d8b72b6ed28c3")
        val nodeId3 = NodeId("b1d9647ad9ee7fa6347bf7f3614d8b72b6ed28c4")
        assertEquals(0, nodeId1.compareTo(nodeId2))
        assertEquals(-1, nodeId1.compareTo(nodeId3))
        assertEquals(1, nodeId3.compareTo(nodeId2))
    }

    @org.junit.Test
    fun testEquality() {
        val nodeId1 = NodeId("b1d9647ad9ee7fa6347bf7f3614d8b72b6ed28c3")
        val nodeId2 = NodeId("b1d9647ad9ee7fa6347bf7f3614d8b72b6ed28c3")
        assertEquals(nodeId1, nodeId2)
    }



}