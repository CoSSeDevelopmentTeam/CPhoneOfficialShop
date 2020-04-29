package net.comorevi.cpapp.shop.sell;

import cn.nukkit.inventory.Inventory;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.model.Bundle;
import net.comorevi.cphone.cphone.model.Response;
import net.comorevi.cphone.cphone.widget.activity.ReturnType;
import net.comorevi.cphone.cphone.widget.activity.base.ModalActivity;

public class SellItemConfirmActivity extends ModalActivity {
    private Inventory inventory;

    public SellItemConfirmActivity(ApplicationManifest manifest, Inventory inventory) {
        super(manifest);
        this.inventory = inventory;
    }

    @Override
    public void onCreate(Bundle bundle) {
        this.setTitle("SellItem confirm activity");
        this.setContent("Content");
        this.setButton1Text("Button 1");
        this.setButton2Text("Button 2");
    }

    @Override
    public ReturnType onStop(Response response) {
        return ReturnType.TYPE_IGNORE;
    }
}
