package vcmsa.ci.qualifybursary

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val userGrade: EditText = findViewById(R.id.entrGrade)
        val userSport: EditText = findViewById(R.id.entrSport)
        val decide: Button = findViewById(R.id.btnDecide)
        val answer: TextView = findViewById(R.id.tvEligible)

        decide.setOnClickListener {
            if (userGrade.text.toString().toInt() >= 75) {
                answer.text = "Eligible for Academic Bursary"

            } else {
                answer.text = "Ineligible for Academic Bursary"
            }

            decide.setOnClickListener {
                if (userGrade.text.toString().toInt() >= 75 && userSport.text.toString() == "yes") {
                    answer.text = "Eligible for Sports Bursary"

                } else {
                    answer.text = "Ineligible for Sports Bursary"
                }

            }
        }
    }
}