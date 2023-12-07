package per.prac.androidprac.models.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BtnViewModel : ViewModel() {

    var enableData = MutableLiveData<Boolean>()

    init {
        enableData.value = true
    }

}