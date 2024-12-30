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

// Função para selecionar a linha da tabela
function selectRow(row) {
    // Verifica se há uma linha já selecionada e remove a classe "selected"
    if (selectedRow) {
        selectedRow.classList.remove("selected");
    }

    // Atualiza a linha selecionada
    selectedRow = row;

    // Adiciona a classe "selected" para destacar a linha selecionada
    selectedRow.classList.add("selected");
}

// Função para confirmar a seleção do produto
function confirmSelectionProduto() {
    if (selectedRow) {
        // Obter o ID do produto da primeira célula da linha selecionada
        const id = selectedRow.cells[0].textContent.trim();

        // Obter a quantidade inserida no campo de input
        const quantidade = document.getElementById("quantidadeInput").value;

        // Verificar se a quantidade é válida
        if (!quantidade || quantidade <= 0) {
            alert("Por favor, insira uma quantidade válida.");
            return;
        }

        // Atualizar os campos ocultos do formulário
        document.getElementById("itemId").value = id;
        document.getElementById("quantidade").value = quantidade;

        // Submeter o formulário
        const ItemForm = document.getElementById("ItemForm");
        if (ItemForm) {
            ItemForm.submit();
        } else {
            console.error("Formulário ItemForm não encontrado!");
        }

        // Fechar o modal
        const modalElement = document.getElementById("AdicionarItens");
        const modalInstance = bootstrap.Modal.getInstance(modalElement);
        if (modalInstance) {
            modalInstance.hide();
        }

        // Limpar a seleção após o envio
        selectedRow = null;
    } else {
        alert("Nenhum produto selecionado!");
    }
}

// Função para confirmar a seleção do cliente
function confirmSelectionCliente() {
    if (selectedRow) {
        const id = selectedRow.cells[0].textContent.trim();

        // Atualizar o campo oculto com o ID do cliente
        document.getElementById("clienteId").value = id;

        // Atualizar o texto de exibição
        document.getElementById("selectedClient").textContent =
            `Cliente selecionado: (ID: ${id})`;

        // Submeter o formulário
        const clienteForm = document.getElementById("clienteForm");
        if (clienteForm) {
            clienteForm.submit();
        } else {
            console.error("Formulário clienteForm não encontrado!");
        }

        // Fechar o modal
        const modalElement = document.getElementById('Clientevenda');
        const modalInstance = bootstrap.Modal.getInstance(modalElement);
        if (modalInstance) {
            modalInstance.hide();
        }

        // Limpar a seleção após o envio
        selectedRow = null;
    } else {
        alert("Nenhum cliente selecionado!");
    }
}

// Certifique-se de que o evento de clique seja atribuído corretamente às linhas da tabela
document.addEventListener('DOMContentLoaded', function() {
    const tableRows = document.querySelectorAll('#ProdutosTable tbody tr');

    tableRows.forEach(function(row) {
        row.addEventListener('click', function() {
            selectRow(row);
        });
    });
});
