package com.example.myevent.di

import com.example.myevent.network.MyEventApi
import com.example.myevent.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(
//        tokenInterceptor: TokenInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
//            .addInterceptor(tokenInterceptor)
            .build()
    }


    @Singleton
    @Provides
    fun provideKhoEventsAPI(okHttpClient: OkHttpClient): MyEventApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MyEventApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun providesUserPreferencesDataStore(
//        @ApplicationContext context: Context,
//        @Dispatcher(NiaDispatchers.IO) ioDispatcher: CoroutineDispatcher,
//        @ApplicationScope scope: CoroutineScope,
//        userPreferencesSerializer: UserPreferencesSerializer,
//    ): DataStore<UserPreferences> =
//        DataStoreFactory.create(
//            serializer = userPreferencesSerializer,
//            scope = CoroutineScope(scope.coroutineContext + ioDispatcher),
////            migrations = listOf(
////                IntToStringIdsMigration,
////            ),
//        ) {
//            context.dataStoreFile("user_preferences.json")
//        }

//    @Singleton
//    @Provides
//    fun provideUerDataRepository(
//        userDataRepository: UserDataRepositoryImpl
//    ): UserDataRepository {
//        return userDataRepository
//    }

}

