package unknowndomain.foundation;

import unknowndomain.engine.block.Block;
import unknowndomain.engine.event.Listener;
import unknowndomain.engine.event.game.GameReadyEvent;
import unknowndomain.engine.event.registry.RegisterEvent;
import unknowndomain.engine.mod.Mod;

@Mod("foundation:1.0.0")
public class Foundation {

    @Listener
    public void onGameReady(GameReadyEvent event) {
        System.out.println("Hello Foundation!");
    }

    @Listener
    public void register(RegisterEvent<Block> event) {

    }
}
