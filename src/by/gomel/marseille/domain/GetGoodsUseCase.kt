package by.gomel.marseille.domain

import by.gomel.marseille.data.Goods
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File


class GetGoodsUseCase(
        private val gson: Gson
) {

    operator fun invoke(): List<Goods> {
        val listType = object : TypeToken<List<Goods>>() { }.type
        return gson.fromJson<List<Goods>>(File(this::class.java.classLoader.getResource("goods.json").toURI()).readText(), listType)
    }

}