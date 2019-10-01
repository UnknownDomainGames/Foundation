package unknowndomain.foundation.init;

import nullengine.client.rendering.item.ItemDisplay;
import nullengine.item.BaseItem;
import nullengine.item.BlockItem;
import nullengine.item.Item;
import nullengine.mod.annotation.AutoRegister;

@AutoRegister
public interface Items {

    Item GRASS = new BlockItem(Blocks.GRASS);

    Item DIRT = new BlockItem(Blocks.DIRT);

    Item ARROW = new BaseItem().name("arrow")
            .setComponent(ItemDisplay.class, new ItemDisplay().model("item/arrow"));
}
