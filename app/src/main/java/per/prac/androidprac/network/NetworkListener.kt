package per.prac.androidprac.network

import per.prac.androidprac.models.network.BaseRes

interface NetworkListener<TT : BaseRes> {

    fun onResponse(res: TT)

}