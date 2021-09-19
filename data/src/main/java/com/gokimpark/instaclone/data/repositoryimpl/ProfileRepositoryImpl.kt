package com.gokimpark.instaclone.data.repositoryimpl

import com.android.volley.NetworkResponse
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonRequest
import com.gokimpark.instaclone.data.datasource.InstacloneApiConfigs
import com.gokimpark.instaclone.data.dto.ProfileDto
import com.gokimpark.instaclone.data.mapper.toProfile
import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.gokimpark.instaclone.domain.repository.ProfileRepository
import com.google.gson.Gson

class ProfileRepositoryImpl(
    private val requestQueue: RequestQueue,
    private val gson: Gson
) : ProfileRepository {

    override fun getProfile(userName: String, callback: (Profile) -> Unit, errorCallback: (String) -> Unit) {
        val request = ProfileJsonRequest(userName, callback, errorCallback)
        requestQueue.add(request)
    }

    private inner class ProfileJsonRequest(
        userName: String, callback: (Profile) -> Unit, errorCallback: (message: String) -> Unit
    ) : JsonRequest<ProfileDto>(Method.GET, "$SERVICE_URL/$userName", null,
        Response.Listener { callback(it.toProfile()) },
        Response.ErrorListener { errorCallback(it.message ?: "(No error message)") }
    ) {

        override fun parseNetworkResponse(response: NetworkResponse): Response<ProfileDto> {
            val s = response.data.toString()
            val dto = gson.fromJson(s, ProfileDto::class.java)
            return Response.success(dto, null)
        }

    }

    companion object {

        private const val SERVICE_NAME = ""
        private const val SERVICE_URL = "${InstacloneApiConfigs.BASE_URL}/${SERVICE_NAME}"

    }

}