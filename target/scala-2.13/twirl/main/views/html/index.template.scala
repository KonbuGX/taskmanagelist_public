
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
"""),format.raw/*3.1*/("""<h1>タスク管理</h1>
<div class="title_item">
    <p>"""),_display_(/*5.9*/Html(message)),format.raw/*5.22*/("""</p>
    <table class="table table-bordered table_size">
        <thead class="th_back">
            <tr>
                <th>タスクNo</th>
                <th>タスク名</th>
                <th>タスク内容</th>
                <th>期日</th>
                <th>ステータス</th>
                <th>更新</th>
                <th>削除</th>
            </tr>
        </thead>
        <tbody class="td_back">
            """),_display_(/*19.14*/if(form.size()<=0)/*19.32*/{_display_(Seq[Any](format.raw/*19.33*/(""" """),format.raw/*19.34*/("""<tr>
                <td>　　</td>
                <td>　　</td>
                <td>　　</td>
                <td>　　</td>
                <td>　　</td>
                <td>　　</td>
                <td>　　</td>
                </tr>
                """)))}/*28.18*/else/*28.22*/{_display_(Seq[Any](format.raw/*28.23*/("""
                """),_display_(/*29.18*/for(item<-form) yield /*29.33*/{_display_(Seq[Any](format.raw/*29.34*/(""" """),format.raw/*29.35*/("""<tr>
                    <td>"""),_display_(/*30.26*/item/*30.30*/.taskNo),format.raw/*30.37*/("""</td>
                    <td>"""),_display_(/*31.26*/item/*31.30*/.taskName),format.raw/*31.39*/("""</td>
                    <td>"""),_display_(/*32.26*/item/*32.30*/.taskContents),format.raw/*32.43*/("""</td>
                    <td>"""),_display_(/*33.26*/item/*33.30*/.deadLine),format.raw/*33.39*/("""</td>
                    <td>"""),_display_(/*34.26*/item/*34.30*/.status),format.raw/*34.37*/("""</td>
                    <td><button onclick="location.href='/edit/"""),_display_(/*35.64*/item/*35.68*/.encodedResult),format.raw/*35.82*/("""'" class="tablebutton"
                            value="update:"""),_display_(/*36.44*/item/*36.48*/.encodedResult),format.raw/*36.62*/("""">更新</button></td>
                    <td><button onclick="location.href='/delete/"""),_display_(/*37.66*/item/*37.70*/.encodedResult),format.raw/*37.84*/("""'" class="tablebutton">削除</button>
                    </td>
                    </tr>
                    """)))}),format.raw/*40.22*/("""
                    """)))}),format.raw/*41.22*/("""
        """),format.raw/*42.9*/("""</tbody>
    </table>
</div>
<button class="button" onclick="location.href='/add'">登録</button>
<button class="button" onclick="location.href='/signout'">サインアウト</button>
<button class="button" onclick="dialogShow()">アカウント削除</button>

<div id="dialog">
    <div id="dialogBackground"></div>
    <div id="dialogContent">
        <div id="dialogMsg">
            アカウントとそれに付随するタスクを削除いたします。<br>
            削除してもよろしいでしょうか。
        </div>
        <div>
            <button class="dialogButton dialogOkButton" onclick="location.href='/accountDelete'">はい</button>
            <button class="dialogButton" onclick="dialogHide()">いいえ</button>
        </div>
    </div>
</div>
""")))}))
      }
    }
  }

  def render(message:String,form:List[TaskListViewModel]): play.twirl.api.HtmlFormat.Appendable = apply(message,form)

  def f:((String,List[TaskListViewModel]) => play.twirl.api.HtmlFormat.Appendable) = (message,form) => apply(message,form)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-10-08T07:37:37.903
                  SOURCE: /Users/bunsawatsubasa1/taskmanagelist/app/views/index.scala.html
                  HASH: 7da1fde70bd101d402531783483242f24ba0f323
                  MATRIX: 972->1|1111->48|1124->54|1163->56|1190->57|1263->105|1296->118|1716->511|1743->529|1782->530|1811->531|2070->771|2083->775|2122->776|2167->794|2198->809|2237->810|2266->811|2323->841|2336->845|2364->852|2422->883|2435->887|2465->896|2523->927|2536->931|2570->944|2628->975|2641->979|2671->988|2729->1019|2742->1023|2770->1030|2866->1099|2879->1103|2914->1117|3007->1183|3020->1187|3055->1201|3166->1285|3179->1289|3214->1303|3353->1411|3406->1433|3442->1442
                  LINES: 28->1|33->2|33->2|33->2|34->3|36->5|36->5|50->19|50->19|50->19|50->19|59->28|59->28|59->28|60->29|60->29|60->29|60->29|61->30|61->30|61->30|62->31|62->31|62->31|63->32|63->32|63->32|64->33|64->33|64->33|65->34|65->34|65->34|66->35|66->35|66->35|67->36|67->36|67->36|68->37|68->37|68->37|71->40|72->41|73->42
                  -- GENERATED --
              */
          