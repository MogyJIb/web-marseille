package by.gomel.marseille.domain

import com.google.gson.Gson
import com.google.gson.GsonBuilder


object Injector {

    private var gson: Gson? = null
    fun provideGson() = gson ?: GsonBuilder().create().also { gson = it }

    private var getGoodsUseCase: GetGoodsUseCase? = null
    fun provideGetGoodsUseCase() = getGoodsUseCase ?: GetGoodsUseCase(provideGson()).also { getGoodsUseCase = it }

}