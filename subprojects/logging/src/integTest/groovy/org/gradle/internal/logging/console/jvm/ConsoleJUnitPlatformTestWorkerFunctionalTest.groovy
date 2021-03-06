/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.internal.logging.console.jvm

import org.gradle.util.Requires
import org.gradle.util.TestPrecondition

import static org.gradle.test.fixtures.junitplatform.JUnitPlatformTestRewriter.LATEST_JUPITER_VERSION

@Requires(TestPrecondition.JDK8_OR_LATER)
class ConsoleJUnitPlatformTestWorkerFunctionalTest extends AbstractConsoleJvmTestWorkerFunctionalTest {

    @Override
    String testAnnotationClass() {
        'org.junit.jupiter.api.Test'
    }

    @Override
    String testDependency() {
        "org.junit.jupiter:junit-jupiter-api:${LATEST_JUPITER_VERSION}','org.junit.jupiter:junit-jupiter-engine:${LATEST_JUPITER_VERSION}"
    }

    @Override
    String testFrameworkConfiguration() {
        """
            tasks.withType(Test) {
                useJUnitPlatform()
            }
        """
    }
}
