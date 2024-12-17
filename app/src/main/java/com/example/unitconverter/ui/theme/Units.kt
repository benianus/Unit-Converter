package com.example.unitconverter.ui.theme

enum class Length(val unit: String) {
    MILLIMETRE("mm"),
    CENTIMETRE("cm"),
    METER("m"),
    KILOMETRE("km"),
    INCH("in"),
    FOOT("ft"),
    YARD("yd"),
    MILE("mi")
}

enum class Weight(val unit: String) {
    MILLIGRAM("mg"),
    GRAM("g"),
    KILOGRAM("kg"),
    OUNCE("oz"),
    POUND("lb")
}

enum class Temperature(val unit: String) {
    CELSIUS("c"),
    FAHRENHEIT("f"),
    KELVIN("k")
}