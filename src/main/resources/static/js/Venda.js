// Configuração para carregar as informações ao abrir o modal
document.addEventListener('DOMContentLoaded', function () {
    const VendasCad = document.getElementById('VendasCad');
    if (!VendasCad) {
        console.error('Modal não encontrado!');
        return;
    }

});

// Limpeza do modal após ser fechado
$("#VendasCad").on('hidden.bs.modal', function () {
    document.getElementById('datairrigacao').value = '';
    document.getElementById('horairrigacao').value = '';
    document.getElementById('intervalo').value = '';
    document.getElementById('selectedIrrigacaoId').value = '';
});

/*
optionsModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget; // O botão que acionou o modal

        // Pega o ID da irrigação do botão
        const id = button.getAttribute('data-irrigacao-id');

        // Faz uma requisição AJAX para buscar os dados mais recentes do servidor
        $.ajax({
            url: `/irrigacao/${id}`,
            method: 'GET',
            success: function (data) {
                // Preenche os campos do modal com os dados retornados
                document.getElementById('datairrigacao').value = data.dataIrrigacao || '';

                // Formata a hora para o padrão HH:mm
                if (data.horaIrrigacao) {
                    const horaRecebida = data.horaIrrigacao.split(":");
                    const horaFormatada = horaRecebida.slice(0, 2).join(":"); // Obtém apenas horas e minutos
                    document.getElementById('horairrigacao').value = horaFormatada;
                } else {
                    document.getElementById('horairrigacao').value = '';
                }

                document.getElementById('intervalo').value = data.intervalo || '';
                document.getElementById('selectedIrrigacaoId').value = id; // Atualiza o ID escondido
            },
            error: function () {
                Swal.fire({
                    icon: 'error',
                    title: 'Erro pegando próxima irrigação!',
                    text: 'Algo deu errado ao pegar as informações da próxima irrigação. Recarregue a página.',
                    showConfirmButton: false,
                    timer: 6000,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                        toast.onmouseenter = Swal.stopTimer;
                        toast.onmouseleave = Swal.resumeTimer;
                    }
                });
                $("#optionsModal").modal('hide'); // Fecha o modal em caso de erro
            }
        });
    });
*/