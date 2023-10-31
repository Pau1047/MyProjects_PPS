package com.example.myprojects_pps.coffeshops

data class InfoCoffe(
    var images: Int,
    var titles: String,
    var directions: String
)

fun getInfoCoffes(): List<InfoCoffe>{
    return listOf(
        InfoCoffe(
            R.drawable.images,
            "Antico Caffè Greco",
            "St. Italy, Rome"
        ),
        InfoCoffe(
            R.drawable.images1,
            "Coffee Room",
            "St. Germany, Berlin"
        ),
        InfoCoffe(
            R.drawable.images2,
            "Coffee Ibiza",
            "St. Colon, Madrid"
        ),
        InfoCoffe(
            R.drawable.images3,
            "Pudding Coffee Shop",
            "St. Diagonal, Barcelona"
        ),
        InfoCoffe(
            R.drawable.images4,
            "L'Express",
            "St. Picadilly Circus, London"
        ),
        InfoCoffe(
            R.drawable.images5,
            "Coffe Corner",
            "St. Àngel Guimerà, Valencia"
        ),
        InfoCoffe(
            R.drawable.images6,
            "Sweet Cup",
            "St. Kinkerstraat, Amsterdam"
        )
    )
}