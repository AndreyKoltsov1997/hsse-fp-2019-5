package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

 /**
   * Exercise 2 Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {
    def iterate(processingChars: List[Char], amountOfParantheses: Int): Boolean = {
      if (processingChars.isEmpty || amountOfParantheses < 0) amountOfParantheses
      processingChars.head match {
        case '(' => iterate(processingChars.tail, amountOfParantheses + 1)
        case ')' => iterate(processingChars.tail, amountOfParantheses - 1)
        case _ => iterate(processingChars.tail, amountOfParantheses)
      }
    }

    iterate(chars, 0)
  }

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def change(money: Int, coins: List[Int]): Int = {
      // NOTE: Return 0 ways if no money have been found
      if (money < 0 || coins.isEmpty) 0
      // NOTE: If no change is found, there's only 1 way
      else if (money == 0) 1
      else change(money, coins.tail) + change(money - coins.head, coins)
    }

    change(money, coins)
  }
}
