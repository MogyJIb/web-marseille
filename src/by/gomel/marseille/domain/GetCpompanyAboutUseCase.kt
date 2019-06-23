package by.gomel.marseille.domain

import by.gomel.marseille.data.CompanyAboutDto
import com.google.gson.Gson
import java.io.File


class GetCpompanyAboutUseCase(
        private val gson: Gson
) {

    operator fun invoke(): CompanyAboutDto {
        return gson.fromJson<CompanyAboutDto>(File(this::class.java.classLoader.getResource("company_about.json").toURI()).readText(), CompanyAboutDto::class.java)
    }

}