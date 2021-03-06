/*
 * Copyright 2015 the original author or authors.
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

package org.gradle.deployment.internal;

import net.jcip.annotations.ThreadSafe;
import org.gradle.internal.concurrent.Stoppable;

/**
 * A registry of deployment handles.
 */
@ThreadSafe
public interface DeploymentRegistry extends Stoppable {
    /**
     * Registers a given deployment handle in the registry.
     *
     * @return true if the given handle was registered; false if it was considered a duplicate (already registered)
     */
    boolean register(DeploymentHandle handle);

    /**
     * Retrieves a deployment handle from the registry with the given id and type.
     *
     * @return the registered deployment handle; null if no deployment is registered with the given id
     */
    <T extends DeploymentHandle> T get(Class<T> handleType, String id);
}
