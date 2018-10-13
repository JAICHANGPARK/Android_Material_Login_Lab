package login.dreamwalker.com.signupandsignin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_button.setOnClickListener {
            if (!isPasswordValid(password_edt.text!!)) {
                password_text_input.error = "error"

            } else {
                password_text_input.error = null
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        password_edt.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(password_edt.text!!)) {
                password_text_input.error = null
            }
            false
        }

        cancel_button.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }


    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }


}
