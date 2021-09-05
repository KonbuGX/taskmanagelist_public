package models;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import javax.inject.*;
import javax.persistence.*;
import play.db.jpa.*;
import play.db.jpa.JPAApi;
import play.libs.concurrent.*;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import models.*;
import play.db.ebean.*;
import io.ebean.*;


public class TaskListRepository{
	private JPAApi jpaApi;
    private DatabaseExecutionContext executionContext;
    public EbeanServer ebean;

    public TaskListRepository(){
        this.ebean = Ebean.getDefaultServer();
    }
	
public static Finder<Integer,TaskListViewModel> find = new Finder<Integer,TaskListViewModel>(
    TaskListViewModel.class);

public List<TaskListViewModel> allList(){
    return find.all();
}

public List<TaskListViewModel> get(int accountNo,int taskNo){
    String accountno = String.valueOf(accountNo);
    String taskno = String.valueOf(taskNo);
    return find.query().where().eq("accountNo", accountNo).eq("taskNo", taskNo).findList();
}

public void add(TaskListViewModel taskList){
    taskList.save();
}

public void update(TaskListViewModel task){
    task.update();
}

    /*@Inject
    @Deprecated
    public TaskListRepository(JPAApi api, DatabaseExecutionContext executionContext){
        this.jpaApi = api;
        this.executionContext = executionContext;
    }
	
	//wrap
	private <T> T withTransaction(Function<EntityManager,T> function){
        return jpaApi.withTransaction(function);
    }
	
	public CompleteStage<List<TaskListViewModel>> list(){
        return supplyAsync(() -> withTransaction(em -> allList(em)),executionContext);
    }
	
    private List<TaskListViewModel> allList(EntityManager em){
        return em.createQuery("SELECT p from TaskListViewModel p",TaskListViewModel.class).getResultList();
    }
*/
}