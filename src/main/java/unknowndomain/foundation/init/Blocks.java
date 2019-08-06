package unknowndomain.foundation.init;

import nullengine.block.BaseBlock;
import nullengine.block.Block;
import nullengine.client.asset.AssetURL;
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

    public static final Block GRASS = new BaseBlock().name("grass");

    public static final Block DIRT = new BaseBlock().name("dirt");

    @Listener
    public void onPreInit(ModLifecycleEvent.PreInitialization event) {
        GRASS.addComponent(BlockRenderer.class, new DefaultBlockRenderer().setModelPath(AssetURL.of("block/grass")));
        DIRT.addComponent(BlockRenderer.class, new DefaultBlockRenderer().setModelPath(AssetURL.of("block/dirt")));
    }
}
