// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bunsawatsubasa1/taskmanagelist/conf/routes
// @DATE:Sun Sep 05 21:14:44 JST 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def update(taskNo:Int): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "update/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("taskNo", taskNo)))
    }
  
    // @LINE:10
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "create")
    }
  
    // @LINE:15
    def delete(taskNo:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("taskNo", taskNo)))
    }
  
    // @LINE:9
    def add(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "add")
    }
  
    // @LINE:12
    def edit(taskNo:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "edit/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("taskNo", taskNo)))
    }
  
    // @LINE:7
    def regi(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "regi")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:16
    def remove(taskNo:Int): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "remove/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("taskNo", taskNo)))
    }
  
  }

  // @LINE:20
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
