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

package com.sergiobelda.androidtodometer.repository

import com.sergiobelda.androidtodometer.db.dao.TaskDao
import com.sergiobelda.androidtodometer.mapper.TaskMapper.toDomain
import com.sergiobelda.androidtodometer.mapper.TaskMapper.toEntity
import com.sergiobelda.androidtodometer.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepository(private val taskDao: TaskDao) {

    fun getTask(id: Int): Flow<Task> = taskDao.getTask(id).map { it.toDomain() }

    suspend fun deleteTask(id: Int) = taskDao.deleteTask(id)

    suspend fun insert(task: Task) = taskDao.insertTask(task.toEntity())

    suspend fun setTaskDone(id: Int) = taskDao.setTaskDone(id)

    suspend fun setTaskDoing(id: Int) = taskDao.setTaskDoing(id)

    suspend fun updateTask(task: Task) = taskDao.updateTask(task.toEntity())
}
