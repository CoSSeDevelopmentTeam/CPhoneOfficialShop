package net.comorevi.cpapp.shop.buy;

import net.comorevi.cpapp.shop.ErrorActivity;
import net.comorevi.cpapp.shop.BuyItem;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.CustomResponse;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.CustomActivity;
import net.comorevi.cphone.cphone.widget.element.Element;
import net.comorevi.cphone.cphone.widget.element.Input;
import net.comorevi.cphone.cphone.widget.element.Label;

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
                new Label(bundle.getString("アイテム(Item): "+ buyItem.getNameJpn()+"/"+ buyItem.getName())+"\nID(META): "+ buyItem.getId()+"("+ buyItem.getMeta()+")"),
                new Input(bundle.getString("buyitem_detail_input_text"), bundle.getString("buyitem_detail_input_placeholder"), "0")
        };
        this.addFormElements(elements);
    }

    @Override
    public ReturnType onStop(Response response) {
        CustomResponse customResponse = (CustomResponse) response;
        if (customResponse.getResult().get(2).toString().equals("0") || !isPositiveNumber(customResponse.getResult().get(2).toString())) {
            new ErrorActivity(getManifest(), "正しい数値を入力してください。", "もどる", "アイテム一覧へ", new BuyItemDetailActivity(getManifest(), buyItem), new BuyItemActivity(getManifest())).start(bundle);
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
