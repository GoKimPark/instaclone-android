package com.gokimpark.instaclone.domain.usecase

import com.gokimpark.instaclone.domain.model.User
import com.gokimpark.instaclone.domain.model.viewitem.Profile

interface ProfileUseCase {

    fun getProfile(user: User, callback: (Profile) -> Unit, errorCallback: (String) -> Unit)

}