package com.optic.app_movil_tfc.domain.use_case.fault

import com.optic.app_movil_tfc.domain.repository.FaultRepository
import javax.inject.Inject

class GetFault @Inject constructor(
    private val repository: FaultRepository
) {
  operator fun invoke (accessCode :String)=repository.getFault(accessCode)
}