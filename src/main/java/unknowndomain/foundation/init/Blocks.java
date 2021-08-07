package unknowndomain.foundation.init;

import engine.block.BaseBlock;
import engine.block.Block;
import engine.graphics.block.BlockDisplay;
import engine.graphics.queue.RenderType;
import engine.mod.annotation.AutoRegister;

@AutoRegister
public interface Blocks {

    Block GRASS = new BaseBlock().name("grass")
            .setComponent(BlockDisplay.class, new BlockDisplay().model("block/grass"));

    Block DIRT = new BaseBlock().name("dirt")
            .setComponent(BlockDisplay.class, new BlockDisplay().model("block/dirt"));

    Block GLASS = new BaseBlock().name("glass")
            .setComponent(BlockDisplay.class, new BlockDisplay().model("block/glass").renderType(RenderType.TRANSPARENT));

}
