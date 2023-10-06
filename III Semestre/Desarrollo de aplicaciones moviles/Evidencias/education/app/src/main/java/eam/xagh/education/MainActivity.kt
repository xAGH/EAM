package eam.xagh.education

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.Serializable

data class Student(val name: String) : Serializable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val studentName: String = getString(R.string.studentName)
        val button: Button = findViewById(R.id.btnLanzarActividad)
        button.setOnClickListener {
            val intent = Intent(this, ObjectActivity::class.java)
            intent.putExtra("student", Student(studentName))
            startActivity(intent)
        }

    }
}