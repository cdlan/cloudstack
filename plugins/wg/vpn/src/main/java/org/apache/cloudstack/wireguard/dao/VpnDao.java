package org.apache.cloudstack.wireguard.dao;


import com.cloud.utils.db.GenericDao;
import org.apache.cloudstack.wireguard.model.Vpn;
import org.apache.cloudstack.wireguard.model.VpnVO;

import java.util.List;

public interface VpnDao extends GenericDao<VpnVO, Long> {

    VpnVO findByPublicIpAddress(long ipAddressId);
    VpnVO findByPublicIpAddressAndState(long ipAddressId, Vpn.State state);
    VpnVO findByAccountAndNetwork(Long accountId, Long networkId);
    List<VpnVO> findByAccount(Long accountId);
    List<VpnVO> listByNetworkId(Long networkId);
}
