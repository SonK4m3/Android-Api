package chatapp.main.models

class Friend(var id: Int, var name: String, var avatar_url: String) {
    var messages: ArrayList<Message>? = null
    init {
        messages = ArrayList()
        messages!!.add(Message())
    }

}