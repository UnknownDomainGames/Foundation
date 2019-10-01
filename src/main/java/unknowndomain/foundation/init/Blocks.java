package unknowndomain.foundation.init;

import nullengine.block.BaseBlock;
import nullengine.block.Block;
import nullengine.client.rendering.block.BlockDisplay;
import nullengine.mod.annotation.AutoRegister;

@AutoRegister
public interface Blocks {

    Block GRASS = new BaseBlock().name("grass")
            .setComponent(BlockDisplay.class, new BlockDisplay().model("block/grass"));

    Block DIRT = new BaseBlock().name("dirt")
            .setComponent(BlockDisplay.class, new BlockDisplay().model("block/dirt"));

}
