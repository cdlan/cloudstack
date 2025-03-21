// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.cloud.vm.snapshot;

import java.util.List;

import org.apache.cloudstack.framework.config.ConfigKey;

import com.cloud.agent.api.RestoreVMSnapshotCommand;
import com.cloud.utils.component.Manager;
import com.cloud.vm.UserVmVO;
import com.cloud.vm.VMInstanceVO;

public interface VMSnapshotManager extends VMSnapshotService, Manager {

    static final ConfigKey<Integer> VMSnapshotExpireInterval = new ConfigKey<Integer>("Advanced", Integer.class, "vmsnapshot.expire.interval", "-1",
            "VM Snapshot expire interval in hours", true, ConfigKey.Scope.Account);

    ConfigKey<Integer> VMSnapshotMax = new ConfigKey<Integer>("Advanced", Integer.class, "vmsnapshot.max", "10", "Maximum vm snapshots for a single vm", true, ConfigKey.Scope.Global);

    /**
     * Delete all VM snapshots belonging to one VM
     * @param id, VM id
     * @param type,
     * @return true for success, false for failure
     */
    boolean deleteAllVMSnapshots(long id, VMSnapshot.Type type);

    /**
     * Sync VM snapshot state when VM snapshot in reverting or snapshoting or expunging state
     * Used for fullsync after agent connects
     *
     * @param vm, the VM in question
     * @param hostId
     * @return true if succeeds, false if fails
     */
    boolean syncVMSnapshot(VMInstanceVO vm, Long hostId);

    boolean hasActiveVMSnapshotTasks(Long vmId);

    RestoreVMSnapshotCommand createRestoreCommand(UserVmVO userVm, List<VMSnapshotVO> vmSnapshotVOs);

}
