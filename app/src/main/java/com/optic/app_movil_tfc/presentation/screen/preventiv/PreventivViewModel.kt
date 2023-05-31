package com.optic.app_movil_tfc.presentation.screen.preventiv

import androidx.lifecycle.ViewModel
import com.optic.app_movil_tfc.domain.use_case.preventiv.PreventivUseCase
import javax.inject.Inject


class PreventivViewModel @Inject constructor(
    private val preventivUseCase : PreventivUseCase,
):ViewModel(){

}