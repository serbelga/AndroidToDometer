/*
 * Copyright 2020 Sergio Belda
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

package com.sergiobelda.androidtodometer.db

import androidx.room.TypeConverter
import com.sergiobelda.androidtodometer.model.Tag
import com.sergiobelda.androidtodometer.model.TaskState

// NOTE: each conversion must have two functions to convert A to B and B to A
// i.e. Tag to String and String to Tag
class Converters {
    @TypeConverter
    fun toString(tag: Tag?): String? {
        return tag?.name
    }

    @TypeConverter
    fun toTag(name: String?): Tag {
        return name?.let { enumValueOf<Tag>(it) } ?: Tag.OTHER
    }

    @TypeConverter
    fun toString(taskState: TaskState?): String? {
        return taskState?.name
    }

    @TypeConverter
    fun toTaskState(name: String): TaskState {
        return enumValueOf(name)
    }
}
