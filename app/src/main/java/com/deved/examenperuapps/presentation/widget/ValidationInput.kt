package com.deved.examenperuapps.presentation.widget

import android.content.Context
import com.deved.examenperuapps.presentation.util.Tools

class ValidationInput() : ValidateInput {

    override fun showError(context: Context) {
        val tools = Tools()
        tools.toast(context, Tools.emptyInput)
    }


}