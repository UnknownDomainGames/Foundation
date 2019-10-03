package unknowndomain.foundation.init;

import nullengine.Platform;
import nullengine.block.Block;
import nullengine.client.game.GameClient;
import nullengine.client.gui.Scene;
import nullengine.client.input.controller.EntityCameraController;
import nullengine.client.rendering.camera.FirstPersonCamera;
import nullengine.enginemod.client.gui.hud.HUDGame;
import nullengine.entity.CameraEntity;
import nullengine.event.Listener;
import nullengine.event.Order;
import nullengine.event.game.GameCreateEvent;
import nullengine.event.game.GameStartEvent;
import nullengine.mod.annotation.AutoListen;
import nullengine.mod.annotation.AutoRegister;
import nullengine.player.Profile;
import nullengine.world.impl.FlatWorldCreationSetting;

import java.util.UUID;

@AutoRegister
@AutoListen
public class GameInitializer {

    @Listener(order = Order.FIRST)
    public static void onGameCreated(GameCreateEvent.Post event) {
        var game = event.getGame();
        var dirt = Blocks.DIRT;
        var grass = Blocks.GRASS;
        game.createWorld("engine:flat", "default",
                FlatWorldCreationSetting.create().layers(new Block[]{dirt, dirt, dirt, dirt, grass}));
    }

    @Listener(order = Order.FIRST)
    public static void onGameStarted(GameStartEvent.Post event) {
        if (event.getGame() instanceof GameClient) {
            var game = (GameClient) event.getGame();
            game.getWorld("default")
                    .map(world -> world.spawnEntity(CameraEntity.class, 0, 6, 0))
                    .ifPresent(entity -> game.joinPlayer(new Profile(UUID.randomUUID(), "default"), entity));

            var player = game.getClientPlayer();

            var renderManager = Platform.getEngineClient().getRenderManager();
            renderManager.setCamera(new FirstPersonCamera(player));

            var entityController = new EntityCameraController(player);
            player.setEntityController(entityController);

            renderManager.getGuiManager().showHud("GameHud", new Scene(new HUDGame()));
        }
    }
}
