
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
  def apply/*1.2*/(message:String,form:List[TaskListViewModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main()/*2.8*/ {_display_(Seq[Any](format.raw/*2.10*/("""
  """),format.raw/*3.3*/("""<h1>タスク管理</h1>
  <div class="title_item">
  <p>"""),_display_(/*5.7*/Html(message)),format.raw/*5.20*/("""</p>
      <table border="1">
        <tr><th>タスクNo</th><th>タスク名</th><th>タスク内容</th><th>期日</th><th>ステータス</th><th>更新</th><th>削除</th></tr>
        """),_display_(/*8.10*/if(form.size()<=0)/*8.28*/{_display_(Seq[Any](format.raw/*8.29*/("""
          """),format.raw/*9.11*/("""<tr><td>　　</td><td>　　</td><td>　　</td><td>　　</td><td>　　</td><td>　　</td><td>　　</td></tr>
        """)))}/*10.10*/else/*10.14*/{_display_(Seq[Any](format.raw/*10.15*/("""
        """),_display_(/*11.10*/for(item<-form) yield /*11.25*/{_display_(Seq[Any](format.raw/*11.26*/("""
        """),format.raw/*12.9*/("""<tr><td>"""),_display_(/*12.18*/item/*12.22*/.taskNo),format.raw/*12.29*/("""</td><td>"""),_display_(/*12.39*/item/*12.43*/.taskName),format.raw/*12.52*/("""</td><td>"""),_display_(/*12.62*/item/*12.66*/.taskContents),format.raw/*12.79*/("""</td><td>"""),_display_(/*12.89*/item/*12.93*/.deadLine),format.raw/*12.102*/("""</td><td>"""),_display_(/*12.112*/item/*12.116*/.status),format.raw/*12.123*/("""</td><td><a href="/edit/"""),_display_(/*12.148*/item/*12.152*/.encodedResult),format.raw/*12.166*/("""" class="delete regi" value="update:"""),_display_(/*12.203*/item/*12.207*/.encodedResult),format.raw/*12.221*/("""">更新</a></td><td><a href="/delete/"""),_display_(/*12.256*/item/*12.260*/.encodedResult),format.raw/*12.274*/("""" class="delete regi">削除</a></td></tr>
        """)))}),format.raw/*13.10*/("""
        """)))}),format.raw/*14.10*/("""
      """),format.raw/*15.7*/("""</table>
  </div>
  <a href="/add" class="add regi">登録</a>
  <a href="/signout" class="add regi">サインアウト</a>
""")))}),format.raw/*19.2*/("""
"""))
      }
    }
  }

  def render(message:String,form:List[TaskListViewModel]): play.twirl.api.HtmlFormat.Appendable = apply(message,form)

  def f:((String,List[TaskListViewModel]) => play.twirl.api.HtmlFormat.Appendable) = (message,form) => apply(message,form)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-09-26T08:40:30.230
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/index.scala.html
                  HASH: 60f0ac6b8cd602b5e31f147f9908e41010af2048
                  MATRIX: 972->1|1111->48|1124->54|1163->56|1192->59|1265->107|1298->120|1469->265|1495->283|1533->284|1571->295|1686->391|1699->395|1738->396|1775->406|1806->421|1845->422|1881->431|1917->440|1930->444|1958->451|1995->461|2008->465|2038->474|2075->484|2088->488|2122->501|2159->511|2172->515|2203->524|2241->534|2255->538|2284->545|2337->570|2351->574|2387->588|2452->625|2466->629|2502->643|2565->678|2579->682|2615->696|2694->744|2735->754|2769->761|2908->870
                  LINES: 28->1|33->2|33->2|33->2|34->3|36->5|36->5|39->8|39->8|39->8|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|43->12|44->13|45->14|46->15|50->19
                  -- GENERATED --
              */
          