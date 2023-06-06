package com.optic.app_movil_tfc.domain.use_case.preventiv

import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.repository.PreventivRepository
import javax.inject.Inject

class UpDataPreventiv @Inject constructor(
    private val preventivRepository: PreventivRepository
) {
    suspend operator fun invoke(preventiv:Preventiv) = preventivRepository.updatePreventiv(preventiv)
}