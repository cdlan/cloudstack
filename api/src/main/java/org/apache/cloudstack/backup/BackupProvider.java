//Licensed to the Apache Software Foundation (ASF) under one
//or more contributor license agreements.  See the NOTICE file
//distributed with this work for additional information
//regarding copyright ownership.  The ASF licenses this file
//to you under the Apache License, Version 2.0 (the
//"License"); you may not use this file except in compliance
//the License.  You may obtain a copy of the License at
//
//http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing,
//software distributed under the License is distributed on an
//"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
//KIND, either express or implied.  See the License for the
//specific language governing permissions and limitations
//under the License.
package org.apache.cloudstack.backup;

import java.util.List;
import java.util.Map;

import com.cloud.utils.Pair;
import com.cloud.vm.VirtualMachine;

public interface BackupProvider {

    /**
     * Returns the unique name of the provider
     * @return returns provider name
     */
    String getName();

    /**
     * Returns description about the backup and recovery provider plugin
     * @return returns description
     */
    String getDescription();

    /**
     * Returns the list of existing backup policies on the provider
     * @return backup policies list
     */
    List<BackupOffering> listBackupOfferings(Long zoneId);

    /**
     * True if a backup offering exists on the backup provider
     */
    boolean isValidProviderOffering(Long zoneId, String uuid);

    /**
     * Assign a VM to a backup offering or policy
     * @param vm the machine to back up
     * @param backupOffering the SLA definition for the backup
     * @return succeeded?
     */
    boolean assignVMToBackupOffering(VirtualMachine vm, BackupOffering backupOffering);

    /**
     * Removes a VM from a backup offering or policy
     * @param vm the machine to stop backing up
     * @return succeeded?
     */
    boolean removeVMFromBackupOffering(VirtualMachine vm);

    /**
     * Whether the provider will delete backups on removal of VM from the offering
     * @return boolean result
     */
    boolean willDeleteBackupsOnOfferingRemoval();

    /**
     * Starts and creates an adhoc backup process
     * for a previously registered VM backup
     * @param vm the machine to make a backup of
     * @return the result and {code}Backup{code} {code}Object{code}
     */
    Pair<Boolean, Backup> takeBackup(VirtualMachine vm);

    /**
     * Delete an existing backup
     * @param backup The backup to exclude
     * @param forced Indicates if backup will be force removed or not
     * @return succeeded?
     */
    boolean deleteBackup(Backup backup, boolean forced);

    /**
     * Restore VM from backup
     */
    boolean restoreVMFromBackup(VirtualMachine vm, Backup backup);

    /**
     * Restore a volume from a backup
     */
    Pair<Boolean, String> restoreBackedUpVolume(Backup backup, String volumeUuid, String hostIp, String dataStoreUuid, Pair<String, VirtualMachine.State> vmNameAndState);

    /**
     * Returns backup metrics for a list of VMs in a zone
     * @param zoneId the zone for which to return metrics
     * @param vms a list of machines to get measurements for
     * @return a map of machine -> backup metrics
     */
    Map<VirtualMachine, Backup.Metric> getBackupMetrics(Long zoneId, List<VirtualMachine> vms);

    /**
     * This method should TODO
     * @param vm the machine to get restore point for
     */
    List<Backup.RestorePoint> listRestorePoints(VirtualMachine vm);

    /**
     * This method should TODO
     * @param restorePoint the restore point to create a backup for
     * @param vm The machine for which to create a backup
     * @param metric the metric object to update with the new backup data
     */
    Backup createNewBackupEntryForRestorePoint(Backup.RestorePoint restorePoint, VirtualMachine vm, Backup.Metric metric);
}
