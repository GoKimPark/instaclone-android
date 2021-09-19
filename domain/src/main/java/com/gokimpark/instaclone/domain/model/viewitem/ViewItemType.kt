package com.gokimpark.instaclone.domain.model.viewitem

import kotlin.reflect.KClass


enum class ViewItemType(val model: KClass<out ViewItem>) {

    UNKNOWN(ViewItem::class),

    POST(Post::class),
    THUMBNAIL(Thumbnail::class),
    CAROUSEL(Carousel::class),
    PERSON_CARD(PersonCard::class),
    ;

}