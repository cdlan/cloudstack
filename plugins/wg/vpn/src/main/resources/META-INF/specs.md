# Specification

## Functional Spec

### APIs

| API                    | Arguments                                  | Description                            |
|------------------------|--------------------------------------------|----------------------------------------|
| createWireguardVpn     | publicipid, ?iprange, ?openfirewall, ?port | Creates wg VPN conf on server          |
| listWireguardVpn       | ?id, ?networkid                            | Lists wg vpn by id and/or network id   |
| deleteWireguardVpn     | id, publicipid                             | Removes wg vpn by id or ids            |
| createWireguardVpnUser | wgvpnid, peerpublickey, ?ipaddress         | Creates vpn user for given wg instance |
| listWireguardVpnUser   | ?wgvpnid                                   | List users for wg instance             |
| deleteWireguardVpnUser | ?wgusrid                                   | Delete user from wg instance           |

### DB Schema

Following tables should be added with appropriate DAO and VO classes:

- wg_vpn:
    - id: auto_increment ID for the table
    - uuid: the UUID for a wg instance
    - vpn_server_addr_id: the public IP of the GW
    - local_ip: address of the GW in the wg network
    - prefix: prefix for the wg network
    - server_private_kay:
    - server_public_key:
    - state: state of the resource
    - account_id: account id of the owner
    - domain_id: the domain ID
    - created: the creation timestamp
    - removed: the removal timestamp

- wg_user:
    - id: auto_increment ID for the table
    - uuid: the UUID for a wg instance
    - vpn_id: id of instance of wg_vpn
    - account_id:
    - domain_id:
    - public_key:
    - ip_address: 
    - state: state of the resource
    - created: the creation timestamp
    - removed: the removal timestamp

### Service Changes

### Client changes

### VR changes

### UI

### Testing

Create Marvin test for the API and features.

### Packaging

Make the feature and any of its plugins packaged separately as a separate
rpm/deb package.