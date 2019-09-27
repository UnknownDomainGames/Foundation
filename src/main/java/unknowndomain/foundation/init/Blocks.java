package unknowndomain.foundation.init;

import nullengine.block.BaseBlock;
import nullengine.block.Block;
import nullengine.client.rendering.block.BlockDisplay;
import nullengine.mod.annotation.AutoListen;
import nullengine.mod.annotation.AutoRegister;

@AutoRegister
@AutoListen(bus = AutoListen.Bus.MOD)
public class Blocks {

    public static final Block GRASS = new BaseBlock().name("grass")
            .setComponent(BlockDisplay.class, new BlockDisplay().model("block/grass"));

    public static final Block DIRT = new BaseBlock().name("dirt")
            .setComponent(BlockDisplay.class, new BlockDisplay().model("block/dirt"));

}
