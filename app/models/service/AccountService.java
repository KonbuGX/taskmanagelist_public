package models;

import static play.libs.Scala.asScala;

import app.*;
import app.Enum.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletionStage;
import javax.inject.*;
import models.*;
import org.mindrot.jbcrypt.BCrypt;
import play.data.*;
import play.db.*;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;

public class AccountService {

  protected AccountDAO accountDAO = new AccountImplements();

  //エラーチェック
  public List<String> Validation(Connection conn,AccountViewModel account,String status) {
    List<String> errorMsg = new ArrayList<String>();

    //必須チェック処理
    if (account.accountName.length() < 1) {
      errorMsg.add("アカウント名を入力してください");
    }
    if (account.password.length() < 1) {
      errorMsg.add("パスワードを入力してください");
    }
    if (errorMsg.size() > 0) {
      return errorMsg;
    }

    List<AccountDTO> tempList = selectByName(conn, account.accountName);
    //サインインのみのチェック処理
    if (status == app.Enum.screenStatus.SIGNIN.toString()) {
      //アカウント名重複チェック
      if (tempList.size() >= 1) {
        errorMsg.add("アカウント名が重複しています。");
      }

      //パスワードチェック処理
      if (account.password.length() < 8) {
        errorMsg.add("パスワードは8文字以上でお願いいたします。");
      }
    }

    //ログインのみのチェック処理
    if (status == app.Enum.screenStatus.LOGIN.toString()) {
      //アカウントチェック処理
      if (tempList.size() == 0) {
        errorMsg.add("アカウントが存在していません。");
        return errorMsg;
      }

      //パスワードチェック
      String password = "";
      for (AccountDTO temp : tempList) {
        password = temp.password.toString();
      }
      Boolean passwordCheck = BCrypt.checkpw(account.password, password);
      if (!passwordCheck) {
        errorMsg.add("パスワードが間違っています。");
      }
    }
    return errorMsg;
  }

  //リストを全取得
  public List<AccountDTO> selectAll(Connection conn) {
    return accountDAO.selectAll(conn);
  }

  //リストをaccountNameで指定しての取得
  public List<AccountDTO> selectByName(Connection conn, String accountName) {
    return accountDAO.selectByName(conn, accountName);
  }

  //インサート処理
  public String InsertAccount(Connection conn, AccountViewModel account) {
    return accountDAO.insertAccount(conn, account);
  }

  //アップデート処理
  public String UpdateAccount(Connection conn, AccountViewModel account) {
    return accountDAO.updateAccount(conn, account);
  }

  //デリート処理
  public String DeleteAccount(Connection conn, int accountNo) {
    return accountDAO.deleteAccount(conn, accountNo);
  }
}
