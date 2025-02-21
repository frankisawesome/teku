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

package tech.pegasys.teku.test.acceptance;

import org.junit.jupiter.api.Test;
import tech.pegasys.teku.test.acceptance.dsl.AcceptanceTestBase;
import tech.pegasys.teku.test.acceptance.dsl.ExternalMetricNode;
import tech.pegasys.teku.test.acceptance.dsl.TekuNode;

public class ExternalMetricPublisherAcceptanceTest extends AcceptanceTestBase {
  private static final int VALIDATOR_COUNT = 8;

  @Test
  void shouldPublishDataFromPrometheus() throws Throwable {
    ExternalMetricNode externalMetricNode = createExternalMetricNode();
    externalMetricNode.start();

    final TekuNode tekuNode =
        createTekuNode(
            config ->
                config
                    .withExternalMetricsClient(externalMetricNode, 1)
                    .withInteropNumberOfValidators(VALIDATOR_COUNT));
    tekuNode.start();

    externalMetricNode.waitForBeaconNodeMetricPublication();
    externalMetricNode.waitForValidatorMetricPublication(VALIDATOR_COUNT);
    externalMetricNode.waitForSystemMetricPublication();

    tekuNode.stop();
    externalMetricNode.stop();
  }
}
