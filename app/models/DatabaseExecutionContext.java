package models;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import javax.inject.*;
import javax.persistence.*;
import play.db.jpa.*;
import play.libs.concurrent.*;
import java.sql.Connection;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;

public class DatabaseExecutionContext
        extends CustomExecutionContext {

    @javax.inject.Inject
    public DatabaseExecutionContext(ActorSystem actorSystem) {
        // uses a custom thread pool defined in application.conf
        super(actorSystem, "database.dispatcher");
    }
}
