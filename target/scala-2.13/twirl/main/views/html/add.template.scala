
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

object add extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Form[TaskListViewModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String,form:Form[TaskListViewModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main()/*2.8*/ {_display_(Seq[Any](format.raw/*2.10*/("""
  """),format.raw/*3.3*/("""<h1>タスク管理</h1>
  <p>"""),_display_(/*4.7*/Html(message)),format.raw/*4.20*/("""</p>
  	"""),_display_(/*5.5*/helper/*5.11*/.form(action=routes.HomeController.create())/*5.55*/{_display_(Seq[Any](format.raw/*5.56*/("""
  	"""),_display_(/*6.5*/helper/*6.11*/.CSRF.formField),format.raw/*6.26*/("""
  	"""),format.raw/*7.4*/("""<div class="other_item">
  	"""),_display_(/*8.5*/helper/*8.11*/.inputText(form("taskName"),'_label -> "タスク名")),format.raw/*8.57*/("""<br>
  	"""),_display_(/*9.5*/helper/*9.11*/.inputDate(form("deadLine"),'_label -> "期日")),format.raw/*9.55*/("""<br>
	"""),_display_(/*10.3*/helper/*10.9*/.select(form("status"),options = helper.options(("未着手","未着手"),("処理中","処理中"),("完了","完了")),'_label -> "ステータス")),format.raw/*10.117*/("""<br>
  	"""),_display_(/*11.5*/helper/*11.11*/.textarea(form("taskContents"),'_label -> "タスク内容",'cols ->20,'rows ->5)),format.raw/*11.82*/("""
  	"""),format.raw/*12.4*/("""</div>
  	<button class="button">登録</button>
  	""")))}),format.raw/*14.5*/("""
   """),format.raw/*15.4*/("""<button class="button" onclick="location.href='/index'">戻る</button>
""")))}),format.raw/*16.2*/("""
"""))
      }
    }
  }

  def render(message:String,form:Form[TaskListViewModel]): play.twirl.api.HtmlFormat.Appendable = apply(message,form)

  def f:((String,Form[TaskListViewModel]) => play.twirl.api.HtmlFormat.Appendable) = (message,form) => apply(message,form)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-10-05T19:08:42.294
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/add.scala.html
                  HASH: 1a0246d6e3662a0b3ab907aa99929d8a91bf4221
                  MATRIX: 970->1|1109->48|1122->54|1161->56|1190->59|1236->80|1269->93|1303->102|1317->108|1369->152|1407->153|1437->158|1451->164|1486->179|1516->183|1570->212|1584->218|1650->264|1684->273|1698->279|1762->323|1795->330|1809->336|1939->444|1974->453|1989->459|2081->530|2112->534|2191->583|2222->587|2321->656
                  LINES: 28->1|33->2|33->2|33->2|34->3|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|45->14|46->15|47->16
                  -- GENERATED --
              */
          