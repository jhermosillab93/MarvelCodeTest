package com.example.marvelcodetest.ui.base

interface BaseMapper<A, B> {

    fun mapFrom(type: A?): B?

}