// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bunsawatsubasa1/taskmanagelist/conf/routes
// @DATE:Thu Sep 23 18:39:15 JST 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  MangaRecordController_2: controllers.MangaRecordController,
  // @LINE:14
  HomeController_1: controllers.HomeController,
  // @LINE:29
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    MangaRecordController_2: controllers.MangaRecordController,
    // @LINE:14
    HomeController_1: controllers.HomeController,
    // @LINE:29
    Assets_0: controllers.Assets
  ) = this(errorHandler, MangaRecordController_2, HomeController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, MangaRecordController_2, HomeController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.MangaRecordController.mangaRecord"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.MangaRecordController.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.MangaRecordController.signup()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """accountCreate""", """controllers.MangaRecordController.accountCreate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signin""", """controllers.MangaRecordController.signin()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signout""", """controllers.MangaRecordController.mangaRecord"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signout""", """controllers.MangaRecordController.signout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index""", """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index""", """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """regi""", """controllers.HomeController.regi"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add""", """controllers.HomeController.add()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """create""", """controllers.HomeController.create()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """edit/""" + "$" + """EncodedResult<[^/]+>""", """controllers.HomeController.edit(EncodedResult:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """update/""" + "$" + """EncodedResult<[^/]+>""", """controllers.HomeController.update(EncodedResult:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete/""" + "$" + """EncodedResult<[^/]+>""", """controllers.HomeController.delete(EncodedResult:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """remove/""" + "$" + """EncodedResult<[^/]+>""", """controllers.HomeController.remove(EncodedResult:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_MangaRecordController_mangaRecord0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_MangaRecordController_mangaRecord0_invoker = createInvoker(
    MangaRecordController_2.mangaRecord,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MangaRecordController",
      "mangaRecord",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_MangaRecordController_login1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_MangaRecordController_login1_invoker = createInvoker(
    MangaRecordController_2.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MangaRecordController",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_MangaRecordController_signup2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_MangaRecordController_signup2_invoker = createInvoker(
    MangaRecordController_2.signup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MangaRecordController",
      "signup",
      Nil,
      "GET",
      this.prefix + """signup""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_MangaRecordController_accountCreate3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("accountCreate")))
  )
  private[this] lazy val controllers_MangaRecordController_accountCreate3_invoker = createInvoker(
    MangaRecordController_2.accountCreate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MangaRecordController",
      "accountCreate",
      Nil,
      "POST",
      this.prefix + """accountCreate""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_MangaRecordController_signin4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signin")))
  )
  private[this] lazy val controllers_MangaRecordController_signin4_invoker = createInvoker(
    MangaRecordController_2.signin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MangaRecordController",
      "signin",
      Nil,
      "POST",
      this.prefix + """signin""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_MangaRecordController_mangaRecord5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signout")))
  )
  private[this] lazy val controllers_MangaRecordController_mangaRecord5_invoker = createInvoker(
    MangaRecordController_2.mangaRecord,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MangaRecordController",
      "mangaRecord",
      Nil,
      "GET",
      this.prefix + """signout""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_MangaRecordController_signout6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signout")))
  )
  private[this] lazy val controllers_MangaRecordController_signout6_invoker = createInvoker(
    MangaRecordController_2.signout(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MangaRecordController",
      "signout",
      Nil,
      "POST",
      this.prefix + """signout""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_index7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index")))
  )
  private[this] lazy val controllers_HomeController_index7_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """index""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_index8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index")))
  )
  private[this] lazy val controllers_HomeController_index8_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "POST",
      this.prefix + """index""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_regi9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("regi")))
  )
  private[this] lazy val controllers_HomeController_regi9_invoker = createInvoker(
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

  // @LINE:18
  private[this] lazy val controllers_HomeController_add10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add")))
  )
  private[this] lazy val controllers_HomeController_add10_invoker = createInvoker(
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

  // @LINE:19
  private[this] lazy val controllers_HomeController_create11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("create")))
  )
  private[this] lazy val controllers_HomeController_create11_invoker = createInvoker(
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

  // @LINE:21
  private[this] lazy val controllers_HomeController_edit12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("edit/"), DynamicPart("EncodedResult", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_edit12_invoker = createInvoker(
    HomeController_1.edit(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "edit",
      Seq(classOf[String]),
      "GET",
      this.prefix + """edit/""" + "$" + """EncodedResult<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_HomeController_update13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("update/"), DynamicPart("EncodedResult", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_update13_invoker = createInvoker(
    HomeController_1.update(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "update",
      Seq(classOf[String]),
      "POST",
      this.prefix + """update/""" + "$" + """EncodedResult<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_HomeController_delete14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete/"), DynamicPart("EncodedResult", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_delete14_invoker = createInvoker(
    HomeController_1.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "delete",
      Seq(classOf[String]),
      "GET",
      this.prefix + """delete/""" + "$" + """EncodedResult<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_HomeController_remove15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("remove/"), DynamicPart("EncodedResult", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_remove15_invoker = createInvoker(
    HomeController_1.remove(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "remove",
      Seq(classOf[String]),
      "POST",
      this.prefix + """remove/""" + "$" + """EncodedResult<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_Assets_versioned16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned16_invoker = createInvoker(
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
    case controllers_MangaRecordController_mangaRecord0_route(params@_) =>
      call { 
        controllers_MangaRecordController_mangaRecord0_invoker.call(MangaRecordController_2.mangaRecord)
      }
  
    // @LINE:7
    case controllers_MangaRecordController_login1_route(params@_) =>
      call { 
        controllers_MangaRecordController_login1_invoker.call(MangaRecordController_2.login())
      }
  
    // @LINE:8
    case controllers_MangaRecordController_signup2_route(params@_) =>
      call { 
        controllers_MangaRecordController_signup2_invoker.call(MangaRecordController_2.signup())
      }
  
    // @LINE:9
    case controllers_MangaRecordController_accountCreate3_route(params@_) =>
      call { 
        controllers_MangaRecordController_accountCreate3_invoker.call(MangaRecordController_2.accountCreate())
      }
  
    // @LINE:10
    case controllers_MangaRecordController_signin4_route(params@_) =>
      call { 
        controllers_MangaRecordController_signin4_invoker.call(MangaRecordController_2.signin())
      }
  
    // @LINE:11
    case controllers_MangaRecordController_mangaRecord5_route(params@_) =>
      call { 
        controllers_MangaRecordController_mangaRecord5_invoker.call(MangaRecordController_2.mangaRecord)
      }
  
    // @LINE:12
    case controllers_MangaRecordController_signout6_route(params@_) =>
      call { 
        controllers_MangaRecordController_signout6_invoker.call(MangaRecordController_2.signout())
      }
  
    // @LINE:14
    case controllers_HomeController_index7_route(params@_) =>
      call { 
        controllers_HomeController_index7_invoker.call(HomeController_1.index)
      }
  
    // @LINE:15
    case controllers_HomeController_index8_route(params@_) =>
      call { 
        controllers_HomeController_index8_invoker.call(HomeController_1.index)
      }
  
    // @LINE:16
    case controllers_HomeController_regi9_route(params@_) =>
      call { 
        controllers_HomeController_regi9_invoker.call(HomeController_1.regi)
      }
  
    // @LINE:18
    case controllers_HomeController_add10_route(params@_) =>
      call { 
        controllers_HomeController_add10_invoker.call(HomeController_1.add())
      }
  
    // @LINE:19
    case controllers_HomeController_create11_route(params@_) =>
      call { 
        controllers_HomeController_create11_invoker.call(HomeController_1.create())
      }
  
    // @LINE:21
    case controllers_HomeController_edit12_route(params@_) =>
      call(params.fromPath[String]("EncodedResult", None)) { (EncodedResult) =>
        controllers_HomeController_edit12_invoker.call(HomeController_1.edit(EncodedResult))
      }
  
    // @LINE:22
    case controllers_HomeController_update13_route(params@_) =>
      call(params.fromPath[String]("EncodedResult", None)) { (EncodedResult) =>
        controllers_HomeController_update13_invoker.call(HomeController_1.update(EncodedResult))
      }
  
    // @LINE:24
    case controllers_HomeController_delete14_route(params@_) =>
      call(params.fromPath[String]("EncodedResult", None)) { (EncodedResult) =>
        controllers_HomeController_delete14_invoker.call(HomeController_1.delete(EncodedResult))
      }
  
    // @LINE:25
    case controllers_HomeController_remove15_route(params@_) =>
      call(params.fromPath[String]("EncodedResult", None)) { (EncodedResult) =>
        controllers_HomeController_remove15_invoker.call(HomeController_1.remove(EncodedResult))
      }
  
    // @LINE:29
    case controllers_Assets_versioned16_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned16_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
