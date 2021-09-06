
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,List[TaskListViewModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message:String,data:List[TaskListViewModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main()/*2.8*/ {_display_(Seq[Any](format.raw/*2.10*/("""
  """),format.raw/*3.3*/("""<h1>タスク管理</h1>
  <div class="title_item">
  <p>"""),_display_(/*5.7*/Html(message)),format.raw/*5.20*/("""</p>
      <table border="1">
        <tr><th>タスクNo</th><th>タスク名</th><th>タスク内容</th><th>期日</th><th>ステータス</th><th>更新</th><th>削除</th></tr>
        """),_display_(/*8.10*/for(item<-data) yield /*8.25*/{_display_(Seq[Any](format.raw/*8.26*/("""
        """),format.raw/*9.9*/("""<tr><td>"""),_display_(/*9.18*/item/*9.22*/.taskNo),format.raw/*9.29*/("""</td><td>"""),_display_(/*9.39*/item/*9.43*/.taskName),format.raw/*9.52*/("""</td><td>"""),_display_(/*9.62*/item/*9.66*/.taskContents),format.raw/*9.79*/("""</td><td>"""),_display_(/*9.89*/item/*9.93*/.deadLine),format.raw/*9.102*/("""</td><td>"""),_display_(/*9.112*/item/*9.116*/.status),format.raw/*9.123*/("""</td><td><a href="/edit/"""),_display_(/*9.148*/item/*9.152*/.taskNo),format.raw/*9.159*/("""" class="delete regi" value="update:"""),_display_(/*9.196*/item/*9.200*/.taskNo),format.raw/*9.207*/("""">更新</a></td><td><a href="/delete/"""),_display_(/*9.242*/item/*9.246*/.taskNo),format.raw/*9.253*/("""" class="delete regi">削除</a></td></tr>
        """)))}),format.raw/*10.10*/("""
      """),format.raw/*11.7*/("""</table>
  </div>
  <a href="/add" class="add regi">登録</a>
""")))}),format.raw/*14.2*/("""
"""))
      }
    }
  }

  def render(message:String,data:List[TaskListViewModel]): play.twirl.api.HtmlFormat.Appendable = apply(message,data)

  def f:((String,List[TaskListViewModel]) => play.twirl.api.HtmlFormat.Appendable) = (message,data) => apply(message,data)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-09-05T21:14:47.060
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/index.scala.html
                  HASH: b77fbe73fc697d428c0ac0bae098b65bd6aaa4ec
                  MATRIX: 972->1|1111->48|1124->54|1163->56|1192->59|1265->107|1298->120|1469->265|1499->280|1537->281|1572->290|1607->299|1619->303|1646->310|1682->320|1694->324|1723->333|1759->343|1771->347|1804->360|1840->370|1852->374|1882->383|1919->393|1932->397|1960->404|2012->429|2025->433|2053->440|2117->477|2130->481|2158->488|2220->523|2233->527|2261->534|2340->582|2374->589|2464->649
                  LINES: 28->1|33->2|33->2|33->2|34->3|36->5|36->5|39->8|39->8|39->8|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|40->9|41->10|42->11|45->14
                  -- GENERATED --
              */
          