package com.gokimpark.instaclone.data.repositoryimpl

import com.android.volley.RequestQueue
import com.android.volley.toolbox.RequestFuture
import com.gokimpark.instaclone.data.datasource.GalleryJsonRequest
import com.gokimpark.instaclone.domain.model.viewitem.Thumbnail
import com.gokimpark.instaclone.domain.repository.GalleryRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutionException

class GalleryRepositoryImpl(
    private val requestQueue: RequestQueue,
    private val gson: Gson
) : GalleryRepository {

    override suspend fun getThumbnails(url: String): List<Thumbnail> {
        val future = RequestFuture.newFuture<List<Thumbnail>>()
        val request = GalleryJsonRequest(gson, url, future::onResponse, future::onErrorResponse)
        requestQueue.add(request)
        return withContext(Dispatchers.IO) {
            try {
                future.get()
            } catch (exc: InterruptedException) {
                emptyList()
            } catch (exc: ExecutionException) {
                emptyList()
            }
        }
    }

}