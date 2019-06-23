package by.gomel.marseille.domain

import com.google.gson.Gson
import com.google.gson.GsonBuilder


object Injector {

    private var gson: Gson? = null
    fun provideGson() = gson ?: GsonBuilder().create().also { gson = it }

    private var getGoodsUseCase: GetGoodsUseCase? = null
    fun provideGetGoodsUseCase() = getGoodsUseCase ?: GetGoodsUseCase(provideGson()).also { getGoodsUseCase = it }

    private var getEmployeesUseCase: GetEmployeesUseCase? = null
    fun provideGetEmployeesUseCase() = getEmployeesUseCase ?: GetEmployeesUseCase(provideGson()).also { getEmployeesUseCase = it }

    private var getServicesUseCase: GetServicesUseCase? = null
    fun provideGetServicesUseCase() = getServicesUseCase ?: GetServicesUseCase(provideGson()).also { getServicesUseCase = it }

    private var getCpompanyAboutUseCase: GetCpompanyAboutUseCase? = null
    fun provideGetCpompanyAboutUseCase() = getCpompanyAboutUseCase ?: GetCpompanyAboutUseCase(provideGson()).also { getCpompanyAboutUseCase = it }

}