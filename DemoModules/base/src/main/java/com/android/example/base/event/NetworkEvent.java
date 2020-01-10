package com.android.example.base.event;

/**
 * Created by nidhin on 13/12/17.
 */

public class NetworkEvent extends BaseRxEvent {
    boolean isConnected = true;

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }
}
