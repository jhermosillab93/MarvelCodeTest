package com.example.marvelbusinessapi.client

import com.example.marvelbusinessapi.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class ApiClient {

    private var okBuilder = OkHttpClient.Builder()
        .addInterceptor{ chain -> return@addInterceptor addApiKeyToRequest(chain) }

    private var adapterBuilder = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())



    fun <S> createService(serviceClass: Class<S>): S {
            return adapterBuilder
            .client(okBuilder.build())
            .build()
            .create(serviceClass)
    }

    private fun addApiKeyToRequest(chain: Interceptor.Chain): Response {
        val publicKey = BuildConfig.PUBLIC_KEY
        val privateKey = BuildConfig.PRIVATE_KEY
        val ts = Timestamp(System.currentTimeMillis()).time.toString()
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url
        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", getHash("$ts$privateKey$publicKey"))
            .addQueryParameter("ts", ts).build()
        request.url(newUrl)
        return chain.proceed(request.build())
    }

    private fun getHash(input: String): String {
       val md = MessageDigest.getInstance("MD5")
        return  BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}