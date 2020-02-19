package com.deved.examenperuapps.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.deved.examenperuapps.R
import com.deved.examenperuapps.data.repository.LoginDataRepository
import com.deved.examenperuapps.domain.interactor.security.LoginUseCase
import com.deved.examenperuapps.domain.repository.LoginRepository
import com.deved.examenperuapps.presentation.di.ViewModelFactory
import com.deved.examenperuapps.presentation.mapper.UserMapper
import com.deved.examenperuapps.presentation.model.UserView
import com.deved.examenperuapps.presentation.ui.BaseActivity
import com.deved.examenperuapps.presentation.viewModel.LoginViewModel
import com.deved.examenperuapps.presentation.widget.ValidationInput
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    private lateinit var validationInput: ValidationInput

    private var loginViewModel: LoginViewModel? = null
    private lateinit var  viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initConfig()
        events()
    }

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    private fun initConfig() {
        viewModelFactory  = ViewModelFactory(LoginUseCase(LoginDataRepository()), UserMapper())
        loginViewModel = ViewModelProvider(this,viewModelFactory).get(LoginViewModel::class.java)
        validationInput = ValidationInput()
    }

    private fun events() {
        btn_initSesionLogin.setOnClickListener {
            if (validateLogin(
                    tv_userLogin.text?.toString()?.trim(),
                    tv_passwordLogin.text?.toString()?.trim()
                )
            ) {
                val userView = UserView("","","pradoulima@gmail.com","ed123")
                loginViewModel?.signInWithEmailAndPassword(userView)
            } else {
                validationInput.showError(application)
            }
        }

        tv_registerUserLogin.setOnClickListener {
            goTo(RegisterActivity::class.java, true)
        }
    }

    private fun validateLogin(user: String?, password: String?): Boolean =
        (!user.equals("") && !password.equals(""))


}
