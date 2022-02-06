package app;
import play.mvc.*;
import java.util.*;
import javax.inject.*;
import java.sql.*;
import play.data.*;
import play.db.*;
import models.*;
import org.mindrot.jbcrypt.BCrypt;
import static play.libs.Scala.asScala;
import play.libs.concurrent.HttpExecutionContext;
import java.util.concurrent.CompletionStage;
import java.sql.Date;
import java.time.LocalDateTime;

public class Enum{
    //CREATE:タスク作成画面
    //EDIT:タスク編集画面
    //DELETE:タスク削除画面
    //LOGIN:ユーザアカウント作成画面
    //SIGNIN:サインイン画面
    //TASKUPDATE:タスクの編集画面
    //TASKDELETE:タスクの削除画面
    //TASKINSERT:メモのホーム画面
    //TASKUPDATE:メモの編集ダイアログ
    public enum screenStatus{CREATE,EDIT,DELETE,LOGIN,SIGNIN,TASKUPDATE,TASKDELETE,TASKMEMOINSERT,TASKMEMOUPDATE}
}