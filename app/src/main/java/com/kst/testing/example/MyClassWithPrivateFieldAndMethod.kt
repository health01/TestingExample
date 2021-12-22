package com.kst.testing.example

data class MyClassWithPrivateFieldAndMethod(
    var field1: String = "",
    var valueSetByPrivateMethod: String = "",
    private var hiddenField: String = "initial"
) {
    fun toBeMockedByMockito(): String {
        return "stuff"
    }

    private fun meineMethod() {
        valueSetByPrivateMethod = "lalal"
    }

    fun getHiddenValue(): String {
        return hiddenField
    }
}