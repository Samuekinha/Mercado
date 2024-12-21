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

// Configuração para carregar as informações ao abrir o modal
document.addEventListener('DOMContentLoaded', function () {
    const VendasCad = document.getElementById('Clientevenda');
    if (!VendasCad) {
        console.error('Modal não encontrado!');
        return;
    }

});

let selectedRow = null;

function selectRow(row) {
    if (selectedRow) {
        selectedRow.classList.remove("selected");
    }
    selectedRow = row;
    selectedRow.classList.add("selected");
}

function confirmSelection() {
    if (selectedRow) {
        const id = selectedRow.cells[0].textContent;
        const nome = selectedRow.cells[1].textContent;
        const email = selectedRow.cells[2].textContent;

        document.getElementById("selectedClient").textContent =
            `Cliente selecionado: ${nome} (ID: ${id}, Email: ${email})`;

        // Atualizar os campos do formulário oculto
        document.getElementById("clienteId").value = id;

        // Enviar o formulário
        document.getElementById("clienteForm").submit();

        // Fechar o modal
        const modal = bootstrap.Modal.getInstance(document.getElementById('Clientevenda'));
        modal.hide();

        // Enviar os dados ao backend (opcional, explicado abaixo)
    } else {
        alert("Nenhum cliente selecionado!");
    }
}

