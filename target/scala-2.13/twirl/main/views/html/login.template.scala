
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
"""),format.raw/*3.1*/("""<h1>タスク管理</h1>
<p>"""),_display_(/*4.5*/Html(message)),format.raw/*4.18*/("""</p>
"""),_display_(/*5.2*/helper/*5.8*/.form(action=routes.MangaRecordController.signin())/*5.59*/{_display_(Seq[Any](format.raw/*5.60*/("""
"""),_display_(/*6.2*/helper/*6.8*/.CSRF.formField),format.raw/*6.23*/("""
"""),format.raw/*7.1*/("""<div class="login_item">
    """),_display_(/*8.6*/helper/*8.12*/.inputText(form("accountName"),'_label -> "アカウント名")),format.raw/*8.63*/("""
    """),_display_(/*9.6*/helper/*9.12*/.inputPassword(form("password"),'_label -> "パスワード")),format.raw/*9.63*/("""
    """),format.raw/*10.5*/("""<input type="checkbox" id="displayPassword" />
    <label for="displayPassword">パスワードを表示</label>
</div>
<button class="button login_button">ログイン</button>
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
                  DATE: 2021-10-08T09:14:24.954
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/login.scala.html
                  HASH: 8c7eb5e7539cff6d693dc21d44641493924551c8
                  MATRIX: 971->1|1109->47|1122->53|1161->55|1188->56|1232->75|1265->88|1296->94|1309->100|1368->151|1406->152|1433->154|1446->160|1481->175|1508->176|1563->206|1577->212|1648->263|1679->269|1693->275|1764->326|1796->331|1981->486|2009->487
                  LINES: 28->1|33->2|33->2|33->2|34->3|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|45->14|46->15
                  -- GENERATED --
              */
          