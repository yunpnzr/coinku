package com.cryptoapp.project_cryptoapp.data.source.network.model.detailcrypto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CommunityData(
    @SerializedName("facebook_likes")
    val facebookLikes: Any?,
    @SerializedName("reddit_accounts_active_48h")
    val redditAccountsActive48h: Int?,
    @SerializedName("reddit_average_comments_48h")
    val redditAverageComments48h: Int?,
    @SerializedName("reddit_average_posts_48h")
    val redditAveragePosts48h: Int?,
    @SerializedName("reddit_subscribers")
    val redditSubscribers: Int?,
    @SerializedName("telegram_channel_user_count")
    val telegramChannelUserCount: Any?,
    @SerializedName("twitter_followers")
    val twitterFollowers: Int?
)