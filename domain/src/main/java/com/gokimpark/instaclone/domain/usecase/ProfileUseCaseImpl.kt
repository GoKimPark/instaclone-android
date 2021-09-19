package com.gokimpark.instaclone.domain.usecase

import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.gokimpark.instaclone.domain.repository.ProfileRepository

class ProfileUseCaseImpl(
    private val profileRepository: ProfileRepository
) : ProfileUseCase {

    override fun getProfile(userName: String, callback: (Profile) -> Unit, errorCallback: (String) -> Unit) {
        return profileRepository.getProfile(userName, callback, errorCallback)
    }

}