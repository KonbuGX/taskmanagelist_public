
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

object delete extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,Form[TaskListViewModel],Int,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String,form:Form[TaskListViewModel],taskNo:Int,encodedResult:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main()/*2.8*/ {_display_(Seq[Any](format.raw/*2.10*/("""
  """),format.raw/*3.3*/("""<h1>タスク管理</h1>
  <p>"""),_display_(/*4.7*/Html(message)),format.raw/*4.20*/("""</p>
  <div class="other_item">
  	"""),_display_(/*6.5*/helper/*6.11*/.form(action=routes.HomeController.remove(encodedResult))/*6.68*/{_display_(Seq[Any](format.raw/*6.69*/("""
  	"""),_display_(/*7.5*/helper/*7.11*/.CSRF.formField),format.raw/*7.26*/("""
  	"""),_display_(/*8.5*/helper/*8.11*/.inputText(form("taskNo"),'_label -> "タスクNo",'disabled -> "disabled")),format.raw/*8.80*/("""<br>
  	"""),_display_(/*9.5*/helper/*9.11*/.inputText(form("taskName"),'_label -> "タスク名",'disabled -> "disabled")),format.raw/*9.81*/("""<br>
  	"""),_display_(/*10.5*/helper/*10.11*/.inputDate(form("deadLine"),'_label -> "期日",'disabled -> "disabled")),format.raw/*10.79*/("""<br>
	"""),_display_(/*11.3*/helper/*11.9*/.inputText(form("status"),'_label -> "ステータス",'disabled -> "disabled")),format.raw/*11.78*/("""<br>
  	"""),_display_(/*12.5*/helper/*12.11*/.textarea(form("taskContents"),'_label -> "タスク内容",'cols ->20,'rows ->5,'disabled -> "disabled")),format.raw/*12.106*/("""
  """),format.raw/*13.3*/("""</div>	
  	<button class="button">削除</button>
  	""")))}),format.raw/*15.5*/("""
  	"""),format.raw/*16.4*/("""<button class="button" onclick="location.href='/index'">戻る</button>
""")))}))
      }
    }
  }

  def render(message:String,form:Form[TaskListViewModel],taskNo:Int,encodedResult:String): play.twirl.api.HtmlFormat.Appendable = apply(message,form,taskNo,encodedResult)

  def f:((String,Form[TaskListViewModel],Int,String) => play.twirl.api.HtmlFormat.Appendable) = (message,form,taskNo,encodedResult) => apply(message,form,taskNo,encodedResult)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-10-05T19:08:42.527
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/delete.scala.html
                  HASH: fb02231b7a9cd04c03b8f0fba905ab496543535f
                  MATRIX: 984->1|1155->80|1168->86|1207->88|1236->91|1282->112|1315->125|1376->161|1390->167|1455->224|1493->225|1523->230|1537->236|1572->251|1602->256|1616->262|1705->331|1739->340|1753->346|1843->416|1878->425|1893->431|1982->499|2015->506|2029->512|2119->581|2154->590|2169->596|2286->691|2316->694|2396->744|2427->748
                  LINES: 28->1|33->2|33->2|33->2|34->3|35->4|35->4|37->6|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|46->15|47->16
                  -- GENERATED --
              */
          