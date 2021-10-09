
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
    """),format.raw/*13.58*/("""
    """),format.raw/*14.5*/("""<title>タスク管理</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*15.50*/routes/*15.56*/.Assets.versioned("lib/bootstrap/css/bootstrap.css")),format.raw/*15.108*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*16.50*/routes/*16.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*16.97*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*17.55*/routes/*17.61*/.Assets.versioned("images/favicon.png")),format.raw/*17.100*/("""">
</head>

<body>
    """),format.raw/*22.27*/("""
    """),_display_(/*23.6*/content),format.raw/*23.13*/("""
    """),format.raw/*24.5*/("""<script src=""""),_display_(/*24.19*/routes/*24.25*/.Assets.versioned("lib/jquery/jquery.min.js")),format.raw/*24.70*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*25.19*/routes/*25.25*/.Assets.versioned("javascripts/main.js")),format.raw/*25.65*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*26.19*/routes/*26.25*/.Assets.versioned("lib/popper.js/umd/popper.min.js")),format.raw/*26.77*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*27.19*/routes/*27.25*/.Assets.versioned("lib/bootstrap/js/bootstrap.min.js")),format.raw/*27.79*/("""" type="text/javascript"></script>
</body>

</html>"""))
      }
    }
  }

  def render(content:Html): play.twirl.api.HtmlFormat.Appendable = apply()(content)

  def f:(() => (Html) => play.twirl.api.HtmlFormat.Appendable) = () => (content) => apply()(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-10-09T18:03:21.292
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/main.scala.html
                  HASH: dbde2a0e43282a47274257e4af7c44a6fe026a41
                  MATRIX: 1194->255|1305->273|1332->274|1405->372|1437->377|1534->447|1549->453|1623->505|1702->557|1717->563|1779->604|1863->661|1878->667|1939->706|1990->814|2022->820|2050->827|2082->832|2123->846|2138->852|2204->897|2284->950|2299->956|2360->996|2440->1049|2455->1055|2528->1107|2608->1160|2623->1166|2698->1220
                  LINES: 33->7|38->8|39->9|43->13|44->14|45->15|45->15|45->15|46->16|46->16|46->16|47->17|47->17|47->17|51->22|52->23|52->23|53->24|53->24|53->24|53->24|54->25|54->25|54->25|55->26|55->26|55->26|56->27|56->27|56->27
                  -- GENERATED --
              */
          