package com.gokimpark.instaclone.domain.usecase

import com.gokimpark.instaclone.domain.model.viewitem.Profile

interface ProfileUseCase {

    fun getProfile(userName: String, callback: (Profile) -> Unit, errorCallback: (String) -> Unit)

}