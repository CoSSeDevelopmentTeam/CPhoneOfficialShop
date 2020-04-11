package net.comorevi.cpapp.shop;

import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.widget.activity.ActivityBase;
import net.comorevi.cphone.cphone.widget.activity.original.MessageActivity;

public class ErrorActivity extends MessageActivity {
    public ErrorActivity(ApplicationManifest manifest, String text, String button1, String button2, ActivityBase... starts) {
        super(manifest, text, button1, button2, starts);
    }
}
