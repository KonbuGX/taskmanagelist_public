// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bunsawatsubasa1/taskmanagelist/conf/routes
// @DATE:Sun Sep 05 21:14:44 JST 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:20
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:20
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """regi""", """controllers.HomeController.regi"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add""", """controllers.HomeController.add()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """create""", """controllers.HomeController.create()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """edit/""" + "$" + """taskNo<[^/]+>""", """controllers.HomeController.edit(taskNo:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """update/""" + "$" + """taskNo<[^/]+>""", """controllers.HomeController.update(taskNo:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete/""" + "$" + """taskNo<[^/]+>""", """controllers.HomeController.delete(taskNo:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """remove/""" + "$" + """taskNo<[^/]+>""", """controllers.HomeController.remove(taskNo:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_regi1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("regi")))
  )
  private[this] lazy val controllers_HomeController_regi1_invoker = createInvoker(
    HomeController_1.regi,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "regi",
      Nil,
      "GET",
      this.prefix + """regi""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_add2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add")))
  )
  private[this] lazy val controllers_HomeController_add2_invoker = createInvoker(
    HomeController_1.add(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "add",
      Nil,
      "GET",
      this.prefix + """add""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_create3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("create")))
  )
  private[this] lazy val controllers_HomeController_create3_invoker = createInvoker(
    HomeController_1.create(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "create",
      Nil,
      "POST",
      this.prefix + """create""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_edit4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("edit/"), DynamicPart("taskNo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_edit4_invoker = createInvoker(
    HomeController_1.edit(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "edit",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """edit/""" + "$" + """taskNo<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_update5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("update/"), DynamicPart("taskNo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_update5_invoker = createInvoker(
    HomeController_1.update(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "update",
      Seq(classOf[Int]),
      "POST",
      this.prefix + """update/""" + "$" + """taskNo<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_delete6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete/"), DynamicPart("taskNo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_delete6_invoker = createInvoker(
    HomeController_1.delete(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "delete",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """delete/""" + "$" + """taskNo<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_remove7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("remove/"), DynamicPart("taskNo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_remove7_invoker = createInvoker(
    HomeController_1.remove(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "remove",
      Seq(classOf[Int]),
      "POST",
      this.prefix + """remove/""" + "$" + """taskNo<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Assets_versioned8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:7
    case controllers_HomeController_regi1_route(params@_) =>
      call { 
        controllers_HomeController_regi1_invoker.call(HomeController_1.regi)
      }
  
    // @LINE:9
    case controllers_HomeController_add2_route(params@_) =>
      call { 
        controllers_HomeController_add2_invoker.call(HomeController_1.add())
      }
  
    // @LINE:10
    case controllers_HomeController_create3_route(params@_) =>
      call { 
        controllers_HomeController_create3_invoker.call(HomeController_1.create())
      }
  
    // @LINE:12
    case controllers_HomeController_edit4_route(params@_) =>
      call(params.fromPath[Int]("taskNo", None)) { (taskNo) =>
        controllers_HomeController_edit4_invoker.call(HomeController_1.edit(taskNo))
      }
  
    // @LINE:13
    case controllers_HomeController_update5_route(params@_) =>
      call(params.fromPath[Int]("taskNo", None)) { (taskNo) =>
        controllers_HomeController_update5_invoker.call(HomeController_1.update(taskNo))
      }
  
    // @LINE:15
    case controllers_HomeController_delete6_route(params@_) =>
      call(params.fromPath[Int]("taskNo", None)) { (taskNo) =>
        controllers_HomeController_delete6_invoker.call(HomeController_1.delete(taskNo))
      }
  
    // @LINE:16
    case controllers_HomeController_remove7_route(params@_) =>
      call(params.fromPath[Int]("taskNo", None)) { (taskNo) =>
        controllers_HomeController_remove7_invoker.call(HomeController_1.remove(taskNo))
      }
  
    // @LINE:20
    case controllers_Assets_versioned8_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
