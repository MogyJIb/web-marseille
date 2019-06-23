package by.gomel.marseille.data

import java.io.Serializable


data class Employee (
        var category: ServiceCategory,
        var name: String,
        var position: String,
        var imageUrl: String
): Serializable {

    constructor() : this(ServiceCategory.HAIR, "", "",  "")

}