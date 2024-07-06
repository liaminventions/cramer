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

fun arbDet(size: Int, layers: Int, sign: MutableList<MutableList<Int>>, mat: Array<Array<Int>>) {

}

fun findDet(mat: Array<Array<Int>>) {
    val cols: Int = mat[0].size
    val rows: Int = mat[1].size
    if (cols!=rows) {
        println("ERROR: array not square")
    }
    var layers: Int = 0
    var sign = mutableListOf<MutableList<Int>>()
    var num: Int = 1
    repeat(rows) {
        // `row` is a new row in the array
        val row = mutableListOf<Int>()
        repeat(cols) { col -> // `col` is a new column in the row
            row += col
        }

        // Append the row to the array, can also use the `add()` function
        sign += row
    }
    for(i: Int in 0..<rows) {
        for(j: Int in 0..<cols) {
            sign[i][j]=num
            num=-num
        }
    }
    //debug
    for (i: Int in 0..<rows) {
        for (j: Int in 0..<cols) {
            print("${sign[i][j]}\t")
        }
        print("\n")
    }
    print("\n")
    return arbDet(rows,0,sign,mat)
}

fun main() {
    println(det2(matrix))
    printMatrix(matrix)
    findDet(matrix)
}
