package com.gokimpark.instaclone.domain.usecase

import com.gokimpark.instaclone.domain.model.User
import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.gokimpark.instaclone.domain.model.viewitem.Thumbnail
import com.gokimpark.instaclone.domain.repository.ProfileRepository
import com.gokimpark.instaclone.domain.repository.GalleryRepository
import javax.inject.Inject

class ProfileUseCaseImpl @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val galleryRepository: GalleryRepository
) : ProfileUseCase {

    override fun getProfile(user: User, callback: (Profile) -> Unit, errorCallback: (String) -> Unit) = when {
        user.profilePath.isNotEmpty() -> profileRepository.getProfileByPath(user.profilePath, callback, errorCallback)
        else -> profileRepository.getProfileByUserName(user.userName, callback, errorCallback)
    }

    override suspend fun getTabContents(tab: Profile.Tab): List<Thumbnail> {
        return galleryRepository.getThumbnails(tab.contentUrl)
    }

}