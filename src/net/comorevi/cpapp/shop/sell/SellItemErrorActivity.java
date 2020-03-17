package net.comorevi.cpapp.shop.sell;

import net.comorevi.cpapp.shop.MainActivity;
import net.comorevi.cphone.cphone.CPhone;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.ModalResponse;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ModalActivity;

public class SellItemErrorActivity extends ModalActivity {

    private CPhone cPhone;
    private Bundle bundle;

    public SellItemErrorActivity(ApplicationManifest manifest) {
        super(manifest);
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.bundle = bundle;
        this.cPhone = bundle.getCPhone();
        this.setTitle(bundle.getString("sellitem_error_title"));
        this.setContent(bundle.getString("sellitem_error_content"));
        this.setButton1Text(bundle.getString("sellitem_error_button1"));
        this.setButton2Text(bundle.getString("sellitem_error_button2"));
    }

    @Override
    public ReturnType onStop(Response response) {
        ModalResponse modalResponse = (ModalResponse) response;
        if (modalResponse.isButton1Clicked()) {
            new MainActivity(getManifest()).start(cPhone.getPlayer(), bundle.getStrings());
            return ReturnType.TYPE_CONTINUE;
        } else {
            return ReturnType.TYPE_END;
        }
    }
}
