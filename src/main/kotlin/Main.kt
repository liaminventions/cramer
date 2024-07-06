package org.example

var matrix = arrayOf(intArrayOf(2, 3), intArrayOf(5, 2))
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun det2(mat: Array<IntArray>): Int {
    return (mat[0][0]*mat[1][1])-(mat[1][0]*mat[0][1])
}

fun main() {
    println(det2(matrix))
}
