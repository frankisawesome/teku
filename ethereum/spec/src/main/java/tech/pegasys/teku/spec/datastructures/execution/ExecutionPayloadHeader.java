/*
 * Copyright 2021 ConsenSys AG.
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

package tech.pegasys.teku.spec.datastructures.execution;

import org.apache.tuweni.bytes.Bytes;
import org.apache.tuweni.bytes.Bytes32;
import org.apache.tuweni.units.bigints.UInt256;
import tech.pegasys.teku.infrastructure.bytes.Bytes20;
import tech.pegasys.teku.infrastructure.ssz.collections.SszByteList;
import tech.pegasys.teku.infrastructure.ssz.collections.SszByteVector;
import tech.pegasys.teku.infrastructure.ssz.containers.Container14;
import tech.pegasys.teku.infrastructure.ssz.containers.ContainerSchema14;
import tech.pegasys.teku.infrastructure.ssz.primitive.SszBytes32;
import tech.pegasys.teku.infrastructure.ssz.primitive.SszUInt256;
import tech.pegasys.teku.infrastructure.ssz.primitive.SszUInt64;
import tech.pegasys.teku.infrastructure.ssz.tree.TreeNode;
import tech.pegasys.teku.infrastructure.unsigned.UInt64;

public class ExecutionPayloadHeader
    extends Container14<
        ExecutionPayloadHeader,
        SszBytes32,
        SszByteVector,
        SszBytes32,
        SszBytes32,
        SszByteVector,
        SszBytes32,
        SszUInt64,
        SszUInt64,
        SszUInt64,
        SszUInt64,
        SszByteList,
        SszUInt256,
        SszBytes32,
        SszBytes32> {

  ExecutionPayloadHeader(
      ContainerSchema14<
              ExecutionPayloadHeader,
              SszBytes32,
              SszByteVector,
              SszBytes32,
              SszBytes32,
              SszByteVector,
              SszBytes32,
              SszUInt64,
              SszUInt64,
              SszUInt64,
              SszUInt64,
              SszByteList,
              SszUInt256,
              SszBytes32,
              SszBytes32>
          type,
      TreeNode backingNode) {
    super(type, backingNode);
  }

  ExecutionPayloadHeader(
      ExecutionPayloadHeaderSchema schema,
      SszBytes32 parentHash,
      SszByteVector feeRecipient,
      SszBytes32 stateRoot,
      SszBytes32 receiptsRoot,
      SszByteVector logsBloom,
      SszBytes32 random,
      SszUInt64 blockNumber,
      SszUInt64 gasLimit,
      SszUInt64 gasUsed,
      SszUInt64 timestamp,
      SszByteList extraData,
      SszUInt256 baseFeePerGas,
      SszBytes32 blockHash,
      SszBytes32 transactionsRoot) {
    super(
        schema,
        parentHash,
        feeRecipient,
        stateRoot,
        receiptsRoot,
        logsBloom,
        random,
        blockNumber,
        gasLimit,
        gasUsed,
        timestamp,
        extraData,
        baseFeePerGas,
        blockHash,
        transactionsRoot);
  }

  @Override
  public ExecutionPayloadHeaderSchema getSchema() {
    return (ExecutionPayloadHeaderSchema) super.getSchema();
  }

  public Bytes32 getParentHash() {
    return getField0().get();
  }

  public Bytes20 getFeeRecipient() {
    return Bytes20.leftPad(getField1().getBytes());
  }

  public Bytes32 getStateRoot() {
    return getField2().get();
  }

  public Bytes32 getReceiptsRoot() {
    return getField3().get();
  }

  public Bytes getLogsBloom() {
    return getField4().getBytes();
  }

  public Bytes32 getPrevRandao() {
    return getField5().get();
  }

  public UInt64 getBlockNumber() {
    return getField6().get();
  }

  public UInt64 getGasLimit() {
    return getField7().get();
  }

  public UInt64 getGasUsed() {
    return getField8().get();
  }

  public UInt64 getTimestamp() {
    return getField9().get();
  }

  public Bytes getExtraData() {
    return getField10().getBytes();
  }

  public UInt256 getBaseFeePerGas() {
    return getField11().get();
  }

  public Bytes32 getBlockHash() {
    return getField12().get();
  }

  public Bytes32 getTransactionsRoot() {
    return getField13().get();
  }
}
