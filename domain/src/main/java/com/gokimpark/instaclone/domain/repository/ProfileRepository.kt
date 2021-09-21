package com.gokimpark.instaclone.domain.repository

import com.gokimpark.instaclone.domain.model.viewitem.Profile

interface ProfileRepository {

    fun getProfileByUserName(userName: String, callback: (Profile) -> Unit, errorCallback: (String) -> Unit)

    fun getProfileByPath(path: String, callback: (Profile) -> Unit, errorCallback: (String) -> Unit)

}