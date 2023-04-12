/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.budgetku.android.feature.createTransaction

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import javax.annotation.concurrent.Immutable

@Immutable
@Parcelize
data class CreateTransactionState(
    val step: Int = 1,
    val percentage: Float = 0.15f
) : Parcelable

@Immutable
@Parcelize
data class CreateTransactionDataState(
    val a: String = ""
) : Parcelable

sealed interface CreateTransactionEvent {
    object NexPage : CreateTransactionEvent
    object PrevPage : CreateTransactionEvent
}