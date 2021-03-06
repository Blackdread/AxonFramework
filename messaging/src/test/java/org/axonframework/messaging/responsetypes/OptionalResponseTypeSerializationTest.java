/*
 * Copyright (c) 2010-2019. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.messaging.responsetypes;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

import org.axonframework.serialization.TestSerializer;

/**
 * Tests serialization capabilities of {@link OptionalResponseType}.
 * 
 * @author JohT
 */
@RunWith(Parameterized.class)
public class OptionalResponseTypeSerializationTest
        extends AbstractResponseTypeTest<Optional<AbstractResponseTypeTest.QueryResponse>> {

    private final TestSerializer serializer;

    public OptionalResponseTypeSerializationTest(TestSerializer serializer) {
        super(new OptionalResponseType<>(QueryResponse.class));
        this.serializer = serializer;
    }

    @Parameterized.Parameters(name = "{index} {0}")
    public static Collection<TestSerializer> serializers() {
        return TestSerializer.all();
    }

    @Test
    public void testResponseTypeShouldBeSerializable() {
        assertEquals(testSubject.getExpectedResponseType(), serializer.serializeDeserialize(testSubject).getExpectedResponseType());
    }
}