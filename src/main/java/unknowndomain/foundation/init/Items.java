package unknowndomain.foundation.init;

import engine.graphics.item.ItemDisplay;
import engine.item.BaseItem;
import engine.item.BlockItem;
import engine.item.Item;
import engine.mod.annotation.AutoRegister;

@AutoRegister
public interface Items {

    Item GRASS = new BlockItem(Blocks.GRASS);

    Item DIRT = new BlockItem(Blocks.DIRT);


    Item GLASS = new BlockItem(Blocks.GLASS);

    Item STICK = new BaseItem().name("stick")
            .setComponent(ItemDisplay.class, new ItemDisplay().model("item/stick"));
}
