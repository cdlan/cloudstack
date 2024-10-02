package org.apache.cloudstack.wireguard.dao;


import com.cloud.utils.db.GenericDaoBase;
import com.cloud.utils.db.SearchBuilder;
import com.cloud.utils.db.SearchCriteria;
import org.apache.cloudstack.wireguard.model.Vpn;
import org.apache.cloudstack.wireguard.model.VpnVO;
import org.apache.log4j.Logger;

import java.util.List;

public class VpnDaoImpl extends GenericDaoBase<VpnVO, Long> implements VpnDao {

    private static final Logger s_logger = Logger.getLogger(VpnDaoImpl.class);

    private final SearchBuilder<VpnVO> AllFieldsSearch;

    protected VpnDaoImpl() {
        AllFieldsSearch = createSearchBuilder();
        AllFieldsSearch.and("accountId", AllFieldsSearch.entity().getAccountId(), SearchCriteria.Op.EQ);
        AllFieldsSearch.and("networkId", AllFieldsSearch.entity().getNetworkId(), SearchCriteria.Op.EQ);
        AllFieldsSearch.and("ipAddress", AllFieldsSearch.entity().getServerAddressId(), SearchCriteria.Op.EQ);
        AllFieldsSearch.and("state", AllFieldsSearch.entity().getState(), SearchCriteria.Op.EQ);
        AllFieldsSearch.done();
    }


    @Override
    public VpnVO findByPublicIpAddress(long ipAddressId) {

        SearchCriteria<VpnVO> sc = AllFieldsSearch.create();
        sc.setParameters("ipAddressId", ipAddressId);

        return findOneBy(sc);
    }

    @Override
    public VpnVO findByPublicIpAddressAndState(long ipAddressId, Vpn.State state) {

        SearchCriteria<VpnVO> sc = AllFieldsSearch.create();
        sc.setParameters("ipAddressId", ipAddressId);
        sc.setParameters("state", state);

        return findOneBy(sc);
    }

    @Override
    public VpnVO findByAccountAndNetwork(Long accountId, Long networkId) {

        SearchCriteria<VpnVO> sc = AllFieldsSearch.create();
        sc.setParameters("accountId", accountId);
        sc.setParameters("networkId", networkId);

        return findOneBy(sc);
    }

    @Override
    public List<VpnVO> findByAccount(Long accountId) {

        SearchCriteria<VpnVO> sc = AllFieldsSearch.create();
        sc.setParameters("accountId", accountId);

        return listBy(sc);
    }

    @Override
    public List<VpnVO> listByNetworkId(Long networkId) {

        SearchCriteria<VpnVO> sc = AllFieldsSearch.create();
        sc.setParameters("networkId", networkId);

        return listBy(sc);
    }
}
