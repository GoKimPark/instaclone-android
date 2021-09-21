package com.gokimpark.instaclone.data.repositoryimpl

import com.android.volley.RequestQueue
import com.android.volley.toolbox.RequestFuture
import com.gokimpark.instaclone.data.datasource.InstacloneApiConfigs
import com.gokimpark.instaclone.data.datasource.ProfileJsonRequest
import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.gokimpark.instaclone.domain.repository.ProfileRepository
import com.google.gson.Gson
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val requestQueue: RequestQueue,
    private val gson: Gson
) : ProfileRepository {

    override fun getProfileByUserName(userName: String, callback: (Profile) -> Unit, errorCallback: (String) -> Unit) {
        val url = "${InstacloneApiConfigs.PROFILE_SERVICE_URL}/${userName}"
        val request = ProfileJsonRequest(gson, url, callback, errorCallback)
        requestQueue.add(request)
    }


    override fun getProfileByPath(path: String, callback: (Profile) -> Unit, errorCallback: (String) -> Unit) {
        val url = "${InstacloneApiConfigs.BASE_URL}/${path}"
        val request = ProfileJsonRequest(gson, url, callback, errorCallback)
        requestQueue.add(request)
    }

}