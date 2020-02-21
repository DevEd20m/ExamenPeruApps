package com.deved.examenperuapps.presentation.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.deved.examenperuapps.R
import com.deved.examenperuapps.data.repository.LoginDataRepository
import com.deved.examenperuapps.data.repository.RegisterDataRepository
import com.deved.examenperuapps.domain.interactor.security.LoginUseCase
import com.deved.examenperuapps.domain.interactor.security.RegisterUseCase
import com.deved.examenperuapps.domain.repository.LoginRepository
import com.deved.examenperuapps.domain.repository.RegisterRepository
import com.deved.examenperuapps.presentation.di.RegisterViewModelFactory
import com.deved.examenperuapps.presentation.di.ViewModelFactory
import com.deved.examenperuapps.presentation.mapper.UserMapper
import com.deved.examenperuapps.presentation.model.UserView
import com.deved.examenperuapps.presentation.ui.BaseActivity
import com.deved.examenperuapps.presentation.viewModel.LoginViewModel
import com.deved.examenperuapps.presentation.viewModel.RegisterViewModel
import com.deved.examenperuapps.presentation.widget.ValidationInput
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {
    private lateinit var validationInput: ValidationInput

    private lateinit var modelFactory: RegisterViewModelFactory
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initConfig()
        events()
    }

    override fun getLayout(): Int {
        return R.layout.activity_register
    }

    private fun initConfig() {
        modelFactory = RegisterViewModelFactory(RegisterUseCase(RegisterDataRepository()), UserMapper())
        registerViewModel = ViewModelProvider(this,modelFactory).get(RegisterViewModel::class.java)
        validationInput = ValidationInput()
    }

    private fun events() {
        btn_registerUserRegister.setOnClickListener {
            if (validateInputs(
                    tv_nameRegister.text?.toString()?.trim(),
                    tv_lastNameRegister.text?.toString()?.trim(),
                    tv_emailRegister.text?.toString()?.trim(),
                    tv_passwordRegister.text?.toString()?.trim()
                )
            ) {
                val userView = UserView("Edmundo","Prado","pradoulima@gmail.com","Ed123456")
                registerViewModel.registerUserWithFirebase(userView)
            } else {
                validationInput.showError(application)
            }
        }
    }

    private fun validateInputs(
        name: String?, lastName: String?,
        email: String?, password: String?
    ): Boolean =
        !name.equals("") && !lastName.equals("") && !email.equals("") && !password.equals("")


}
