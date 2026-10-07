class OrdemServico(
    val veiculo: Veiculo,
    val pecas: MutableList<Peca> = mutableListOf(),
    val servicos: MutableList<ServicoMecanico> = mutableListOf(),
    var pecaAdicional: Peca? = null,
    var codigoStatus: Int = 1,
    var pagamentoAVista: Boolean = false
) {

    fun calcularSubtotal(): Double {
        var subtotal = 0.0

        for (peca in pecas) {
            subtotal += peca.preco
        }

        for (servico in servicos) {
            subtotal += servico.valor
        }

        subtotal += pecaAdicional?.preco ?: 0.0

        return subtotal
    }

    fun descricaoStatus(): String {
        return when (codigoStatus) {
            1 -> "Orçamento"
            2 -> "Em Conserto"
            3 -> "Testes"
            4 -> "Finalizado"
            else -> "Status inválido"
        }
    }

    fun calcularTotal(): Double {
        val subtotal = calcularSubtotal()

        return if (pagamentoAVista) {
            subtotal * 0.95
        } else {
            subtotal
        }
    }
}
