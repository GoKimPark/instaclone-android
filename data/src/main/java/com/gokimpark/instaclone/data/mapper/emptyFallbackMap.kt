package com.gokimpark.instaclone.data.mapper


fun <E, R> List<E>?.emptyFallbackMap(transform: (E) -> R) = this?.map(transform) ?: emptyList()