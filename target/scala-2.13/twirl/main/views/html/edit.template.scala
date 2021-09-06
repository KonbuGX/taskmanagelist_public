
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

object edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Form[TaskListViewModel],Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String,form:Form[TaskListViewModel],taskNo:Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main()/*2.8*/ {_display_(Seq[Any](format.raw/*2.10*/("""
  """),format.raw/*3.3*/("""<h1>タスク管理</h1>
  <p>"""),_display_(/*4.7*/Html(message)),format.raw/*4.20*/("""</p>
  	"""),_display_(/*5.5*/helper/*5.11*/.form(action=routes.HomeController.update(taskNo))/*5.61*/{_display_(Seq[Any](format.raw/*5.62*/("""
  	"""),_display_(/*6.5*/helper/*6.11*/.CSRF.formField),format.raw/*6.26*/("""
  	"""),format.raw/*7.4*/("""<div class="other_item">
  	"""),_display_(/*8.5*/helper/*8.11*/.inputText(form("taskName"),'_label -> "タスク名")),format.raw/*8.57*/("""
  	"""),_display_(/*9.5*/helper/*9.11*/.inputDate(form("deadLine"),'_label -> "期日")),format.raw/*9.55*/("""
	"""),_display_(/*10.3*/helper/*10.9*/.select(form("status"),options = helper.options(("未着手","未着手"),("処理中","処理中"),("完了","完了")),'_label -> "ステータス")),format.raw/*10.117*/("""
  	"""),_display_(/*11.5*/helper/*11.11*/.textarea(form("taskContents"),'_label -> "タスク内容",'cols ->40,'rows ->10)),format.raw/*11.83*/("""
  	"""),format.raw/*12.4*/("""</div>
  	<button class="regi" value=taskNo>更新</button>
  	""")))}),format.raw/*14.5*/("""
  	"""),format.raw/*15.4*/("""<a href="/" class="delete regi">戻る</a>
""")))}),format.raw/*16.2*/("""
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
                  DATE: 2021-09-05T21:14:46.885
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/edit.scala.html
                  HASH: 3fa8e3fe1a55b90bc5d1724e6839220b320fa6a2
                  MATRIX: 975->1|1125->59|1138->65|1177->67|1206->70|1252->91|1285->104|1319->113|1333->119|1391->169|1429->170|1459->175|1473->181|1508->196|1538->200|1592->229|1606->235|1672->281|1702->286|1716->292|1780->336|1809->339|1823->345|1953->453|1984->458|1999->464|2092->536|2123->540|2213->600|2244->604|2314->644
                  LINES: 28->1|33->2|33->2|33->2|34->3|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|45->14|46->15|47->16
                  -- GENERATED --
              */
          