package org.example

var matrix = mutableListOf(
    mutableListOf(1,4,3),
    mutableListOf(3,2,1),
    mutableListOf(5,5,5)
)

fun printMatrix(mat: MutableList<MutableList<Int>>) {
    val cols: Int = mat[0].size
    val rows: Int = mat[1].size
    for (i: Int in 0 until rows) {
        for (j: Int in 0 until cols) {
            print("${mat[i][j]}\t")
        }
        print("\n")
    }
    print("\n")
}

fun det2(mat: MutableList<MutableList<Int>>): Int {
    return (mat[0][0]*mat[1][1])-(mat[1][0]*mat[0][1])
}

fun arbDet(size: Int, layers: Int, sign: MutableList<MutableList<Int>>, mat: MutableList<MutableList<Int>>): Int {
    var result = 0
    if(size>2) {
        // make new square array of size "size-1"
        var tempMatrix: MutableList<MutableList<Int>> = MutableList( size - 1) { MutableList(size - 1) { 0 } }
        var firstEntryCol=1
        for(n: Int in 0 until size) {
            if(n>0) { firstEntryCol = 0 }
            var skip = 0
            for(i: Int in 0 until size-1) {
                for(j: Int in 0 until size-1) {
                    if(j+firstEntryCol==n) {
                        skip=1
                    }
                    tempMatrix[i][j] = mat[i+1][j+firstEntryCol+skip]
                }
                skip=0
            }
            result+=(sign[layers][n]*mat[0][n])*(arbDet(size-1,layers+1,sign,tempMatrix))
        }
    } else {
        result=det2(mat)
    }
    return result
}

fun findDet(mat: MutableList<MutableList<Int>>): Int {
    val cols: Int = mat[0].size
    val rows: Int = mat[1].size
    if (cols!=rows) {
        println("ERROR: array not square")
    }
    var sign: MutableList<MutableList<Int>> = MutableList(rows) { MutableList(cols) { 0 } }
    var num = 1
    for(i: Int in 0 until rows) {
        for(j: Int in 0 until cols) {
            sign[i][j]=num
            num=-num
        }
    }
    return arbDet(rows,0,sign,mat)
}

fun main() {
    println(findDet(matrix))
}
