package tk.coaster3000.modscript.util

object ValidationUtil {
	def notNull[T](ob: T, msg: String = null):T = {
		val message = Option.apply(msg)
		if (LogicUtil.isNull(ob))
			throw new IllegalArgumentException(message.getOrElse("Cannot have null object here!"), new NullPointerException)
		ob
	}

	def notNullOrEmpty[T](ob: T, msg: String = null):T = {
		val message = Option.apply(msg)
		if (LogicUtil.isNullOrEmpty(notNull(ob)))
			throw new IllegalArgumentException(message.getOrElse("Object cannot be empty here."))
		ob
	}
}
