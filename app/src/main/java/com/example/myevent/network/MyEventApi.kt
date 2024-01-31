package com.example.myevent.network


import com.example.myevent.model.AuthenticationRequest
import com.example.myevent.model.Community
import com.example.myevent.model.Event
import com.example.myevent.model.EventRequest
import com.example.myevent.model.ResponseStatus
import com.example.myevent.model.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface MyEventApi {

    @GET("communities")
    suspend fun getCommunities(): List<Community>

    @GET("events")
    suspend fun getEvents():List<Event>

    @GET("events/{id}")
    suspend fun getEventById(
        @Path("id") eventId: String
    ):Event

    @POST("auth/authenticate")
    suspend fun authenticateUser(@Body request: AuthenticationRequest): Response<TokenResponse>

    @POST("events/{id}")
    suspend fun createEvent(
        @Header("Authorization") authorizationHeader: String,
        @Path(value = "id") communityId: Long,
        @Body request: EventRequest
    ): Response<ResponseStatus>

    @GET("events/community/{id}")
    suspend fun getEventsByCommunityId(
        @Path(value = "id") communityId: Int
    ):List<Event>
}
