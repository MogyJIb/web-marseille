package by.gomel.marseille.domain

import by.gomel.marseille.data.Employee
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File


class GetEmployeesUseCase(
        private val gson: Gson
) {

    operator fun invoke(): List<Employee> {
        val listType = object : TypeToken<List<Employee>>() { }.type
        return gson.fromJson<List<Employee>>(File(this::class.java.classLoader.getResource("employees.json").toURI()).readText(), listType)
    }

}