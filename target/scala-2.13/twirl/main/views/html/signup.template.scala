
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

object signup extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Form[AccountViewModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String,form:Form[AccountViewModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main()/*2.8*/ {_display_(Seq[Any](format.raw/*2.10*/("""
  """),format.raw/*3.3*/("""<h1>タスク管理</h1>
  <p>"""),_display_(/*4.7*/Html(message)),format.raw/*4.20*/("""</p>
  	"""),_display_(/*5.5*/helper/*5.11*/.form(action=routes.MangaRecordController.accountCreate())/*5.69*/{_display_(Seq[Any](format.raw/*5.70*/("""
  	"""),_display_(/*6.5*/helper/*6.11*/.CSRF.formField),format.raw/*6.26*/("""
  	"""),format.raw/*7.4*/("""<div class="other_item">
		"""),_display_(/*8.4*/helper/*8.10*/.inputText(form("accountName"),'_label -> "アカウント名")),format.raw/*8.61*/("""
  	    """),_display_(/*9.9*/helper/*9.15*/.inputText(form("password"),'_label -> "パスワード")),format.raw/*9.62*/("""
  	"""),format.raw/*10.4*/("""</div>
  	<button class="regi">新規作成</button>
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
                  DATE: 2021-09-20T17:40:47.070
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/signup.scala.html
                  HASH: e492a6d6802b03b648bb271400167fbe1fc759b5
                  MATRIX: 972->1|1110->47|1123->53|1162->55|1191->58|1237->79|1270->92|1304->101|1318->107|1384->165|1422->166|1452->171|1466->177|1501->192|1531->196|1584->224|1598->230|1669->281|1703->290|1717->296|1784->343|1815->347|1894->396|1923->398
                  LINES: 28->1|33->2|33->2|33->2|34->3|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|43->12|44->13
                  -- GENERATED --
              */
          