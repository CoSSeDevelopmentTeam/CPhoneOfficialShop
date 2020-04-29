package net.comorevi.cpapp.shop.sell;

import net.comorevi.cpapp.shop.OfficialShopPlugin;
import net.comorevi.cpapp.shop.SellItem;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.ModalResponse;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ModalActivity;
import net.comorevi.cphone.presenter.SharingData;
import net.comorevi.moneyapi.MoneySAPI;

public class SellItemActivity extends ModalActivity {
    public SellItemActivity(ApplicationManifest manifest) {
        super(manifest);
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.setTitle(bundle.getString("sellitem_title"));
        this.setContent(bundle.getString("sellitem_content") + "\n" + getSellItemString());
        this.setButton1Text(bundle.getString("sellitem_button1"));
        this.setButton2Text(bundle.getString("sellitem_button2"));
    }

    @Override
    public ReturnType onStop(Response response) {
        ModalResponse modalResponse = (ModalResponse) response;
        if (modalResponse.isButton1Clicked()) {
            OfficialShopPlugin plugin = (OfficialShopPlugin) SharingData.server.getPluginManager().getPlugin("CPhoneOfficialShopPlugin");
            if (plugin != null) {
                plugin.sendSellItemInventory(modalResponse.getPlayer());
            }
            return ReturnType.TYPE_IGNORE;
        } else {
            return ReturnType.TYPE_END;
        }
    }

    private String getSellItemString() {
        StringBuilder result = new StringBuilder();
        SellItem.getShopItemList().forEach(sellItem -> result.append(" - ").append(sellItem.getNameJpn()).append("/").append(sellItem.getName()).append(": ").append(sellItem.getPrice()).append(MoneySAPI.UNIT).append("\n"));
        return result.toString();
    }
}
