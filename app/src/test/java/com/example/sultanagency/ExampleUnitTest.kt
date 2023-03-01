package com.example.sultanagency

import com.example.sultanagency.data.LocalRepository
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun date() {
        val lRepo: LocalRepository = LocalRepository()
        println(lRepo.publicationList[2].openDate.toString())
        assertEquals(4, 2 + 2)
    }
}