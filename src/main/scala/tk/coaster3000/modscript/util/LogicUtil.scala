package tk.coaster3000.modscript.util

object LogicUtil {
	def isNullOrEmpty[T](raw: T):Boolean = {
		var po:Option[T] = null
		raw match {
				case a: Option[T] => po = a
				case _ => po = Option.apply[T](raw)
		}
		val o = po
		isNull(o)
		raw match {
				case a: String => a.isEmpty
				case b: Traversable[_] => b.isEmpty
		}
	}

	def isNull(raw: Any):Boolean = {
		val o = Option.apply(raw)
		o.isEmpty
	}

	def fixNull[T](raw: T, d: =>T):T = {
		val o = Option.apply(raw)
		if (o.isEmpty) d else raw
	}
}
