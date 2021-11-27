package com.gokimpark.instaclone.domain.usecase

import com.gokimpark.instaclone.domain.model.User
import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.gokimpark.instaclone.domain.model.viewitem.Thumbnail

interface ProfileUseCase {

    fun getProfile(user: User, callback: (Profile) -> Unit, errorCallback: (String) -> Unit)

    suspend fun getTabContents(tab: Profile.Tab): List<Thumbnail>

}