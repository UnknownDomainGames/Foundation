package unknowndomain.foundation.init;

import nullengine.Platform;
import nullengine.block.Block;
import nullengine.client.game.GameClient;
import nullengine.client.gui.Scene;
import nullengine.client.input.controller.EntityCameraController;
import nullengine.client.rendering.RenderContext;
import nullengine.client.rendering.camera.FirstPersonCamera;
import nullengine.enginemod.client.gui.hud.HUDGame;
import nullengine.event.Listener;
import nullengine.event.game.GameCreationEvent;
import nullengine.event.game.GameStartEvent;
import nullengine.mod.annotation.AutoListen;
import nullengine.mod.annotation.AutoRegister;
import nullengine.player.Player;
import nullengine.world.WorldCommon;
import nullengine.world.impl.FlatWorldCreationSetting;

@AutoRegister
@AutoListen
public class GameInitializer {

    @Listener
    public static void onGameCreated(GameCreationEvent.Post event) {
        var game = event.getGame();
        var dirt = Blocks.DIRT;
        var grass = Blocks.GRASS;
        var world = (WorldCommon) game.createWorld("engine:flat", "default", FlatWorldCreationSetting.create().layers(new Block[]{dirt, dirt, dirt, dirt, grass}));
        if (game instanceof GameClient) {
            Player player = ((GameClient) game).getPlayer();
            world.playerJoin(player);
            player.getControlledEntity().getPosition().set(0, 5, 0);
        }
    }

    @Listener
    public static void onGameStarted(GameStartEvent.Post event) {
        if (event.getGame() instanceof GameClient && Platform.isClient()) {
            var game = (GameClient) event.getGame();
            var player = game.getPlayer();
            RenderContext renderContext = Platform.getEngineClient().getRenderContext();
            renderContext.setCamera(new FirstPersonCamera(player));

            var entityController = new EntityCameraController(player);
            game.setEntityController(entityController);
            renderContext.getWindow().addCursorCallback((window, xpos, ypos) -> {
                entityController.handleCursorMove(xpos, ypos);
            });
            renderContext.getGuiManager().showHud("game-hud", new Scene(new HUDGame()));
        }
    }
}
