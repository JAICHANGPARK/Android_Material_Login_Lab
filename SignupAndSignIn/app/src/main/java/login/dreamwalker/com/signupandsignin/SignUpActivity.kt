package login.dreamwalker.com.signupandsignin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.toast
import org.jetbrains.anko.warn
import java.util.logging.Logger

class SignUpActivity : AppCompatActivity() {

    val log = AnkoLogger(this.javaClass)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        register_button.setOnClickListener {
            val username = username_edt.text.toString()
            val email = email_edt.text.toString()
            val password = password_edt.text.toString()
            val passwordAgain = password_check_edt.text.toString()
            var check = false

            log.warn { email }

            if (username.isEmpty()) {
                username_edt.error = "사용할 ID를 입력해주세요"
                check = true
            }

            if (!isEmailValid(email)) {
                email_edt.error = "올바른 E-mail 다시 입력"
                check = true
            }

            if (password.isEmpty()) {
                password_edt.error = "비밀번호는 공백일 수 없습니다."
                check = true
            }

            if (passwordAgain.isEmpty()) {
                password_check_edt.error = "비밀번호 확인은 공백일 수 없습니다."
                check = true
            }

            if (!isPasswordValid(password_edt.text)) {
                password_edt.error = "보안을 위해 비밀번호는 8자리 이상으로 해주세요."
                check = true
            }

            if (passwordEqualCheck(password, passwordAgain)) {
                log.error { "값이 같음" }
            } else {
                log.error { "값이 다름" }
                password_check_edt.error = "비밀번호가 다릅니다. 다시 확인해주세요"
                check = true
            }

            if (check) {
                toast("실패")
            } else {
                toast("등록 성공")
            }

        }


    }

    private fun isEmailValid(email: String): Boolean {
        //TODO: Replace this with your own logic
        return email.contains("@")
    }

    private fun passwordEqualCheck(origin: String, check: String): Boolean {
        if (origin.isNotEmpty() && check.isNotEmpty()) {
            return origin == check
        } else {
            return false
        }
    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }
}
