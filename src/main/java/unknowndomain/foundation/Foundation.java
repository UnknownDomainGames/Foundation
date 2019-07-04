package unknowndomain.foundation;

import com.google.inject.Inject;
import nullengine.event.Listener;
import nullengine.event.mod.ModLifecycleEvent;
import nullengine.mod.annotation.Mod;
import org.slf4j.Logger;

@Mod(id = "foundation", version = "0.1.0-alpha", name = "Foundation")
public class Foundation {

    @Inject
    public static Logger logger;

    @Listener
    public void onInit(ModLifecycleEvent.Initialization event) {
        logger.info("Hello World");
    }
}
