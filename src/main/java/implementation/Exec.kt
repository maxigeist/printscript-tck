package implementation

import app.Validate

class Exec{
    fun execute(src: String, version: String){
        Validate()
            .main(listOf(src, version))
    }
}