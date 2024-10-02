package org.apache.cloudstack.wireguard.model;

import org.apache.cloudstack.acl.ControlledEntity;
import org.apache.cloudstack.api.Identity;
import org.apache.cloudstack.api.InternalIdentity;

public interface Vpn extends ControlledEntity, InternalIdentity, Identity {

    enum State {
        Added, Running, Removed
    }

    String getLocalIp();

    int getPrefix();

    String getServerPrivateKey();

    String getServerPublicKey();

    State getState();

    long getServerAddressId();

    long getNetworkId();

}
