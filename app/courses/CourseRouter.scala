package courses

import javax.inject.Inject

import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class CourseRouter @Inject()(controller: CourseController) extends SimpleRouter {
	override def routes: Routes = {
		case GET(p"/${int(id)}") => 
			controller.search(id)
	}
}