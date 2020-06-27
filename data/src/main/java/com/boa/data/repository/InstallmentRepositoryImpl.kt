package com.boa.data.repository

import com.boa.data.datasource.InstallmentDataSource
import com.boa.data.mapper.InstallmentResponseToModelMapper
import com.boa.domain.model.Installment
import com.boa.domain.repository.InstallmentRepository

class InstallmentRepositoryImpl(
    private val installmentDataSource: InstallmentDataSource,
    private val installmentResponseToModelMapper: InstallmentResponseToModelMapper
) : InstallmentRepository {
    override suspend fun getInstallment(
        paymentMethodId: String,
        issuerId: String,
        amount: Float
    ): List<Installment> {
        val result = installmentDataSource.getInstallment(paymentMethodId, issuerId, amount)
        val list = mutableListOf<Installment>()

        result.takeIf { it.isNotEmpty() }?.forEach { installment ->
            installment.payer_costs.takeIf { it.isNotEmpty() }
                ?.forEach { list.add(installmentResponseToModelMapper.map(it)) }
        }

        return list
    }
}