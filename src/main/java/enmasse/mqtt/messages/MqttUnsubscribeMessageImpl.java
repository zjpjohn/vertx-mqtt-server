/*
 * Copyright 2016 Red Hat Inc.
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

package enmasse.mqtt.messages;

import io.vertx.codegen.annotations.GenIgnore;

import java.util.List;

/**
 * Represents an MQTT UNSUBSCRIBE message
 */
public class MqttUnsubscribeMessageImpl implements MqttUnsubscribeMessage {

    private final int messageId;
    private final List<String> topics;

    /**
     * Constructor
     *
     * @param messageId message identifier
     * @param topics    list of topics to unsubscribe
     */
    public MqttUnsubscribeMessageImpl(int messageId, List<String> topics) {

        this.messageId = messageId;
        this.topics = topics;
    }

    /**
     * Create a Vert.x unsubscribe message starting from a Netty one
     *
     * @param msg   Netty unsubscribe message instance
     * @return  instance of Vert.x unsubscribe message
     */
    @GenIgnore
    static MqttUnsubscribeMessageImpl create(io.netty.handler.codec.mqtt.MqttUnsubscribeMessage msg) {

        return new MqttUnsubscribeMessageImpl(msg.variableHeader().messageId(), msg.payload().topics());
    }

    public int messageId() { return this.messageId; }

    public List<String> topics() { return this.topics; }
}
