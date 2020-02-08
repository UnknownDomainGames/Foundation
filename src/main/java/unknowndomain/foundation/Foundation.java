package unknowndomain.foundation;

import com.google.inject.Inject;
import engine.event.Listener;
import engine.event.mod.ModLifecycleEvent;
import engine.mod.annotation.Dependency;
import engine.mod.annotation.Mod;
import org.slf4j.Logger;

@Mod(id = "foundation", version = "0.2.0-snapshot", name = "Foundation",
        dependencies = @Dependency(id = "engine", version = "0.2.0-snapshot"))
public class Foundation {

    @Inject
    public static Logger logger;

    @Listener
    public void onInit(ModLifecycleEvent.Initialization event) {
        logger.info("Hello World");
    }
}
