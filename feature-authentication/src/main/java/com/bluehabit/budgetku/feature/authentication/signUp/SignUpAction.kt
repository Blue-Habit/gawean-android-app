/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.budgetku.feature.authentication.signUp

sealed interface SignUpAction{

    object Submit: SignUpAction
//    class SignUpWithGoogle(var result: Task<GoogleSignInAccount>?): SignUpEvent
}