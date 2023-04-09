/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.budgetku.android.feature.dashboard.budget

import com.bluehabit.budgetku.android.base.BaseViewModelData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
) : BaseViewModelData<BudgetState, BudgetDataState, BudgetEvent>(BudgetState(), BudgetDataState()) {
    init {
        handleActions()
    }

    override fun handleActions() = onEvent {}

}