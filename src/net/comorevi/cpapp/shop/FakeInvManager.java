package net.comorevi.cpapp.shop;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import com.nukkitx.fakeinventories.inventory.ChestFakeInventory;
import com.nukkitx.fakeinventories.inventory.FakeSlotChangeEvent;

public class FakeInvManager {

    public void sendFakeInventory(Player player) {
        ChestFakeInventory fakeInventory = new ChestFakeInventory();
        fakeInventory.setName("Fake Inventory");
        fakeInventory.setItem(0, Item.get(ItemID.APPLE));
        fakeInventory.addListener(this::onSlotChange);
        player.addWindow(fakeInventory);
    }

    private void onSlotChange(FakeSlotChangeEvent event) {
        EventListener.invMap.put(event.getPlayer().getName(), event.getInventory());
        System.out.println(EventListener.invMap.get(event.getPlayer().getName()));
    }
}
