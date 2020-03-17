package net.comorevi.cpapp.shop.buy;

import net.comorevi.cphone.cphone.CPhone;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ListActivity;

public class BuyItemActivity extends ListActivity {

    private CPhone cPhone;
    private Bundle bundle;

    public BuyItemActivity(ApplicationManifest manifest) {
        super(manifest);
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.bundle = bundle;
        this.cPhone = bundle.getCPhone();
        this.setTitle("title");
        this.setContent("この機能は現在利用できません。");
    }

    @Override
    public ReturnType onStop(Response response) {
        return ReturnType.TYPE_END;
    }
}
