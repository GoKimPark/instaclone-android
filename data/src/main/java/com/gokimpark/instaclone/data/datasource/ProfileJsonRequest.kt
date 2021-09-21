package com.gokimpark.instaclone.data.datasource

import com.android.volley.NetworkResponse
import com.android.volley.Response
import com.android.volley.toolbox.JsonRequest
import com.gokimpark.instaclone.data.dto.ProfileDto
import com.gokimpark.instaclone.data.dto.ProfileResponseDto
import com.gokimpark.instaclone.data.mapper.toProfile
import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.google.gson.Gson

class ProfileJsonRequest(
    private val gson: Gson,
    url: String,
    callback: (Profile) -> Unit,
    errorCallback: (message: String) -> Unit
) : JsonRequest<ProfileResponseDto>(
    Method.GET, url, null,
    Response.Listener { callback(it.profile.toProfile()) },
    Response.ErrorListener { errorCallback(it.message ?: "(No error message)") }
) {

    override fun parseNetworkResponse(response: NetworkResponse): Response<ProfileResponseDto> {
        val s = response.data.toString()
        val dto = gson.fromJson(s, ProfileResponseDto::class.java)
        return Response.success(dto, null)
    }

}