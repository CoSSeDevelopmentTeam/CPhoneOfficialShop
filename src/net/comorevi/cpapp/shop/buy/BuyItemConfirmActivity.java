package net.comorevi.cpapp.shop.buy;

import cn.nukkit.item.Item;
import net.comorevi.cpapp.shop.BuyItem;
import net.comorevi.cpapp.shop.ErrorActivity;
import net.comorevi.cpapp.shop.MainActivity;
import net.comorevi.cphone.cphone.CPhone;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.ModalResponse;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ModalActivity;
import net.comorevi.moneyapi.MoneySAPI;
import net.comorevi.moneyapi.util.TAXType;

public class BuyItemConfirmActivity extends ModalActivity {

    private Bundle bundle;
    private CPhone cphone;
    private BuyItem buyItem;
    private int amount;

    public BuyItemConfirmActivity(ApplicationManifest manifest, BuyItem buyItem, int amount) {
        super(manifest);
        this.buyItem = buyItem;
        this.amount = amount;
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.bundle = bundle;
        this.cphone = bundle.getCPhone();
        this.setTitle("確認 - OfficialShop");
        this.setContent("アイテム/Item: "+ buyItem.getNameJpn()+"/"+ buyItem.getName()+
                "\nID(META): "+ buyItem.getId()+"("+ buyItem.getMeta()+")"+
                "\n個数/Amount: "+amount+ MoneySAPI.UNIT+
                "\n値段/Price: "+amount* buyItem.getPrice()*TAXType.ADMIN_SHOP);
        this.setButton1Text("購入する");
        this.setButton2Text("メインメニューに戻る");
    }

    @Override
    public ReturnType onStop(Response response) {
        ModalResponse modalResponse = (ModalResponse) response;
        if (modalResponse.isButton1Clicked()) {
            if (!MoneySAPI.getInstance().isPayable(modalResponse.getPlayer(), (int) (buyItem.getPrice()*TAXType.ADMIN_SHOP))) {
                new ErrorActivity(getManifest(), "所持金が不足しています。", "個数を再設定する", "アプリホームへ", new BuyItemDetailActivity(getManifest(), buyItem), new MainActivity(getManifest()));
                return ReturnType.TYPE_CONTINUE;
            } else if (!modalResponse.getPlayer().getInventory().canAddItem(Item.get(buyItem.getId(), buyItem.getMeta(), amount))) {
                new ErrorActivity(getManifest(), "インベントリにアイテムを追加できません。", "個数を再設定する", "アプリホームへ", new BuyItemDetailActivity(getManifest(), buyItem), new MainActivity(getManifest()));
                return ReturnType.TYPE_CONTINUE;
            }

            MoneySAPI.getInstance().reduceMoney(modalResponse.getPlayer(), (int) (buyItem.getPrice()*TAXType.ADMIN_SHOP));
            modalResponse.getPlayer().getInventory().addItem(Item.get(buyItem.getId(), buyItem.getMeta(), amount));
            cphone.setHomeMessage("アイテムを購入しました。");
            return ReturnType.TYPE_END;
        } else {
            new MainActivity(getManifest()).start(bundle);
            return ReturnType.TYPE_CONTINUE;
        }
    }
}
