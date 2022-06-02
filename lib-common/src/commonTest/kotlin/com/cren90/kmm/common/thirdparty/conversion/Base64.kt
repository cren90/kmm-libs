//package com.cren90.kmm.common.thirdparty.conversion
//import org.junit.jupiter.api.Assertions.assertArrayEquals
//import org.junit.jupiter.api.Test
//import kotlin.random.Random.Default.nextBytes
//import kotlin.test.assertEquals
//
///**
// * This JVM specific test can verifiy the common Base64 implemenation
// */
//class Base64Test {
//
//    @Test
//    fun encodeDecode() {
//        (0..100).forEach { i ->
//            val input = nextBytes(i * 10)
//
//            val javaEncoded = java.util.Base64.getEncoder().encodeToString(input)
//            val kotlinEncoded = String(Base64.encoder.encode(input))
//            assertEquals(javaEncoded, kotlinEncoded)
//
//            assertArrayEquals(input, Base64.decoder.decode(kotlinEncoded.encodeToByteArray()))
//        }
//    }
//
//}