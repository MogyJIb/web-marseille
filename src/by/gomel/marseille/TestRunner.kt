package by.gomel.marseille

import by.gomel.marseille.domain.Injector

fun main(vararg args: String) {
    Injector.provideGetGoodsUseCase()().forEach { println(it) }
}