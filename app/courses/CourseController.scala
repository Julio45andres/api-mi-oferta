package courses

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class CourseController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
	
	def search(id: Int) = Action {
		Ok(fetchCourse(id))
	}
	def fetchCourse(id: Int): JsValue = {
		Json.obj(
			"grupo" -> id,
			"cupomaximo" -> 4,
			"cupodisponible" -> 5,
			"aulas" -> "19-216",
			"profesores" -> "Marín"
		)
	}
}