
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/()(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>タスク管理</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/routes/*14.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*14.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/routes/*15.65*/.Assets.versioned("images/favicon.png")),format.raw/*15.104*/("""">
    </head>
    <body>
        """),format.raw/*19.32*/("""
        """),_display_(/*20.10*/content),format.raw/*20.17*/("""

        """),format.raw/*22.9*/("""<script src=""""),_display_(/*22.23*/routes/*22.29*/.Assets.versioned("javascripts/main.js")),format.raw/*22.69*/("""" type="text/javascript"></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(content:Html): play.twirl.api.HtmlFormat.Appendable = apply()(content)

  def f:(() => (Html) => play.twirl.api.HtmlFormat.Appendable) = () => (content) => apply()(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-09-05T21:14:46.702
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/main.scala.html
                  HASH: c094ead2db037ad10284a9b8c32d15a88edded01
                  MATRIX: 1199->260|1310->278|1337->279|1417->384|1453->393|1554->467|1569->473|1632->514|1720->575|1735->581|1796->620|1858->744|1895->754|1923->761|1960->771|2001->785|2016->791|2077->831
                  LINES: 33->7|38->8|39->9|42->12|43->13|44->14|44->14|44->14|45->15|45->15|45->15|48->19|49->20|49->20|51->22|51->22|51->22|51->22
                  -- GENERATED --
              */
          