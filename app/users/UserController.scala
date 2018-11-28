package users

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

final case class UserData(id: Int, userName: String, password: String)

/**
 * 
 * Users API Controller
 */
@Singleton
class UserController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
	def validate(username: String) = Action {
		Ok(checkInpediments(username))
	}

	def checkInpediments(username: String): JsValue = {
		val impediments = userInpediments.find(userInfo => userInfo._1 == username)
		if(impediments equals None) Json.obj("error" -> "usuario no encontrado")
		impediments match {
			case Some(userInfo) if userInfo._2 == "" => Json.obj("status" -> "ok")
			case Some(userInfo) =>  Json.obj(
										"status" -> "prevented",
										"impediments" -> userInfo._2
									)
			case _ => Json.obj("error" -> ":o ha ocurrido un error")
		}
	}

	private val userList = List(
		UserData(1, "julian.munozm", "pass"),
		UserData(2, "pedro.montoyam", "pass")
	)

	private val userInpediments = List(
		("julian.munozm", ""),
		("pedro.montoyam", "Devolución de material bibliotecario pendiente.\nDevolución de audifonos en el CENDOI.")
	)
}