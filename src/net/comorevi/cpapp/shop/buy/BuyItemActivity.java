package net.comorevi.cpapp.shop.buy;

import net.comorevi.cpapp.shop.MainActivity;
import net.comorevi.cpapp.shop.BuyItem;
import net.comorevi.cphone.cphone.CPhone;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.ListResponse;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ListActivity;
import net.comorevi.cphone.cphone.widget.element.Button;

import java.util.LinkedList;
import java.util.List;

public class BuyItemActivity extends ListActivity {

    private CPhone cPhone;
    private Bundle bundle;
    private List<Button> buttonList = new LinkedList<>();

    public BuyItemActivity(ApplicationManifest manifest) {
        super(manifest);
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.bundle = bundle;
        this.cPhone = bundle.getCPhone();
        this.setTitle("title");
        this.setContent("この機能は現在利用できません。");
        BuyItem.getShopItemList().forEach((buyItem) -> {
            buttonList.add(new Button(buyItem.getNameJpn()+"/"+ buyItem.getName()));
        });
        this.addButtons(buttonList.toArray(Button[]::new));
    }

    @Override
    public ReturnType onStop(Response response) {
        ListResponse listResponse = (ListResponse) response;
        if (listResponse.getButtonIndex() == -1) {
            new MainActivity(getManifest()).start(listResponse.getPlayer(), bundle.getStrings());
        } else {
            new BuyItemDetailActivity(getManifest(), BuyItem.values()[listResponse.getButtonIndex()]).start(listResponse.getPlayer(), bundle.getStrings());
        }
        return ReturnType.TYPE_CONTINUE;
    }
}
