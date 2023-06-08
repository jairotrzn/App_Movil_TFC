package com.optic.app_movil_tfc.domain.repository

import com.optic.app_movil_tfc.domain.model.Fault
import javax.inject.Inject

class UpdateFault @Inject constructor(
    private val faultRepository: FaultRepository
) {
    suspend operator fun invoke(fault: Fault) = faultRepository.updateFault(fault)
}