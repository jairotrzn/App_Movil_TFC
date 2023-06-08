package com.optic.app_movil_tfc.data.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.optic.app_movil_tfc.core.Constants.FAULTS
import com.optic.app_movil_tfc.core.Constants.MACHINES
import com.optic.app_movil_tfc.core.Constants.PREVENTIV
import com.optic.app_movil_tfc.data.repository.FaultRepositoryImpl
import com.optic.app_movil_tfc.data.repository.PreventivRepositoryImpl
import com.optic.app_movil_tfc.domain.repository.FaultRepository
import com.optic.app_movil_tfc.domain.repository.PreventivRepository
import com.optic.app_movil_tfc.domain.repository.UpdateFault
import com.optic.app_movil_tfc.domain.use_case.fault.FaultUseCase
import com.optic.app_movil_tfc.domain.use_case.fault.GetFault
import com.optic.app_movil_tfc.domain.use_case.preventiv.GetPreventiv
import com.optic.app_movil_tfc.domain.use_case.preventiv.PreventivUseCase
import com.optic.app_movil_tfc.domain.use_case.preventiv.UpDataPreventiv
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)

object AppModule{
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    @Named(PREVENTIV)
    fun providePreventivRef(db: FirebaseFirestore): CollectionReference = db.collection(PREVENTIV)

    @Provides
    @Named(MACHINES)
    fun provideMachineRef(db: FirebaseFirestore): CollectionReference = db.collection(MACHINES)

    @Provides
    @Named(FAULTS)
    fun provideFaultRef(db: FirebaseFirestore): CollectionReference = db.collection(MACHINES)
    @Provides
    fun providePreventivsUseCase(repository: PreventivRepository) = PreventivUseCase(
        getPreventiv = GetPreventiv(repository),
        updatePreventiv = UpDataPreventiv(repository)
    )

    @Provides
    fun providePreventivRepository(impl: PreventivRepositoryImpl):PreventivRepository =impl

    @Provides
    fun provideFaultRepository(impl: FaultRepositoryImpl):FaultRepository = impl

    @Provides
    fun provideFaultUseCase(repository: FaultRepository) = FaultUseCase(
        getFault = GetFault(repository),
        updateFault = UpdateFault(repository)
    )
}