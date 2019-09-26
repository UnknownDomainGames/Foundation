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
import nullengine.event.game.GameCreateEvent;
import nullengine.event.game.GameStartEvent;
import nullengine.mod.annotation.AutoListen;
import nullengine.mod.annotation.AutoRegister;
import nullengine.world.impl.FlatWorldCreationSetting;

@AutoRegister
@AutoListen
public class GameInitializer {

    @Listener
    public static void onGameCreated(GameCreateEvent.Post event) {
        var game = event.getGame();
        var dirt = Blocks.DIRT;
        var grass = Blocks.GRASS;
        var world = game.createWorld("engine:flat", "default",
                FlatWorldCreationSetting.create().layers(new Block[]{dirt, dirt, dirt, dirt, grass}));
        if (game instanceof GameClient) {
            var player = ((GameClient) game).getPlayer();
            var entity = world.spawnEntity(CameraEntity.class, 0, 7, 0);
            player.controlEntity(entity);
        }
    }

    @Listener
    public static void onGameStarted(GameStartEvent.Post event) {
        if (event.getGame() instanceof GameClient) {
            var game = (GameClient) event.getGame();
            var player = game.getPlayer();
            var renderContext = Platform.getEngineClient().getRenderManager();
            renderContext.setCamera(new FirstPersonCamera(player));

            var entityController = new EntityCameraController(player);
            game.setEntityController(entityController);
            renderContext.getGuiManager().showHud("game-hud", new Scene(new HUDGame()));
        }
    }
}
