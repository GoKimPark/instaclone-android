package com.gokimpark.instaclone.domain.repository

import com.gokimpark.instaclone.domain.model.viewitem.Thumbnail

interface GalleryRepository {

    suspend fun getThumbnails(url: String): List<Thumbnail>

}