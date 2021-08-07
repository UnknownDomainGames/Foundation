package unknowndomain.foundation.init;

import engine.block.state.BlockState;
import engine.event.Listener;
import engine.event.Order;
import engine.event.game.GameCreateEvent;
import engine.event.game.GameStartEvent;
import engine.mod.annotation.AutoListen;
import engine.mod.annotation.AutoRegister;
import engine.world.impl.FlatWorldCreationSetting;

@AutoRegister
@AutoListen
public class GameInitializer {

    @Listener(order = Order.FIRST)
    public static void onGameCreated(GameCreateEvent.Post event) {
        var game = event.getGame();
        var dirt = Blocks.DIRT.getDefaultState();
        var grass = Blocks.GRASS.getDefaultState();
        game.createWorld("engine:flat", "default",
                FlatWorldCreationSetting.create().layers(new BlockState[]{dirt, dirt, dirt, dirt, grass}));
    }

    @Listener(order = Order.FIRST)
    public static void onGameStarted(GameStartEvent.Post event) {
//        if (event.getGame() instanceof GameClient) {
//            var game = (GameClient) event.getGame();
//            game.getWorld("default")
//                    .map(world -> world.spawnEntity(CameraEntity.class, 0, 6, 0))
//                    .ifPresent(entity -> game.joinPlayer(new Profile(UUID.randomUUID(), "default"), entity));
//
//            game.getClientPlayer().setEntityController(new EntityCameraController());
//        }
    }
}
