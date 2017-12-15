package com.sf.tinker.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.sf.tinker.R
import com.sf.tinker.ui.MainActivity
import com.sf.tinker.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {
    override fun injectContentView() {

    }

    override fun toMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun toastUserNameInvalid() {
        Toast.makeText(applicationContext, "用户名不合法", Toast.LENGTH_LONG).show()
    }

    override fun initViewData() {

    }

    override fun initListener() {
        btnLogin.setOnClickListener {
            mPresenter.login(textUserName.text.toString(), textPassword.text.toString())
        }
    }

    override fun createPresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
