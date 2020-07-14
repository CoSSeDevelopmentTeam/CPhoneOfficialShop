package net.comorevi.cpapp.shop.buy;

import cn.nukkit.item.Item;
import net.comorevi.cpapp.shop.BuyItem;
import net.comorevi.cpapp.shop.MainActivity;
import net.comorevi.cphone.cphone.CPhone;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.ModalResponse;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ModalActivity;
import net.comorevi.cphone.cphone.widget.activity.original.MessageActivity;
import net.comorevi.np.moneys.MoneySAPI;
import net.comorevi.np.moneys.util.TaxType;

public class BuyItemConfirmActivity extends ModalActivity {

    private Bundle bundle;
    private CPhone cphone;
    private BuyItem buyItem;
    private int amount;
    private int price;

    public BuyItemConfirmActivity(ApplicationManifest manifest, BuyItem buyItem, int amount) {
        super(manifest);
        this.buyItem = buyItem;
        this.amount = amount;
        this.price = (int) (buyItem.getPrice() * amount * TaxType.ADMIN_SHOP.getRatio());
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.bundle = bundle;
        this.cphone = bundle.getCPhone();
        this.setTitle(bundle.getString("buyitem_confirm_title"));
        this.setContent("アイテム/Item \n - "+ buyItem.getNameJpn()+"/"+ buyItem.getName()+
                "\nID:META \n - "+ buyItem.getId()+":"+ buyItem.getMeta()+
                "\n個数/Amount \n - "+amount+
                "\n値段/Price \n - "+price+MoneySAPI.UNIT);
        this.setButton1Text(bundle.getString("buyitem_confirm_button1"));
        this.setButton2Text(bundle.getString("buyitem_confirm_button2"));
    }

    @Override
    public ReturnType onStop(Response response) {
        ModalResponse modalResponse = (ModalResponse) response;
        if (modalResponse.isButton1Clicked()) {
            if (!MoneySAPI.getInstance().isPayable(modalResponse.getPlayer(), price)) {
                new MessageActivity(getManifest(), bundle.getString("error_title") ,bundle.getString("buyitem_confirm_error1"), bundle.getString("buyitem_confirm_error1_button1"), bundle.getString("buyitem_confirm_error1_button2"), new BuyItemDetailActivity(getManifest(), buyItem)).start(bundle);
                return ReturnType.TYPE_CONTINUE;
            } else if (!modalResponse.getPlayer().getInventory().canAddItem(Item.get(buyItem.getId(), buyItem.getMeta(), amount))) {
                new MessageActivity(getManifest(), bundle.getString("error_title") ,bundle.getString("buyitem_confirm_error2"), bundle.getString("buyitem_confirm_error2_button1"), bundle.getString("buyitem_confirm_error2_button2"), new BuyItemDetailActivity(getManifest(), buyItem)).start(bundle);
                return ReturnType.TYPE_CONTINUE;
            }

            MoneySAPI.getInstance().reduceMoney(modalResponse.getPlayer(), price);
            modalResponse.getPlayer().getInventory().addItem(Item.get(buyItem.getId(), buyItem.getMeta(), amount));
            cphone.setHomeMessage(bundle.getString("buyitem_confirm_phone_home_message"));
            return ReturnType.TYPE_END;
        } else {
            new MainActivity(getManifest()).start(bundle);
            return ReturnType.TYPE_CONTINUE;
        }
    }
}
