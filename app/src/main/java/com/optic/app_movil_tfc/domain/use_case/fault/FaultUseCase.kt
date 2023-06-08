package com.optic.app_movil_tfc.domain.use_case.fault

import com.optic.app_movil_tfc.domain.repository.UpdateFault

data class FaultUseCase(
    val getFault: GetFault,
    val updateFault: UpdateFault
)


