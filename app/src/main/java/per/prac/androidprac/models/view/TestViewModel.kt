package per.prac.androidprac.models.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel(
    var max: Int
) : ViewModel() {

    var viewData = MutableLiveData<Int>()

    init {
        viewData.value = 1
    }

    fun plusAndJudge(n: Int): Boolean {
        viewData.value = (viewData.value)?.plus(n)
        return viewData.value!! >= max
    }

    fun minusAndJudge(n: Int): Boolean {
        viewData.value = (viewData.value)?.minus(n)
        return viewData.value!! <= 1
    }
}