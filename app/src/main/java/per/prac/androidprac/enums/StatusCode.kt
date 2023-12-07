package per.prac.androidprac.enums

import com.google.gson.stream.MalformedJsonException
import java.net.ConnectException
import java.net.SocketTimeoutException

enum class StatusCode(
    var code: Int,
    var message: String
) {
    S_SUCCESS(0, "SUCCESS"),

    E_MALFORM_JSON(996, "JSON형식 오류"),
    E_NET_CONNECT_FAIL(997, "연결실패"),
    E_NET_TIME_OUT(998, "시간초과"),
    E_UNKNOWN(999, "알 수 없는 에러"),

    ;

    companion object {
        fun getCodeByThrowable(t: Throwable) = when (t) {
            is SocketTimeoutException -> E_NET_TIME_OUT
            is ConnectException -> E_NET_CONNECT_FAIL
            is MalformedJsonException -> E_MALFORM_JSON
            else -> E_UNKNOWN
        }

        fun getCodeByCode(code: Int): StatusCode {
            StatusCode.values().forEach {
                if (it.code == code) {
                    return it
                }
            }
            return E_UNKNOWN
        }
    }

}