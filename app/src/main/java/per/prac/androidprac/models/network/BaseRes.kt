package per.prac.androidprac.models.network

import per.prac.androidprac.enums.StatusCode

open class BaseRes {

    var isSuccess: Boolean = true
    var statusCode: StatusCode = StatusCode.S_SUCCESS

}