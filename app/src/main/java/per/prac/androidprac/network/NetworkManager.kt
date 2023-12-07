package per.prac.androidprac.network

import okhttp3.OkHttpClient
import per.prac.androidprac.models.network.res.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkManager() {

    val BASE_URL: String = "https://api.github.com"

    val TIME_OUT: Long = 5L

    var service: NetworkInterface? = null

    init {
        val client = OkHttpClient.Builder()
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build()

        service = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkInterface::class.java)
    }

    fun getRepository(owner: String, repo: String, callback: ANetworkListener<Repository>) {
        service?.let {
            it.getRepository(owner, repo).enqueue(callback)
        }
    }

}