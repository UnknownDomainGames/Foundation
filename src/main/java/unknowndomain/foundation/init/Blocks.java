package unknowndomain.foundation.init;

import nullengine.block.BaseBlock;
import nullengine.block.Block;
import nullengine.client.asset.AssetPath;
import nullengine.client.rendering.block.BlockRenderer;
import nullengine.client.rendering.block.DefaultBlockRenderer;
import nullengine.event.Listener;
import nullengine.event.mod.ModLifecycleEvent;
import nullengine.mod.annotation.AutoListen;
import nullengine.mod.annotation.AutoRegister;

import static nullengine.mod.annotation.AutoListen.EventBus.MOD;

@AutoRegister
@AutoListen(value = MOD)
public class Blocks {

    public static final Block GRASS = new BaseBlock().registerName("grass");

    public static final Block DIRT = new BaseBlock().registerName("dirt");

    @Listener
    public void onPreInit(ModLifecycleEvent.PreInitialization event) {
        AssetPath blockModelPath = AssetPath.of("foundation", "models", "block");
        GRASS.addComponent(BlockRenderer.class, new DefaultBlockRenderer().setModelPath(blockModelPath.resolve("grass.json")));
        DIRT.addComponent(BlockRenderer.class, new DefaultBlockRenderer().setModelPath(blockModelPath.resolve("dirt.json")));
    }
}
