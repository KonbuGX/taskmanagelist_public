
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

object delete extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Form[TaskListViewModel],Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String,form:Form[TaskListViewModel],taskNo:Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main()/*2.8*/ {_display_(Seq[Any](format.raw/*2.10*/("""
  """),format.raw/*3.3*/("""<h1>タスク管理</h1>
  <p>"""),_display_(/*4.7*/Html(message)),format.raw/*4.20*/("""</p>
  <div class="other_item">
  	"""),_display_(/*6.5*/helper/*6.11*/.form(action=routes.HomeController.remove(taskNo))/*6.61*/{_display_(Seq[Any](format.raw/*6.62*/("""
  	"""),_display_(/*7.5*/helper/*7.11*/.CSRF.formField),format.raw/*7.26*/("""
  	"""),_display_(/*8.5*/helper/*8.11*/.inputText(form("taskNo"),'_label -> "タスクNo",'disabled -> "disabled")),format.raw/*8.80*/("""
  	"""),_display_(/*9.5*/helper/*9.11*/.inputText(form("taskName"),'_label -> "タスク名",'disabled -> "disabled")),format.raw/*9.81*/("""
  	"""),_display_(/*10.5*/helper/*10.11*/.inputDate(form("deadLine"),'_label -> "期日",'disabled -> "disabled")),format.raw/*10.79*/("""
	"""),_display_(/*11.3*/helper/*11.9*/.inputText(form("status"),'_label -> "ステータス",'disabled -> "disabled")),format.raw/*11.78*/("""
  	"""),_display_(/*12.5*/helper/*12.11*/.textarea(form("taskContents"),'_label -> "タスク内容",'cols ->40,'rows ->10,'disabled -> "disabled")),format.raw/*12.107*/("""
  """),format.raw/*13.3*/("""</div>	
  	<button class="regi">削除</button>
  	""")))}),format.raw/*15.5*/("""
  	  """),format.raw/*16.6*/("""<a href="/" class="delete regi">戻る</a>
""")))}),format.raw/*17.2*/("""
"""))
      }
    }
  }

  def render(message:String,form:Form[TaskListViewModel],taskNo:Int): play.twirl.api.HtmlFormat.Appendable = apply(message,form,taskNo)

  def f:((String,Form[TaskListViewModel],Int) => play.twirl.api.HtmlFormat.Appendable) = (message,form,taskNo) => apply(message,form,taskNo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-09-05T21:14:47.005
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/delete.scala.html
                  HASH: b9b0ea37d66c736546a39659f0b440bfec4dc78a
                  MATRIX: 977->1|1127->59|1140->65|1179->67|1208->70|1254->91|1287->104|1348->140|1362->146|1420->196|1458->197|1488->202|1502->208|1537->223|1567->228|1581->234|1670->303|1700->308|1714->314|1804->384|1835->389|1850->395|1939->463|1968->466|1982->472|2072->541|2103->546|2118->552|2236->648|2266->651|2344->699|2377->705|2447->745
                  LINES: 28->1|33->2|33->2|33->2|34->3|35->4|35->4|37->6|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|46->15|47->16|48->17
                  -- GENERATED --
              */
          