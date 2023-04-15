/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.budgetku.android.feature.auth.resetPassword

import android.util.Patterns
import com.bluehabit.budgetku.android.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(

) : BaseViewModel<ResetPasswordState, ResetPasswordEvent>(ResetPasswordState()) {

    init {
        handleActions()
    }

    private fun validateData(
        valid: suspend (Boolean) -> Unit
    ) = asyncWithState {
        when {
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.isEmpty() -> {
                if (!isButtonEnabled) return@asyncWithState
                commit { copy(isButtonEnabled = false) }
            }
            else -> valid(true)
        }
    }

    override fun handleActions() = onEvent {
        when (it) {
            is ResetPasswordEvent.ValidateEmailAddress -> validateData {
                commit { copy(isButtonEnabled = it) }
            }
            is ResetPasswordEvent.SendLinkResetPasswordToEmail -> {
                showSnackbar("Send link to ${it.email}")
            }
        }
    }
}


