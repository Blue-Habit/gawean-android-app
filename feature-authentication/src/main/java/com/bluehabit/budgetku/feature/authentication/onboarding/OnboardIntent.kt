/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.budgetku.feature.authentication.onboarding

sealed interface OnboardIntent{
    data class PagerChanges(val page:Int=0): OnboardIntent

}