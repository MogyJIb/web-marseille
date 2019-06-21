package by.gomel.marseille.data

import java.io.Serializable
import java.util.*


data class Goods (
        var category: GoodsCategory,
        var name: String,
        var price: Double,
        var imageUrl: String,
        var description: String,
        var ingredients: String,
        var formats: String,
        var use: String,
        var uid: String = UUID.randomUUID().toString()
): Serializable {

    constructor() : this(GoodsCategory.ISRAEL, "", 0.0, "","","","", "", "")

}



enum class GoodsCategory(
    val title: String
) {
    ISRAEL("Израиль"),
    ITALY("Италия")
}

