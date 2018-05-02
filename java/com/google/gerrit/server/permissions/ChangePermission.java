// Copyright (C) 2017 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.server.permissions;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gerrit.extensions.api.access.GerritPermission;

public enum ChangePermission implements ChangePermissionOrLabel {
  READ,
  RESTORE,
  DELETE,
  ABANDON,
  EDIT_ASSIGNEE,
  EDIT_DESCRIPTION,
  EDIT_HASHTAGS,
  EDIT_TOPIC_NAME,
  REMOVE_REVIEWER,
  ADD_PATCH_SET,
  REBASE,
  SUBMIT,
  SUBMIT_AS("submit on behalf of other users");

  private final String description;

  ChangePermission() {
    this.description = null;
  }

  ChangePermission(String description) {
    this.description = checkNotNull(description);
  }

  @Override
  public String describeForException() {
    return description != null ? description : GerritPermission.describeEnumValue(this);
  }
}