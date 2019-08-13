package unknowndomain.foundation.init;

import nullengine.client.rendering.item.ItemBlockRenderer;
import nullengine.client.rendering.item.ItemRenderer;
import nullengine.event.Listener;
import nullengine.event.mod.ModLifecycleEvent;
import nullengine.item.BlockItem;
import nullengine.item.Item;
import nullengine.mod.annotation.AutoListen;
import nullengine.mod.annotation.AutoRegister;

@AutoRegister
@AutoListen(bus = AutoListen.Bus.MOD)
public class Items {

    public static final Item GRASS = new BlockItem(Blocks.GRASS);

    public static final Item DIRT = new BlockItem(Blocks.DIRT);

    @Listener
    public static void onPreInit(ModLifecycleEvent.PreInitialization event) {
        GRASS.setComponent(ItemRenderer.class, new ItemBlockRenderer());
        DIRT.setComponent(ItemRenderer.class, new ItemBlockRenderer());
    }
}
