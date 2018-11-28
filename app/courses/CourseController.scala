package courses

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

final case class CourseData(grupo: Int, cupomaximo: Int, cupodisponible: Int, aulas: String, profesores: String)

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
		val course = courseList.find(course => course.grupo == id)
		course match {
			case Some(course) => {
				Json.obj(
					"grupo" -> course.grupo,
					"cupomaximo" -> course.cupomaximo,
					"cupodisponible" -> course.cupodisponible,
					"aulas" -> course.aulas,
					"profesores" -> course.profesores
				)
			}
			case None => { Json.obj("error" -> "Curso no encontrado") }
			case _ => { Json.obj("error" -> ":o ha ocurrido un error") }
		}
	}

	private val courseList = List(
		CourseData(873484, 30, 3, "19-314", "Julián Ruiz"),
		CourseData(318980, 20, 2, "21-218", "Felipe Palacio"),  
		CourseData(744707, 32, 4, "20-312", "German"),  
		CourseData(467593, 18, 1, "21-218", "Julián Ruiz"),  
		CourseData(582447, 21, 5, "20-312", "Luz Viviana Cobaleda"),  
		CourseData(453188, 30, 4, "19-314", "Fernando Perez"),  
		CourseData(860097, 35, 6, "19-314", "Andres Santamaria"),  
		CourseData(333288, 30, 4, "21-218", "Bernardo Arenas"),  
		CourseData(451869, 41, 7, "10-101", "Roberto Florez"),  
		CourseData(941766, 25, 4, "19-314", "Estefania Garcia"),
		CourseData(371355, 35, 9, "20-312", "Maribel Cano"),
		CourseData(762020, 30, 4, "21-218", "Pablo Martinez"), 
		CourseData(160989, 28, 3, "19-314", "Camilo Suarez"),
		CourseData(680331, 30, 1, "21-218", "Carmen Pelaez"), 
		CourseData(525230, 35, 8, "19-314", "Laura Cevallos")
	)
}