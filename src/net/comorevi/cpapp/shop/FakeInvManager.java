package net.comorevi.cpapp.shop;

import cn.nukkit.Player;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import com.nukkitx.fakeinventories.inventory.ChestFakeInventory;
import com.nukkitx.fakeinventories.inventory.FakeSlotChangeEvent;
import net.comorevi.cphone.cphone.application.ApplicationInstance;

import java.util.LinkedHashMap;
import java.util.Map;

public class FakeInvManager implements ApplicationInstance {
    public Map<String, Inventory> invMap = new LinkedHashMap<>();

    public void sendFakeInventory(Player player) {
        ChestFakeInventory fakeInventory = new ChestFakeInventory();
        fakeInventory.setName("Fake Inventory");
        fakeInventory.setItem(0, Item.get(ItemID.APPLE));
        fakeInventory.addListener(this::onSlotChange);
        player.addWindow(fakeInventory);
    }

    private void onSlotChange(FakeSlotChangeEvent event) {
        invMap.put(event.getPlayer().getName(), event.getInventory());
        System.out.println(invMap.get(event.getPlayer().getName()));
    }
}
