package per.prac.androidprac.network

import per.prac.androidprac.models.network.res.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkInterface {

    @GET("/repos/{owner}/{repo}")
    fun getRepository(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Call<Repository>

}