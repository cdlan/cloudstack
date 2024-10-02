package org.apache.cloudstack.wireguard.model;

import com.cloud.utils.db.Encrypt;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;

@Entity
@Table(name="wg_vpn")
public class VpnVO implements Vpn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "local_ip")
    private String localIp;

    @Column(name = "prefix")
    private int prefix;

    @Encrypt
    @Column(name = "server_private_key")
    private String serverPrivateKey;

    @Column(name = "server_public_key")
    private String serverPublicKey;

    @Column(name = "state")
    private Vpn.State state;

    @Column(name = "vpn_server_addr_id")
    private long serverAddressId;

    @Column(name = "account_id")
    private long accountId;

    @Column(name = "domain_id")
    private long domainId;

    @Column(name = "network_id")
    private long networkId;

    public VpnVO() {
        this.uuid = UUID.randomUUID().toString();
    }

    public VpnVO(String localIp, int prefix, String serverPrivateKey, String serverPublicKey, long serverAddressId, long accountId, long domainId, Long networkId) {
        this.uuid = UUID.randomUUID().toString();
        this.localIp = localIp;
        this.prefix = prefix;
        this.serverPrivateKey = serverPrivateKey;
        this.serverPublicKey = serverPublicKey;
        this.state = State.Added;
        this.serverAddressId = serverAddressId;
        this.accountId = accountId;
        this.domainId = domainId;
        this.networkId = networkId;
    }

    public long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getLocalIp() {
        return localIp;
    }

    public int getPrefix() {
        return prefix;
    }

    public String getServerPrivateKey() {
        return serverPrivateKey;
    }

    public String getServerPublicKey() {
        return serverPublicKey;
    }

    public State getState() {
        return state;
    }

    public long getServerAddressId() {
        return serverAddressId;
    }

    public long getAccountId() {
        return accountId;
    }

    public long getDomainId() {
        return domainId;
    }

    public long getNetworkId() {
        return networkId;
    }

    public String getName() {
        return null;
    }

    public Class<?> getEntityType() {
        return VpnVO.class;
    }
}
