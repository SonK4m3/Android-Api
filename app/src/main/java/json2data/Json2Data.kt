package json2data

import com.google.gson.Gson

class Json2Data {

    val gson = Gson()
    val json = """{"full-name":"SONNH","age":21,"id":"B20DCVT311"}"""
    val person = gson.fromJson(json, Student::class.java)

    fun Destructing(){
        val (_name, _age, _id) = person
        println(_name + "-" + _age + "-" + _id)
    }
}