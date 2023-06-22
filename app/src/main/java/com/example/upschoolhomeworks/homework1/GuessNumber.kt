package com.example.upschoolhomeworks.homework1

import kotlin.random.Random

class GuessNumber : Response() {

    private val random = Random.nextInt(0, 101)

    override fun finishGuessUnsuccessful(randomNumber: Int) {
        println("Oyun bitti :( Doğru sayı: $randomNumber")
    }

    override fun finisGuessSuccessful() {
        println("Tebrikler! Doğru tahmin ettiniz :)")
    }

    fun start() {
        println("Bir sayı tahmin et :)")
        var guessRight = 3

        while (guessRight > 0) {
            val number = readUserInput()

            if (number == null || number == 0) {
                break
            }

            if (number < 0 || number > 100) {
                println("Lütfen 0 ile 100 arasında bir sayı giriniz.")
                continue
            }

            if (checkGuess(number)) {
                guessRight--
            } else {
                guessRight = 0
            }

        }

        finishGuessUnsuccessful(random)
    }

    private fun checkGuess(number: Int): Boolean {
        when {
            number > random -> {
                println("Daha küçük bir sayı tahmin etmelisin :)")
                return true
            }
            number < random -> {
                println("Daha büyük bir sayı tahmin etmelisin :)")
                return true
            }
            else -> {
                finisGuessSuccessful()
                return false
            }
        }
    }

    private fun readUserInput(): Int? {
        val input = readLine()
        return input?.toIntOrNull()
    }
}

fun main() {
   val game = GuessNumber()
   game.start()
}
