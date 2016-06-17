/*
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.iot.client.fuse.node.rules;

import java.util.List;

import com.amazonaws.services.iot.client.fuse.node.Node;

public class TopicRuleActionsNode extends Node {

    private static final String NODE_NAME = "actions";

    public TopicRuleActionsNode(Node parent) {
        super(parent, NODE_NAME, true);
    }

    @Override
    public void init() {
        synchronized (this) {
            List<TopicRuleActionNode> actionsNodes = iotClient.getTopicRuleActions(this, parent.getName());
            this.addChildren(actionsNodes);

            super.init();
        }
    }
    
}