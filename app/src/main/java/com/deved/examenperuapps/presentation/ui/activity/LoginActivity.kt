package com.deved.examenperuapps.presentation.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.deved.examenperuapps.R
import com.deved.examenperuapps.data.repository.LoginDataRepository
import com.deved.examenperuapps.domain.interactor.security.LoginUseCase
import com.deved.examenperuapps.presentation.di.ViewModelFactory
import com.deved.examenperuapps.presentation.mapper.UserMapper
import com.deved.examenperuapps.presentation.model.UserView
import com.deved.examenperuapps.presentation.ui.BaseActivity
import com.deved.examenperuapps.presentation.viewModel.LoginViewModel
import com.deved.examenperuapps.presentation.widget.ValidationInput
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    private lateinit var validationInput: ValidationInput
    private var loginViewModel: LoginViewModel? = null
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initConfig()
        events()
    }

    override fun onStart() {
        super.onStart()
        var status = loginViewModel?.isSign(mAuth)
        status?.let {
            if(it){
                goTo(MainActivity::class.java,true)
            }
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    private fun initConfig() {
        mAuth = FirebaseAuth.getInstance()
        viewModelFactory = ViewModelFactory(LoginUseCase(LoginDataRepository()), UserMapper())
        loginViewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        validationInput = ValidationInput()
    }

    private fun events() {
        btn_initSesionLogin.setOnClickListener {
            val userView = UserView(
                "", "", tv_userLogin.text?.toString()?.trim(),
                tv_passwordLogin.text?.toString()?.trim()
            )
            if (validateLogin(userView)
            ) {
                loginViewModel?.signInWithEmailAndPassword(userView)

            } else {
                validationInput.showError(application)
            }
        }

        tv_registerUserLogin.setOnClickListener {
            goTo(RegisterActivity::class.java, true)
        }
    }

    private fun validateLogin(userView: UserView): Boolean =
        (!userView.Email.equals("") && !userView.Password.equals(""))


}
