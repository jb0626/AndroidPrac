package per.prac.androidprac.network

import android.util.Log
import per.prac.androidprac.enums.StatusCode
import per.prac.androidprac.models.network.BaseRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
abstract class ANetworkListener<TT : BaseRes> : NetworkListener<TT>, Callback<TT> {

    var maxRetryCount: Int = 3

    var retryCount: Int = 0

    override fun onResponse(call: Call<TT>, response: Response<TT>) {
        Log.d("NETWORK", "CODE : ${response.code()}")
        val res = response.body() ?: BaseRes()

        if (response.isSuccessful) {
            res.isSuccess = true
            res.statusCode = StatusCode.S_SUCCESS
        } else {
            res.isSuccess = false
            res.statusCode = StatusCode.getCodeByCode(response.code())
        }

        onResponse(res as TT)
    }

    override fun onFailure(call: Call<TT>, t: Throwable) {
        if (retryCount < maxRetryCount) {
            Log.i("NETWORK", "Retry : ${retryCount}/${maxRetryCount}")
            retryCount++
            call.clone().enqueue(this)
        } else {
            val res = BaseRes()
            res.statusCode = StatusCode.getCodeByThrowable(t)
            onResponse(res as TT)
        }
    }
}