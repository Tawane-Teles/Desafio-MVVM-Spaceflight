package com.spaceflight.network.response

import com.squareup.moshi.Json

data class NewResponse (
    @Json (name = "id")
    var id: String,
    @Json (name =  "featured")
    var featured:   Boolean?,
    @Json (name = "title")
    var 

)