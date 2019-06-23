package by.gomel.marseille.data

import java.io.Serializable


data class CompanyAboutDto(
        var history: CompanyHistoryDto,
        var contacts: CompanyContactsDto
) : Serializable {

    constructor() : this(CompanyHistoryDto(), CompanyContactsDto())

}


data class CompanyHistoryDto(
        var content: String,
        var title: String
): Serializable {

    constructor() : this("", "")

}


data class CompanyContactsDto(
    var address: String,
    var imageUrl: String,
    var title: String,
    var mapTitle: String,
    var phoneNumbers: List<String>,
    var references: List<ContactReferenceDto>
): Serializable {

    constructor() : this("", "", "", "", emptyList(), emptyList())

}


data class ContactReferenceDto(
     var title: String,
     var imageUrl: String,
     var urlReference: String
): Serializable {

    constructor() : this("", "", "")

}
