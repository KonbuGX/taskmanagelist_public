
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
"""),format.raw/*3.1*/("""<h1>タスク管理</h1>
<p>"""),_display_(/*4.5*/Html(message)),format.raw/*4.18*/("""</p>
"""),_display_(/*5.2*/helper/*5.8*/.form(action=routes.MangaRecordController.accountCreate())/*5.66*/{_display_(Seq[Any](format.raw/*5.67*/("""
"""),_display_(/*6.2*/helper/*6.8*/.CSRF.formField),format.raw/*6.23*/("""
"""),format.raw/*7.1*/("""<div class="login_item">
    """),_display_(/*8.6*/helper/*8.12*/.inputText(form("accountName"),'_label -> "アカウント名")),format.raw/*8.63*/("""
    """),_display_(/*9.6*/helper/*9.12*/.inputPassword(form("password"),'_label -> "パスワード")),format.raw/*9.63*/("""
    """),format.raw/*10.5*/("""<input type="checkbox" id="displayPassword" />
    <label for="displayPassword">パスワードを表示</label>
</div>
<button class="button login_button">新規作成</button>
""")))}),format.raw/*14.2*/("""
"""),format.raw/*15.1*/("""<button class="button" onclick="location.href='/'">戻る</button>
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
                  DATE: 2021-10-08T09:14:24.942
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/signup.scala.html
                  HASH: a47d2b8bb8b0d60e84862c34558a6920c2c2faf3
                  MATRIX: 972->1|1110->47|1123->53|1162->55|1189->56|1233->75|1266->88|1297->94|1310->100|1376->158|1414->159|1441->161|1454->167|1489->182|1516->183|1571->213|1585->219|1656->270|1687->276|1701->282|1772->333|1804->338|1989->493|2017->494
                  LINES: 28->1|33->2|33->2|33->2|34->3|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|45->14|46->15
                  -- GENERATED --
              */
          