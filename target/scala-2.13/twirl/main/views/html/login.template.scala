
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Form[AccountViewModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String,form:Form[AccountViewModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main()/*2.8*/ {_display_(Seq[Any](format.raw/*2.10*/("""
  """),format.raw/*3.3*/("""<h1>タスク管理</h1>
  <p>"""),_display_(/*4.7*/Html(message)),format.raw/*4.20*/("""</p>
  	"""),_display_(/*5.5*/helper/*5.11*/.form(action=routes.MangaRecordController.signin())/*5.62*/{_display_(Seq[Any](format.raw/*5.63*/("""
  	"""),_display_(/*6.5*/helper/*6.11*/.CSRF.formField),format.raw/*6.26*/("""
  	"""),format.raw/*7.4*/("""<div class="other_item">
		"""),_display_(/*8.4*/helper/*8.10*/.inputText(form("accountName"),'_label -> "アカウント名")),format.raw/*8.61*/("""
  	    """),_display_(/*9.9*/helper/*9.15*/.inputText(form("password"),'_label -> "パスワード")),format.raw/*9.62*/("""
  	"""),format.raw/*10.4*/("""</div>
  	<button class="regi">ログイン</button>
  	""")))}),format.raw/*12.5*/("""
	"""),format.raw/*13.2*/("""<a href="/" class="regi">戻る</a>
""")))}))
      }
    }
  }

  def render(message:String,form:Form[AccountViewModel]): play.twirl.api.HtmlFormat.Appendable = apply(message,form)

  def f:((String,Form[AccountViewModel]) => play.twirl.api.HtmlFormat.Appendable) = (message,form) => apply(message,form)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-09-20T17:40:47.111
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/login.scala.html
                  HASH: a62169feff07e24246de4db76d7af6b7e24c51d5
                  MATRIX: 971->1|1109->47|1122->53|1161->55|1190->58|1236->79|1269->92|1303->101|1317->107|1376->158|1414->159|1444->164|1458->170|1493->185|1523->189|1576->217|1590->223|1661->274|1695->283|1709->289|1776->336|1807->340|1886->389|1915->391
                  LINES: 28->1|33->2|33->2|33->2|34->3|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|43->12|44->13
                  -- GENERATED --
              */
          