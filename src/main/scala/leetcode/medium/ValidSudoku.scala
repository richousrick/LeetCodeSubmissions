package leetcode.medium

import scala.collection.mutable

object ValidSudoku {

	/**
	 * Tests a sudoku board is valid.
	 * Single line implementation. However, notably slower than the other implementations.
	 *
	 * @param board board the sudoku puzzle is on
	 * @return true if the grid complies with all rules
	 */
	def isValidSudokuInline(board: Array[Array[Char]]): Boolean =
	// set of coordinates and gridID for each digit on the board
		(for (i <- 0 until 9;
					j <- 0 until 9
					if board(i)(j) != '.')
			yield (i, j, j / 3 + ((i / 3) * 3))).groupBy(p => board(p._1)(p._2)).values
			// convert Set[(Int, Int, Int)] into (Set[Int], Set[Int], Set[Int]) and test they are all unique
			.forall(_.unzip3
				.productIterator
				.asInstanceOf[Iterator[Vector[Int]]]
				.forall(_.groupBy(identity).values.forall(_.size == 1)))


	/**
	 * Tests a sudoku board is valid.
	 * Optimised for minimal memory usage.
	 *
	 * @param board board the sudoku puzzle is on
	 * @return true if the grid complies with all rules
	 */
	def isValidSudokuMemory(board: Array[Array[Char]]): Boolean =
	// set of coordinates and gridID for each digit on the board
		{
			var groups: Map[Int, mutable.Set[(Int, Int, Int)]] = Map()
			for (i <- 0 until 9;
					 j <- 0 until 9
					 if board(i)(j) != '.') {
				if (!groups.contains(board(i)(j).asDigit - 1)) {
					groups += (board(i)(j).asDigit - 1) -> mutable.Set()
				}
				groups(board(i)(j).asDigit - 1) += ((i, j, j / 3 + ((i / 3) * 3)))
			}
			groups.values
		}
			.forall(g => {
				// convert Set[(Int, Int)] into (Set[Int], Set[Int])
				// assert each coordinate has a unique x, y and gridID
				g
					.unzip3
					.productIterator
					.asInstanceOf[Iterator[mutable.HashSet[Int]]]
					.map(_.size)
					.distinct sameElements Iterator(g
					.size)
			})

	/**
	 * Tests a sudoku board is valid.
	 * Optimised for Speed.
	 *
	 * @param board board the sudoku puzzle is on
	 * @return true if the grid complies with all rules
	 */
	def isValidSudoku(board: Array[Array[Char]]): Boolean = {
		// set of coordinates for each relevant 1-9 number on the board
		val groups: Array[mutable.Set[(Int, Int, Int)]] = Array.fill[mutable.Set[(Int, Int, Int)]](9)(mutable.Set())
		for (i <- 0 until 9;
				 j <- 0 until 9
				 if board(i)(j) != '.') {
			groups(board(i)(j).asDigit - 1) += ((i, j, j / 3 + ((i / 3) * 3)))
		}
		groups.forall(g => {
			// convert Set[(Int, Int, Int)] into (Set[Int], Set[Int], Set[Int])
			val uz = g.unzip3
			// assert each coordinate has a unique x, y and gridID
			Set(uz._1.size, uz._2.size, uz._3.size, g.size).size == 1
		})
	}
}
