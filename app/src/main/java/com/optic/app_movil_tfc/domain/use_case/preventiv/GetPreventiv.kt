package com.optic.app_movil_tfc.domain.use_case.preventiv

import com.optic.app_movil_tfc.domain.repository.PreventivRepository
import javax.inject.Inject

class GetPreventiv @Inject constructor(
    private val repository: PreventivRepository
) {
    operator fun invoke(accessCode : String) = repository.getPreventiv(accessCode)
}