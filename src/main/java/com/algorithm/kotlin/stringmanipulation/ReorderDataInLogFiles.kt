package com.algorithm.kotlin.stringmanipulation

class ReorderDataInLogFiles {

    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val letters = mutableListOf<String>()
        val digits = mutableListOf<String>()

        for (log in logs) {
            if (Character.isDigit(log.split(" ")[1][0])) {
                digits.add(log)
            } else {
                letters.add(log)
            }
        }
        letters.sortWith { s1: String, s2: String ->
            val splitS1 = s1.split(" ", limit = 2)
            val splitS2 = s2.split(" ", limit = 2)

            val compared = splitS1[1].compareTo(splitS2[1])
            if (compared == 0) {
                splitS1[0].compareTo(splitS2[0])
            }
            compared
        }

        letters.addAll(digits)

        return letters.toTypedArray()
    }
}