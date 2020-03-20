package net.comorevi.cpapp.shop.sell;

import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.item.Item;
import cn.nukkit.utils.TextFormat;
import net.comorevi.cphone.cphone.CPhone;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.ModalResponse;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ModalActivity;
import net.comorevi.moneyapi.MoneySAPI;

import java.util.*;

public class SellItemActivity extends ModalActivity {

    private CPhone cPhone;
    private Bundle bundle;
    private int price;

    public SellItemActivity(ApplicationManifest manifest) {
        super(manifest);
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.bundle = bundle;
        this.cPhone = bundle.getCPhone();
        this.setTitle(bundle.getString("sellitem_title"));
        for (String key : getSellItemMap().keySet()) {
            price = price + getSellItemMap().get(key) * 5;
        }
        this.setContent(bundle.getString("sellitem_content1") + "\n<" + bundle.getString("sellitem_content2") + ">\n" + getSellItemString((LinkedHashMap<String, Integer>) getSellItemMap()) + "<" + bundle.getString("sellitem_content3") + ">\n - " + price + " " + MoneySAPI.getInstance().getMoneyUnit());
        this.setButton1Text(bundle.getString("sellitem_button1"));
        this.setButton2Text(bundle.getString("sellitem_button2"));
    }

    @Override
    public ReturnType onStop(Response response) {
        ModalResponse modalResponse = (ModalResponse) response;
        if (modalResponse.isButton1Clicked()) {
            PlayerInventory inventory = cPhone.getPlayer().getInventory();
            removeItem(inventory);
            MoneySAPI.getInstance().addMoney(cPhone.getPlayer().getName(), price);
            cPhone.setHomeMessage(TextFormat.AQUA + bundle.getString("sellitem_phone_home_message") + TextFormat.RESET + "(" + price + MoneySAPI.getInstance().getMoneyUnit() + ")");
            return ReturnType.TYPE_END;
        } else {
            return ReturnType.TYPE_END;
        }
    }

    private Map<String, Integer> getSellItemMap() {
        PlayerInventory inventory = cPhone.getPlayer().getInventory();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Integer key : inventory.slots.keySet()) {
            if (inventory.getItem(key).getId() == Item.WOOD || inventory.getItem(key).getId() == Item.WOOD2 || inventory.getItem(key).getId() == Item.COBBLE) {
                if (map.containsKey(inventory.getItem(key).getName())) {
                    int amount = map.get(inventory.getItem(key).getName());
                    map.put(inventory.getItem(key).getName(), inventory.getItem(key).count + amount);
                } else {
                    map.put(inventory.getItem(key).getName(), inventory.getItem(key).count);
                }
            }
        }
        return map;
    }

    private String getSellItemString(LinkedHashMap<String, Integer> map) {
        StringBuilder result = new StringBuilder();
        for (String key : map.keySet()) {
            result.append(" - ").append(key).append(" x").append(map.get(key)).append("\n");
        }
        return result.toString();
    }

    private void removeItem(PlayerInventory inventory) {
        Collection<Item> collection = inventory.slots.values();
        collection.removeIf(item -> item.getId() == Item.WOOD || item.getId() == Item.WOOD2 || item.getId() == Item.COBBLE);
        inventory.sendContents(cPhone.getPlayer());
    }
}
