/*
 * Copyright 2021 Sergio Belda Galbis
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

package com.sergiobelda.androidtodometer.mapper

import com.sergiobelda.androidtodometer.db.view.TaskProjectView
import com.sergiobelda.androidtodometer.model.TaskProject

object TaskProjectMapper {

    fun TaskProjectView.toDomain() = TaskProject(
        id = task.taskId,
        name = task.taskName,
        description = task.taskDescription,
        taskState = task.taskState,
        projectId = task.taskProjectId,
        projectName = projectName,
        tag = task.tag
    )
}
