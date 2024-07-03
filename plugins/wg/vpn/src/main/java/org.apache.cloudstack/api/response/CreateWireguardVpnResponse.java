package org.apache.cloudstack.api.response;

import com.cloud.serializer.Param;
import org.apache.cloudstack.api.ApiConstants;
import org.apache.cloudstack.api.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class CreateWireguardVpnResponse extends BaseResponse {

    @SerializedName(ApiConstants.ID)
    @Param(description = "the id of the wg vpn")
    private String id;

    @SerializedName(ApiConstants.PUBLIC_IP_ID)
    @Param(description = "the public ip address of the vpn server")
    private String publicIpId;

    @SerializedName(ApiConstants.PUBLIC_IP)
    @Param(description = "the public ip address of the vpn server")
    private String publicIp;

    @SerializedName("iprange")
    @Param(description = "the range of ips to allocate to the clients")
    private String ipRange;

    @SerializedName("serverpublickey")
    @Param(description = "the wg server public key", isSensitive = true)
    private String serverPublicKey;

    @SerializedName(ApiConstants.STATE)
    @Param(description = "the state of the rule")
    private String state;

    @SerializedName(ApiConstants.PROJECT_ID)
    @Param(description = "the project id of the vpn")
    private String projectId;

    @SerializedName(ApiConstants.PROJECT)
    @Param(description = "the project name of the vpn")
    private String projectName;

    @SerializedName(ApiConstants.ACCOUNT)
    @Param(description = "the account of the wg vpn")
    private String accountName;

    @SerializedName(ApiConstants.DOMAIN_ID)
    @Param(description = "the domain id of the account of the remote access vpn")
    private String domainId;

    @SerializedName(ApiConstants.DOMAIN)
    @Param(description = "the domain name of the account of the remote access vpn")
    private String domainName;


    public void setId(String id) {
        this.id = id;
    }

    public void setPublicIpId(String publicIpId) {
        this.publicIpId = publicIpId;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }

    public void setIpRange(String ipRange) {
        this.ipRange = ipRange;
    }

    public void setServerPublicKey(String serverPublicKey) {
        this.serverPublicKey = serverPublicKey;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
}
