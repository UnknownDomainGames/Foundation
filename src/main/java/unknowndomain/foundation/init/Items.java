package unknowndomain.foundation.init;

import nullengine.client.rendering.item.ItemDisplay;
import nullengine.item.BaseItem;
import nullengine.item.BlockItem;
import nullengine.item.Item;
import nullengine.mod.annotation.AutoListen;
import nullengine.mod.annotation.AutoRegister;

@AutoRegister
@AutoListen(bus = AutoListen.Bus.MOD)
public class Items {

    public static final Item GRASS = new BlockItem(Blocks.GRASS);

    public static final Item DIRT = new BlockItem(Blocks.DIRT);

    public static final Item ARROW = new BaseItem().setComponent(ItemDisplay.class, new ItemDisplay().model("item/arrow")).name("arrow");
}
