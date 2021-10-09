
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
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/routes/*14.60*/.Assets.versioned("lib/bootstrap/css/bootstrap.css")),format.raw/*14.112*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*15.54*/routes/*15.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*15.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*16.59*/routes/*16.65*/.Assets.versioned("images/favicon.png")),format.raw/*16.104*/("""">
    </head>
    <body>
        """),format.raw/*20.32*/("""
        """),_display_(/*21.10*/content),format.raw/*21.17*/("""
        """),format.raw/*22.9*/("""<script src=""""),_display_(/*22.23*/routes/*22.29*/.Assets.versioned("lib/jquery/jquery.min.js")),format.raw/*22.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*23.23*/routes/*23.29*/.Assets.versioned("javascripts/main.js")),format.raw/*23.69*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*24.23*/routes/*24.29*/.Assets.versioned("lib/popper.js/umd/popper.min.js")),format.raw/*24.81*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*25.23*/routes/*25.29*/.Assets.versioned("lib/bootstrap/js/bootstrap.min.js")),format.raw/*25.83*/("""" type="text/javascript"></script>
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
                  DATE: 2021-09-26T14:12:21.625
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/main.scala.html
                  HASH: f490fa9e2e88f4b511259a0cad779f3277ea060c
                  MATRIX: 1199->260|1310->278|1337->279|1417->384|1453->393|1554->467|1569->473|1643->525|1726->581|1741->587|1804->628|1892->689|1907->695|1968->734|2030->858|2067->868|2095->875|2131->884|2172->898|2187->904|2253->949|2337->1006|2352->1012|2413->1052|2497->1109|2512->1115|2585->1167|2669->1224|2684->1230|2759->1284
                  LINES: 33->7|38->8|39->9|42->12|43->13|44->14|44->14|44->14|45->15|45->15|45->15|46->16|46->16|46->16|49->20|50->21|50->21|51->22|51->22|51->22|51->22|52->23|52->23|52->23|53->24|53->24|53->24|54->25|54->25|54->25
                  -- GENERATED --
              */
          