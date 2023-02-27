package json2data

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("full-name") var name: String,
    var age: Int,
    var id: String) {

}
