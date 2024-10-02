package org.apache.cloudstack.wireguard.model;

public interface VpnUser {
    enum State {
        Add, Revoke, Active
    }

    String getName();

    String getIp();

    String getPublicKey();

    State getState();
}
