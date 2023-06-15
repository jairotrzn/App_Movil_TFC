package com.optic.app_movil_tfc.domain.use_case.fault

import com.optic.app_movil_tfc.domain.model.Fault
import com.optic.app_movil_tfc.domain.repository.FaultRepository
import javax.inject.Inject

class UpdateFault @Inject constructor(
    private val faultRepository: FaultRepository
){
    suspend operator fun invoke(fault: Fault) = faultRepository.updateFault(fault)
}