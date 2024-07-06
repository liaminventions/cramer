package org.example

var matrix = arrayOf(arrayOf(2, 3), arrayOf(5, 2))

fun printMatrix(mat: Array<Array<Int>>) {
    val cols: Int = mat[0].size
    val rows: Int = mat[1].size
    for (i: Int in 0..<rows) {
        for (j: Int in 0..<cols) {
            print("${mat[i][j]}\t")
        }
        print("\n")
    }
    print("\n")
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun det2(mat: Array<Array<Int>>): Int {
    return (mat[0][0]*mat[1][1])-(mat[1][0]*mat[0][1])
}

fun arbDet(size: Int, layers: Int, sign: Array<Array<Int>>, mat: Array<Array<Int>>) {

}

fun findDet(mat: Array<Array<Int>>) {
    var layers: Int = 0
    // var sign =
}

fun main() {
    println(det2(matrix))
    printMatrix(matrix)
}
