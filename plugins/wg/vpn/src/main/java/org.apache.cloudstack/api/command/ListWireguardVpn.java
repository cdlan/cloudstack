package org.apache.cloudstack.api.command;

import com.cloud.exception.*;
import org.apache.cloudstack.acl.RoleType;
import org.apache.cloudstack.api.*;
import org.apache.cloudstack.api.command.user.vpn.ListRemoteAccessVpnsCmd;
import org.apache.cloudstack.api.response.CreateWireguardVpnResponse;
import org.apache.cloudstack.api.response.IPAddressResponse;
import org.apache.cloudstack.api.response.NetworkResponse;
import org.apache.cloudstack.api.response.RemoteAccessVpnResponse;
import org.apache.log4j.Logger;

@APICommand(name = "listWireguardVpn",
        description = "My API short description here",
        responseObject = CreateWireguardVpnResponse.class,
        since = "4.19.1.0",
        requestHasSensitiveInfo = false, responseHasSensitiveInfo = true,
        authorized = {RoleType.Admin, RoleType.ResourceAdmin, RoleType.DomainAdmin, RoleType.User})
public class ListWireguardVpn extends BaseListProjectAndAccountResourcesCmd {

    public static final Logger s_logger = Logger.getLogger(ListWireguardVpn.class.getName());

    /////////////////////////////////////////////////////
    //////////////// API parameters /////////////////////
    /////////////////////////////////////////////////////
    @Parameter(name = ApiConstants.PUBLIC_IP_ID, type = BaseCmd.CommandType.UUID, entityType = IPAddressResponse.class, description = "public ip address id of the vpn server")
    private Long publicIpId;

    @Parameter(name = ApiConstants.ID,
            type = BaseCmd.CommandType.UUID,
            entityType = RemoteAccessVpnResponse.class,
            description = "Lists remote access vpn rule with the specified ID",
            since = "4.19.1.0")
    private Long id;

    @Parameter(name = ApiConstants.NETWORK_ID,
            type = BaseCmd.CommandType.UUID,
            entityType = NetworkResponse.class,
            description = "list remote access VPNs for certain network",
            since = "4.19.1.0")
    private Long networkId;

    /////////////////////////////////////////////////////
    /////////////////// Accessors ///////////////////////
    /////////////////////////////////////////////////////


    public Long getPublicIpId() {
        return publicIpId;
    }

    public Long getId() {
        return id;
    }

    public Long getNetworkId() {
        return networkId;
    }

    public void execute() throws ResourceUnavailableException, InsufficientCapacityException, ServerApiException, ConcurrentOperationException, ResourceAllocationException, NetworkRuleConflictException {

    }
}
