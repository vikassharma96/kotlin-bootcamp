import java.util.*

fun main(args: Array<String>) {

    print("Input the number of test cases!")
    val read = Scanner(System.`in`)
    val numOfTestCases: Int = read.nextInt()
    for (i in 1..numOfTestCases) {
        println("Enter no of rows")
        val rows: Int = read.nextInt()
        println("Enter no of columns")
        val columns = read.nextInt()
        var charArray = arrayOf<Array<Char>>()
        for (j in 1..rows) {
            var array = arrayOf<Char>()
            for (k in 1..columns) {
                println("Enter character")
                array += readLine()!![0]
            }
            charArray += array
        }

        var germCount = 0

        for (l in 0 until rows) {
            for (m in 0 until columns) {
                if (charArray[l][m] == 'r') {
                    if ((l + 1) < rows) charArray[l + 1][m] = 'k';
                    if ((m + 1) < columns) charArray[l][m + 1] = 'k';
                    if ((l + 1) < rows && (m + 1) < columns) charArray[l + 1][m + 1] = 'k';
                    if ((l - 1) >= 0) charArray[l - 1][m] = 'k';
                    if ((m - 1) >= 0) charArray[l][m - 1] = 'k';
                    if ((l - 1) >= 0 && (m - 1) >= 0) charArray[l - 1][m - 1] = 'k';
                    continue;
                } else if (charArray[l][m] == 'b') {
                    if ((l + 1) < rows) charArray[l + 1][m] = 'k';
                    if ((m + 1) < columns) charArray[l][m + 1] = 'k';
                    if ((l - 1) >= 0) charArray[l - 1][m] = 'k';
                    if ((m - 1) >= 0) charArray[l][m - 1] = 'k';
                    continue;
                }
            }
        }

        for (n in 0 until rows)
            for (o in 0 until columns)
                if (charArray[n][o] == 'x')
                    germCount++

        println("germs left $germCount")

    }



    if (args.isEmpty())
        print("Please provide command line argument")
    else
        println("Argument is ${args[0]}")

    for (name in args.indices) {
        println("Hello ${args[name]}")
    }

    val text: String = """
        |
        |for(a: String)
        |print(dsdgsdg)""".trimMargin()
    println(text)

    val price = """${'$'}99.9"""
    println(price)

    println(sendMessage(1))

    val nums = intArrayOf(2, 7, 11, 15)
    print(Arrays.toString(twoSum(nums, 9)))

}

fun sendMessage(message: Any): Int? {
    val string: String? = message as? String
    val x = 10
    val a: Any = when (x) {
        in 1..10 -> {
            println("is valid")
            0
        }
        else -> 1
    }
    println(a)
    return string?.length
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    if (nums.size < 2) {
        throw IllegalArgumentException("")
    }
    val list = mutableListOf<Int>()
    nums.forEachIndexed { index, i ->
        list.add(index, i)
    }
    nums.sort()
    var firstNumberIndex: Int = -1
    var secondNumberIndex: Int = -1

    var p = 0
    var q = nums.size - 1
    var currentSum: Int
    for (i in nums.indices) {
        currentSum = nums[p] + nums[q]
        when {
            currentSum == target -> {
                list.forEachIndexed { index, element ->
                    if (firstNumberIndex == -1 && element == nums[p])
                        firstNumberIndex = index
                    else if (secondNumberIndex == -1 && element == nums[q])
                        secondNumberIndex = index
                }
                return intArrayOf(firstNumberIndex, secondNumberIndex)
            }
            currentSum < target -> p++
            currentSum > target -> q--
        }
    }
    throw IllegalArgumentException("")
}