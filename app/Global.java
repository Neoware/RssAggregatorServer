import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import scala.concurrent.duration.Duration;
import play.Application;
import play.GlobalSettings;
import play.libs.Akka;

/**
 * Created by Neti on 24/04/2016.
 */

class UpdateActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        // Update shit
    }
}

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        ActorRef updateActor = Akka.system().actorOf(new Props(UpdateActor.class));
        Akka.system().scheduler().schedule(
                Duration.Zero(),
                Duration.create(1, TimeUnit.HOURS),
                updateActor, "UPDATE", Akka.system().dispatcher(), null);
    }
}
