/*
 * Copyright 2020 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.storage.server.kvstore;

import java.io.File;
import tech.pegasys.teku.storage.server.DatabaseVersion;
import tech.pegasys.teku.storage.server.StateStorageMode;
import tech.pegasys.teku.storage.storageSystem.InMemoryStorageSystemBuilder;
import tech.pegasys.teku.storage.storageSystem.StorageSystem;
import tech.pegasys.teku.storage.store.StoreConfig;

public class InMemoryV6KvStoreDatabaseTest extends AbstractKvStoreDatabaseWithHotStatesTest {
  @Override
  protected StorageSystem createStorageSystem(
      final File tempDir,
      final StateStorageMode storageMode,
      final StoreConfig storeConfig,
      final boolean storeNonCanonicalBlocks) {
    return InMemoryStorageSystemBuilder.create()
        .specProvider(spec)
        .version(DatabaseVersion.V6)
        .storageMode(storageMode)
        .stateStorageFrequency(1L)
        .storeConfig(storeConfig)
        .storeNonCanonicalBlocks(storeNonCanonicalBlocks)
        .build();
  }
}
