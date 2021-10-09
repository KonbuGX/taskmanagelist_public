// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bunsawatsubasa1/taskmanagelist/conf/routes
// @DATE:Thu Oct 07 20:32:10 JST 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseMangaRecordController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def mangaRecord(): Call = {
    
      () match {
      
        // @LINE:6
        case ()  =>
          
          Call("GET", _prefix)
      
      }
    
    }
  
    // @LINE:12
    def signout(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "signout")
    }
  
    // @LINE:8
    def signup(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signup")
    }
  
    // @LINE:10
    def signin(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "signin")
    }
  
    // @LINE:9
    def accountCreate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "accountCreate")
    }
  
    // @LINE:7
    def login(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:13
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def edit(EncodedResult:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "edit/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("EncodedResult", EncodedResult)))
    }
  
    // @LINE:19
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "create")
    }
  
    // @LINE:13
    def accountDelete(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "accountDelete")
    }
  
    // @LINE:25
    def remove(EncodedResult:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "remove/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("EncodedResult", EncodedResult)))
    }
  
    // @LINE:18
    def add(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "add")
    }
  
    // @LINE:24
    def delete(EncodedResult:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("EncodedResult", EncodedResult)))
    }
  
    // @LINE:22
    def update(EncodedResult:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "update/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("EncodedResult", EncodedResult)))
    }
  
    // @LINE:15
    def index(): Call = {
    
      () match {
      
        // @LINE:15
        case ()  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "index")
      
      }
    
    }
  
  }

  // @LINE:29
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
