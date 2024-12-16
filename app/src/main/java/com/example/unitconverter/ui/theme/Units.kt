package com.example.unitconverter.ui.theme

enum class Length(val unit: String) {
    MILLIMETRE("millimeter"),
    CENTIMETRE("centimeter"),
    METER("meter"),
    KILOMETRE("kilometer"),
    INCH("inch"),
    FOOT("foot"),
    YARD("yard"),
    MILE("mile")
}

enum class Weight(val unit: String) {
    MILLIGRAM("milligram"),
    GRAM("gram"),
    KILOGRAM("kilogram"),
    OUNCE("ounce"),
    POUND("pound")
}

enum class Temperature(val unit: String) {
    CELSIUS("celsius"),
    FAHRENHEIT("Fahrenheit"),
    KELVIN("Kelvin")
}