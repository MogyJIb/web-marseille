package by.gomel.marseille.domain

import by.gomel.marseille.data.Service
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File


class GetServicesUseCase(
        private val gson: Gson
) {

    operator fun invoke(): List<Service> {
        val listType = object : TypeToken<List<Service>>() { }.type
        return gson.fromJson<List<Service>>(File(this::class.java.classLoader.getResource("services.json").toURI()).readText(), listType)
    }

}