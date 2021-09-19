package com.gokimpark.instaclone.domain.repository

import com.gokimpark.instaclone.domain.model.viewitem.Profile

interface ProfileRepository {

    fun getProfile(userName: String, callback: (Profile) -> Unit, errorCallback: (String) -> Unit)

}