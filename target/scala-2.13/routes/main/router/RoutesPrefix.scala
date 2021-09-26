// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bunsawatsubasa1/taskmanagelist/conf/routes
// @DATE:Thu Sep 23 18:39:15 JST 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
