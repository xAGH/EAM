package eam.xagh.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object)
        val student = intent.getSerializableExtra("student") as Student
        val text = findViewById<TextView>(R.id.studentName)
        val backBtn = findViewById<Button>(R.id.regresar)
        text.text = "El estudiante es ${student.name}";
        backBtn.setOnClickListener {
            finish()
        }
    }
}