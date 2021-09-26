package models;

import app.*;
import app.Enum.*;
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

public class AccountService {
protected AccountDAO accountDAO = new AccountImplements();
//protected enum screenStatus{CREATE,EDIT,DELETE,}
@Inject Database db;

//ログイン処理の検証
public List<String> Validation(Connection conn,AccountViewModel account,String status){
    List<String> errorMsg = new ArrayList<String>();

    //必須チェック処理
    if(account.accountName.length() < 1){
        errorMsg.add("アカウント名を入力してください");
    }
    if(account.password.length() < 1){
        errorMsg.add("パスワードを入力してください");
    }
    if(errorMsg.size() > 0){
        return errorMsg;
    }

    List<AccountDTO> tempList = selectByName(conn,account.accountName);
    //サインインのみのチェック処理
    if(status == app.Enum.screenStatus.SIGNIN.toString()){
        
        //アカウント名重複チェック
        if(tempList.size() >= 1){
            errorMsg.add("アカウント名が重複しています。");
        }

        //パスワードチェック処理
        if(account.password.length() < 8){
            errorMsg.add("パスワードは8文字以上でお願いいたします。");
        }

    }

    //ログインのみのチェック処理
    if(status == app.Enum.screenStatus.LOGIN.toString()){
        //アカウントチェック処理
        if(tempList.size() == 0){
            errorMsg.add("アカウントが存在していません。");
            return errorMsg;
        }

        //パスワードチェック
        String password = "";
        for(AccountDTO temp : tempList){
            password = temp.password.toString();
        }
        Boolean passwordCheck = BCrypt.checkpw(account.password,password);
        if(!passwordCheck){
           errorMsg.add("パスワードが間違っています。");
        }
    }
    return errorMsg;
}

public List<AccountDTO> selectAll(Connection conn){
    return accountDAO.selectAll(conn);
}

public List<AccountDTO> selectByName(Connection conn,String accountName){
    return accountDAO.selectByName(conn,accountName);
}

public String InsertTask(Connection conn,AccountViewModel task){
    return accountDAO.insertTask(conn,task);
}

public String UpdateTask(Connection conn,AccountViewModel task){
    return accountDAO.updateTask(conn,task);
}

public String DeleteTask(Connection conn,int accountNo){
    return accountDAO.deleteTask(conn,accountNo);
}

}