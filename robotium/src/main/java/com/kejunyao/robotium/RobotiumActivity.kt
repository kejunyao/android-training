package com.kejunyao.robotium

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年02月10日
 */
class RobotiumActivity : AppCompatActivity() {

    companion object {
        private const val USER_NAME = "admin"
        private const val PASS_WORD = "123456"
    }

    private var  mAccountInputView: EditText? = null
    private var  mPasswordInputView: EditText? = null
    private var  mLoginButton: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robotium)
        mAccountInputView = findViewById(R.id.user_name)
        mPasswordInputView = findViewById(R.id.pass_word)
        mLoginButton = findViewById(R.id.login)

        mLoginButton!!.setOnClickListener {
            doLogin()
        }
    }

    private fun doLogin() {
        val success = USER_NAME == mAccountInputView?.text?.toString()?.trim()
                && PASS_WORD == mPasswordInputView?.text?.toString()?.trim();
        Toast.makeText(this, if (success) "登录成功" else "登录失败", Toast.LENGTH_LONG).show()
    }
}