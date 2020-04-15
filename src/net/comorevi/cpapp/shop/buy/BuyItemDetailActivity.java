package net.comorevi.cpapp.shop.buy;

import net.comorevi.cpapp.shop.BuyItem;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.CustomResponse;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.CustomActivity;
import net.comorevi.cphone.cphone.widget.activity.original.MessageActivity;
import net.comorevi.cphone.cphone.widget.element.Element;
import net.comorevi.cphone.cphone.widget.element.Input;
import net.comorevi.cphone.cphone.widget.element.Label;
import net.comorevi.moneyapi.MoneySAPI;

public class BuyItemDetailActivity extends CustomActivity {

    private Bundle bundle;
    private BuyItem buyItem;

    public BuyItemDetailActivity(ApplicationManifest manifest, BuyItem buyItem) {
        super(manifest);
        this.buyItem = buyItem;
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.bundle = bundle;
        this.setTitle(bundle.getString("buyitem_detail_title"));
        Element[] elements = {
                new Label(bundle.getString("buyitem_detail_label")),
                new Label(bundle.getString("アイテム(Item)\n - "+ buyItem.getNameJpn()+"/"+ buyItem.getName())+"\nID:META\n - "+ buyItem.getId()+":"+ buyItem.getMeta()+ "\n１つあたりの値段(Price)\n - "+ buyItem.getPrice()+ MoneySAPI.UNIT),
                new Input(bundle.getString("buyitem_detail_input_text"), bundle.getString("buyitem_detail_input_placeholder"))
        };
        this.addFormElements(elements);
    }

    @Override
    public ReturnType onStop(Response response) {
        CustomResponse customResponse = (CustomResponse) response;
        if (!isPositiveNumber(customResponse.getResult().get(2).toString())) {
            new MessageActivity(getManifest(), bundle.getString("error_title") ,bundle.getString("buyitem_detail_error"), bundle.getString("buyitem_detail_error_button1"), bundle.getString("buyitem_detail_error_button2"), new BuyItemDetailActivity(getManifest(), buyItem)).start(bundle);
            return ReturnType.TYPE_CONTINUE;
        } else if (isPositiveNumber(customResponse.getResult().get(2).toString())) {
            new BuyItemConfirmActivity(getManifest(), buyItem, Integer.parseInt(customResponse.getResult().get(2).toString())).start(bundle);
            return ReturnType.TYPE_CONTINUE;
        } else {
            new BuyItemActivity(getManifest()).start(bundle);
            return ReturnType.TYPE_CONTINUE;
        }
    }

    private boolean isPositiveNumber(String value) {
        try {
            int i = Integer.parseInt(value);
            return i > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
