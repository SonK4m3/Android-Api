package mvvm.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel(): ViewModel() {
    private val _data = MutableLiveData<String>()

    val data: LiveData<String>
        get() = _data

    fun fetchData() {
        // fetch data from a remote server or local database
        val result = "Hello World"

        // update LiveData
        _data.postValue(result)
    }
}