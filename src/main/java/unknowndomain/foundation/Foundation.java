package unknowndomain.foundation;

import org.slf4j.Logger;
import unknowndomain.engine.block.Block;
import unknowndomain.engine.block.BlockBase;
import unknowndomain.engine.event.Listener;
import unknowndomain.engine.event.game.GameEvent;
import unknowndomain.engine.mod.Mod;
import unknowndomain.engine.mod.annotation.AutoListen;
import unknowndomain.engine.mod.annotation.AutoRegister;
import unknowndomain.engine.mod.annotation.Inject;

@Mod("foundation:1.0.0")
@AutoListen
public class Foundation {

    @AutoRegister
    public static Block WOOD = new BlockBase().registerName("wood");

    @Inject
    public static Logger logger;

    @Listener
    public void onGameReady(GameEvent.Ready event) {
        System.out.println("Hello Foundation!");
    }
}
