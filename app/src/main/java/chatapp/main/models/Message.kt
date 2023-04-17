package chatapp.main.models

class Message() {
    var id: Int
    var content: String
    var time: String
    var isSeen: Int
    init {
        id = 1
        content = "What’s man!"
        time = ". 4:30 PM"
        isSeen = 2
    }
}