package com.dsw.pam.takschedule.viewmodel.network

import com.dsw.pam.takschedule.model.Task
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

interface TaskApiService {
    suspend fun getTasks(): List<Task> // Do pobierania zadań
    suspend fun createTask(task: Task): Task // Do tworzenia nowego zadania
}

class TaskApiServiceImpl(private val client: HttpClient) : TaskApiService {
    override suspend fun getTasks(): List<Task> {
        val response: String = client.get("https://jsonplaceholder.typicode.com/posts").toString()
        return try {
            Json.decodeFromString(response) // Deserializacja odpowiedzi do List<Task>
        } catch (e: Exception) {
            emptyList() // Zwróć pustą listę w razie błędu
        }
    }

    override suspend fun createTask(task: Task): Task {
        val taskJson = Json.encodeToString(task)
        // Wysyłanie zapytania POST
        val response: String = client.post("https://jsonplaceholder.typicode.com/posts") {
            contentType(ContentType.Application.Json)
            setBody(taskJson) // Wysłanie obiektu zadania w ciele zapytania
        }.toString()
        return try {
            Json.decodeFromString(response) // Zwróć nowo utworzone zadanie po deserializacji
        } catch (e: Exception) {
            throw e // Jeśli wystąpi błąd, wyrzuć wyjątek
        }
    }
}
