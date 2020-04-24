package net.comorevi.cpapp.shop;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.network.protocol.ContainerClosePacket;
import net.comorevi.cpapp.shop.sell.NewSellItemActivity;
import net.comorevi.cphone.cphone.application.ApplicationManifest;
import net.comorevi.cphone.cphone.application.Initializer;
import net.comorevi.cphone.cphone.data.ApplicationData;
import net.comorevi.cphone.cphone.data.RuntimeData;
import net.comorevi.cphone.cphone.event.CPhoneOpenEvent;
import net.comorevi.cphone.cphone.widget.activity.ActivityBase;
import net.comorevi.cphone.presenter.SharingData;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedHashMap;
import java.util.Map;

public class EventListener extends Initializer implements Listener {

    public static FakeInvManager inv = new FakeInvManager();
    public static Map<String, Inventory> invMap = new LinkedHashMap<>();

    @Override
    public void initialize() {
        SharingData.server.getPluginManager().registerEvents(this, SharingData.pluginInstance);
    }

    @EventHandler
    public void onOpen(CPhoneOpenEvent event) {
        //System.out.println("opened.");
    }

    @EventHandler
    public void onPacketReceive(DataPacketReceiveEvent event) {
        if (event.getPacket() instanceof ContainerClosePacket) {
            System.out.println(invMap.get(event.getPlayer().getName()));
            if (invMap.containsKey(event.getPlayer().getName())) {
                System.out.println("Event called2.");
                try {
                    ApplicationManifest manifest = ApplicationData.applications.get("OfficialShop");
                    Class<? extends ActivityBase> mainClass = null;

                    mainClass = new URLClassLoader(new URL[]{new File(RuntimeData.currentDirectory + "/app/OfficialShop.jar").toURI().toURL()}, SharingData.pluginInstance.getClass().getClassLoader())
                            .loadClass(manifest.getMain())
                            .asSubclass(ActivityBase.class);

                    Constructor<ActivityBase> constructor = (Constructor<ActivityBase>) mainClass.getConstructor(ApplicationManifest.class);
                    ActivityBase activityBase = constructor.newInstance(manifest);

                    new NewSellItemActivity(manifest).start(event.getPlayer(), activityBase.getStrings()); //TODO: 第二引数
                } catch (ClassNotFoundException | MalformedURLException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
