package by.gomel.marseille.data

import java.io.Serializable

data class Service (
        var category: ServiceCategory,
        var name: String,
        var minPrice: Double,
        var maxPrice: Double
): Serializable {
    val price: Double
        get() = if (maxPrice < 0) minPrice else maxPrice

    constructor() : this(ServiceCategory.HAIR, "", 0.0, 0.0)
}



enum class ServiceCategory(
        val title: String,
        val iconUrl: String
) {
    HAIR("Парикмахерские услуги", ""),
    MANICURE("Маникюр", "https://i.imgur.com/INtMaEo.jpg"),
    PEDICURE("Педикюр", ""),
    MAKE_UP("Макияж", ""),
    MAGIC_WHITE("Отбеливание зубов", ""),
    TOOL_SHARPENING("Заточка инструмента", "")
}