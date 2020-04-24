package net.comorevi.cpapp.shop;

import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.item.Item;
import net.comorevi.cpapp.shop.buy.BuyItemActivity;
import net.comorevi.cpapp.shop.sell.SellItemActivity;
import net.comorevi.cpapp.shop.sell.SellItemErrorActivity;
import net.comorevi.cphone.cphone.CPhone;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.ListResponse;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ListActivity;
import net.comorevi.cphone.cphone.widget.element.Button;

public class MainActivity extends ListActivity {

    private CPhone cPhone;
    private Bundle bundle;

    public MainActivity(ApplicationManifest manifest) {
        super(manifest);
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.bundle = bundle;
        this.cPhone = bundle.getCPhone();
        this.setTitle(bundle.getString("main_title"));
        this.setContent(bundle.getString("main_content"));
        Button[] buttons = {
                new Button(bundle.getString("main_button1")),
                new Button(bundle.getString("main_button2")),
                new Button("Open Fake Inventory.")
        };
        this.addButtons(buttons);
    }

    @Override
    public ReturnType onStop(Response response) {
        ListResponse listResponse = (ListResponse) response;
        switch (listResponse.getButtonIndex()) {
            case 0:
                if (hasItem()) {
                    new SellItemActivity(getManifest()).start(cPhone.getPlayer(), bundle.getStrings());
                } else {
                    new SellItemErrorActivity(getManifest()).start(cPhone.getPlayer(), bundle.getStrings());
                }
                return ReturnType.TYPE_CONTINUE;
            case 1:
                new BuyItemActivity(getManifest()).start(cPhone.getPlayer(), bundle.getStrings());
                return ReturnType.TYPE_CONTINUE;
            case 2:
                EventListener.inv.sendFakeInventory(listResponse.getPlayer());
                return ReturnType.TYPE_IGNORE;
        }
        return ReturnType.TYPE_END;
    }

    private boolean hasItem() {
        PlayerInventory inventory = cPhone.getPlayer().getInventory();
        for (Integer key : inventory.slots.keySet()) {
            if (inventory.getItem(key).getId() == Item.WOOD || inventory.getItem(key).getId() == Item.WOOD2 || inventory.getItem(key).getId() == Item.COBBLE) {
                return true;
            }
        }
        return false;
    }
}
