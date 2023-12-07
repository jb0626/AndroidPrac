package per.prac.androidprac.models.network.res

import com.google.gson.annotations.SerializedName
import per.prac.androidprac.models.network.BaseRes

data class Repository(
    @SerializedName("id") var id: Int,
    @SerializedName("private") var private: Boolean,
    @SerializedName("name") var name: String,
    @SerializedName("full_name") var fullName: String,
    @SerializedName("html_url") var htmlUrl: String
) : BaseRes()
