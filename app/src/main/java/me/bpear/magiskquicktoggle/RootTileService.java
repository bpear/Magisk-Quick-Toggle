package me.bpear.magiskquicktoggle;

import android.graphics.drawable.Icon;
import android.service.quicksettings.TileService;

import me.bpear.magiskquicktoggle.utils.Shell;

/**
 * Created by Brandon Pearse on 9/13/2016.
 */
public class RootTileService extends TileService{
    private int toggleState = 1;
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onTileAdded() {
        super.onTileAdded();
        //Check for root when you first add tile. Needed to toggle settings.
        Shell.su("su");
    }

    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
    }

    @Override
    public void onStopListening() {
        super.onStopListening();
    }

    @Override
    public void onClick() {
        super.onClick();
        Icon icon;

        if (toggleState == 1) {
            toggleState = 0;
            // Hide/unmount Magisk root
            Shell.su("setprop magisk.root 0");
            icon =  Icon.createWithResource(getApplicationContext(), R.drawable.ic_root_off);
        } else {
            toggleState = 1;
            // Mount Magisk root
            Shell.su("setprop magisk.root 1");
            icon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_root);
        }
        getQsTile().setIcon(icon);
        getQsTile().updateTile();
    }
}