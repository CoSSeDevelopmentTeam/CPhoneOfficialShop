package net.comorevi.cpapp.shop.sell;

import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ModalActivity;

public class NewSellItemActivity extends ModalActivity {
    public NewSellItemActivity(ApplicationManifest manifest) {
        super(manifest);
    }

    @Override
    public void onCreate(Bundle bundle) {

    }

    @Override
    public ReturnType onStop(Response response) {
        return null;
    }
}
