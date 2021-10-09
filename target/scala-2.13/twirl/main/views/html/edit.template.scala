
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

object edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Form[TaskListViewModel],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String,form:Form[TaskListViewModel],encodedResult:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main()/*2.8*/ {_display_(Seq[Any](format.raw/*2.10*/("""
  """),format.raw/*3.3*/("""<h1>タスク管理</h1>
  <p>"""),_display_(/*4.7*/Html(message)),format.raw/*4.20*/("""</p>
  	"""),_display_(/*5.5*/helper/*5.11*/.form(action=routes.HomeController.update(encodedResult))/*5.68*/{_display_(Seq[Any](format.raw/*5.69*/("""
  	"""),_display_(/*6.5*/helper/*6.11*/.CSRF.formField),format.raw/*6.26*/("""
  	"""),format.raw/*7.4*/("""<div class="other_item">
  	"""),_display_(/*8.5*/helper/*8.11*/.inputText(form("taskName"),'_label -> "タスク名",'class -> "txt")),format.raw/*8.73*/("""<br>
  	"""),_display_(/*9.5*/helper/*9.11*/.inputDate(form("deadLine"),'_label -> "期日")),format.raw/*9.55*/("""<br>
	"""),_display_(/*10.3*/helper/*10.9*/.select(form("status"),options = helper.options(("未着手","未着手"),("処理中","処理中"),("完了","完了")),'_label -> "ステータス")),format.raw/*10.117*/("""<br>
  	"""),_display_(/*11.5*/helper/*11.11*/.textarea(form("taskContents"),'_label -> "タスク内容",'cols ->20,'rows ->5)),format.raw/*11.82*/("""
  	"""),format.raw/*12.4*/("""</div>
  	<button class="button">更新</button>
  	""")))}),format.raw/*14.5*/("""
  	"""),format.raw/*15.4*/("""<button class="button" onclick="location.href='/index'">戻る</button>
""")))}),format.raw/*16.2*/("""
"""))
      }
    }
  }

  def render(message:String,form:Form[TaskListViewModel],encodedResult:String): play.twirl.api.HtmlFormat.Appendable = apply(message,form,encodedResult)

  def f:((String,Form[TaskListViewModel],String) => play.twirl.api.HtmlFormat.Appendable) = (message,form,encodedResult) => apply(message,form,encodedResult)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-10-05T19:08:42.318
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/edit.scala.html
                  HASH: 63e9d08b6620121dd19d0b3097fa0dcd0841916d
                  MATRIX: 978->1|1138->69|1151->75|1190->77|1219->80|1265->101|1298->114|1332->123|1346->129|1411->186|1449->187|1479->192|1493->198|1528->213|1558->217|1612->246|1626->252|1708->314|1742->323|1756->329|1820->373|1853->380|1867->386|1997->494|2032->503|2047->509|2139->580|2170->584|2249->633|2280->637|2379->706
                  LINES: 28->1|33->2|33->2|33->2|34->3|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|45->14|46->15|47->16
                  -- GENERATED --
              */
          