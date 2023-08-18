/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.eureka.data.contract

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task

class GoogleAuthContract: ActivityResultContract<Int, Task<GoogleSignInAccount>?>() {
    override fun createIntent(context: Context, input: Int): Intent {
        val gso= GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("264573731963-2434pg7hk30e0rp3h1852p1ehk1fdjs9.apps.googleusercontent.com")
            .requestProfile()
            .requestEmail()
            .build()

        val gsi = GoogleSignIn.getClient(
            context,
            gso
        )
        gsi.signOut()
        return gsi.signInIntent
    }


    override fun parseResult(resultCode: Int, intent: Intent?): Task<GoogleSignInAccount>? {
        return when (resultCode){
            Activity.RESULT_OK->{
                return GoogleSignIn.getSignedInAccountFromIntent(intent)
            }
            else -> null
        }
    }



}