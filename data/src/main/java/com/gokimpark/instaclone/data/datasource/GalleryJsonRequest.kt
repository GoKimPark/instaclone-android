package com.gokimpark.instaclone.data.datasource

import android.util.Log
import com.android.volley.NetworkResponse
import com.android.volley.Response
import com.android.volley.toolbox.JsonRequest
import com.gokimpark.instaclone.data.dto.GalleryResponseDto
import com.gokimpark.instaclone.data.mapper.toThumbnail
import com.gokimpark.instaclone.domain.model.viewitem.Thumbnail
import com.google.gson.Gson


class GalleryJsonRequest(
    private val gson: Gson,
    url: String,
    callback: (List<Thumbnail>) -> Unit,
    errorListener: Response.ErrorListener
) : JsonRequest<GalleryResponseDto>(
    Method.GET, url, null,
    Response.Listener { callback(it.thumbnails.orEmpty().map { dto -> dto.toThumbnail() }) },
    errorListener
) {

    override fun parseNetworkResponse(response: NetworkResponse): Response<GalleryResponseDto> {
        val s = response.data.decodeToString()
        Log.d("thumbnail", s)
        val dto = gson.fromJson(s, GalleryResponseDto::class.java)
        return Response.success(dto, null)
    }

}