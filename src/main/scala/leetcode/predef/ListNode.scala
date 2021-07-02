package leetcode.predef

class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x

	override def toString: String =
		if (next != null) {
			s"$x," + next.toString
		} else {
			x + ""
		}
}