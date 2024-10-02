package org.apache.cloudstack.wireguard.service;

import com.cloud.exception.NetworkRuleConflictException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.user.Account;
import com.cloud.utils.Pair;
import org.apache.cloudstack.api.command.user.vpn.ListRemoteAccessVpnsCmd;
import org.apache.cloudstack.api.command.user.vpn.ListVpnUsersCmd;
import org.apache.cloudstack.wireguard.model.Vpn;
import org.apache.cloudstack.wireguard.model.VpnUser;

import java.util.List;

public interface WireguardVpnService {

    Vpn createRemoteAccessVpn(long vpnServerAddressId, String localIp, boolean openFirewall) throws NetworkRuleConflictException;

    boolean destroyRemoteAccessVpnForIp(long ipId, Account caller, boolean forceCleanup) throws ResourceUnavailableException;

    Vpn startRemoteAccessVpn(long vpnServerAddressId, boolean openFirewall) throws ResourceUnavailableException;

    VpnUser addVpnUser(long vpnOwnerId, String userName, String password);

    boolean removeVpnUser(long vpnOwnerId, String userName, Account caller);

    List<? extends VpnUser> listVpnUsers(long vpnOwnerId, String userName);

    boolean applyVpnUsers(long vpnOwnerId, String userName, boolean forRemove) throws ResourceUnavailableException;

    boolean applyVpnUsers(long vpnOwnerId, String userName) throws ResourceUnavailableException;

    Pair<List<? extends Vpn>, Integer> searchForRemoteAccessVpns(ListRemoteAccessVpnsCmd cmd);

    Pair<List<? extends VpnUser>, Integer> searchForVpnUsers(ListVpnUsersCmd cmd);

    List<? extends Vpn> listRemoteAccessVpns(long networkId);

    Vpn getRemoteAccessVpn(long vpnAddrId);

    Vpn getRemoteAccessVpnById(long vpnId);

    Vpn updateRemoteAccessVpn(long id, String customId, Boolean forDisplay);
}
